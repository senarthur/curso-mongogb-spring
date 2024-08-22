package com.arthursena.mongoSpring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arthursena.mongoSpring.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
