package com.techelevator.model.park;

public class Weather {
	
	String parkCode;
	int fiveDayForecastValue;
	int lowF;
	int highF;
	int lowC;
	int highC;
	/**
	 * @return the lowC
	 */
	public int getLowC() {
		return lowC;
	}
	/**
	 * @param lowC the lowC to set
	 */
	public void setLowC(int low) {
		this.lowC = tempConvertToC(low);
	}
	/**
	 * @return the highC
	 */
	public int getHighC() {
		return highC;
	}
	/**
	 * @param highC the highC to set
	 */
	public void setHighC(int high) {
		this.highC = tempConvertToC(high);
	}
	String Forecast;
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
	public int getLowF() {
		return lowF;
	}
	/**
	 * @param low the low to set
	 */
	public void setLowF(int low) {
		this.lowF = low;
	}
	/**
	 * @return the high
	 */
	public int getHighF() {
		return highF;
	}
	/**
	 * @param high the high to set
	 */
	public void setHighF(int high) {
		this.highF = high;
	}
	/**
	 * @return the forecast
	 */
	public String getForecast() {
		return Forecast.replaceAll(" ", "");
	}
	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(String forecast) {
		this.Forecast = forecast.replaceAll(" ", "");
	}
	public int tempConvertToC(int temp) {
		int newTemp = ((temp - 32)* 5/9);
		return newTemp;
	}
}

