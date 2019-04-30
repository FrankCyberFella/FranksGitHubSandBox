package com.techelevator.ssg.model.planets;

public interface PlanetDAO {

	public double calculateAgeInPlanetYears(double earthAge, Planet planet);
	public double calculatePlanetWeight(double earthWeight, Planet planet);
	public long calculateTravelTimeFromEarth(String transitMethod, Planet planet);
	
}
