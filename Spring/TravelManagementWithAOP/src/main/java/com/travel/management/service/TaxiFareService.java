package com.travel.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.management.bean.TaxiFare;
import com.travel.management.dao.TaxiFareDao;

@Service
public class TaxiFareService {

	@Autowired
	TaxiFareDao dao;
	
	public List<TaxiFare> getAllTaxiFare(){
		return dao.getAllTaxiFare();
	}
	
	public float findTaxiFare(TaxiFare fare) {
		return dao.findFare(fare);
	}
}
