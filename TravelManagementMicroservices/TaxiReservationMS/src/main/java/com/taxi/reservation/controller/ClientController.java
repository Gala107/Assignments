package com.taxi.reservation.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxi.reservation.bean.Client;
import com.taxi.reservation.service.ClientService;

@Controller
@RequestMapping("client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PostMapping(value = "getClient")
	public ModelAndView getClient(HttpServletRequest request, final RedirectAttributes redirectAttributes, ModelAndView view) {

		String findBy = request.getParameter("findBy");
		String clientInfo = request.getParameter("clientInfo");

		Client client = "phone".equals(findBy) ? clientService.findClientByPhone(clientInfo)
				: clientService.findClientByEmail(clientInfo);
		if (client == null) {
			view.addObject("msg", "This is a new Client. Please use 'New Client Reservation' link.");
			view.setViewName("findClient.jsp");
		} else {	
			redirectAttributes.addFlashAttribute("client", client);		
			view.setViewName("redirect:getClientFrom");	
		}
		return view;
	}
}
