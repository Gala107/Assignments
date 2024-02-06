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

import com.taxi.reservation.service.ClientService;
import com.taxi.reservation.service.TaxiInfoService;
import com.taxi.reservation.bean.Client;
import com.taxi.reservation.bean.TaxiInfo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

	@Mock
	ClientService clientService;

	@Mock
	TaxiInfoService infoService;

	@InjectMocks
	ClientController controller;

	@SuppressWarnings("unchecked")
	@Test
	void testGetClient_ByEmail() {
		// Setup
		String findBy = "email";
		String clientInfo = "gala@me.com";
		String viewName = "makeReservation";
		ModelAndView view = new ModelAndView();

		Client client = new Client();
		client.setEmail(findBy);
		List<TaxiInfo> info = new ArrayList<TaxiInfo>();

		Mockito.when(clientService.findClientByEmail(clientInfo)).thenReturn(client);
		Mockito.when(infoService.getAllTaxiInfo()).thenReturn(info);

		// Testing
		view = controller.getClient(findBy, clientInfo, view);
		Client testClient = (Client) view.getModelMap().get("client");
		List<TaxiInfo> testInfo = (List<TaxiInfo>) view.getModelMap().get("taxi");
		
		assertEquals(findBy, testClient.getEmail());
		assertEquals(info.size(), testInfo.size());
		assertEquals(viewName, view.getViewName());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetClient_ByPhone() {
		// Setup
		String findBy = "phone";
		String clientInfo = "123 222 3243";
		String viewName = "makeReservation";
		ModelAndView view = new ModelAndView();

		Client client = new Client();
		client.setEmail(findBy);
		List<TaxiInfo> info = new ArrayList<TaxiInfo>();

		Mockito.when(clientService.findClientByPhone(clientInfo)).thenReturn(client);
		Mockito.when(infoService.getAllTaxiInfo()).thenReturn(info);

		// Testing
		view = controller.getClient(findBy, clientInfo, view);
		Client testClient = (Client) view.getModelMap().get("client");
		List<TaxiInfo> testInfo = (List<TaxiInfo>) view.getModelMap().get("taxi");
		
		assertEquals(findBy, testClient.getEmail());
		assertEquals(info.size(), testInfo.size());
		assertEquals(viewName, view.getViewName());
	}

	@Test
	void testFindClient() {
		// Setup
		ModelAndView view = new ModelAndView();
		
		// Testing
		view = controller.findClient(view);
		
		assertTrue(view.getModelMap().containsKey("client"));
		assertTrue(view.getModelMap().containsKey("clientInfo"));
		assertTrue(view.getModelMap().containsKey("findBy"));
		assertEquals("findClient", view.getViewName());	
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetTaxiInfo() {
		// Setup
		Client client = new Client();
		ModelAndView view = new ModelAndView();
		List<TaxiInfo> info = new ArrayList<TaxiInfo>();
		
		Mockito.when(infoService.getAllTaxiInfo()).thenReturn(info);
		
		// Testing
		view = controller.getTaxiInfo(client, view);
		List<TaxiInfo> testInfo = (List<TaxiInfo>) view.getModelMap().get("taxi");
		
		assertTrue(view.getModelMap().containsKey("reservation"));
		assertTrue(view.getModelMap().containsKey("taxi"));
		assertEquals(0, testInfo.size());
		assertEquals("makeReservation", view.getViewName());		
	}
}
