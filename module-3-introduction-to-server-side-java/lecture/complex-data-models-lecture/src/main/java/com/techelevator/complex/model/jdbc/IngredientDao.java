package com.techelevator.complex.model.jdbc;

import java.util.List;

import com.techelevator.complex.model.Ingredient;

public interface IngredientDao {

	List<Ingredient> getIngredientsForRecipe(Long recipeId);

	void saveIngredients(List<Ingredient> ingredients, Long id);

	void deleteIngredient(Long ingredientId);

}