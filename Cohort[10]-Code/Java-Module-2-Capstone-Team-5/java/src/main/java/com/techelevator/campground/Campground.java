package com.techelevator.campground;

import java.time.LocalDate;

public class Campground {
	
	private Long campgroundId;
	private Long parkId;
	private String name;
	private String openFrom;
	private String openTo;
	private double dailyFee;
	
	
	/**
	 * @return the campgroundId
	 */
	public Long getCampgroundId() {
		return campgroundId;
	}
	/**
	 * @param campgroundId the campgroundId to set
	 */
	public void setCampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}
	/**
	 * @return the parkId
	 */
	public Long getParkId() {
		return parkId;
	}
	/**
	 * @param parkId the parkId to set
	 */
	public void setParkId(Long parkId) {
		this.parkId = parkId;
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
	 * @return the openFrom
	 */
	public String getOpenFrom() {
		return openFrom;
	}
	/**
	 * @param openFrom the openFrom to set
	 */
	public void setOpenFrom(String openFrom) {
		this.openFrom = openFrom;
	}
	/**
	 * @return the openTo
	 */
	public String getOpenTo() {
		return openTo;
	}
	/**
	 * @param openTo the openTo to set
	 */
	public void setOpenTo(String openTo) {
		this.openTo = openTo;
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