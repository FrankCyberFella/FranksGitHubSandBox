package com.techelevator.model;

import java.util.List;

public interface WeatherDao {

	public List<Weather> getWeatherByCode(String parkCode);
	
}
