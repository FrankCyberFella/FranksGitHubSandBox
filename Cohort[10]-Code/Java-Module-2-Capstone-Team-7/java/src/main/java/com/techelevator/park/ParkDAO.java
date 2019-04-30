package com.techelevator.park;

import java.util.List;

public interface ParkDAO {

	public void displayParkInfo(int id);
	
	public  Park getParkInformationById(int id);
	
	public List<Park> getParks();
}
