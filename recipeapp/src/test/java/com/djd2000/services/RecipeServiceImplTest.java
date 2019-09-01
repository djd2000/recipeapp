/**
 * 
 */
package com.djd2000.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.djd2000.domain.Recipe;
import com.djd2000.repositories.RecipeRepository;

/**
 * @author david
 *
 */
public class RecipeServiceImplTest {

	RecipeService recipeService;

	@Mock
	RecipeRepository recipeRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	/**
	 * Test method for {@link com.djd2000.services.RecipeServiceImpl#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {

		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
//		recipeService.getRecipes().add(recipe);

		when(recipeRepository.findAll()).thenReturn(recipesData);

		Set<Recipe> recipes = recipeService.getRecipes();

		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}
