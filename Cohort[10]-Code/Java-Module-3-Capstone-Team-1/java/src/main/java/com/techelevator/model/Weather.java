package com.techelevator.model;

import java.time.LocalDate;

public class Weather {
	
	private String parkCode;
	private int fiveDayWeather;
	private int low;
	private int high;
	private String forecast;
	private String partlyCloudy;
	private LocalDate weatherDate;
	private int lowC;
	private int highC;
	
	

	public int getLowC() {
		return lowC;
	}

	public void setLowC(int lowC) {
		this.lowC = lowC;
	}

	public int getHighC() {
		return highC;
	}

	public void setHighC(int highC) {
		this.highC = highC;
	}

	public String getPartlyCloudy() {
		return partlyCloudy;
	}
	
	public void setPartlyCloudy(String partlyCloudy) {
		this.partlyCloudy = partlyCloudy;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayWeather() {
		return fiveDayWeather;
	}
	public void setFiveDayWeather(int fiveDayWeather) {
		this.fiveDayWeather = fiveDayWeather;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public LocalDate getWeatherDate() {
		return weatherDate;
	}

	public void setWeatherDate(LocalDate weatherDate) {
		this.weatherDate = weatherDate;
	}



	
	

}
