package com.uncopyrighted.uncopyrightedmain.domain;

import org.springframework.data.repository.CrudRepository;

public interface IconRepository extends CrudRepository<Icon, Long> {
	User findByName(String name);
}
