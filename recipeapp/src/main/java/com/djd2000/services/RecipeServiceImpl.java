package com.djd2000.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.djd2000.domain.Recipe;
import com.djd2000.repositories.RecipeRepository;

/**
 * 
 * @author david
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	RecipeRepository recipieRepository;

	public RecipeServiceImpl(RecipeRepository recipieRepository) {
		super();
		this.recipieRepository = recipieRepository;
	}

	@Override
	public Set<Recipe> getAllRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipieRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

}
