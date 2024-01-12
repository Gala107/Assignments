package com.travel.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.service.TaxiInfoService;

@Controller
public class TaxiInfoController {

	@Autowired
	TaxiInfoService service;
	
	@RequestMapping(value = "getTaxiInfo", method = RequestMethod.POST)
	public ModelAndView getTaxiInfo(HttpServletRequest request, ModelAndView model) {
		System.out.println("Inside Taxi Info Controller!!!!!");
		
		String viewName = model.getViewName();
		return model;
	}
}
