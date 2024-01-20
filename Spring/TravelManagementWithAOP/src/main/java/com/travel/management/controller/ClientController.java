package com.travel.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.bean.Client;
import com.travel.management.service.ClientService;
import com.travel.management.service.TaxiInfoService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	@Autowired
	TaxiInfoService taxiService;

	@RequestMapping(value = "getClient", method = RequestMethod.POST)
	public ModelAndView getClient(HttpServletRequest request, ModelAndView view) {

		String findBy = request.getParameter("findBy");
		String clientInfo = request.getParameter("clientInfo");

		Client client = "phone".equals(findBy) ? clientService.findClientByPhone(clientInfo)
				: clientService.findClientByEmail(clientInfo);
		if (client == null) {
			view.addObject("msg", "This is a new Client. Please use 'New Client Reservation' link.");
			view.setViewName("findClient.jsp");
		} else {
			view.addObject("client", client);
			view.addObject("taxi", taxiService.getAllTaxiInfo());
			view.setViewName("makeReservation.jsp");
		}
		return view;
	}

	@RequestMapping(value = "makeNewClientReservation", method = RequestMethod.GET)
	public ModelAndView getNewClient(ModelAndView view) {
		view.addObject("taxi", taxiService.getAllTaxiInfo());
		view.setViewName("makeReservation.jsp");
		return view;
	}
}
