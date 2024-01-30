package com.spring.boot.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudEurekaApplication.class, args);
	}

}
