package com.techelevator.park;

import java.util.List;

public interface ParkDAO {
  //Signiture of a method that returns a list of parks
	public List<Park> selectAllParks();
	
}
