package com.taxi.reservation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.bean.TransitTaxiFare;
import com.taxi.reservation.repository.TaxiReservationRepository;

@Service
public class TaxiReservationService {

	@Autowired
	TaxiReservationRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public void saveTaxiReservation(TaxiReservation taxiReservation) {
		float fare = findFareAmount(taxiReservation.getPickupLocation(), taxiReservation.getDestination(),
				taxiReservation.getPassengerNum());
		if (fare != 0f) {
			taxiReservation.setFare(fare);
		}
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

	public void deleteTaxiReservation(int id) {
		repository.deleteById(id);
	}

	public float findFareAmount(String pickupLocation, String destination, int passengerNum) {
		return restTemplate.getForObject(
				"http://FARECALCULATIONMS/fare/getFare/" + pickupLocation + "/" + destination + "/" + passengerNum,
				Float.class);
	}

	@SuppressWarnings("unchecked")
	public List<TransitTaxiFare> findAllTaxiFares() {
		List<HashMap<String, Object>> results = restTemplate.getForObject("http://FARECALCULATIONMS/fare/findAllFares",
				List.class);

		List<TransitTaxiFare> fares = new ArrayList<TransitTaxiFare>();
		try {
			for (HashMap<String, Object> result : results) {
				TransitTaxiFare fare = new TransitTaxiFare();
				fares.add(fare);
				BeanUtils.populate(fare, result);
			}
		} catch (Exception e) {
			System.err.println("Not able to retrieve Taxi Fares available: " + e);
		}
		return fares;
	}
}
