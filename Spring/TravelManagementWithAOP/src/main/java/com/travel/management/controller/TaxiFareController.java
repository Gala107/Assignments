package com.travel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.bean.TaxiFare;
import com.travel.management.service.TaxiFareService;


@Controller
public class TaxiFareController {
	
	@Autowired
	TaxiFareService service;

	@GetMapping("viewFares")
	public ModelAndView findAllTaxiFare(ModelAndView view) {
		List<TaxiFare> fares = service.getAllTaxiFare();
		view.addObject("taxiFares", fares);
		view.setViewName("viewFares.jsp");
		return view;
	}
}
