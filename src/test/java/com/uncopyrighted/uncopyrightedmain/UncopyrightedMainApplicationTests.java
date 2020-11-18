package com.uncopyrighted.uncopyrightedmain;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.uncopyrighted.uncopyrightedmain.web.IconController;
import com.uncopyrighted.uncopyrightedmain.web.PictureController;
import com.uncopyrighted.uncopyrightedmain.web.SongController;



@ExtendWith(SpringExtension.class)
@SpringBootTest
class UncopyrightedMainApplicationTests {
	
	@Autowired
	private IconController iconcontroller;
	
	@Autowired
	private PictureController picturecontroller;
	
	@Autowired
	private SongController songcontroller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(iconcontroller).isNotNull();
		assertThat(picturecontroller).isNotNull();
		assertThat(songcontroller).isNotNull();
	}
}
