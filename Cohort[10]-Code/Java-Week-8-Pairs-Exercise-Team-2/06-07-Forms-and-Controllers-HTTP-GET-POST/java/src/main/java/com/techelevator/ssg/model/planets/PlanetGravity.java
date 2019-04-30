package com.techelevator.ssg.model.planets;

public class PlanetGravity {

	double gravitySun = 27.95;
	double gravityMercury = 0.37;
	double gravityVenus = 0.90;
	double gravityEarth = 1.00;
	double gravityMoon = 0.17;
	double gravityMars = 0.38;
	double gravityJupiter = 2.65;
	double gravitySaturn = 1.13;
	double gravityUranus = 1.09;
	double gravityNeptune = 1.43;
	double gravityPluto = 0.04;
	double calculation;
	
	public double planetWeightCalculation (int earthWeight, String selectPlanet) {
		
		if(selectPlanet.equals("sun")) {
			calculation = earthWeight*gravitySun;
		}
		if(selectPlanet.equals("mercury")) {
			calculation = earthWeight*gravityMercury;
		}
		if(selectPlanet.equals("venus")) {
			calculation = earthWeight*gravityVenus;
		}
		if(selectPlanet.equals("earth")) {
			calculation = earthWeight*gravityEarth;
		}
		if(selectPlanet.equals("moon")) {
			calculation = earthWeight*gravityMoon;
		}
		if(selectPlanet.equals("mars")) {
			calculation = earthWeight*gravityMars;
		}
		if(selectPlanet.equals("jupiter")) {
			calculation = earthWeight*gravityJupiter;
		}
		if(selectPlanet.equals("saturn")) {
			calculation = earthWeight*gravitySaturn;
		}
		if(selectPlanet.equals("uranus")) {
			calculation = earthWeight*gravityUranus;
		}
		if(selectPlanet.equals("neptune")) {
			calculation = earthWeight*gravityNeptune;
		}
		if(selectPlanet.equals("pluto")) {
			calculation = earthWeight*gravityPluto;
		}
		return calculation;
	}

	public double getGravitySun() {
		return gravitySun;
	}
	public double getGravityMercury() {
		return gravityMercury;
	}
	public double getGravityVenus() {
		return gravityVenus;
	}
	public double getGravityEarth() {
		return gravityEarth;
	}
	public double getGravityMoon() {
		return gravityMoon;
	}
	public double getGravityMars() {
		return gravityMars;
	}
	public double getGravityJupiter() {
		return gravityJupiter;
	}
	public double getGravitySaturn() {
		return gravitySaturn;
	}
	public double getGravityUranus() {
		return gravityUranus;
	}
	public double getGravityNeptune() {
		return gravityNeptune;
	}
	public double getGravityPluto() {
		return gravityPluto;
	}
	
}
