package com.spring.boot.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootMicroserviceJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceJdbcApplication.class, args);
	}

}
