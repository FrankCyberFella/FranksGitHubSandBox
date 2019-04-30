package Model;

import java.util.HashMap;
import java.util.Map;

public class AlienWeightCalculator {
	
	private double earthWeight;
	private String planet;
	private int alienWeight;
	
	public AlienWeightCalculator(double earthWeight,  String planet) {
		this.earthWeight = earthWeight;
		this.planet = planet;
		
		
		Map<String, Double> planetG = new HashMap<String, Double>();
		planetG.put("Mercury", 87.96);
		planetG.put("Venus", 224.68);
		planetG.put("Earth", 1.0);
		planetG.put("Mars", 0.38);
		planetG.put("Jupiter", 2.65);
		planetG.put("Saturn", 1.13);
		planetG.put("Uranus", 1.09);
		planetG.put("Neptune", 1.43);
		
		//planetAge = earthAgeInDays/planetYears.get(planet);
		alienWeight = (int)(earthWeight * planetG.get(planet));	
		
		
	}
	
	public int getAlienWeight() {
		return alienWeight;
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
	public void setEarthWeight(int earthWeight) {
		this.earthWeight = earthWeight;
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
