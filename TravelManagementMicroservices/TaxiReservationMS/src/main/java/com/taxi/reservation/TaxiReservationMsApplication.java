package com.taxi.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.taxi.reservation")
@EntityScan(basePackages = "com.taxi.reservation.bean")
@EnableJpaRepositories(basePackages = "com.taxi.reservation.repository")
@EnableDiscoveryClient
public class TaxiReservationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiReservationMsApplication.class, args);
		System.out.println("Taxi Reservation Microservice is running on Port 8181.");
	}

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
		return new RestTemplate(); 
	}
}
