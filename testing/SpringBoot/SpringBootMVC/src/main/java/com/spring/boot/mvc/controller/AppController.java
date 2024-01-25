package com.spring.boot.mvc.controller;

import java.util.HashMap;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.mvc.bean.User;

@Controller
@RequestMapping(path = "/app")
public class AppController {

	static HashMap<String, User> users = new HashMap<String, User>();

	// url: http://localhost:8080/app/register
	@PostMapping("/register")
	public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			Model model) {
		User user = new User(name, email, password);
		users.put(email, user);
		System.out.println("[AppController] User regustered successfully: " + user.getEmail() + " at " + new Date());
		model.addAttribute("title", "User " + email + " Registered!");
		model.addAttribute("message", "Welcome " + name + "! You were registered at " + new Date());
		return "success";
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
		String templatePage = "";
		if (users.containsKey(email)) {
			User user = users.get(email);
			if (user.getPassword().equals(password)) {
				System.out.println(
						"[AppController] User logged in successfully: " + email + " at " + new Date());
				model.addAttribute("title", "User " + email + " Registered!");
				model.addAttribute("message", "Welcome " + user.getName() + "! You were logged in at " + new Date());
				templatePage = "success";
			} else {
				System.out.println("[AppController] User login failed: " + user.getEmail() + " at " + new Date());
				model.addAttribute("title", "Invalid Credentials");
				model.addAttribute("message", "Please try again");
				templatePage = "error";
			}
		}
		
		return templatePage;
	}
}
