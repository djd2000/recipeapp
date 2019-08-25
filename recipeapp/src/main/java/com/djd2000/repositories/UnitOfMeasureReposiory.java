package com.djd2000.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.djd2000.domain.UnitOfMeasure;

public interface UnitOfMeasureReposiory extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}
