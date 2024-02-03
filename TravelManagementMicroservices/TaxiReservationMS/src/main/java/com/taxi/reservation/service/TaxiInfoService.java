package com.taxi.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.reservation.repository.TaxiInfoRepository;
import com.taxi.reservation.bean.TaxiInfo;

@Service
public class TaxiInfoService {

	@Autowired
	TaxiInfoRepository repository;
	
	public List<TaxiInfo> getAllTaxiInfo() {
		return repository.findAll();
	}
	
	public TaxiInfo getTaxiInfo(int id) {
		return repository.getReferenceById(id);
	}
}
