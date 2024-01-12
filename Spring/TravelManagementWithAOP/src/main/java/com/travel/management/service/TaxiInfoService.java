package com.travel.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.management.dao.TaxiInfoDao;

@Service
public class TaxiInfoService {

	@Autowired
	TaxiInfoDao dao;
}
