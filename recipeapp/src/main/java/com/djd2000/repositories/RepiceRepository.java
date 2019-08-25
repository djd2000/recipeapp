package com.djd2000.repositories;

import org.springframework.data.repository.CrudRepository;

import com.djd2000.domain.Recipe;

public interface RepiceRepository extends CrudRepository<Recipe, Long> {

}
