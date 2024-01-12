package com.travel.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.management.dao.TaxiInfoDao;
import com.travel.management.entity.TaxiInfo;

@Service
public class TaxiInfoService {

	@Autowired
	TaxiInfoDao dao;
	
	public List<TaxiInfo> getAllTaxiInfo() {
		return dao.getAllTaxiInfo();
	}
}
