package com.travel.management.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TaxiReservationControllerTest {

	@Mock
	ClientService clientService;
	@Mock
	TaxiReservationService taxiService;
	@Mock
	TaxiFareService fareService;
	@Mock
	TaxiInfoService infoService;
	@Mock
	HttpServletRequest request;
	@Mock
	RedirectAttributes redirectAttributes;

	@InjectMocks
	TaxiReservationController controller;

	@Test
	void testSaveReservation() {
		Client client = new Client();
		client.setId(1);
		TaxiInfo info = new TaxiInfo();

		TaxiReservation reservation = new TaxiReservation();
		reservation.setClient(client);
		reservation.setTaxiInfo(info);

		TaxiFare fare = new TaxiFare();
		ModelAndView view = new ModelAndView();

		try {
			Mockito.when(infoService.getTaxiInfo(1)).thenReturn(info);
			Mockito.when(fareService.findTaxiFare(fare)).thenReturn(0f);
		} catch (Exception e) {
			System.err.println(e);
		}

		view = controller.saveReservation(reservation, view);
		assertEquals("confirmReservation.jsp", view.getViewName());
	}

	@Test
	void testDeleteReservation() {
		ModelAndView view = new ModelAndView();

		try {
			Mockito.when(request.getParameter("id")).thenReturn("5");
			Mockito.when(taxiService.getAllTaxiReservations()).thenReturn(null);
		} catch (Exception e) {
			System.err.println(e);
		}

		view = controller.deleteReservation(request, view);
		assertEquals("viewReservations.jsp", view.getViewName());
		assertEquals(true, view.getModelMap().containsAttribute("taxiReservations"));
	}

	@Test
	void testViewReservations() {
		ModelAndView view = new ModelAndView();

		try {
			Mockito.when(taxiService.getAllTaxiReservations()).thenReturn(new ArrayList<TaxiReservation>());
		} catch (Exception e) {
			System.err.println(e);
		}

		view = controller.viewReservations(view);
		assertEquals("viewReservations.jsp", view.getViewName());
		assertEquals(true, view.getModelMap().containsAttribute("taxiReservations"));
	}

	@Test
	void testSaveUpdateReservation() {
		TaxiReservation reservation = new TaxiReservation();
		TaxiFare fare = new TaxiFare();
		ModelAndView view = new ModelAndView();

		try {
			Mockito.when(fareService.findTaxiFare(fare)).thenReturn(0f);
		} catch (Exception e) {
			System.err.println(e);
		}

		view = controller.saveUpdateReservation(reservation, view);
		assertEquals("viewReservations.jsp", view.getViewName());
		assertEquals(true, view.getModelMap().containsAttribute("taxiReservations"));
	}

	@Test
	void testUpdateReservation() {
		TaxiReservation reservation = new TaxiReservation();
		ModelAndView view = new ModelAndView();

		try {
			Mockito.when(request.getParameter("id")).thenReturn("5");
			Mockito.when(taxiService.getTaxiReservation(5)).thenReturn(reservation);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		view = controller.updateReservation(request, redirectAttributes, view);
		assertEquals("redirect:updateReservationFrom", view.getViewName());
	}
}
