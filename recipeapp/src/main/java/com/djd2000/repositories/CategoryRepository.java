package com.djd2000.repositories;

import org.springframework.data.repository.CrudRepository;

import com.djd2000.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
