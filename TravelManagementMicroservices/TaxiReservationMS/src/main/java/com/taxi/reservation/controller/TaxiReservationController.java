package com.taxi.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.taxi.reservation.bean.Client;
import com.taxi.reservation.bean.TaxiInfo;
import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.service.ClientService;
import com.taxi.reservation.service.TaxiInfoService;
import com.taxi.reservation.service.TaxiReservationService;

@Controller
@RequestMapping("reservation")
public class TaxiReservationController {

	@Autowired
	ClientService clientService;
	@Autowired
	TaxiReservationService taxiService;
	@Autowired
	TaxiInfoService infoService;

	@PostMapping(value = "saveReservation")
	public ModelAndView saveReservation(@ModelAttribute TaxiReservation taxiReservation, @ModelAttribute Client client, ModelAndView view) {
		if (client.getId() == 0) {
			clientService.saveClient(client);
		}
		taxiReservation.setClient(client);
		taxiReservation.setTaxiInfo(getTaxiInfo(taxiReservation));
		taxiService.saveTaxiReservation(taxiReservation);

		view.addObject("reservation", taxiReservation);
		if (taxiReservation.getFare() == 0) {
			view.addObject("msg", "Not available for this route.");
		}
		view.setViewName("confirmReservation");
		return view;
	}

	@GetMapping(value = "deleteReservation/{id}")
	public ModelAndView deleteReservation(@PathVariable(value = "id") int id, ModelAndView view) {
		taxiService.deleteTaxiReservation(id);
		return setTaxiReservationsView(view);
	}

	@GetMapping(value = "viewReservations")
	public ModelAndView viewReservations(ModelAndView view) {
		return setTaxiReservationsView(view);
	}
	
	@GetMapping(value = "viewFares")
	public ModelAndView viewFares(ModelAndView view) {
		view.addObject("fares", taxiService.findAllTaxiFares());
		view.setViewName("viewFares");
		return view;
	}
		
	private ModelAndView setTaxiReservationsView(ModelAndView view) {
		view.addObject("taxiReservations", taxiService.getAllTaxiReservations());
		view.setViewName("viewReservations");
		return view;
	}

	private TaxiInfo getTaxiInfo(TaxiReservation reservation) {
		int taxiInfoId = reservation.getTaxiInfo().getId();
		return infoService.getTaxiInfo(taxiInfoId);
	}
}
