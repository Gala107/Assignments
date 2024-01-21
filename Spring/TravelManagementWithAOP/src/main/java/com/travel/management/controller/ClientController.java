package com.travel.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.travel.management.bean.Client;
import com.travel.management.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@RequestMapping(value = "getClient", method = RequestMethod.POST)
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
