package com.techelevator.dao;

import java.util.List;

import com.techelevator.npgeek.model.Park;

public interface ParkDao {
	
	public Park getParkByCode(String parkCode);
	public List<Park> getAllParks();
	
}
