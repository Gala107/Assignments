package com.travel.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.bean.Client;
import com.travel.management.bean.TaxiReservation;
import com.travel.management.service.TaxiInfoService;

@Controller
public class TaxiInfoController {

	@Autowired
	TaxiInfoService service;
	
	@RequestMapping(value = "getClientFrom", method = RequestMethod.GET)
	public ModelAndView getTaxiInfo(@ModelAttribute("client") Client client, ModelAndView view) {
		view.addObject("taxi", service.getAllTaxiInfo());
		view.setViewName("makeReservation.jsp");
		return view;
	}
	
	@RequestMapping(value = "updateReservationFrom", method = RequestMethod.GET)
	public ModelAndView getTaxiInfo(@ModelAttribute("reservation") TaxiReservation reservation, ModelAndView view) {
		view.addObject("taxi", service.getAllTaxiInfo());
		view.setViewName("updateReservation.jsp");
		return view;
	}
}
