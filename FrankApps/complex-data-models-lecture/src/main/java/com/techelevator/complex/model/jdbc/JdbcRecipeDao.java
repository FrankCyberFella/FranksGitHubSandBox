package com.techelevator.complex.model.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techelevator.complex.model.Recipe;

@Component
public class JdbcRecipeDao implements RecipeDao {

	@Autowired
	private IngredientDao ingredientDao;
	
	private JdbcTemplate jdbcConnection;
	
	@Autowired
	public JdbcRecipeDao(DataSource dataSource) {
		jdbcConnection = new JdbcTemplate(dataSource);
	}
	
	/* (non-Javadoc)
	 * @see com.techelevator.complex.model.jdbc.RecipeDao#getAllRecipes()
	 */
	@Override
	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		SqlRowSet results = jdbcConnection.queryForRowSet("SELECT * FROM recipes");
		while(results.next()) {
			recipes.add(mapResultToRecipe(results));
		}
		return recipes;
	}

	@Override
	public Recipe getRecipe(Long recipeId) {
		Recipe foundRecipe = null;
		SqlRowSet results = jdbcConnection.queryForRowSet("SELECT * FROM recipes WHERE id=?", recipeId);
		if(results.next()) {
			foundRecipe = mapResultToRecipe(results);
		}
		return foundRecipe;
	}
	
	private Recipe mapResultToRecipe(SqlRowSet results) {
		Recipe newRecipe = new Recipe();
		newRecipe.setId(results.getLong("id"));
		newRecipe.setName(results.getString("name"));
		newRecipe.setDescription(results.getString("description"));
		newRecipe.setDurationInMinutes(results.getInt("duration_in_minutes"));
		
		newRecipe.setIngredients(ingredientDao.getIngredientsForRecipe(newRecipe.getId()));
		
		return newRecipe;
	}

	@Transactional
	public void addRecipe(Recipe newRecipe) {
		Long recipeId = jdbcConnection.queryForObject("INSERT INTO recipes (name, duration_in_minutes, description) "
				+ "VALUES (?,?,?) RETURNING id", 
				Long.class, newRecipe.getName(), newRecipe.getDurationInMinutes(), newRecipe.getDescription());
		newRecipe.setId(recipeId);
		ingredientDao.saveIngredients(newRecipe.getIngredients(), recipeId);

	}

	@Override
	@Transactional
	public void saveRecipe(Recipe edittedRecipe) {
		jdbcConnection.update("UPDATE recipes SET name=?, description=?, duration_in_minutes=? WHERE id=?",
				edittedRecipe.getName(), edittedRecipe.getDescription(), edittedRecipe.getDurationInMinutes(),
				edittedRecipe.getId());
		
		ingredientDao.saveIngredients(edittedRecipe.getIngredients(), edittedRecipe.getId());
	}
}
