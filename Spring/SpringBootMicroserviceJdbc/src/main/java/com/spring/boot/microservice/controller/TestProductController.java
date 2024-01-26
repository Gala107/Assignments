package com.spring.boot.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservice.model.Response;
import com.spring.boot.microservice.model.TestProduct;
import com.spring.boot.microservice.repository.TestProductRepository;

@RestController
@RequestMapping(path = "/products")
public class TestProductController {

	@Autowired
	TestProductRepository repository;

	@PostMapping(path = "/add")
	public ResponseEntity<Response> addTestProduct(@RequestParam String name, @RequestParam String brandName,
			@RequestParam Integer price) {
		TestProduct product = new TestProduct(0, name, brandName, price);
		System.out.println("TestProduct: " + product);

		try {
			repository.save(product);

			Response response = new Response(101, "Product " + name + " is saved successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			Response response = new Response(701,
					"Product " + name + " is not saved successfully. Exception: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/update/{pid}")
	public ResponseEntity<Response> updateTestProduct(@PathVariable("pid") Integer pid) {
		TestProduct product = new TestProduct(pid, "WaterBottle", "Hidrate", 3000);
		System.out.println("TestProduct: " + product);

		try {
			
			// save() inserts new record if id is missing or updates existing record if id is present
			repository.save(product);

			Response response = new Response(101, "Product with ID" + pid + " is updated successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			Response response = new Response(701, "Product with ID" + pid + " is not updated successfully. Exception: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/list")
	public ResponseEntity<Response> fetchAllProducts() {
		try {
			List<TestProduct> products = new ArrayList<TestProduct>();
			repository.findAll().forEach(product -> products.add(product));

			Response response = new Response(101, "All Products [" + products.size() + "] are fetched successfully", products);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			Response response = new Response(701, "Unable to fetch Products. Something went wrong. Exception: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/delete/{pid}")
	public ResponseEntity<Response> deleteTestProduct(@PathVariable("pid") Integer pid) {
		TestProduct product = new TestProduct();
		product.setPid(pid);
		System.out.println("TestProduct: " + product);

		try {
			
			repository.delete(product);

			Response response = new Response(101, "Product with ID" + pid + " is deleted successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			Response response = new Response(701, "Product with ID" + pid + " is not deleted successfully. Exception: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
