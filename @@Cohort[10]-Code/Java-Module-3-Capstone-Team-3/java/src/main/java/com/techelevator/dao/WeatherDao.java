package com.techelevator.dao;

import java.util.List;

import com.techelevator.npgeek.model.Weather;

public interface WeatherDao {
	
	public List<Weather> getFiveDayForecastByParkCode(String parkCode);
	
}
