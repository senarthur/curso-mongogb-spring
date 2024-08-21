package com.arthursena.mongoSpring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.arthursena.mongoSpring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
