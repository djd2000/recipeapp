package com.djd2000.bootstrap;

import java.math.BigDecimal;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.djd2000.domain.Category;
import com.djd2000.domain.Difficulty;
import com.djd2000.domain.Ingredient;
import com.djd2000.domain.Notes;
import com.djd2000.domain.Recipe;
import com.djd2000.domain.UnitOfMeasure;
import com.djd2000.repositories.CategoryRepository;
import com.djd2000.repositories.RecipeRepository;
import com.djd2000.repositories.UnitOfMeasureReposiory;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author david
 *
 */
@Slf4j
@Component
public class RecipeBootstrap implements CommandLineRunner {
	private final RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private UnitOfMeasureReposiory unitOfMeasureRepository;

	public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureReposiory unitOfMeasureRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if (!recipeRepository.findAll().iterator().hasNext()) {
			loadData();
			log.debug("loading bootstarp data");
		}

		printData();

	}

	private void printData() {
		// TODO Auto-generated method stub

	}

	private void loadData() {
		Recipe guacRecipe = new Recipe();
		Optional<Category> mexicanCategory = categoryRepository.findByDescription("Mexican");
		Optional<Category> americanCategory = categoryRepository.findByDescription("American");
//		Optional<UnitOfMeasure> uOMTeaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");

		// get UOMs
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

		if (!eachUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

		if (!tableSpoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		if (!teaSpoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

		if (!dashUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

		if (!pintUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

		if (!cupsUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		// get optionals
		UnitOfMeasure eachUom = eachUomOptional.get();
		UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
		UnitOfMeasure teapoonUom = tableSpoonUomOptional.get();
		UnitOfMeasure dashUom = dashUomOptional.get();
		UnitOfMeasure pintUom = pintUomOptional.get();
		UnitOfMeasure cupsUom = cupsUomOptional.get();

//		Set<Category> perfectGuacamoleCategories = new HashSet<>();
//		perfectGuacamoleCategories.add(categoryMexican.get());

//		Set<Ingredient> pgIngredients = new HashSet<>();
//		Ingredient avacadoIngredient = new Ingredient();
//		avacadoIngredient.setAmount(new BigDecimal(2));
//		avacadoIngredient.setDescription("Ripe Avacados");
//		pgIngredients.add(avacadoIngredient);

//		Ingredient kosherSalt = new Ingredient();
//		kosherSalt.setAmount(new BigDecimal(0.5));
//		kosherSalt.setDescription("KosherSalt");
//		kosherSalt.setUom(uOMTeaspoon.get());
//		pgIngredients.add(kosherSalt);

		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes(
				"The BEST guacamole! EASY to make with ripe avocados, salt, serrano chiles, cilantro and lime. Garnish with red radishes or jicama. Serve with tortilla chips.");
		guacRecipe.setNotes(guacNotes);
//		guacNotes.setRecipe(guacRecipe);

		guacRecipe.setDescription("Perfect Gucamaloe");
		guacRecipe.setCookTime(0);
		guacRecipe.setPrepTime(10);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections(
				"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.");
		guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		// guacRecipe.setCategories(perfectGuacamoleCategories);
		guacRecipe.getCategories().add(americanCategory.get());
		guacRecipe.getCategories().add(mexicanCategory.get());
		guacRecipe.setServings(4);
		guacRecipe.setSource("Elise Bauer");

//		avacadoIngredient.setRecipe(guacRecipe);
//		kosherSalt.setRecipe(guacRecipe);

//		guacRecipe.setIngredients(pgIngredients);

		Set<Ingredient> guacIngredients = new HashSet<>();
		final BigDecimal bigDecTwo = new BigDecimal(2);
		final BigDecimal bigDecHalf = new BigDecimal(".5");

//		guacIngredients.add(new Ingredient("ripe avocados", bigDecTwo, eachUom));
//		guacIngredients.add(new Ingredient("Kosher salt", bigDecHalf, teapoonUom));
//		guacIngredients.add(new Ingredient("fresh lime juice or lemon juice", bigDecTwo, tableSpoonUom));
//		guacIngredients.add(new Ingredient("minced red onion or thinly sliced green onion", bigDecTwo, tableSpoonUom));
//		guacIngredients.add(new Ingredient("serrano chiles, stems and seeds removed, minced", bigDecTwo, eachUom));
//		guacIngredients.add(new Ingredient("Cilantro", bigDecTwo, tableSpoonUom));
//		guacIngredients.add(new Ingredient("freshly grated black pepper", bigDecTwo, dashUom));
//		guacIngredients.add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", bigDecHalf, eachUom));

//		addIngredientsToRecipe(guacIngredients, guacRecipe);

		guacRecipe.addingIngredient(new Ingredient("ripe avocados", bigDecTwo, eachUom));
		guacRecipe.addingIngredient(new Ingredient("Kosher salt", bigDecHalf, teapoonUom));
		guacRecipe.addingIngredient(new Ingredient("fresh lime juice or lemon juice", bigDecTwo, tableSpoonUom));
		guacRecipe.addingIngredient(
				new Ingredient("minced red onion or thinly sliced green onion", bigDecTwo, tableSpoonUom));
		guacRecipe.addingIngredient(
				new Ingredient("serrano chiles, stems and seeds removed, minced", bigDecTwo, eachUom));
		guacRecipe.addingIngredient(new Ingredient("Cilantro", bigDecTwo, tableSpoonUom));
		guacRecipe.addingIngredient(new Ingredient("freshly grated black pepper", bigDecTwo, dashUom));
		guacRecipe
				.addingIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", bigDecHalf, eachUom));

		recipeRepository.save(guacRecipe);

		Set<Category> spicyGrilledChickenTacosCategories = new HashSet<>();
		spicyGrilledChickenTacosCategories.add(mexicanCategory.get());

		Set<Ingredient> sgctIngredients = new HashSet<>();
		Ingredient driedOregano = new Ingredient();
		driedOregano.setAmount(new BigDecimal(1));
		driedOregano.setDescription("Dried Oregano");
//		driedOregano.setUom(uOMTeaspoon.get());
		sgctIngredients.add(driedOregano);

		Ingredient driedCumin = new Ingredient();
		driedCumin.setAmount(new BigDecimal(1));
		driedCumin.setDescription("Dried Cumin");
//		driedCumin.setUom(uOMTeaspoon.get());
		sgctIngredients.add(driedCumin);

		Recipe tacosRecipe = new Recipe();

		Notes tacoNotes = new Notes();
		tacoNotes.setRecipeNotes(
				"Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
		tacosRecipe.setNotes(tacoNotes);
		tacoNotes.setRecipe(tacosRecipe);

		tacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
		tacosRecipe.setCookTime(15);
		tacosRecipe.setPrepTime(20);
		tacosRecipe.setDifficulty(Difficulty.EASY);
		tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n");
//				"\n" + 
//				"2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" + 
//				"\n" + 
//				"Set aside to marinate while the grill heats and you prepare the rest of the toppings.");
		tacosRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

		tacosRecipe.setCategories(spicyGrilledChickenTacosCategories);
		tacosRecipe.setServings(6);
		tacosRecipe.setSource("Sally Vargas");

		driedCumin.setRecipe(tacosRecipe);
		driedOregano.setRecipe(tacosRecipe);

		tacosRecipe.setIngredients(sgctIngredients);
		recipeRepository.save(tacosRecipe);

	}

	private void addIngredientsToRecipe(Set<Ingredient> ingredients, Recipe recipe) {
//		recipe.getIngredients().addAll(ingredients);
		for (Ingredient ingredient : ingredients) {
			ingredient.setRecipe(recipe);
			recipe.getIngredients().add(ingredient);
		}
	}

}
