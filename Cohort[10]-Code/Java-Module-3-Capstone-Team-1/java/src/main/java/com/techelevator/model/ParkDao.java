package com.techelevator.model;
import java.util.List;

public interface ParkDao {
	
	public List<Park> getAllParks();
	
	public Park getParkById(String parkCode);
	
	public Park getParkByParkName(String parkName);

}
