package com.travel.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.management.bean.TaxiReservation;
import com.travel.management.dao.TaxiReservationDao;

@Service
public class TaxiReservationService {

	@Autowired
	TaxiReservationDao dao;
	
	public void saveTaxiReservation(TaxiReservation taxiReservation) {
		dao.saveTaxiReservation(taxiReservation);
	}
	
	public TaxiReservation getTaxiReservation(int id) {
		return dao.getTaxiReservation(id);
	}
	
	public void updateTaxiReservation(TaxiReservation taxiReservation) {
		dao.updateTaxiReservation(taxiReservation);
	}
	
	public List<TaxiReservation> getAllTaxiReservations() {
		return dao.getAllTaxiReservations();
	}
	
	public void deleteTaxiReservation(int id ) {
		dao.deleteTaxiReservation(id);
	}
}
