package com.djd2000.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.djd2000.domain.Category;
/**
 * 
 * @author david
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Optional<Category> findByDescription(String description);
}
