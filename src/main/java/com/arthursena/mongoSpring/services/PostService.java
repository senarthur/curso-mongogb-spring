package com.arthursena.mongoSpring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthursena.mongoSpring.domain.Post;
import com.arthursena.mongoSpring.repository.PostRepository;
import com.arthursena.mongoSpring.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public List<Post> findByTitle(String title) {
		// return repo.findByTitleContainingIgnoreCase(title); // Utilizando Query Methods
		return repo.findByTitle(title); // Utilizando Query
	}
	
	public List<Post> findByTextAndDate(String text, Date min, Date max) {
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.findByTextAndDate(text, min, max);
	}
}
