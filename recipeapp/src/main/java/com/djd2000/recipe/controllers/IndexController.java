package com.djd2000.recipe.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djd2000.domain.Category;
import com.djd2000.domain.UnitOfMeasure;
import com.djd2000.repositories.CategoryRepository;
import com.djd2000.repositories.UnitOfMeasureReposiory;

/**
 * 
 * @author david
 *
 */
@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureReposiory unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureReposiory unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}


	@RequestMapping({ "", "/", "index", "index.html" })
	public String getIndexPage() {
		
		Optional<Category> category = categoryRepository.findByDescription("Mexican");
		Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		System.out.println("Cat Id is  " + category.get().getId());
		System.out.println("Unit of measure Id is " + unitOfMeasure.get().getId());
		return "index";
	}

}
