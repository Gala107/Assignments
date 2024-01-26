package com.spring.boot.mongo.db.controller;

import java.time.LocalDateTime;
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

import com.spring.boot.mongo.db.model.Address;
import com.spring.boot.mongo.db.model.Response;
import com.spring.boot.mongo.db.model.User;
import com.spring.boot.mongo.db.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	UserRepository repository;

	@PostMapping(path = "/add")
	public ResponseEntity<Response> addUser(@RequestParam String name, @RequestParam String phone,
			@RequestParam String email, @RequestParam String adLine, @RequestParam String city,
			@RequestParam String state, @RequestParam Integer zipCode) {
		try {
			Address address = new Address(adLine, city, zipCode, state);
			User user = new User(null, name, phone, email, address);
			repository.save(user);

			Response response = new Response(101, "User " + name + " is saved successfully at " + LocalDateTime.now());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			Response response = new Response(301, "OOPS! Something went wrong: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/list")
	public ResponseEntity<Response> listAllUsers() {
		try {
			List<User> users = new ArrayList<User>();
			repository.findAll().forEach(user -> users.add(user));

			Response response = new Response(101,
					"Users [" + users.size() + "] is fetched successfully at " + LocalDateTime.now());
			response.setUsers(users);
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			Response response = new Response(301, "OOPS! Something went wrong: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/update/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable("id") String id) {
		try {
			User user = repository.findById(id).get();
			user.setName("John Darling");
			user.setEmail("john@me.com");
			user.getAddress().setAdLine("103 Lows St");
			user.getAddress().setCity("Leawood");
			user.getAddress().setState("Kansas");
			user.getAddress().setZipCode(1111);

			repository.save(user);

			Response response = new Response(101,
					"User with id " + id + " is updated successfully at " + LocalDateTime.now());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			Response response = new Response(301, "OOPS! Something went wrong: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/delete/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable("id") String id) {
		try {
			User user = repository.findById(id).get();
			repository.delete(user);

			Response response = new Response(101,
					"User with id " + id + " is updated successfully at " + LocalDateTime.now());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			Response response = new Response(301, "OOPS! Something went wrong: " + e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
