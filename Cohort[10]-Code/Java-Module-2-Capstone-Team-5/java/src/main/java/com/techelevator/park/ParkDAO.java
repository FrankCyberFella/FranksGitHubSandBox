package com.techelevator.park;

import java.util.List;

public interface ParkDAO {

	/*
	 * THIS METHOD WILL ALLOW USER TO SEE PARK AND
	 * ITS INFO
	 * 
	 * @return parks in a list
	 */
	
	public List<Park> seeAllParks();
	public Park seeSpecificPark(Long id);


}
