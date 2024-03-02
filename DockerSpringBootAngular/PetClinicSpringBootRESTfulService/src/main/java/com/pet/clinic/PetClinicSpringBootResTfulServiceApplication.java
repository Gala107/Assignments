package com.pet.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="com.pet.clinic.bean")
@EnableJpaRepositories(basePackages="com.pet.clinic.repository")
public class PetClinicSpringBootResTfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicSpringBootResTfulServiceApplication.class, args);
	}
}
