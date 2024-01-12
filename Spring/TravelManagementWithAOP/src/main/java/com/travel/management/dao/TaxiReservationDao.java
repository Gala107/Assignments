package com.travel.management.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.management.entity.TaxiReservation;

@Repository
public class TaxiReservationDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveTaxiReservation(TaxiReservation taxiReservation) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(taxiReservation);
			tran.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	public List<TaxiReservation> getAllTaxiReservations() {
		Session session = sessionFactory.openSession();
		TypedQuery<TaxiReservation> query = session.createQuery("select t from TaxiReservation t", TaxiReservation.class);
		return query.getResultList();
	}
}
