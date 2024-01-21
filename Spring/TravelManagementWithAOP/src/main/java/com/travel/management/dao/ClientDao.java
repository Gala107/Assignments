package com.travel.management.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.management.bean.Client;

@Repository
public class ClientDao {

	@Autowired
	SessionFactory sessionFactory;

	public Client findClientByPhone(String phone) {
		try {
			Session session = sessionFactory.openSession();
			TypedQuery<Client> query = session.createQuery("select c from Client c where c.phone = :phone", Client.class);
			query.setParameter("phone", phone);
			Client client = query.getSingleResult();
			session.close();
			return client;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Client findClientByEmail(String email) {
		try {
			Session session = sessionFactory.openSession();
			TypedQuery<Client> query = session.createQuery("select c from Client c where c.email = :email",
					Client.class);
			query.setParameter("email", email);
			Client client = query.getSingleResult();
			session.close();
			return client;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public boolean saveClient(Client client) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
}
