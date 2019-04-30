package com.techelevator.model.weather;

public class Weather {

	String parkCode;
	int fiveDayForecastValue;
	int low;
	int high;
	String forecast;
	int lowCelcius;
	int highCelcius;
	
	/**
	 * @return the parkCode
	 */
	public String getParkcode() {
		return parkCode;
	}
	/**
	 * @param parkcode the parkCode to set
	 */
	public void setParkcode(String parkCode) {
		this.parkCode = parkCode;
	}
	/**
	 * @return the fiveDayForecastValue
	 */
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	/**
	 * @param fiveDayForecastValue the fiveDayForecastValue to set
	 */
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	/**
	 * @return the low
	 */
	public int getLow() {
		return low;
	}
	/**
	 * @param low the low to set
	 */
	public void setLow(int low) {
		this.low = low;
	}
	/**
	 * @return the high
	 */
	public int getHigh() {
		return high;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(int high) {
		this.high = high;
	}
	/**
	 * @return the forecast
	 */
	public String getForecast() {
		return forecast;
	}
	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	public int getHighCelcius() {
		
		return  this.highCelcius;
	}
	
	public int getLowCelcius() {
		
		return this.lowCelcius;
	}
	
	public void setLowCelcius(int cLow){
		this.lowCelcius = cLow;
	}
	
	public void setHighCelcius(int cHigh) {
		this.highCelcius = cHigh;
	}
}
