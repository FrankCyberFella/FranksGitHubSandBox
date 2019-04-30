package Model;

import java.util.HashMap;
import java.util.Map;

public class AlienAgeCalculator {
	
	private double earthAgeInDays;
	private String planet;
	private int planetAge;
	/**
	 * @return the earthAgeInDays
	 */
	public double getEarthAgeInDays() {
		return earthAgeInDays;
	}

	/**
	 * @param earthAgeInDays the earthAgeInDays to set
	 */
	public void setEarthAgeInDays(int earthAgeInDays) {
		this.earthAgeInDays = earthAgeInDays;
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
	 * @return the planetAge
	 */
	public int getPlanetAge() {
		return planetAge;
	}

	/**
	 * @param planetAge the planetAge to set
	 */
	public void setPlanetAge(int planetAge) {
		this.planetAge = planetAge;
	}

	/**
	 * @return the earthAgeInYears
	 */
	public double getEarthAgeInYears() {
		return earthAgeInYears;
	}

	/**
	 * @param earthAgeInYears the earthAgeInYears to set
	 */
	public void setEarthAgeInYears(double earthAgeInYears) {
		this.earthAgeInYears = earthAgeInYears;
	}

	private double earthAgeInYears;
	
	public AlienAgeCalculator(double earthAgeInYears,  String planet) {
		this.earthAgeInYears = earthAgeInYears;
		this.planet = planet;
		this.earthAgeInDays = (earthAgeInYears * 365.26);
		
		Map<String, Double> planetYears = new HashMap<String, Double>();
		planetYears.put("Mercury", 87.96);
		planetYears.put("Venus", 224.68);
		planetYears.put("Earth", 365.26);
		planetYears.put("Mars", 686.98);
		planetYears.put("Jupiter", 11.862);
		planetYears.put("Saturn", 29.456);
		planetYears.put("Uranus", 84.07);
		planetYears.put("Neptune", 164.81);
		
		planetAge = (int)(earthAgeInDays/planetYears.get(planet));
			
	}

}
