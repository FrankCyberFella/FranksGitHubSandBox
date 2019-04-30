package com.techelevator.model.park;

import java.util.List;

import com.techelevator.model.park.Park;

public interface ParkDao {
	
	public List<Park> getAllParks();
	
	public Park getParkByCode(String parkCode);

}
