package Model;

import java.util.HashMap;
import java.util.Map;

public class AlienTravelCalculator {
	
	private double earthAge;
	private String planet;
	private String trans;
	private int finalAge;
	private Float travelYears;
	
	public AlienTravelCalculator(double earthAge, String planet, String trans) {
		this.earthAge = earthAge;
		this.planet = planet;
		this.trans = trans;
		
		Map<String, Float> planetMiles = new HashMap<String, Float>();
		planetMiles.put("Mercury", 56974146f);
		planetMiles.put("Venus", 25724767f);
		planetMiles.put("Mars", 48678219f);
		planetMiles.put("Jupiter", 390674710f);
		planetMiles.put("Saturn", 792248270f);
		planetMiles.put("Uranus", 1692662530f);
		planetMiles.put("Neptune", 2703959960f);
		
		Map<String, Integer> transSpeed = new HashMap<String, Integer>();
		transSpeed.put("Walking", 3);
		transSpeed.put("Car", 100);
		transSpeed.put("Bullet Train", 200);
		transSpeed.put("Boeing 747", 570);
		transSpeed.put("Concorde", 1350);
		planet="Jupiter";
		trans="Boeing 747";
		travelYears = (planetMiles.get(planet)/transSpeed.get(trans))/(365 * 24);
		finalAge = (int) (travelYears + earthAge);

	}
	

	/**
	 * @return the travelYears
	 */
	public Float getTravelYears() {
		return travelYears;
	}


	/**
	 * @return the finalAge
	 */
	public int getFinalAge() {
		return finalAge;
	}
	/**
	 * @return the earthAge
	 */
	public double getEarthAge() {
		return earthAge;
	}

	/**
	 * @param earthAge the earthAge to set
	 */
	public void setEarthAge(double earthAge) {
		this.earthAge = earthAge;
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
	 * @return the transMode
	 */
	public String getTrans() {
		return trans;
	}

	/**
	 * @param transMode the transMode to set
	 */
	public void setTransMode(String transMode) {
		this.trans = transMode;
	}

}
