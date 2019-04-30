package com.techelevator.ssg.model.store;

public class AlienAge {

	private double alienAge;
	private String planet;
	private double age;
	
	public AlienAge (String planet, double alienAge,double age) {
		this.alienAge = alienAge;
		this.planet = planet;
		this.age = age;
	}
	
	/**
	 * @return the age
	 */
	public double getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * @return the alienAge
	 */
	public double getAlienAge() {
		return alienAge;
	}
	/**
	 * @param alienAge the alienAge to set
	 */
	public void setAlienAge(double alienAge) {
		this.alienAge = alienAge;
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
