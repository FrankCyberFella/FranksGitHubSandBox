package com.techelevator.site;

import java.time.LocalDate;
import java.util.List;



public interface SiteDAO {
	//created signature of for the method to list for the campground sites
	public List<Site>selectAvilableSitesbyCampgroundId(int campgroundId, LocalDate startDate, LocalDate endDate);
	
	
}
