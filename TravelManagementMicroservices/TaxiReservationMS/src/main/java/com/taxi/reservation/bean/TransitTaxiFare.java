package com.taxi.reservation.bean;

public class TransitTaxiFare {
	
	private float fare;
	private String pickupLocation;
	private String destination;
	private int passengerNum;
	
	public TransitTaxiFare() {

	}

	public float getFare() {
		return fare;
	}


	public void setFare(float fare) {
		this.fare = fare;
	}


	public String getPickupLocation() {
		return pickupLocation;
	}


	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getPassengerNum() {
		return passengerNum;
	}


	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}
}
