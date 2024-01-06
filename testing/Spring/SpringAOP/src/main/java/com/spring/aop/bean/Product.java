package com.spring.aop.bean;

public class Product {

	int id;
	String name;
	int price;
	String brand;
	int stock;
	boolean canBuy;
	
	public Product() {
		System.out.println("[Product] Object is created.");		
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isCanBuy() {
		return canBuy;
	}

	public void setCanBuy(boolean canBuy) {
		this.canBuy = canBuy;
	}
	
	// Business Method
	public void purchaseProduct(String deliveryLocation, String deliveryTime, String userEmail) {
		// 1. Validate the Stock | PRE PROCESSING
		System.out.println("[Product] - Validating Stock...");
		if (stock > 0) {
			System.out.println("[Product] - Please initiate the transaction for the amount of " + price);
			System.out.println();
			
			// 2. Transaction - CORE BUSINESS LOGIC
			System.out.println("-----------------------------");
			System.out.println("[Product] - Bank Transaction started for " + name + " with price as " + price);
			System.out.println("[Product] - Thank you " + userEmail + " for buying " + name + " of " + brand);
			System.out.println();
			
			// 3. Notification | POST PROCESSING
			System.out.println("[Product] - Notifying " + userEmail + " through email with invoice of the amount " + price);
			System.out.println("[Product] - Product " + brand + " " + name + " will be delivered at " + deliveryLocation + " by " + deliveryTime);
			System.out.println("[Product] - Notify the Shipment and Dispatch Department for the purchase of " + name);
		} else {
			System.out.println("[Product] - We are out of stock. Please come back later.");
		}
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", stock=" + stock
				+ ", canBuy=" + canBuy + "]";
	}
}
