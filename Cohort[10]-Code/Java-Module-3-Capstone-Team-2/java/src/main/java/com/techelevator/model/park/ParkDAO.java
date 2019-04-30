package com.techelevator.model.park;

import java.util.List;

public interface ParkDAO {
	
	// To retrieve all of our parks 
	public List<Park> getAllParks();
	
	public List<Park> getFavoriteParks();

}
