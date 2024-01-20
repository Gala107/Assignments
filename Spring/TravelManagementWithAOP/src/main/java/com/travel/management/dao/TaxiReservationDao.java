package com.travel.management.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.management.bean.TaxiReservation;

@Repository
public class TaxiReservationDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveTaxiReservation(TaxiReservation taxiReservation) {
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(taxiReservation);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public boolean updateTaxiReservation(TaxiReservation taxiReservation) {
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(taxiReservation);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public TaxiReservation getTaxiReservation(int id) {
		Session session = sessionFactory.openSession();
		return session.get(TaxiReservation.class, id);
	}

	public List<TaxiReservation> getAllTaxiReservations() {
		Session session = sessionFactory.openSession();
		TypedQuery<TaxiReservation> query = session.createQuery("select t from TaxiReservation t",
				TaxiReservation.class);
		return query.getResultList();
	}

	public void deleteTaxiReservation(int id) {
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			TaxiReservation reservation = session.get(TaxiReservation.class, id);
			session.delete(reservation);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(e);
		}
	}
}
