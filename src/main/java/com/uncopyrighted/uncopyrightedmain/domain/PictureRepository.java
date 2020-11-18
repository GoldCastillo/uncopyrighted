package com.uncopyrighted.uncopyrightedmain.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PictureRepository extends CrudRepository<Picture, Long> {
	 List<Picture> findByName(String name);
}
