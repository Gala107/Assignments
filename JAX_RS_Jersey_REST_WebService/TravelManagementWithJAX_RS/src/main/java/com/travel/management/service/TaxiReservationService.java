package com.travel.management.service;

import java.util.List;

import com.travel.management.bean.TaxiReservation;
import com.travel.management.dao.TaxiReservationDao;

public class TaxiReservationService {

	TaxiReservationDao dao = new TaxiReservationDao();
	
	public String saveTaxiReservation(TaxiReservation taxiReservation) {
		int result = dao.saveTaxiReservation(taxiReservation);
		return result == 0 ? "Failure: Couldn't save Taxi Reservation" : "Success: Taxi Reservation is saved";
	}
	
	public TaxiReservation getTaxiReservation(int id) {
		return dao.getTaxiReservation(id);
	}
	
	public List<TaxiReservation> getAllTaxiReservations() {
		return dao.getAllTaxiReservations();
	}
	
	public String deleteTaxiReservation(int id ) {
		int result = dao.deleteTaxiReservation(id);
		return result == 0 ? "Failure: Couldn't delete Taxi Reservation" : "Success: Taxi Reservation is deleted";
	}
}
