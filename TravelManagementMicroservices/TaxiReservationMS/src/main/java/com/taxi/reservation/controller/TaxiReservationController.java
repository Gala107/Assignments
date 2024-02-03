package com.taxi.reservation.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

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
	public ModelAndView saveReservation(TaxiReservation taxiReservation, ModelAndView view) {
		Client client = taxiReservation.getClient();
		if (client.getId() == 0) {
			clientService.saveClient(client);
		}
		//taxiReservation.setFare(getTaxiFare(taxiReservation));
		taxiReservation.setTaxiInfo(getTaxiInfo(taxiReservation));
		taxiService.saveTaxiReservation(taxiReservation);

		view.addObject("reservation", taxiReservation);
		if (taxiReservation.getFare() == 0) {
			view.addObject("msg", "Not available for this route.");
		}
		view.setViewName("confirmReservation.jsp");
		return view;
	}

	@GetMapping(value = "deleteReservation")
	public ModelAndView deleteReservation(HttpServletRequest request, ModelAndView view) {
		int id = Integer.parseInt(request.getParameter("id"));
		taxiService.deleteTaxiReservation(id);
		return setTaxiReservationsView(view);
	}

	@GetMapping(value = "viewReservations")
	public ModelAndView viewReservations(ModelAndView view) {
		return setTaxiReservationsView(view);
	}

	@PostMapping(value = "saveUpdateReservation")
	public ModelAndView saveUpdateReservation(TaxiReservation taxiReservation, ModelAndView view) {
		//taxiReservation.setFare(getTaxiFare(taxiReservation));
		taxiService.updateTaxiReservation(taxiReservation);
		return setTaxiReservationsView(view);
	}

	@GetMapping(value = "updateReservation")
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

	private TaxiInfo getTaxiInfo(TaxiReservation reservation) {
		int taxiInfoId = reservation.getTaxiInfo().getId();
		return infoService.getTaxiInfo(taxiInfoId);
	}
}
