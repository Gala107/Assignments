package com.spring.dependency.injection.bean;

import java.util.List;

public class Restaurant {
	
	String name;
	String phone;
	String operatingHours;
	float ratings;
	
	// 1 to 1; HAS-A Relationship
	Address address;
	
	// 1 to many; HAS-A Relationship
	List<String> searchKeywords;
	//List<Dish> dishes;
	
	public Restaurant() {
		System.out.println("[Restaurant] - Object constructed.");
	}

	// Parameterized constructor for Constructor Injection
	public Restaurant(Address address) {
		System.out.println("[Restaurant] - Object Constructed - Parameterized Constructor with Address as Input");
		System.out.println("[Restaurant] - Constructor Injection");
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("[Restaurant] setAddress(...) is executed - SETTER INJECTION");
		this.address = address;
	}

	public List<String> getSearchKeywords() {
		return searchKeywords;
	}

	public void setSearchKeywords(List<String> searchKeywords) {
		System.out.println("[Restaurant] setSearchKeywords is executed - setter injection (1 to Many)");
		this.searchKeywords = searchKeywords;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", phone=" + phone + ", operatingHours=" + operatingHours + ", ratings="
				+ ratings + ", address=" + address + "]";
	}
}
