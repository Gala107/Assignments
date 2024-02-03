package com.fare.calculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fare.calculation.bean.TaxiFare;
import com.fare.calculation.service.TaxiFareService;

@RestController
@RequestMapping("fare")
public class TaxiFareController {

	@Autowired
	TaxiFareService service;

	@GetMapping(value = "viewFares", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TaxiFare> findAllTaxiFare() {
		return service.getAllTaxiFare();
	}

	@GetMapping(value = "getFare", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TaxiFare getTaxiFare(TaxiFare taxiFare) {
		return service.getTaxiFare(taxiFare);
	}
}
