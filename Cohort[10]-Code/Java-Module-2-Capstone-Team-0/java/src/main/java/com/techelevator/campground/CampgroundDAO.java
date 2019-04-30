package com.techelevator.campground;

import java.util.List;

public interface CampgroundDAO {
	
	public List<Campground>selectCampgroundByParkId(int parkID);
	//if needed add ----selectAllCampgrounds
	
	
	
	
}
