package com.techelevator.ssg.model.store;

public class DriveTime {
	
	public String planet;
	public String transport;

	public double startingAge;
	public double endingAge;
	public double travelYears;
	
	public DriveTime (String planet, String transport, double startingAge, double endingAge , double travelYears) {
		this.planet = planet;
		this.transport = transport;
		this.travelYears = travelYears;
		this.startingAge = startingAge;
		this.endingAge = endingAge;
	}
	
	
	
	/**
	 * @return the travelYears
	 */
	public double getTravelYears() {
		return travelYears;
	}



	/**
	 * @param travelYears the travelYears to set
	 */
	public void setTravelYears(double travelYears) {
		this.travelYears = travelYears;
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
	/**
	 * @return the transport
	 */
	public String getTransport() {
		return transport;
	}
	/**
	 * @param transport the transport to set
	 */
	public void setTransport(String transport) {
		this.transport = transport;
	}
	
	
	/**
	 * @return the startingAge
	 */
	public double getStartingAge() {
		return startingAge;
	}
	/**
	 * @param startingAge the startingAge to set
	 */
	public void setStartingAge(double startingAge) {
		this.startingAge = startingAge;
	}
	/**
	 * @return the endingAge
	 */
	public double getEndingAge() {
		return endingAge;
	}
	/**
	 * @param endingAge the endingAge to set
	 */
	public void setEndingAge(double endingAge) {
		this.endingAge = endingAge;
	}

}
