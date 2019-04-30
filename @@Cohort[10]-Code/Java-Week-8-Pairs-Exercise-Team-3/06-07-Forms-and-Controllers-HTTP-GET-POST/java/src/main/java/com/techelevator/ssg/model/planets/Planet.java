package com.techelevator.ssg.model.planets;

public class Planet {

	private String name;
	private double yearInEarthYears;
	private double gravityOverEarthGravity;
	private long milesFromEarth;
	
	public Planet() {
		
	}

	public Planet(String name, double gravityRatio, double yearRatio, long milesFromEarth) {
		this.name=name;
		this.yearInEarthYears=yearRatio;//number of years in one earth year
		this.gravityOverEarthGravity=gravityRatio;
		this.milesFromEarth=milesFromEarth;
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
	 * @return the yearInEarthDays
	 */
	public double getYearInEarthYears() {
		return yearInEarthYears;
	}

	/**
	 * @param yearInEarthDays the yearInEarthDays to set
	 */
	public void setYearInEarthYears(double yearInEarthDays) {
		this.yearInEarthYears = yearInEarthDays;
	}

	/**
	 * @return the gravityOverEarthGravity
	 */
	public double getGravityOverEarthGravity() {
		return gravityOverEarthGravity;
	}

	/**
	 * @param gravityOverEarthGravity the gravityOverEarthGravity to set
	 */
	public void setGravityOverEarthGravity(double gravityOverEarthGravity) {
		this.gravityOverEarthGravity = gravityOverEarthGravity;
	}

	/**
	 * @return the milesFromEarth
	 */
	public long getMilesFromEarth() {
		return milesFromEarth;
	}

	/**
	 * @param milesFromEarth the milesFromEarth to set
	 */
	public void setMilesFromEarth(long milesFromEarth) {
		this.milesFromEarth = milesFromEarth;
	}
	
}
