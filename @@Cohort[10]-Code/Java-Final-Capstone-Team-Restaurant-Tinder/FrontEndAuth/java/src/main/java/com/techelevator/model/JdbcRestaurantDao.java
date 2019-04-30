package com.techelevator.model;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.authentication.AuthProvider;

@Component
public class JdbcRestaurantDao implements RestaurantDao {

	private JdbcTemplate jdbcTemplate;
	
	
	
	
	@Autowired
	public JdbcRestaurantDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	


	@Override
	public void saveLink(Restaurant restaurant, User currentUser) {
		
		 String sqlLink = "INSERT INTO user_restaurant(user_id, restaurant_id) VALUES (?, ?)";
		 jdbcTemplate.update(sqlLink, currentUser.getId(), restaurant.getId());
	}
	
	@Override
	public void visitRestaurant(Restaurant restaurant, User currentUser) {
		 int visits = getVisits(restaurant, currentUser);
		 visits ++;
		 System.out.println(visits);
		 String sqlVisit = "UPDATE user_restaurant SET times_visited = ? WHERE user_id = ? AND restaurant_id = ?";
		 jdbcTemplate.update(sqlVisit, visits, currentUser.getId(), restaurant.getId());
	}
	
	@Override
	public int getVisits(Restaurant restaurant, User currentUser) {
		int restVisits = 0;
		String sqlVisits = "Select times_visited From user_restaurant Where user_id = ? and restaurant_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlVisits, currentUser.getId(), restaurant.getId());
		while(results.next()) {
			 restVisits = mapResultToVisits(results);
		}
		return restVisits;
	 }
	
	private int mapResultToVisits(SqlRowSet results) {
		int visits;
		visits = results.getInt("times_visited");
		return visits;
		
	}
	
	
	
	
	@Override
	public void saveRestaurant(Restaurant restaurant, User currentUser) {
			

	        String sqlRestInsert = "INSERT INTO restaurants(id, name, address, city, "
	        										+ "cuisine, rating, price, locality, menu) "
	        										+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	       
	        
	         
	        jdbcTemplate.update(sqlRestInsert
	        		, restaurant.getId()
	        		, restaurant.getName()
	        		, restaurant.getAddress()
	        		, restaurant.getCity()
	        		, restaurant.getCuisine()
	        		, restaurant.getRating()
	        		, restaurant.getPrice()
	        		, restaurant.getLocality()
	        		, restaurant.getMenu());
	        
	        
	}

	@Override
	public ArrayList<Restaurant> getLikes(User currentUser) {
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		String sqlLikeSelect = "Select * " + 
								"From restaurants " + 
								"inner join user_restaurant " + 
								"on restaurants.id = user_restaurant.restaurant_id " + 
								"inner join users " + 
								"on users.id = user_restaurant.user_id " + 
								"where user_restaurant.user_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlLikeSelect, currentUser.getId());
		
		 while(results.next()) {
	            Restaurant restaurant = mapResultToRestaurant(results);
	            restaurants.add(restaurant);
	        }
		 return restaurants;
	}
	
	
	public void deleteRestaurantFromFavs(Restaurant restaurant, User currentUser) {
		String sqlDeleteRest = "DELETE " + 
								"FROM user_restaurant " + 
								"WHERE user_id = ? and restaurant_id = ?";
		
		jdbcTemplate.update(sqlDeleteRest, currentUser.getId(), restaurant.getId());
	}

	private Restaurant mapResultToRestaurant(SqlRowSet results) {
		Restaurant restaurant = new Restaurant();
		restaurant.setId(results.getLong("restaurant_id"));
		restaurant.setAddress(results.getString("address"));
		restaurant.setCuisine(results.getString("cuisine"));
		restaurant.setName(results.getString("name"));
		restaurant.setMenu(results.getString("menu"));
		restaurant.setRating(results.getDouble("rating"));
		restaurant.setPrice(results.getInt("price"));
		restaurant.setVisits(results.getInt("times_visited"));
		return restaurant;
	}
	
	
}