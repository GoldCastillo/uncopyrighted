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
		Picture picture = picturerepository.findByName("Dog");
		assertThat(picture).isNotNull();
	}

	@Test
	public void createNewPicture() {
		Picture picture= new Picture("Road", "Landscape", "/uncopyrighted-main/src/main/resources/templates/pictures/Road.jpeg");
				
		picturerepository.save(picture);
		assertThat(picture.getPictureid()).isNotNull();
	}

	@Test
	public void DeletePicture() {
		Picture picture = picturerepository.findByName("Dog");
		picturerepository.deleteById(picture.getPictureid());
		Picture deletedPicture = picturerepository.findByName("Dog");
		assertThat(deletedPicture).isNull();
	}
}
