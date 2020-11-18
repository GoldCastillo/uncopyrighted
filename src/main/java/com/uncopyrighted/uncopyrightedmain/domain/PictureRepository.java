package com.uncopyrighted.uncopyrightedmain.domain;

import org.springframework.data.repository.CrudRepository;

public interface PictureRepository extends CrudRepository<Picture, Long> {
	Picture findByName(String name);
}
