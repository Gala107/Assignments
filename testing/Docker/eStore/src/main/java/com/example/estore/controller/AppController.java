package com.example.estore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estore.model.Response;
import com.example.estore.model.Product;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/welcome")
	public String welcome() {
		return "<h3>Welcome to eStore in AppController</h3>";
	}
	
	@GetMapping("/products")
	public Response getProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("iPhone",8000));
		products.add(new Product("MacBook", 11000));
		products.add(new Product("Watch", 2000));
		
		Response response = new Response(101, "Products fetched successfully", products);
		return response;
	}
}
