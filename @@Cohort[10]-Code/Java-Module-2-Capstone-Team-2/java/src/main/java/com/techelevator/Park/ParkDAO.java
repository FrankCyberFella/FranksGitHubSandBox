package com.techelevator.Park;

import java.util.List;

public interface ParkDAO {

	
	public List<Park> getAllParks();
	
	public void selectPark();
	
    public void showParkDescription(String parkSearch);

	List<String> getAllParkNames();
}
