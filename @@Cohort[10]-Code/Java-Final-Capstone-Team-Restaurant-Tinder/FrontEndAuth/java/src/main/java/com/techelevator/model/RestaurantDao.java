package com.techelevator.model;

import java.util.ArrayList;

public interface RestaurantDao {
	
	public void saveRestaurant(Restaurant restaurant, User currentUser);

	void saveLink(Restaurant restaurant, User currentUser);
	
	public ArrayList<Restaurant> getLikes(User currentUser);

	void visitRestaurant(Restaurant restaurant, User currentUser);

	int getVisits(Restaurant restaurant, User currentUser);
	
	public void deleteRestaurantFromFavs(Restaurant restaurant, User currentUser); 
}
