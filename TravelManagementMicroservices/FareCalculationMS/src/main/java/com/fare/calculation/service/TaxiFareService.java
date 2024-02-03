package com.fare.calculation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fare.calculation.repository.TaxiFareRepository;
import com.fare.calculation.bean.TaxiFare;

@Service
public class TaxiFareService {

	@Autowired
	TaxiFareRepository repository;
	
	public List<TaxiFare> getAllTaxiFare(){
		return repository.findAll();
	}
	
	public TaxiFare getTaxiFare(TaxiFare fare) {
		return repository.getTaxiFare(fare.getPickupLocation(), fare.getDestination(), fare.getPassengerNum());
	}
}
