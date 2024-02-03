package com.taxi.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.repository.TaxiReservationRepository;

@Service
public class TaxiReservationService {

	@Autowired
	TaxiReservationRepository repository;
	
	public void saveTaxiReservation(TaxiReservation taxiReservation) {
		repository.save(taxiReservation);
	}
	
	public TaxiReservation getTaxiReservation(int id) {
		return repository.getReferenceById(id);
	}
	
	public void updateTaxiReservation(TaxiReservation taxiReservation) {
		repository.save(taxiReservation);
	}
	
	public List<TaxiReservation> getAllTaxiReservations() {
		return repository.findAll();
	}
	
	public void deleteTaxiReservation(int id ) {
		repository.deleteById(id);
	}
}
