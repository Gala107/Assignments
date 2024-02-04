package com.taxi.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.taxi.reservation.bean.Client;
import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.service.TaxiInfoService;

@Controller
@RequestMapping("info")
public class TaxiInfoController {

	@Autowired
	TaxiInfoService service;
	
	@GetMapping(value = "getClientFrom")
	public ModelAndView getTaxiInfo(@ModelAttribute("client") Client client, ModelAndView view) {
		view.addObject("reservation", new TaxiReservation());
		view.addObject("taxi", service.getAllTaxiInfo());
		view.setViewName("makeReservation");
		return view;
	}
	
	@PostMapping(value = "updateReservationFrom")
	public ModelAndView getTaxiInfo(@ModelAttribute("reservation") TaxiReservation reservation, ModelAndView view) {
		view.addObject("taxi", service.getAllTaxiInfo());
		view.setViewName("updateReservation");
		return view;
	}
}
