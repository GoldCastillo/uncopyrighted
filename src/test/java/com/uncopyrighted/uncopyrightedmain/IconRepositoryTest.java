package com.uncopyrighted.uncopyrightedmain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.uncopyrighted.uncopyrightedmain.domain.Icon;
import com.uncopyrighted.uncopyrightedmain.domain.IconRepository;




@DataJpaTest
public class IconRepositoryTest {

	@Autowired
	private IconRepository iconrepository;

	@Test
	public void findByNameShouldReturnIcon() {
		Icon icon = iconrepository.findByName("Wifi");
		assertThat(icon).isNotNull();
	}

	@Test
	public void createNewIcon() {
		Icon icon= new Icon("Settings", "/uncopyrighted-main/src/main/resources/templates/Icons/settings.jpg");
				
		iconrepository.save(icon);
		assertThat(icon.getIconid()).isNotNull();
	}

	@Test
	public void DeleteIcon() {
		Icon icon = iconrepository.findByName("Wifi");
		iconrepository.deleteById(icon.getIconid());
		Icon deletedIcon = iconrepository.findByName("Wifi");
		assertThat(deletedIcon).isNull();
	}
}
