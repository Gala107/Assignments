package com.travel.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.entity.Client;
import com.travel.management.entity.TaxiInfo;
import com.travel.management.entity.TaxiReservation;
import com.travel.management.service.TaxiReservationService;

@Controller
public class TaxiReservationController {

	@Autowired
	TaxiReservationService service;

	@RequestMapping(value = "makeReservation", method = RequestMethod.POST)
	public ModelAndView makeReservation(HttpServletRequest request, TaxiReservation taxiReservation) {

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		String taxi = request.getParameter("taxi");

		String pickupLocation = request.getParameter("pickupLocation");
		String pickupTime = request.getParameter("pickupTime");
		String destination = request.getParameter("destination");
		int passengerNum = Integer.parseInt(request.getParameter("passengerNum"));
		boolean luggage = "yes".equals(request.getParameter("luggage"));

		Client client = taxiReservation.getClient();
		client.setName(name);
		client.setPhone(phone);
		client.setEmail(email);

		TaxiInfo taxiInfo = taxiReservation.getTaxiInfo();
		taxiInfo.setId(passengerNum);
		taxiInfo.setCarModel(taxi);
		taxiInfo.setLicensePlate(taxi);

		taxiReservation.setPickupLocation(pickupLocation);
		taxiReservation.setPickupTime(pickupTime);
		taxiReservation.setDestination(destination);
		taxiReservation.setPassengerNum(passengerNum);
		taxiReservation.setLuggage(luggage);

		service.saveTaxiReservation(taxiReservation);
		List<TaxiReservation> taxiReservations = service.getAllTaxiReservations();

		ModelAndView model = new ModelAndView();
		model.addObject("taxiReservations", taxiReservations);
		model.setViewName("viewReservations.jsp");	
		return model;
	}
}
