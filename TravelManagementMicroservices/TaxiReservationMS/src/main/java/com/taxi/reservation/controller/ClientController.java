package com.taxi.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.reservation.bean.Client;
import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.service.ClientService;
import com.taxi.reservation.service.TaxiInfoService;

@Controller
@RequestMapping("client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	TaxiInfoService infoService;

	@PostMapping(value = "getClient")
	public ModelAndView getClient(@RequestParam(value="findBy") String findBy, @RequestParam(value="clientInfo") String clientInfo, ModelAndView view) {
		Client client = "phone".equals(findBy) ? clientService.findClientByPhone(clientInfo)
				: clientService.findClientByEmail(clientInfo);
		if (client == null) {
			view.addObject("msg", "This is a new Client. Please use 'New Client Reservation' link.");
			view.setViewName("findClient");
		} else {
			view.addObject("client", client);
			view.addObject("reservation", new TaxiReservation());
			view.addObject("taxi", infoService.getAllTaxiInfo());
			view.setViewName("makeReservation");
			return view;
		}
		return view;
	}

	@GetMapping(value = "findClient")
	public ModelAndView findClient(ModelAndView view) {
		view.addObject("client", new Client());
		view.addObject("clientInfo", "");
		view.addObject("findBy", "");
		view.setViewName("findClient");

		return view;
	}
}
