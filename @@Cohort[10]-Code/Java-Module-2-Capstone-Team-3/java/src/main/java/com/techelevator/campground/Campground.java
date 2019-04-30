package com.techelevator.campground;

public class Campground {
	private Long campgroundId;
	private int parkId;
	private String name;
	private String openFrom;
	private String openTo;
	private double dailyFee;
	
	
	public Long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenFrom() {
		return openFrom;
	}
	public void setOpenFrom(String openFrom) {
		this.openFrom = openFrom;
	}
	public String getOpenTo() {
		return openTo;
	}
	public void setOpenTo(String openTo) {
		this.openTo = openTo;
	}
	public double getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	@Override
	public String toString() {
		String campground = "";
		campground += getName() +  " " + getOpenFrom() + " " + getOpenTo() + " " + getDailyFee();
		
		return campground;
	}
	
}
