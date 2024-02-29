package com.spring.boot.jenkins.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("simple")
public class SimpleController {

	@GetMapping(value="/")
	public String getMessage() {
		return "Testing Spring Boot with Jenkins running as Docker container";
	}
	
	@PostMapping(value="/getList")
	public List<String> getList(@RequestBody String message) {
		List<String> alist = Arrays.asList("one", "two", "three", "fourth");		
		return alist;
	}
	
}
