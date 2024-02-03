package com.travel.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.travel.management.bean.Client;
import com.travel.management.bean.TaxiFare;
import com.travel.management.bean.TaxiInfo;
import com.travel.management.bean.TaxiReservation;
import com.travel.management.service.ClientService;
import com.travel.management.service.TaxiFareService;
import com.travel.management.service.TaxiInfoService;
import com.travel.management.service.TaxiReservationService;

@Controller
public class TaxiReservationController {

	@Autowired
	ClientService clientService;
	@Autowired
	TaxiReservationService taxiService;
	@Autowired
	TaxiFareService fareService;
	@Autowired
	TaxiInfoService infoService;

	@RequestMapping(value = "saveReservation", method = RequestMethod.POST)
	public ModelAndView saveReservation(TaxiReservation taxiReservation, ModelAndView view) {
		Client client = taxiReservation.getClient();
		if (client.getId() == 0) {
			clientService.saveClient(client);
		}
		taxiReservation.setFare(getTaxiFare(taxiReservation));
		taxiReservation.setTaxiInfo(getTaxiInfo(taxiReservation));
		taxiService.saveTaxiReservation(taxiReservation);

		view.addObject("reservation", taxiReservation);
		if (taxiReservation.getFare() == 0) {
			view.addObject("msg", "Not available for this route.");
		}
		view.setViewName("confirmReservation.jsp");
		return view;
	}

	@RequestMapping(value = "deleteReservation", method = RequestMethod.GET)
	public ModelAndView deleteReservation(HttpServletRequest request, ModelAndView view) {
		int id = Integer.parseInt(request.getParameter("id"));
		taxiService.deleteTaxiReservation(id);
		return setTaxiReservationsView(view);
	}

	@RequestMapping(value = "viewReservations", method = RequestMethod.GET)
	public ModelAndView viewReservations(ModelAndView view) {
		return setTaxiReservationsView(view);
	}

	@RequestMapping(value = "saveUpdateReservation", method = RequestMethod.POST)
	public ModelAndView saveUpdateReservation(TaxiReservation taxiReservation, ModelAndView view) {
		taxiReservation.setFare(getTaxiFare(taxiReservation));
		taxiService.updateTaxiReservation(taxiReservation);
		return setTaxiReservationsView(view);
	}

	@RequestMapping(value = "updateReservation", method = RequestMethod.GET)
	public ModelAndView updateReservation(HttpServletRequest request, final RedirectAttributes redirectAttributes,
			ModelAndView view) {
		int id = Integer.parseInt(request.getParameter("id"));
		TaxiReservation reservation = taxiService.getTaxiReservation(id);

		redirectAttributes.addFlashAttribute("reservation", reservation);
		view.setViewName("redirect:updateReservationFrom");
		return view;
	}

	private ModelAndView setTaxiReservationsView(ModelAndView view) {
		view.addObject("taxiReservations", taxiService.getAllTaxiReservations());
		view.setViewName("viewReservations.jsp");
		return view;
	}

	private float getTaxiFare(TaxiReservation reservation) {
		TaxiFare fare = new TaxiFare();
		fare.setPickupLocation(reservation.getPickupLocation());
		fare.setDestination(reservation.getDestination());
		fare.setPassengerNum(reservation.getPassengerNum());

		return fareService.findTaxiFare(fare);
	}

	private TaxiInfo getTaxiInfo(TaxiReservation reservation) {
		int taxiInfoId = reservation.getTaxiInfo().getId();
		return infoService.getTaxiInfo(taxiInfoId);
	}
}
