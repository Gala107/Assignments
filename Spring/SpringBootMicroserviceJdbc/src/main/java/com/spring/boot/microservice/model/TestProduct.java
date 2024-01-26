package com.spring.boot.microservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="test_product")
public class TestProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pid;
	String name;
	Integer price;
	
	@Column(name="brand_name")
	String brandName;
	
	public TestProduct() {

	}

	public TestProduct(Integer pid, String name, String brandName, Integer price) {
		this.pid = pid;
		this.name = name;
		this.brandName = brandName;
		this.price = price;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", brandName=" + brandName + ", price=" + price + "]";
	}
}
