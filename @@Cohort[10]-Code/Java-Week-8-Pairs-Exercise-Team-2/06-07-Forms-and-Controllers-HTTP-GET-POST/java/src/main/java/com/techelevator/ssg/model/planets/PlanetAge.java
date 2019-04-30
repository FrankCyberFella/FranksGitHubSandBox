package com.techelevator.ssg.model.planets;

public class PlanetAge {

	double ageMercury = 0.24;
	double ageVenus = 0.62;
	double ageEarth = 1.00;
	double ageMars = 1.88;
	double ageJupiter = 11.86;
	double ageSaturn = 29.46;
	double ageUranus = 84.07;
	double ageNeptune = 164.81;
	double agePluto = 247.70;
	double calculation;
	
	public double planetAgeCalculation (int earthAge, String selectPlanet) {
	
		if(selectPlanet.equals("mercury")) {
			calculation = earthAge/ageMercury;
		}
		if(selectPlanet.equals("venus")) {
			calculation = earthAge/ageVenus;
		}
		if(selectPlanet.equals("earth")) {
			calculation = earthAge/ageEarth;
		}
		if(selectPlanet.equals("mars")) {
			calculation = earthAge/ageMars;
		}
		if(selectPlanet.equals("jupiter")) {
			calculation = earthAge/ageJupiter;
		}
		if(selectPlanet.equals("saturn")) {
			calculation = earthAge/ageSaturn;
		}
		if(selectPlanet.equals("uranus")) {
			calculation = earthAge/ageUranus;
		}
		if(selectPlanet.equals("neptune")) {
			calculation = earthAge/ageNeptune;
		}
		if(selectPlanet.equals("pluto")) {
			calculation = earthAge/agePluto;
		}
		return calculation;
	}

	public double getAgeMercury() {
		return ageMercury;
	}
	public double getAgeVenus() {
		return ageVenus;
	}
	public double getAgeEarth() {
		return ageEarth;
	}
	public double getAgeMars() {
		return ageMars;
	}
	public double getAgeJupiter() {
		return ageJupiter;
	}
	public double getAgeSaturn() {
		return ageSaturn;
	}
	public double getAgeUranus() {
		return ageUranus;
	}
	public double getAgeNeptune() {
		return ageNeptune;
	}
	public double getAgePluto() {
		return agePluto;
	}
	
}
