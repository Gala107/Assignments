package com.spring.boot.mongo.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.boot.mongo.db.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
