package com.taxi.reservation.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import com.taxi.reservation.bean.Client;
import com.taxi.reservation.bean.TaxiInfo;
import com.taxi.reservation.bean.TaxiReservation;
import com.taxi.reservation.bean.TransitTaxiFare;
import com.taxi.reservation.service.ClientService;
import com.taxi.reservation.service.TaxiInfoService;
import com.taxi.reservation.service.TaxiReservationService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TaxiReservationControllerTest {

	@Mock
	ClientService clientService;

	@Mock
	TaxiReservationService taxiService;

	@Mock
	TaxiInfoService infoService;

	@InjectMocks
	TaxiReservationController controller;

	@Test
	void testSaveReservation_NoFare() {
		// Setup
		int taxiInfoId = 1;
		String viewName = "confirmReservation";
		TaxiInfo info = new TaxiInfo();
		info.setId(taxiInfoId);
		TaxiReservation reservation = new TaxiReservation();
		reservation.setTaxiInfo(info);
		ModelAndView view = new ModelAndView();

		Mockito.when(infoService.getTaxiInfo(taxiInfoId)).thenReturn(info);

		// Testing
		view = controller.saveReservation(reservation, new Client(), view);

		assertTrue(view.getModelMap().containsKey("msg"));
		assertEquals(viewName, view.getViewName());
	}
	
	@Test
	void testSaveReservation_WithFare() {
		// Setup
		int taxiInfoId = 1;
		String viewName = "confirmReservation";
		TaxiInfo info = new TaxiInfo();
		info.setId(taxiInfoId);
		TaxiReservation reservation = new TaxiReservation();
		reservation.setFare(100);
		reservation.setTaxiInfo(info);
		ModelAndView view = new ModelAndView();

		Mockito.when(infoService.getTaxiInfo(taxiInfoId)).thenReturn(info);

		// Testing
		view = controller.saveReservation(reservation, new Client(), view);

		assertFalse(view.getModelMap().containsKey("msg"));
		assertEquals(viewName, view.getViewName());
	}

	@Test
	void testDeleteReservation() {
		// Setup
		int id = 1;
		String viewName = "viewReservations";
		ModelAndView view = new ModelAndView();
		List<TaxiReservation> reservations = new ArrayList<TaxiReservation>();

		Mockito.when(taxiService.getAllTaxiReservations()).thenReturn(reservations);

		// Testing
		view = controller.deleteReservation(id, view);

		assertTrue(view.getModelMap().containsKey("taxiReservations"));
		assertEquals(viewName, view.getViewName());
	}

	@Test
	void testViewReservations() {
		// Setup
		String viewName = "viewReservations";
		ModelAndView view = new ModelAndView();
		List<TaxiReservation> reservations = new ArrayList<TaxiReservation>();

		Mockito.when(taxiService.getAllTaxiReservations()).thenReturn(reservations);

		// Testing
		view = controller.viewReservations(view);

		assertTrue(view.getModelMap().containsKey("taxiReservations"));
		assertEquals(viewName, view.getViewName());
	}

	@Test
	void testViewFares() {
		// Setup
		String viewName = "viewFares";
		List<TransitTaxiFare> fares = new ArrayList<TransitTaxiFare>();
		ModelAndView view = new ModelAndView();
		
		Mockito.when(taxiService.findAllTaxiFares()).thenReturn(fares);
		
		// Testing
		view = controller.viewFares(view);
		
		assertTrue(view.getModelMap().containsKey("fares"));
		assertEquals(viewName, view.getViewName());
	}
}
