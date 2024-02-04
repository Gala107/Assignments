package com.taxi.reservation.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@Table(name = "taxi_reservation")
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
	@ManyToOne
	private Client client;
	@ManyToOne
	private TaxiInfo taxi;
	
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public TaxiInfo getTaxiInfo() {
		return taxi;
	}
	public void setTaxiInfo(TaxiInfo taxi) {
		this.taxi = taxi;
	}
	@Override
	public String toString() {
		return "TaxiReservation [id=" + id + ", pickupLocation=" + pickupLocation + ", pickupTime=" + pickupTime
				+ ", destination=" + destination + ", passengerNum=" + passengerNum + ", isLuggage=" + isLuggage
				+ ", fare=" + fare + ", client=" + client + ", taxi=" + taxi + "]";
	}
}
