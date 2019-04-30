package com.techelevator.campground;

import java.util.List;

import com.techelevator.park.Park;

public interface CampgroundDAO {

	/* SEE ACADIA CAMPGROUNDS */
	
	public List<Campground> seeAllCampgrounds(Park park);
	
	public Campground getTheCampground(Long id);




}
