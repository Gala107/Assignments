package com.fare.calculation.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.fare.calculation.service.TaxiFareService;
import com.fare.calculation.bean.TaxiFare;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TaxiFareControllerTest {

	@Mock
	TaxiFareService service;

	@InjectMocks
	TaxiFareController controller;

	@Test
	void testFindAllFares() {
		// Setup
		int id = 1;
		String pickupLocation = "Home";
		String carModel = "Accura";
		String destination = "Airpoert";
		float amount = 150f;
		List<TaxiFare> mockFares = new ArrayList<TaxiFare>();
		mockFares.add(new TaxiFare(id, pickupLocation, 2, carModel, destination, amount));

		Mockito.when(service.getAllTaxiFare()).thenReturn(mockFares);

		// Testing
		List<TaxiFare> fares = controller.findAllFares();
		TaxiFare fare = fares.get(0);
		
		assertEquals(id, fare.getId());
		assertEquals(pickupLocation, fare.getPickupLocation());
		assertEquals(carModel, fare.getCarModel());
		assertEquals(amount, fare.getFare());
	}

	@Test
	void testGetTaxiFare() {
		// Setup
		String pickupLocation = "Home";
		String destination = "Airpoert";
		int passengerNum = 5;
		float mockAmount = 150f;
		
		Mockito.when(service.getTaxiFare(pickupLocation, destination, passengerNum)).thenReturn(mockAmount);
		
		// Testing
		float amount = controller.getTaxiFare(pickupLocation, destination, passengerNum);
		
		assertEquals(mockAmount, amount);
	}
}
