package com.techelevator.dao.park.model;

import java.util.List;

public interface ParkDao {
	
	public List<Park> getAllParks();

	public List<Park> getTopParkSurvey();

	public List<Park>  getParkCount();

}
