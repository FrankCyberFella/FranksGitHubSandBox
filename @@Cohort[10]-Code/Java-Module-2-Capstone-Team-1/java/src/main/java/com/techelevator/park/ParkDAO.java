package com.techelevator.park;

import java.util.List;

public interface ParkDAO {
	//method to get all parks
	public List<Park> getAllParks();
	public List<String> displayParkInfo();
	public void getParkInfoByName(String parkName);
}
