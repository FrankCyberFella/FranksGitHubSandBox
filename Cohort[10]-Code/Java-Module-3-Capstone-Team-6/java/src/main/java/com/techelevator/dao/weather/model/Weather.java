package com.techelevator.dao.weather.model;

public class Weather {

	private String parkCode;
	private int fiveDayValue;
	private int low;
	private int high;
	private int lowCel;
	private int highCel;
	private String forecast;
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
	 * @return the fiveDay
	 */
	public int getFiveDayValue() {
		return fiveDayValue;
	}
	/**
	 * @param fiveDay the fiveDay to set
	 */
	public void setFiveDayValue(int fiveDayValue) {
		this.fiveDayValue = fiveDayValue;
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
	public int getLowCel() {
		return lowCel;
	}
	public void setLowCel(int low) {
		double a = (low-32)*(5.0/9);
		 this.lowCel = (int) a;
	}
	public int getHighCel() {
		return highCel;
	}
	public void setHighCel(int high) {
		double a = (high-32)*(5.0/9);
		this.highCel = (int) a;
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
		if(forecast.contains(" ")) {
			String[] result = forecast.split(" ");
			for(int i = 0; i < result.length; i++) {
				if (i == 0) {
					forecast = result[i];
					continue;
				} else {
					result[i] = result [i].substring(0,1).toUpperCase() + result [i].substring(1);
					forecast += result[i];
				}
			}
		}
		this.forecast = forecast;
	}
	
	
	
}
