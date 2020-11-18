package com.uncopyrighted.uncopyrightedmain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uncopyrighted.uncopyrightedmain.domain.Picture;
import com.uncopyrighted.uncopyrightedmain.domain.PictureRepository;




@DataJpaTest
public class PictureRepositoryTest {
	@Autowired
	private PictureRepository picturerepository;

	@Test
	public void findByNameShouldReturnPicture() {
		List<Picture> pictures = picturerepository.findByName("Street");
		assertThat(pictures).hasSize(1);
		assertThat(pictures.get(0).getFile()).isEqualTo("/uncopyrighted-main/src/main/resources/templates/pictures/street-picture.jpeg");
	}

	@Test
	public void createNewPicture() {
		Picture picture= new Picture("Road", "Landscape", "/uncopyrighted-main/src/main/resources/templates/pictures/Road.jpeg");
				
		picturerepository.save(picture);
		assertThat(picture.getPictureid()).isNotNull();
	}

	@Test
	public void DeletePicture() {
		List <Picture> picture = picturerepository.findByName("Street");
		picturerepository.deleteById(picture.get(0).getPictureid());
		List <Picture> deletedPicture = picturerepository.findByName("Street");
		assertThat(deletedPicture).hasSize(0);
	}
}

