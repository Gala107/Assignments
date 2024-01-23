package com.spring.boot.initializer.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/welcome")
	public String welcomeHome() {
		return "welcome";
	}
}
