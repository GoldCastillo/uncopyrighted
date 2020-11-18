package com.uncopyrighted.uncopyrightedmain.domain;

import org.springframework.data.repository.CrudRepository;

public interface IconRepository extends CrudRepository<Icon, Long> {
	Icon findByName(String name);
}
