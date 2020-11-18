package com.uncopyrighted.uncopyrightedmain.domain;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	Song findByName(String name);
}
