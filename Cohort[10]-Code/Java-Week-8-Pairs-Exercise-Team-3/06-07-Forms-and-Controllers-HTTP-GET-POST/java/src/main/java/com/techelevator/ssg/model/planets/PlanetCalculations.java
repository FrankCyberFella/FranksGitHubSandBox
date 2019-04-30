package com.techelevator.ssg.model.planets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetCalculations implements PlanetDAO {
	private Planet planet;
	private double earthAge;
	private double earthWeight;
	private String transitMethod;
	
	public PlanetCalculations() {
		
	}
	
	public PlanetCalculations(Planet planet, double earthAge, double earthWeight, String transitMethod) {
		this.planet = planet;
		this.earthAge = earthAge;
		this.earthWeight = earthWeight;
		this.transitMethod = transitMethod;
	}

	@Override
	public double calculateAgeInPlanetYears(double earthAge, Planet planet) {
		double newAge = earthAge/planet.getYearInEarthYears();
		return newAge;
	}

	@Override
	public double calculatePlanetWeight(double earthWeight, Planet planet) {
		double newWeight = earthWeight * planet.getGravityOverEarthGravity();
		return newWeight;
	}

	@Override
	public long calculateTravelTimeFromEarth(String transitMethod, Planet planet) {
		Map<String,Integer> speeds = new HashMap<String,Integer>();
		speeds.put("Walking", 3);
		speeds.put("Car", 100);
		speeds.put("Bullet Train", 200);
		speeds.put("Boeing 747", 570);
		speeds.put("Concorde", 1350);
		
		
		return (long)(planet.getMilesFromEarth()/speeds.get(transitMethod)/24/365.26);
	}

	public Planet getPlanetByName(String planetName) {
		Planet thePlanet = new Planet();
		if(PlanetCalculations.thePlanets().containsKey(planetName)) {
			thePlanet=PlanetCalculations.thePlanets().get(planetName);
		}
		return thePlanet;
	}
	
	
	
	public static Map<String,Planet> thePlanets(){
		final double dPY=365.26;
		Map<String,Planet> thePlanets = new HashMap<String,Planet>();
		thePlanets.put("Mercury",new Planet("Mercury", 0.37, 87.96/dPY, 56974146L));
		thePlanets.put("Venus",new Planet("Venus", 0.90, 224.68/dPY, 25724767L));
		thePlanets.put("Earth",new Planet("Earth", 1, 1, 0L));
		thePlanets.put("Luna",new Planet("Luna", 0.17, 1, 238900L));
		thePlanets.put("Mars",new Planet("Mars", 0.38, 686.98/dPY, 48678219L));
		thePlanets.put("Jupiter",new Planet("Jupiter", 2.65, 11.862, 390674710L));
		thePlanets.put("Saturn",new Planet("Saturn", 1.13, 29.456, 792248270L));
		thePlanets.put("Uranus",new Planet("Uranus", 1.09, 84.07, 1692662530L));
		thePlanets.put("Neptune",new Planet("Neptune", 1.43, 164.81, 2703959960L));
		thePlanets.put("Pluto",new Planet("Pluto", 0.04, 247.7, 4660283942L));
		return thePlanets;
	}
}
