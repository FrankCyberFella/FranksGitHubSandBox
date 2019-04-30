package com.techelevator.Campground;

public class Campground {

	private int campgroundId;
	private String name;
	private String openFromDate;
	private String openToDate;
	private double dailyFee;
	/**
	 * @return the campgroundId
	 */
	public int getCampgroundId() {
		return campgroundId;
	}
	/**
	 * @param campgroundId the campgroundId to set
	 */
	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the openFromDate
	 */
	public String getOpenFromDate() {
		return openFromDate;
	}
	/**
	 * @param openFromDate the openFromDate to set
	 */
	public void setOpenFromDate(String openFromDate) {
		this.openFromDate = openFromDate;
	}
	/**
	 * @return the openToDate
	 */
	public String getOpenToDate() {
		return openToDate;
	}
	/**
	 * @param openToDate the openToDate to set
	 */
	public void setOpenToDate(String openToDate) {
		this.openToDate = openToDate;
	}
	/**
	 * @return the dailyFee
	 */
	public double getDailyFee() {
		return dailyFee;
	}
	/**
	 * @param dailyFee the dailyFee to set
	 */
	public void setDailyFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	public String toString() {
		return name;
	}
	
}
