package com.travel.management.aspect;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.travel.management.bean.Client;
import com.travel.management.bean.TaxiReservation;

@Aspect
public class TaxiReservationControllerAspect {

	@After("execution(* com.travel.management.controller.TaxiReservationController.saveReservation(..))")
	public void saveReservationNotification(JoinPoint joinPoint) {
		TaxiReservation reservation = (TaxiReservation) joinPoint.getArgs()[0];
		Client client = reservation.getClient();
		Date recordCreatedDate = new Date();
		System.out.println("[TaxiReservationControllerAspect] Taxi Reservation record is created for " + client.getName() + " on " + recordCreatedDate);
	}
	
	@After("execution(* com.travel.management.controller.TaxiReservationController.deleteReservation(..))")
	public void deleteReservationNotification(JoinPoint joinPoint) {
		HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
		String id = request.getParameter("id");
		Date recordDeletedDate = new Date();
		System.out.println("[TaxiReservationControllerAspect] Taxi Reservation record with ID=" + id + " is deleted on " + recordDeletedDate);
	}
}
