package com.travel.management.controller;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.travel.management.bean.TaxiReservation;
import com.travel.management.service.TaxiInfoService;
import com.travel.management.service.TaxiReservationService;

@Path("/taxi")
public class TaxiReservationController {

	TaxiReservationService taxiService = new TaxiReservationService();
	TaxiInfoService infoService = new TaxiInfoService();
	
	@GET
	@Path("findAllTaxiReservations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaxiReservation> findAllTaxiReservations() {
		return taxiService.getAllTaxiReservations();
	}

	@POST
	@Path("saveReservation")
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveReservation(TaxiReservation taxiReservation) {
		return taxiService.saveTaxiReservation(taxiReservation);
	}

	@DELETE
	@Path("deleteReservation/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteReservation(@PathParam("id") int id) {
		return taxiService.deleteTaxiReservation(id);
	}
}
