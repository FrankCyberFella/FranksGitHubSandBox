package com.techelevator.model.park;

import java.time.LocalDate;

public class Park {
	
	long parkId;
	String name;
	String location;
	LocalDate establishDate;
	long area;
	long visitors;
	String description;
	long campgroundId;
	String parkName;
	LocalDate openFrom;
	LocalDate openTo;
	double dailyFee;
	String parkCode;
	String state;
	long acreage;
	long elevationFeet;
	double milesOfTrail;
	long numberOfCampsites;
	String climate;
	long yearFounded;
	String quote;
	
	public long getParkId() {
		return parkId;
	}
	public void setParkId(long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(LocalDate establishDate) {
		this.establishDate = establishDate;
	}
	public long getArea() {
		return area;
	}
	public void setArea(long area) {
		this.area = area;
	}
	public long getVisitors() {
		return visitors;
	}
	public void setVisitors(long visitors) {
		this.visitors = visitors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public LocalDate getOpenFrom() {
		return openFrom;
	}
	public void setOpenFrom(LocalDate openFrom) {
		this.openFrom = openFrom;
	}
	public LocalDate getOpenTo() {
		return openTo;
	}
	public void setOpenTo (LocalDate openTo) {
		this.openTo = openTo;
	}
	public double getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getAcreage() {
		return acreage;
	}
	public void setAcreage(long acreage) {
		this.acreage = acreage;
	}
	public long getElevationFeet() {
		return elevationFeet;
	}
	public void setElevationFeet(long elevationFeet) {
		this.elevationFeet = elevationFeet;
	}
	public double getMilesOfTrail() {
		return milesOfTrail; 
	}
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public long getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(long numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public long getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(long yearFounded) {
		this.yearFounded = yearFounded;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
}
