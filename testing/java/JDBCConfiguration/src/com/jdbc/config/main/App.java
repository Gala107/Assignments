package com.jdbc.config.main;

import java.util.ArrayList;

import com.jdbc.config.db.DB;
import com.jdbc.config.model.Customer;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to Customer Management System.");
		
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Leo");
		customer.setPhone("333 333 3333");
		customer.setEmail("leo@me.com");
		customer.setBirthday("2000-05-05");
		customer.setAge(99);
		customer.setTemperature(11f);
		customer.setInDateTime("2021-11-27 12:40:54");
		customer.setOutDateTime("2021-11-27 12:40:54");
		System.out.println("Connecting to DB...");
		
		DB db = new DB();
		db.createConnection();
		
		//db.createCustomer(customer);
		//db.updateCustomer(customer);
		
		db.deleteCustomer(1);
		System.out.println();
		
		ArrayList<Customer> customers = db.getCustomers();
		customers.forEach(cRef -> System.out.println(cRef));
		
		db.closeConnection();
	}
}
