package com.techelevator.complex.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.complex.model.Ingredient;

@Component
public class JdbcIngredientDao implements IngredientDao {
	private JdbcTemplate jdbcConnection;
	
	@Autowired
	public JdbcIngredientDao(DataSource dataSource) {
		jdbcConnection = new JdbcTemplate(dataSource);
	}
	
	/* (non-Javadoc)
	 * @see com.techelevator.complex.model.jdbc.IngredientDao#getIngredientsForRecipe(java.lang.Long)
	 */
	@Override
	public List<Ingredient> getIngredientsForRecipe(Long recipeId) {
		List<Ingredient> ingredients = new ArrayList<>();
		SqlRowSet results = jdbcConnection.queryForRowSet("SELECT * FROM ingredients WHERE recipe_id = ?", recipeId);
		while(results.next()) {
			ingredients.add(mapResultToIngredient(results));
		}
		return ingredients;
	}

	private Ingredient mapResultToIngredient(SqlRowSet result) {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(result.getLong("id"));
		ingredient.setQuantity(result.getString("quantity"));
		ingredient.setType(result.getString("type"));
		ingredient.setRecipeId(result.getLong("recipe_id"));
		return ingredient;
	}

	@Override
	public void saveIngredients(List<Ingredient> ingredients, Long recipeId) {
		for(Ingredient ingredient : ingredients) {
			if(ingredient.getId() != null) {
				jdbcConnection.update("UPDATE ingredients SET type=?, quantity=? WHERE id=?",
						ingredient.getType(), ingredient.getQuantity(), ingredient.getId());
			} else {
				if( ! ingredient.getType().equals("") && ! ingredient.getQuantity().equals("")) {
					Long id = jdbcConnection.queryForObject("INSERT INTO ingredients (type, quantity, recipe_id) VALUES (?, ?, ?)"
							+ " RETURNING id", Long.class,
						ingredient.getType(), ingredient.getQuantity(), recipeId);
					ingredient.setId(id);
				}
			}
		}
	}

	@Override
	public void deleteIngredient(Long ingredientId) {
		jdbcConnection.update("DELETE FROM ingredients WHERE id=?", ingredientId);
		
	}
}
