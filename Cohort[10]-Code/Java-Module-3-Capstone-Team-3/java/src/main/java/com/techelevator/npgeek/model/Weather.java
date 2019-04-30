package com.techelevator.npgeek.model;

public class Weather {
	
	private int fiveDayForecastValue;
	private int lowF;
	private int highF;
	private int lowC;
	private int highC;
	private String forecast;
	private String parkCode;
	

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLowF() {
		return lowF;
	}
	public void setLowF(int low) {
		this.lowF = low;
	}
	public int getHighF() {
		return highF;
	}
	public void setHighF(int high) {
		this.highF = high;
	}
	public int getLowC() {
		return lowC;
	}
	public void setLowC(int low) {
		this.lowC = tempConvertToC(low);
	}
	public int getHighC() {
		return highC;
	}
	public void setHighC(int high) {
		this.highC = tempConvertToC(high);
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public boolean isGreaterThanSeventyFive() {		
		return highF > 75;
	}
	
	public boolean isLessThanTwenty() {		
		return lowF < 20;
	}
	
	public boolean isDifferenceGreaterThanTwenty() {		
		return (highF - lowF) > 20;
	}
	
	public int tempConvertToC(int temp) {
		int newTemp = ((temp-32)*5)/9;
		return newTemp;	
	}
	
}
