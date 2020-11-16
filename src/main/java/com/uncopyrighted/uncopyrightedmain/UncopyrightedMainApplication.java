package com.uncopyrighted.uncopyrightedmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.uncopyrighted.uncopyrightedmain.domain.User;
import com.uncopyrighted.uncopyrightedmain.domain.UserRepository;



@SpringBootApplication
public class UncopyrightedMainApplication {

	private static final Logger log = LoggerFactory.getLogger(UncopyrightedMainApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(UncopyrightedMainApplication.class, args);
	}
	
	@Bean
	public static CommandLineRunner uncopyrighted(UserRepository userRepository) {
		return (args) -> {

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN",
					"user@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);

			

			log.info("Fetch all Users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

		};
	
	}
}
