package com.techelevator.model;

import java.time.LocalDate;

public class Park {
	
//	long parkId;
	String name;
//	String location;
//	LocalDate establishDate;
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
	String quoteSource;
	int entryFee;
	int numberOfSpecies;
	int numOfSurvey;
	
	
	
	/**
	 * @return the numOfSurvey
	 */
	public int getNumOfSurvey() {
		return numOfSurvey;
	}
	/**
	 * @param numOfSurvey the numOfSurvey to set
	 */
	public void setNumOfSurvey(int numOfSurvey) {
		this.numOfSurvey = numOfSurvey;
	}
	/**
	 * @return the numberOfSpecies
	 */
	public int getNumberOfSpecies() {
		return numberOfSpecies;
	}
	/**
	 * @param numberOfSpecies the numberOfSpecies to set
	 */
	public void setNumberOfSpecies(int numberOfSpecies) {
		this.numberOfSpecies = numberOfSpecies;
	}
	/**
	 * @return the entryFee
	 */
	public int getEntryFee() {
		return entryFee;
	}
	/**
	 * @param entryFee the entryFee to set
	 */
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	/**
	 * @return the quoteSource
	 */
	public String getQuoteSource() {
		return quoteSource;
	}
	/**
	 * @param quoteSource the quoteSource to set
	 */
	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}
//	public long getParkId() {
//		return parkId;
//	}
//	public void setParkId(long parkId) {
//		this.parkId = parkId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	public LocalDate getEstablishDate() {
//		return establishDate;
//	}
//	public void setEstablishDate(LocalDate establishDate) {
//		this.establishDate = establishDate;
//	}
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
	/**
	 * @return the parkName
	 */
	public String getParkName() {
		return parkName;
	}
	/**
	 * @param parkName the parkName to set
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	
}
