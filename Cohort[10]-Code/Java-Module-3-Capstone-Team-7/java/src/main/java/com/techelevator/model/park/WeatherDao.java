package com.techelevator.model.park;

import java.util.List;

public interface WeatherDao {
	
	public List<Weather> getAllWeather(String parkCode);

}
