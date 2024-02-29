package com.spring.boot.jenkins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.jenkins.controller.SimpleController;

@SpringBootTest
public class SimpleControllerTest {

	@Autowired
	SimpleController controller;
	
	@Test
	void testGetMessage() {
		String result = controller.getMessage();
		assertEquals("Testing Spring Boot with Jenkins running as Docker container", result);
	}
}
