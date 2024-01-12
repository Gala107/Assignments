package com.travel.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.entity.Client;
import com.travel.management.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService service;

	@RequestMapping(value = "getClient", method = RequestMethod.POST)
	public ModelAndView getClient(HttpServletRequest request) {

		String findBy = request.getParameter("findBy");
		String clientInfo = request.getParameter("clientInfo");

		
		Client client = "phone".equals(findBy) ? service.findClientByPhone(clientInfo) : service.findClientByEmail(clientInfo);
		ModelAndView model = new ModelAndView();
		if (client == null) {
			model.addObject("msg", "This is a new Client. Please use 'New Client Reservation' link.");
			model.setViewName("findClient.jsp");
		} else {
			model.addObject("client", client);
			//model.setViewName("getTaxiInfo");
			model.setViewName("makeReservation.jsp");
		}
		return model;
	}
}
