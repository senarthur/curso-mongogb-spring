package com.arthursena.mongoSpring.services;

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
		// return repo.findByTitleContainingIgnoreCase(title);
		return repo.findByTitle(title);
	}
}
