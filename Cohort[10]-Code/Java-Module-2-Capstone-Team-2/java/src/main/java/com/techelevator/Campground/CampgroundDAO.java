package com.techelevator.Campground;

import java.util.List;


public interface CampgroundDAO {

	public List<Campground> showAllCampgrounds();
	
	public void selectCampground();
	
	public List<String> showAvailableDates();
	
	public void showCampground(int parkId);
	
	public List<Campground> campGroundsToString(int parkId);
	
	public List<String> showCampgroundNames(int parkId);
}
