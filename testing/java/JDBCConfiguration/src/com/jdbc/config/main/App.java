package com.jdbc.config.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.jdbc.config.db.DB;
import com.jdbc.config.model.Customer;

public class App {

	public static void main(String[] args) {
		/*
		 System.out.println("Welcome to Customer Management System.");
		 
		
		Customer customer = new Customer();
		//customer.setId(2);
		customer.setName("George");
		customer.setPhone("20202020202");
		customer.setEmail("george@me.com");
		customer.setBirthday("2000-05-05");
		customer.setAge(99);
		customer.setTemperature(11f);
		customer.setInDateTime("2018-11-27 12:40:54");
		customer.setOutDateTime("2018-11-27 12:40:54");
		System.out.println("Connecting to DB...");
		
		DB db = new DB();
		db.createConnection();
		
		db.createCustomer(customer);
		//db.updateCustomer(customer);
		
		db.deleteCustomer(1);
		System.out.println();
		
		ArrayList<Customer> customers = db.getCustomers();
		customers.forEach(cRef -> System.out.println(cRef));
		
		db.closeConnection();
		*/
		
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter name: ");
//		String name = scanner.nextLine();
//		
//		System.out.println("Enter created_by: ");
//		String created_by = scanner.nextLine();
		
//		System.out.println("Enter customer ID: ");
//		int cid = scanner.nextInt();
		
		scanner.close();
		
		DB db = new DB();
		db.createConnection();
//		db.executeProcedure(name, created_by);
//		db.executeProcedure(cid);
//		db.executeBatchWithPreparedStatement();
//		db.executeTransaction();
		
		db.showMetadata();
		db.closeConnection();
	}
}
