package com.fare.calculation.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "taxi_fare")
public class TaxiFare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "pickup_location")
	private String pickupLocation;
	@Column(name = "passenger_num")
	private int passengerNum;
	@Column(name = "car_model")
	private String carModel;
	private String destination;
	private float fare;
	
	public TaxiFare() {

	}

	public TaxiFare(int id, String pickupLocation, int passengerNum, String carModel, String destination, float fare) {
		super();
		this.id = id;
		this.pickupLocation = pickupLocation;
		this.passengerNum = passengerNum;
		this.carModel = carModel;
		this.destination = destination;
		this.fare = fare;
	}

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

	public int getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}
}
