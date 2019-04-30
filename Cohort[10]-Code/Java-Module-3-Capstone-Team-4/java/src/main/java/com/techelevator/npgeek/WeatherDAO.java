package com.techelevator.npgeek;

import java.util.List;

import com.techelevator.model.Weather;

public interface WeatherDAO {
	
	public List<Weather> getForecast(String code);

}
