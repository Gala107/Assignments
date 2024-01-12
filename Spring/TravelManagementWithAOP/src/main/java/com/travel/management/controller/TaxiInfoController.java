package com.travel.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.entity.TaxiInfo;
import com.travel.management.service.TaxiInfoService;

@Controller
public class TaxiInfoController {

	@Autowired
	TaxiInfoService service;
	
	@RequestMapping(value = "getTaxiInfo", method = RequestMethod.POST)
	public ModelAndView getTaxiInfo(HttpServletRequest request) {
		Object client = request.getAttribute("client");
		
		List<TaxiInfo> taxiInfo = service.getAllTaxiInfo();
		
		ModelAndView model = new ModelAndView();
		model.addObject("taxiInfo", taxiInfo);
		model.setViewName("makeReservation.jsp");
		
		return model;
	}
}
