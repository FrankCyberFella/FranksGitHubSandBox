package com.techelevator.model;

import java.time.LocalDate;

public class Weather {
	
	int day;
	int low;
	int high;
	String forecast;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
		if (forecast.contains(" ")) {
			String[] result = forecast.split(" ");
			for (int i = 0; i < result.length ; i++) {
				if (i == 0) {
					forecast = result[i];
					continue;
				} else {
					result[i] = result[i].substring(0,1).toUpperCase() + result[i].substring(1);
					forecast += result[i];
				}
			}
			
		}
		this.forecast = forecast;
	}
	
	
	
}
