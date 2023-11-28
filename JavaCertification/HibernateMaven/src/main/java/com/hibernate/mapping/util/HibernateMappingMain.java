package com.hibernate.mapping.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.mapping.model.Player;
import com.hibernate.mapping.model.Team;
import com.hibernate.maven.model.User;

public class HibernateMappingMain {

	static Session session;

	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");

		try {
			session = SessionBuilder.build("create");
			session.beginTransaction();
			
			Team team1 = new Team("Ukraine");
			Team team2 = new Team("Russia");
			Team team3 = new Team("USA");

			Player player1 = new Player();
			player1.setAge(27);
			player1.setPlayerName("Justin");
			player1.getTeams().add(team1);
			player1.getTeams().add(team2);
			player1.getTeams().add(team3);
			
			session.persist(team1);
			session.persist(team2);
			session.persist(team3);
			session.persist(player1);

			session.getTransaction().commit();
			System.out.println("\n.......Records are Persisted Successfully to DB.......\n");
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
