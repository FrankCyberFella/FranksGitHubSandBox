package com.techelevator.model.weather;

import java.util.List;

public interface WeatherDAO {
	
	//Method to get all weather forecasts
	public List<Weather> getAllWeatherForecasts();
	
	//Method to get specific forecasts for a park
	List<Weather> getForecastByCode(String parkCode);

}
