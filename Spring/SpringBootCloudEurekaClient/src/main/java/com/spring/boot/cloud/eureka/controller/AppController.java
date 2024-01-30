package com.spring.boot.cloud.eureka.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.cloud.eureka.bean.Product;
import com.spring.boot.cloud.eureka.bean.Response;

@RestController
@RequestMapping(path="/app")
public class AppController {
	
	@GetMapping(path="/products")
	public Response getProducts() {
		Product p1 = new Product("iPhone", 80000);
		Product p2 = new Product("Apple", 8120000);
		Product p3 = new Product("Water Bootle", 1300);
		Product p4 = new Product("Apple Watch", 9000);
		Product p5 = new Product("Apple MacBook", 250000);
		
		List<Product> products = Arrays.asList(p1, p2, p3, p4, p5);
		Response response = new Response(101, "Products fetched successfully", products);
		return response;
	}
}
