package com.uncopyrighted.uncopyrightedmain.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IconRepository extends CrudRepository<Icon, Long> {
	 List<Icon> findByName(String name);
}
