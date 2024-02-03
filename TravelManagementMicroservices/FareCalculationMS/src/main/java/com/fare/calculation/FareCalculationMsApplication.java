package com.fare.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.fare.calculation")
@EntityScan(basePackages = "com.fare.calculation.bean")
@EnableJpaRepositories(basePackages = "com.fare.calculation.repository")
@EnableDiscoveryClient
public class FareCalculationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FareCalculationMsApplication.class, args);
		System.out.println("Fare Calculation Microservice is running on Port 8282.");
	}

}
