package com.arthursena.mongoSpring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.arthursena.mongoSpring.domain.Post;
import com.arthursena.mongoSpring.domain.User;
import com.arthursena.mongoSpring.dto.AuthorDTO;
import com.arthursena.mongoSpring.dto.CommentDTO;
import com.arthursena.mongoSpring.repository.PostRepository;
import com.arthursena.mongoSpring.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bianca = new User(null, "Bianca Martini", "bianca@gmail.com");
		User cassia = new User(null, "Cássia Collen", "cassia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(alex, bianca, cassia));
		
		Post post1 = new Post(null, sdf.parse("21/03/2024"), "Bora bora São Paulo!", "Quem vem me encontrar em São Paulo?", new AuthorDTO(bianca));
		Post post2 = new Post(null, sdf.parse("18/05/2024"), "Bom dia pessoal!", "Nada melhor do que uma manhã dessas né?", new AuthorDTO(bianca));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2024"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Eu também estou em SP prima!", sdf.parse("21/03/2024"), new AuthorDTO(cassia));
		CommentDTO c3 = new CommentDTO("Que vista incrível!", sdf.parse("18/05/2024"), new AuthorDTO(cassia));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		bianca.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(bianca);
	}

}
