package com.techelevator.model.weather;

public class Weather {
	
	private String parkCode;
	private int fivedayForecastValue;
	private int low;
	private int high;
	private String forecast;
	
	public Weather() {
		
	}

	/**
	 * @return the parkCode
	 */
	public String getParkCode() {
		return parkCode;
	}

	/**
	 * @param parkCode the parkCode to set
	 */
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	/**
	 * @return the fivedayForecastValue
	 */
	public int getFivedayForecastValue() {
		return fivedayForecastValue;
	}

	/**
	 * @param fivedayForecastValue the fivedayForecastValue to set
	 */
	public void setFivedayForecastValue(int fivedayForecastValue) {
		this.fivedayForecastValue = fivedayForecastValue;
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

	
}
