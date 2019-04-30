package com.techelevator.dao.weather.model;

import java.util.List;

public interface WeatherDao {


	public List<Weather> getTodayWeather(String code);

	public List<Weather> getFourWeather(String code);
	
}
