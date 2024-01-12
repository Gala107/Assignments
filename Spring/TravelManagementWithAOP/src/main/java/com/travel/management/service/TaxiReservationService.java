package com.travel.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.management.dao.TaxiReservationDao;
import com.travel.management.entity.TaxiReservation;

@Service
public class TaxiReservationService {

	@Autowired
	TaxiReservationDao dao;
	
	public void saveTaxiReservation(TaxiReservation taxiReservation) {
		dao.saveTaxiReservation(taxiReservation);
	}
	
	public List<TaxiReservation> getAllTaxiReservations() {
		return dao.getAllTaxiReservations();
	}
}
