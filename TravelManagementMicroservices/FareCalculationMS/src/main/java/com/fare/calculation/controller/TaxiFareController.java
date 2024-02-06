package com.fare.calculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fare.calculation.bean.TaxiFare;
import com.fare.calculation.service.TaxiFareService;

@RestController
@RequestMapping("fare")
public class TaxiFareController {

	@Autowired
	TaxiFareService service;

	@GetMapping(value = "getFare/{pickupLocation}/{destination}/{passengerNum}")
	public float getTaxiFare(@PathVariable(name = "pickupLocation") String pickupLocation,
			@PathVariable(name = "destination") String destination,
			@PathVariable(name = "passengerNum") int passengerNum) {
		return service.getTaxiFare(pickupLocation, destination, passengerNum);
	}
	
	@GetMapping(value = "findAllFares", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TaxiFare> findAllFares() {
		return service.getAllTaxiFare();
	}
}
