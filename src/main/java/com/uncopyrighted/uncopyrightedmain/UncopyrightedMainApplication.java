package com.uncopyrighted.uncopyrightedmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uncopyrighted.uncopyrightedmain.domain.Icon;
import com.uncopyrighted.uncopyrightedmain.domain.IconRepository;
import com.uncopyrighted.uncopyrightedmain.domain.Picture;
import com.uncopyrighted.uncopyrightedmain.domain.PictureRepository;
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
	public static CommandLineRunner uncopyrighted(UserRepository userRepository, SongRepository songRepository, PictureRepository pictureRepository, IconRepository iconRepository) {
		return (args) -> {

			
			//Users
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN",
					"user@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);
			
			//Songs
			Song song1 = new Song("Glitcher", "Joe Crotty", 2020, "electronica / dance (edm)", "/uncopyrighted-main/src/main/resources/templates/music/joe-crotty-glitcher.mp3");
			Song song2 = new Song("Optimistic / Inspirational", "Mixaund", 2020, "corporate / pop", "/uncopyrighted-main/src/main/resources/templates/music/mixaund-optimistic-inspirational.mp3");
			Song song3 = new Song("Land", "MusicByAden", 2020, "electronica / deep house", "/uncopyrighted-main/src/main/resources/templates/music/musicbyaden-land.mp3");
			Song song4 = new Song("Fluorescent Color", "Punch Deck", 2020, "electronica / pop", "/uncopyrighted-main/src/main/resources/templates/music/punch-deck-fluorescent-color.mp3");
			Song song5 = new Song("Good Feeling", "Roa Music", 2020, "electronica / dance (edm)", "/uncopyrighted-main/src/main/resources/templates/music/roa-music-good-feeling.mp3");
			
			songRepository.save(song1);
			songRepository.save(song2);
			songRepository.save(song3);
			songRepository.save(song4);
			songRepository.save(song5);
			
			
			//Pictures
			Picture picture1 = new Picture("Street", "City", "https://cdn.pixabay.com/photo/2020/09/05/22/29/cliff-5547648_1280.jpg");
			Picture picture2 = new Picture("City-Urban", "City", "/uncopyrighted-main/src/main/resources/templates/pictures/city-Urban.jpeg");
			Picture picture3 = new Picture("Dog", "Animal", "/uncopyrighted-main/src/main/resources/templates/pictures/dog.jpeg");
			Picture picture4 = new Picture("Mountain", "Landscape", "/uncopyrighted-main/src/main/resources/templates/pictures/mountain.jpeg");
			Picture picture5 = new Picture("Tree-Sunset", "Breathtaking", "/uncopyrighted-main/src/main/resources/templates/pictures/tree-sunset.jpeg");
			pictureRepository.save(picture1);	
			pictureRepository.save(picture2);
			pictureRepository.save(picture3);
			pictureRepository.save(picture4);
			pictureRepository.save(picture5);
			
			//Icons
			Icon icon1 = new Icon("Calendar", "/uncopyrighted-main/src/main/resources/templates/Icons/calendar.jpg");
			Icon icon2 = new Icon("Right-hand", "/uncopyrighted-main/src/main/resources/templates/Icons/right-hand.jpg");
			Icon icon3 = new Icon("Sea", "/uncopyrighted-main/src/main/resources/templates/Icons/sea.jpg");
			Icon icon4 = new Icon("Wifi", "/uncopyrighted-main/src/main/resources/templates/Icons/wifi.jpg");
			Icon icon5 = new Icon("World-Wide", "/uncopyrighted-main/src/main/resources/templates/Icons/world-wide.jpg");
			iconRepository.save(icon1);
			iconRepository.save(icon2);
			iconRepository.save(icon3);
			iconRepository.save(icon4);
			iconRepository.save(icon5);
			
			
			
			log.info("Fetch all Users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			
			log.info("Fetch all Songs");
			for (Song song : songRepository.findAll()) {
				log.info(song.toString());
			}
			
			log.info("Fetch all Pictures");
			for (Picture picture : pictureRepository.findAll()) {
				log.info(picture.toString());
			}
			
			log.info("Fetch all Icons");
			for (Icon icon : iconRepository.findAll()) {
				log.info(icon.toString());
			}

		};
	
	}
}
