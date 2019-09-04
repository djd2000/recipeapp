package com.djd2000.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.djd2000.domain.Recipe;
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
	public void testMockMVC() throws Exception {
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMVC.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}

	@Test
	public void test() {

		// given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());

		Recipe recipe2 = new Recipe();
		recipe2.setId(1L);
		recipes.add(recipe2);

		when(recipeService.getRecipes()).thenReturn(recipes);
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// when
		String viewName = indexController.getIndexPage(model);

		// then
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
