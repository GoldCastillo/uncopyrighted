package com.uncopyrighted.uncopyrightedmain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uncopyrighted.uncopyrightedmain.domain.Song;
import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;
import com.uncopyrighted.uncopyrightedmain.domain.Song;
import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;




@DataJpaTest
public class SongRepositoryTest {

	@Autowired
	private SongRepository songrepository;

	@Test
	public void findByNameShouldReturnSong() {
		List<Song> songs = songrepository.findByName("Glitcher");
		assertThat(songs).hasSize(1);
		assertThat(songs.get(0).getFile()).isEqualTo("/uncopyrighted-main/src/main/resources/templates/music/joe-crotty-glitcher.mp3");
	}

	@Test
	public void createNewSong() {
		Song song= new Song("San Pedro", "Tubebackr", 2020, "electronica / dance (edm)", "/uncopyrighted-main/src/main/resources/templates/music/tubebackr-san-pedro.mp3");			
		songrepository.save(song);
		assertThat(song.getSongid()).isNotNull();
	}

	@Test
	public void DeleteSong() {
		List <Song> song = songrepository.findByName("Glitcher");
		songrepository.deleteById(song.get(0).getSongid());
		List <Song> deletedSong = songrepository.findByName("Glitcher");
		assertThat(deletedSong).hasSize(0);
	}
}
