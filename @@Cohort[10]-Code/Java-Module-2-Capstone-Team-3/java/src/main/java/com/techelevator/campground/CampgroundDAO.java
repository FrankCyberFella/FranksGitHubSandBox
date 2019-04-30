package com.techelevator.campground;

import java.util.List;


public interface CampgroundDAO {

	public List<Campground> getAllCampgrounds(String nameSearch);
	public List<Campground> searchCampgroundsByName(String nameSearch);
	public Campground getCampgroundById(Long id);
	
}
