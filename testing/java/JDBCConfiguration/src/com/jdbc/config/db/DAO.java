package com.jdbc.config.db;

import java.util.ArrayList;

import com.jdbc.config.model.Customer;

public interface DAO {
	void createConnection();
	void closeConnection();
	
	void createCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(int id);
	ArrayList<Customer> getCustomers();
}
