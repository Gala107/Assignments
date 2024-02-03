package com.taxi.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.taxi.reservation")
@EntityScan(basePackages = "com.taxi.reservation.bean")
@EnableJpaRepositories(basePackages = "com.taxi.reservation.repository")
@EnableDiscoveryClient
public class TaxiReservationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiReservationMsApplication.class, args);
		System.out.println("Taxi Reservation Microservice is running on Port 8181.");
	}

}
