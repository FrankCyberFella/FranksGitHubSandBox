package com.techelevator.campground;

public class Campground {
	//defined class properties (aka datamembers) 
	private int parkId;
	private String openToMm;
	private String openFromMm;
	private String name;
	private double dailyFee;
	private int campgroundId;

	/**
	 * @return the parkId
	 */
	public int getParkId() {
		return parkId;
	}
	/**
	 * @param parkId the parkId to set
	 */
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	/**
	 * @return the openToMm
	 */
	public String getOpenToMm() {
		return openToMm;
	}
	/**
	 * @param openToMm the openToMm to set
	 */
	public void setOpenToMm(String openToMm) {
		this.openToMm = openToMm;
	}
	/**
	 * @return the openFromMm
	 */
	public String getOpenFromMm() {
		return openFromMm;
	}
	/**
	 * @param openFromMm the openFromMm to set
	 */
	public void setOpenFromMm(String openFromMm) {
		this.openFromMm = openFromMm;
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
	
	

}
