package com.example.cms.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cms.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
