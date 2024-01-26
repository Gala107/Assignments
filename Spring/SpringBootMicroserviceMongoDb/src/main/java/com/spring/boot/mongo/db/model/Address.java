package com.spring.boot.mongo.db.model;

public class Address {

	String adLine;
	String city;
	Integer zipCode;
	String state;
	
	public Address() {

	}
	public Address(String adLine, String city, Integer zipCode, String state) {
		super();
		this.adLine = adLine;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
	}
	public String getAdLine() {
		return adLine;
	}
	public void setAdLine(String adLine) {
		this.adLine = adLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [adLine=" + adLine + ", city=" + city + ", zipCode=" + zipCode + ", state=" + state + "]";
	}
}
