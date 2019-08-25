package com.djd2000.repositories;

import org.springframework.data.repository.CrudRepository;

import com.djd2000.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

//	@Override
//	public Iterable<Recipe> findAll();
//	
//	@Override
//	public <S extends Recipe> S save(S entity);
}
