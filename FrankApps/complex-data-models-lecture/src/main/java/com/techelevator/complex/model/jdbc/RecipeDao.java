package com.techelevator.complex.model.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.complex.model.Recipe;

public interface RecipeDao {

	List<Recipe> getAllRecipes();

	Recipe getRecipe(Long recipeId);

	void addRecipe(Recipe newRecipe);

	void saveRecipe(Recipe edittedRecipe);


}