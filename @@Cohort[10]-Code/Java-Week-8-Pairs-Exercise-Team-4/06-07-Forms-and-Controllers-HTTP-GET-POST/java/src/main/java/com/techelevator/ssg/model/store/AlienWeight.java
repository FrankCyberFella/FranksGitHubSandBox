package com.techelevator.ssg.model.store;

public class AlienWeight {
	
	private double earthWeight;
	private double alienWeight; 
	private String planet;
	
	public AlienWeight(double earthWeight, double alienWeight, String planet) {
		this.earthWeight = earthWeight;
		this.alienWeight = alienWeight;
		this.planet = planet;
	}
	/**
	 * @return the earthWeight
	 */
	public double getEarthWeight() {
		return earthWeight;
	}
	/**
	 * @param earthWeight the earthWeight to set
	 */
	public void setEarthWeight(double earthWeight) {
		this.earthWeight = earthWeight;
	}
	/**
	 * @return the alienWeight
	 */
	public double getAlienWeight() {
		return alienWeight;
	}
	/**
	 * @param alienWeight the alienWeight to set
	 */
	public void setAlienWeight(double alienWeight) {
		this.alienWeight = alienWeight;
	}
	/**
	 * @return the planet
	 */
	public String getPlanet() {
		return planet;
	}
	/**
	 * @param planet the planet to set
	 */
	public void setPlanet(String planet) {
		this.planet = planet;
	}

}
