package com.uncopyrighted.uncopyrightedmain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uncopyrighted.uncopyrightedmain.domain.Song;
import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;




@DataJpaTest
public class SongRepositoryTest {

	@Autowired
	private SongRepository songrepository;

	@Test
	public void findByNameShouldReturnSong() {
		Song song = songrepository.findByName("Glitcher");
		assertThat(song).isNotNull();
	}

	@Test
	public void createNewSong() {
		Song song= new Song("San Pedro", "Tubebackr", 2020, "electronica / dance (edm)", "/uncopyrighted-main/src/main/resources/templates/music/tubebackr-san-pedro.mp3");
				
		songrepository.save(song);
		assertThat(song.getSongid()).isNotNull();
	}

	@Test
	public void DeleteSong() {
		Song song = songrepository.findByName("Glitcher");
		songrepository.deleteById(song.getSongid());
		Song deletedSong = songrepository.findByName("Glitcher");
		assertThat(deletedSong).isNull();
	}
}
