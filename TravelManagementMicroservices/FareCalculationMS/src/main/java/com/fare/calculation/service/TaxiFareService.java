package com.fare.calculation.service;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fare.calculation.repository.TaxiFareRepository;
import com.fare.calculation.bean.TaxiFare;

@Service
public class TaxiFareService {

	@Autowired
	TaxiFareRepository repository;

	public List<TaxiFare> getAllTaxiFare() {
		return repository.findAll();
	}

	public float getTaxiFare(String pickupLocation, String destination, int passengerNum) {
		float fare = 0.0f;
		try {
			fare = repository.getTaxiFare(pickupLocation, destination, passengerNum);
		} catch (AopInvocationException e) {
			System.out.println("No fare found for pickup location: " + pickupLocation + " | destination: " + destination
					+ " | passengers number: " + passengerNum);
		}
		return fare;
	}
}
