package com.travel.management.service;

import java.util.List;

import com.travel.management.bean.TaxiInfo;
import com.travel.management.dao.TaxiInfoDao;

public class TaxiInfoService {

	TaxiInfoDao dao = new TaxiInfoDao();
	
	public List<TaxiInfo> getAllTaxiInfo() {
		return dao.getAllTaxiInfo();
	}
	
	public TaxiInfo getTaxiInfo(int id) {
		return dao.getTaxiInfo(id);
	}
}
