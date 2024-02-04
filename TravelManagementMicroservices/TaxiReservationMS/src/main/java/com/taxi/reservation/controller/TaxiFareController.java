package com.taxi.reservation.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.fare.calculation.bean.TaxiFare;
import com.taxi.reservation.bean.Client;
import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.service.ClientService;
import com.taxi.reservation.service.TaxiInfoService;

@Controller
@RequestMapping("fare")
public class TaxiFareController {

	@GetMapping(value = "viewFares")
	public ModelAndView findAllTaxiFare(ModelAndView view) {
		view.addObject("fare", new ArrayList());
		view.setViewName("viewFares");
		return view;
	}

	@GetMapping(value = "getFare")
	public ModelAndView getTaxiFare(ModelAndView view) {

		// return service.getTaxiFare(taxiFare);
		return view;
	}
}
