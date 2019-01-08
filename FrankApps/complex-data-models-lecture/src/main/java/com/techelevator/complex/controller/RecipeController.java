package com.techelevator.complex.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.complex.model.Recipe;
import com.techelevator.complex.model.jdbc.IngredientDao;
import com.techelevator.complex.model.jdbc.RecipeDao;

@Controller
public class RecipeController {

	@Autowired
	private RecipeDao recipeDao;

	@Autowired
	private IngredientDao ingredientDao;

	@RequestMapping(path = { "/", "/recipe", "/recipe/list" }, method = RequestMethod.GET)
	public String showRecipes(Model modelHolder) {
		modelHolder.addAttribute("recipes", recipeDao.getAllRecipes());
		return "recipe/list";
	}

	@RequestMapping(path = "/recipe/detail", method = RequestMethod.GET)
	public String showRecipeDetail(Model modelHolder, @RequestParam Long recipeId) {
		Recipe recipeToShow = recipeDao.getRecipe(recipeId);
		if (recipeToShow != null) {
			modelHolder.addAttribute("recipe", recipeToShow);
		} else {
			throw new ResourceNotFoundException();
		}

		return "recipe/detail";
	}

	@RequestMapping(path = "/recipe/new", method = RequestMethod.GET)
	public String newRecipeDetail(Model modelHolder) {
		Recipe newRecipe = new Recipe();

		modelHolder.addAttribute("recipe", newRecipe);

		return "recipe/new";
	}

	@RequestMapping(path = "/recipe/new", method = RequestMethod.POST)
	public String saveNewRecipe(@ModelAttribute Recipe newRecipe) {
		recipeDao.addRecipe(newRecipe);

		return "redirect:/recipe/list";
	}

	@RequestMapping(path = "/recipe/edit", method = RequestMethod.GET)
	public String editRecipeDetail(Model modelHolder, @RequestParam Long recipeId) {
		Recipe recipeToEdit = recipeDao.getRecipe(recipeId);

		if (recipeToEdit != null) {
			modelHolder.addAttribute("recipe", recipeToEdit);
		} else {
			throw new ResourceNotFoundException();
		}

		return "recipe/edit";
	}

	@RequestMapping(path = "/recipe/edit", method = RequestMethod.POST)
	public String saveEditRecipe(@ModelAttribute Recipe edittedRecipe) {

		recipeDao.saveRecipe(edittedRecipe);

		return "redirect:/recipe/detail?recipeId=" + edittedRecipe.getId();
	}

	@RequestMapping(path = "/recipe/edit/deleteIngredient", method = RequestMethod.GET)
	public String deleteIngredient(@RequestParam Long ingredientId, @RequestParam Long recipeId) {
		ingredientDao.deleteIngredient(ingredientId);

		return "redirect:/recipe/edit?recipeId=" + recipeId;
	}
}
