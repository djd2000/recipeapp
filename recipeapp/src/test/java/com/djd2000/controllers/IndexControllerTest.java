package com.djd2000.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.djd2000.services.RecipeService;

public class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	@Mock
	Model model;

	IndexController indexController;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}

	@Test
	public void test() {

		assertEquals(indexController.getIndexPage(model), "index");
		// verify interactions in mocks
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), anySet());

	}

}
