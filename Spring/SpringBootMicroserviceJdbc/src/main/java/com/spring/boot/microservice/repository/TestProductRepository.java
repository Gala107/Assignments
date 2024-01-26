package com.spring.boot.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.microservice.model.TestProduct;

public interface TestProductRepository extends CrudRepository<TestProduct, Integer> {

}
