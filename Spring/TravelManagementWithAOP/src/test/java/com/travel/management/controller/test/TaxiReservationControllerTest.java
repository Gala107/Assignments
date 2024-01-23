package com.travel.management.controller.test;

import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import com.travel.management.bean.TaxiReservation;
import com.travel.management.controller.TaxiReservationController;
import com.travel.management.service.ClientService;
import com.travel.management.service.TaxiReservationService;

@ExtendWith(MockitoExtension.class)
public class TaxiReservationControllerTest {

	@InjectMocks
	TaxiReservationController controller = new TaxiReservationController();

	@Mock
	ClientService clientService;
	@Mock
	TaxiReservationService taxiService;
	
	TaxiReservation reservation = new TaxiReservation();
	ModelAndView view = new ModelAndView();

	@BeforeEach
	public void setTaxiReservations() throws IllegalArgumentException, InvocationTargetException, Exception {

		List<TaxiReservation> expectedReservations = Arrays.asList(reservation);
		when(taxiService.getAllTaxiReservations()).thenReturn(expectedReservations);
	}
	
	@Test
	public void testGetAllTaxiReservations_Successfull() throws IllegalArgumentException, InvocationTargetException, Exception {

		controller.viewReservations(view);
	}
}
