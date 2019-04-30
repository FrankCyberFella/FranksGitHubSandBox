package com.techelevator.park;

import java.util.List;

public interface ParkDAO {

	public List<Park> getAllParks();
	public Park getParkInformation(String name);
	
	
}
