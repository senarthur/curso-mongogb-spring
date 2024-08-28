package com.arthursena.mongoSpring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arthursena.mongoSpring.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
