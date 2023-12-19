package com.hibernate.maven.util;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.maven.model.User;

public class AppMain {

	static User userObj;
	static Session sessionObj;

	public static void main(String[] args) {

		System.out.println(".......Hibernate Maven Example.......\n");

		// sessionObj.createCriteria(...) is deprecated. No Criteria with Session object anymore.

		// CREATE/PERSIST
		try {
			sessionObj = SessionBuilder.build("create");
			sessionObj.beginTransaction();

			for (int i = 1; i <= 5; i++) {
				userObj = new User("Galochka", "admin", new Date());
				sessionObj.persist(userObj);
			}

			sessionObj.getTransaction().commit();
			System.out.println("\n.......Records are Persisted Successfully to DB.......\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		System.out.println();

		// READ/UPDATE USER FROM DB
		try {
			sessionObj = SessionBuilder.build("update");
			sessionObj.beginTransaction();
			User user = sessionObj.get(User.class, 1);

			System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());

			user.setUserName("Andrea");
			user = sessionObj.merge(user);
			sessionObj.getTransaction().commit();

			System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());
			System.out.println("\n.......Record is Read and Updated Successfully in DB.......\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		System.out.println();

		// DELETE USER FROM DB
		try {
			sessionObj = SessionBuilder.build("update");
			sessionObj.beginTransaction();
			User user = sessionObj.get(User.class, 3);
			System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());

			sessionObj.remove(user);
			sessionObj.getTransaction().commit();
			System.out.println("\n.......Record is Deleted Successfully in DB.......\n");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		System.out.println();

		// USING HQL QUERIES AND NAMED PARAMETERS
		try {
			sessionObj = SessionBuilder.build("update");
			sessionObj.beginTransaction();

			// setParameter discovers parameter data type
			// In this case "where u.userName = :nameValue" :nameValue DOES NOT have to
			// match u.userName
			String hql = "from User u where u.userName = :nameValue";
			List<User> result = sessionObj.createQuery(hql, User.class).setParameter("nameValue", "Galochka").list();

			// setString specifies the parameter is String value
			// List<User> result = sessionObj.createQuery(hql,
			// User.class).setString("nameValue", "Galochka").list();
			System.out.println("Users are retrieved through HQL setParamater query");
			for (User user : result) {
				System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());
			}
			System.out.println();

			hql = "from User u where u.userId between :id1 and :id2 order by u.userId desc";
			result = sessionObj.createQuery(hql, User.class).setParameter("id1", 4).setParameter("id2", 5).list();
			System.out.println("Users are retrieved with between claw");
			for (User user : result) {
				System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());
			}
			System.out.println();

			// setProperties takes an User object with preset values
			// In this case "where u.userName = :userName" :userName has to match u.userName
			// so we know what instance variable value the parameter is coming from: User
			// object, userName property!
			User userObj = new User("Andrea", null, null);
			hql = "from User u where u.userName = :userName";
			result = sessionObj.createQuery(hql, User.class).setProperties(userObj).list();
			System.out.println("Users are retrieved through HQL setProperties query");
			for (User user : result) {
				System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());
			}

			System.out.println("\n.......Record is Retrieved Successfully from DB.......\n");
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}

		// USING NATIVE SQL QUERIES
		try {
			sessionObj = SessionBuilder.build("update");
			sessionObj.beginTransaction();

			String sql = "select * from user";
			List<User> result = sessionObj.createNativeQuery(sql, User.class).list();
			System.out.println("Users are retrieved through native SQL query");
			for (User user : result) {
				System.out.println("User name: " + user.getUserName() + " and User Id: " + user.getUserId());
			}
			System.out.println();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
}
