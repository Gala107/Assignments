package com.example.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.model.Customer;
import com.example.cms.model.Response;
import com.example.cms.repository.CustomerRepository;

@RestController
@RequestMapping("/app")
public class AppController {
	
	@Autowired
	CustomerRepository repository;
	
	@PostMapping("/add")
	public Response addCustomer(@RequestParam String name, @RequestParam String phone, @RequestParam String email) {
		
		Customer customer = new Customer(null, name, phone, email);
		repository.save(customer);
		
		return new Response(101, name + " is added successfully at " + new Date(), null);
	}
	
	@GetMapping("/list")
	public Response listCustomer() {
		
		List<Customer> customers = new ArrayList<Customer>();
		repository.findAll().forEach(customer -> customers.add(customer));
		
		return new Response(101, "Total of " + customers.size() + " customers is fetched at "+ new Date(), customers);
	}
}
