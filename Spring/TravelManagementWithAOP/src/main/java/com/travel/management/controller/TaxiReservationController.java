package com.travel.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.bean.Client;
import com.travel.management.bean.TaxiReservation;
import com.travel.management.service.ClientService;
import com.travel.management.service.TaxiInfoService;
import com.travel.management.service.TaxiReservationService;

@Controller
public class TaxiReservationController {

	@Autowired
	ClientService clientService;
	@Autowired
	TaxiReservationService taxiService;
	@Autowired
	TaxiInfoService infoService;

	@RequestMapping(value = "makeReservation", method = RequestMethod.POST)
	public ModelAndView makeReservation(TaxiReservation taxiReservation, ModelAndView view) {
		Client client = taxiReservation.getClient();
		if (client.getId() == 0) {
			clientService.saveClient(client);
		}
		taxiService.saveTaxiReservation(taxiReservation);

		view.addObject("taxiReservations", getTaxiReservations());
		view.setViewName("viewReservations.jsp");	
		return view;
	}
	
	@RequestMapping(value="deleteReservation", method=RequestMethod.GET)
	public ModelAndView deleteReservation(HttpServletRequest request, ModelAndView view) {
		int id = Integer.parseInt(request.getParameter("id"));
		taxiService.deleteTaxiReservation(id);
		
		view.addObject("taxiReservations", getTaxiReservations());
		view.setViewName("viewReservations.jsp");	
		return view;
	}
	
	@RequestMapping(value="viewReservations", method=RequestMethod.GET)
	public ModelAndView viewReservations(ModelAndView view) {
		view.addObject("taxiReservations", getTaxiReservations());
		view.setViewName("viewReservations.jsp");	
		return view;
	}
	
	@RequestMapping(value = "updateReservation", method = RequestMethod.GET)
	public ModelAndView makeReservation(HttpServletRequest request, ModelAndView view) {
		int id = Integer.parseInt(request.getParameter("id"));
		TaxiReservation reservation = taxiService.getTaxiReservation(id);
		
		view.addObject("reservation", reservation);
		view.addObject("taxi",infoService.getAllTaxiInfo());
		view.setViewName("updateReservation.jsp");	
		return view;
	}
	
	@RequestMapping(value = "saveUpdateReservation", method = RequestMethod.POST)
	public ModelAndView saveUpdateReservation(TaxiReservation taxiReservation, ModelAndView view) {
		taxiService.updateTaxiReservation(taxiReservation);
		
		view.addObject("taxiReservations", getTaxiReservations());
		view.setViewName("viewReservations.jsp");	
		return view;
	}
	
	private List<TaxiReservation> getTaxiReservations() {
		return taxiService.getAllTaxiReservations();
	}
}
