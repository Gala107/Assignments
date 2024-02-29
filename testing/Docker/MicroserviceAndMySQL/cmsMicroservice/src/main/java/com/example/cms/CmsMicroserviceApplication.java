package com.example.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmsMicroserviceApplication {

	public static void main(String[] args) {
		// externalize the spring properties
		System.setProperty("spring.config.location", "application.properties");
		SpringApplication.run(CmsMicroserviceApplication.class, args);
	}

}
