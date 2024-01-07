package com.spring.jdbc.model;

public class Dish {
	
	int id;
	String name;
	int price;
	
	public Dish() {

	}
	
	public Dish(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
