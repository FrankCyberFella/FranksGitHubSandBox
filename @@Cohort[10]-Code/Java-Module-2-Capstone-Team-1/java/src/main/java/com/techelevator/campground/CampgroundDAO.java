package com.techelevator.campground;

import java.util.List;

public interface CampgroundDAO {
	//method to get all campgrounds
	public List<Campground> getAllCampgrounds(String parkName);

}
