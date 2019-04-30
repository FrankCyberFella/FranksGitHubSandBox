package com.techelevator.campground;

import java.util.List;

public interface CampgroundDAO {

	
	public List<Campground> getCampgroundInformationById(int id);
	
	public List<Integer> searchCampExists(int id);
	
	public void displayCampground(int id);
	
}
