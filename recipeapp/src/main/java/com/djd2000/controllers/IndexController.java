package com.djd2000.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djd2000.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author david
 *
 */
@Slf4j
@Controller
public class IndexController {
	RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "index", "index.html" })
	public String getIndexPage(Model model) {
		log.debug("Getting Index page");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

}
