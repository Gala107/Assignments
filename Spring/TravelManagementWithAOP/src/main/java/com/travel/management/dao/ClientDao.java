package com.travel.management.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.management.entity.Client;

@Repository
public class ClientDao {

	@Autowired
	SessionFactory sessionFactory;

	public Client findClientByPhone(String phone) {
		try {
			Session session = sessionFactory.openSession();
			TypedQuery<Client> query = session.createQuery("select c from Client c where c.phone = :phone",
					Client.class);
			query.setParameter("phone", phone);
			return query.getSingleResult();
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
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
