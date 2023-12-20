package com.spring.autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
	
	String name;
	String email;
	
	// 1 to 1 relationship
	Order order;
	
	public User() {
		System.out.println("[User] - Object is created: " + hashCode());	
	}

	@Autowired
	public User(Order order) {
		System.out.println("[User] - Constructor Injection - Object is created with Parametarized Constructor having Order as input");	
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Order getOrder() {
		return order;
	}

	// setter Method will inject Order as Dependency which is pretty much the reference type
	@Autowired
	public void setOrder(Order order) {
		System.out.println("[User] - Setter Injection - setOrder(...) is executed having Order as input");	
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", order=" + order + "]";
	}
}
