package com.arthursena.mongoSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.arthursena.mongoSpring.domain.User;
import com.arthursena.mongoSpring.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bianca = new User(null, "Bianca Martini", "bianca@gmail.com");
		User cassia = new User(null, "Cássia Collen", "cassia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(alex, bianca, cassia));
	}

}
