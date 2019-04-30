package com.techelevator.site;

import java.util.List;

import com.techelevator.campground.Campground;

public interface SiteDAO {
	
	public List<Site> getAllSites();
	public List<Site> getAvailableSites(String parkName, Campground campToReserve, String arrivalDate, String departureDate);
	

	
	
}
