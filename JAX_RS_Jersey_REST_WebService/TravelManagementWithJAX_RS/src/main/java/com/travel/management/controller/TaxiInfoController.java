package com.travel.management.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.travel.management.bean.TaxiInfo;
import com.travel.management.bean.TaxiReservation;
import com.travel.management.service.TaxiInfoService;
import com.travel.management.service.TaxiReservationService;

@Path("/info")
public class TaxiInfoController {
	
	TaxiInfoService infoService = new TaxiInfoService();
	TaxiReservationService taxiService = new TaxiReservationService();
	
	@GET
	@Path("findAllTaxiInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaxiInfo> findAllTaxiInfo() {
		return infoService.getAllTaxiInfo();
	}
	
	@GET
	@Path("findAllTaxiReservations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaxiReservation> findAllTaxiReservations() {
		return taxiService.getAllTaxiReservations();
	}
}
