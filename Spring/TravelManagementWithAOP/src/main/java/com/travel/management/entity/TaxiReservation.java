package com.travel.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TaxiReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pickupLocation;
	private String pickupTime;
	private String destination;
	private int passengerNum;
	private float fare;	
	@Column(name = "luggage")
	private boolean isLuggage;	
	@OneToOne
	private int clientId;
	@OneToOne
	private int taxiId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
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
	public boolean isLuggage() {
		return isLuggage;
	}
	public void setLuggage(boolean isLuggage) {
		this.isLuggage = isLuggage;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getTaxiId() {
		return taxiId;
	}
	public void setTaxiId(int taxiId) {
		this.taxiId = taxiId;
	}
	@Override
	public String toString() {
		return "TaxiReservation [id=" + id + ", pickupLocation=" + pickupLocation + ", pickupTime=" + pickupTime
				+ ", destination=" + destination + ", passengerNum=" + passengerNum + ", isLuggage=" + isLuggage
				+ ", fare=" + fare + ", clientId=" + clientId + ", taxiId=" + taxiId + "]";
	}
}
