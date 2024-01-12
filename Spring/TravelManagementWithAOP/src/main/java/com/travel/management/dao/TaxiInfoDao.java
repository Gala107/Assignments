package com.travel.management.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travel.management.entity.TaxiInfo;

@Repository
public class TaxiInfoDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<TaxiInfo> getAllTaxiInfo() {
		Session session = sessionFactory.openSession();
		TypedQuery<TaxiInfo> query = session.createQuery("select t from TaxiInfo t", TaxiInfo.class);
		return query.getResultList();
	}
}
