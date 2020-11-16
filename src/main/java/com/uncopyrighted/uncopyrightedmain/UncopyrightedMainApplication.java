package com.uncopyrighted.uncopyrightedmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uncopyrighted.uncopyrightedmain.domain.Song;
import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;
import com.uncopyrighted.uncopyrightedmain.domain.User;
import com.uncopyrighted.uncopyrightedmain.domain.UserRepository;



@SpringBootApplication
public class UncopyrightedMainApplication {

	private static final Logger log = LoggerFactory.getLogger(UncopyrightedMainApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(UncopyrightedMainApplication.class, args);
	}
	
	@Bean
	public static CommandLineRunner uncopyrighted(UserRepository userRepository, SongRepository songRepository) {
		return (args) -> {

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN",
					"user@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);
			
			Song song1 = new Song("Optimistic / Inspirational", "Mixaund", 2020, "corporate / pop", "resources/music/mixaund-optimistic-inspirational.mp3");
			Song song2 = new Song("Land", "MusicByAden", 2020, "electronica / deep house", "resources/music/musicbyaden-land.mp3");
			Song song3 = new Song("Fluorescent Color", "Punch Deck", 2020, "electronica / pop", "resources/music/punch-deck-fluorescent-color.mp3");
			Song song4 = new Song("Good Feeling", "Roa Music", 2020, "electronica / dance (edm)", "resources/music/roa-music-good-feeling.mp3");
			Song song5 = new Song("Glitcher", "Joe Crotty", 2020, "electronica / dance (edm)", "resources/music/joe-crotty-glitcher.mp3");

			songRepository.save(song1);
			songRepository.save(song2);
			songRepository.save(song3);
			songRepository.save(song4);
			songRepository.save(song5);
			
			
			log.info("Fetch all Users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			
			log.info("Fetch all Songs");
			for (Song song : songRepository.findAll()) {
				log.info(song.toString());
			}

		};
	
	}
}
