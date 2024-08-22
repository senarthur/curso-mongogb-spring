package com.arthursena.mongoSpring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.arthursena.mongoSpring.domain.Post;
import com.arthursena.mongoSpring.domain.User;
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
		
		Post post1 = new Post(null, sdf.parse("21/03/2024"), "Bora bora São Paulo!", "Quem vem me encontrar em São Paulo?", bianca);
		Post post2 = new Post(null, sdf.parse("18/05/2024"), "Bom dia pessoal!", "Nada melhor do que uma manhã dessas né?", bianca);
		
		userRepository.saveAll(Arrays.asList(alex, bianca, cassia));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
