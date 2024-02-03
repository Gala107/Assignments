package com.travel.management.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.management.bean.TaxiFare;

@Repository
public class TaxiFareDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<TaxiFare> getAllTaxiFare() {
		Session session = sessionFactory.openSession();
		TypedQuery<TaxiFare> query = session.createQuery("select t from TaxiFare t", TaxiFare.class);
		List<TaxiFare> fares = query.getResultList();
		session.close();
		return fares;
	}

	public float findFare(TaxiFare fare) {
		try {
			Session session = sessionFactory.openSession();
			TypedQuery<TaxiFare> query = session.createQuery(
					"select t from TaxiFare t where t.pickupLocation = :pickupLocation and t.destination = :destination and t.passengerNum = :passengerNum",
					TaxiFare.class);
			query.setParameter("pickupLocation", fare.getPickupLocation());
			query.setParameter("destination", fare.getDestination());
			query.setParameter("passengerNum", fare.getPassengerNum());
			TaxiFare result = query.getSingleResult();
			session.close();
			return result.getFare();
		} catch (NoResultException e) {
			return 0;
		}
	}

}
