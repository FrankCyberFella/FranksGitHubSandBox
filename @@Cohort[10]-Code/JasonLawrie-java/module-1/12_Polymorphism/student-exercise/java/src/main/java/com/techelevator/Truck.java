package com.techelevator;

public class Truck implements Vehicle {
	
	private int numberOfAxles;

	public Truck(int numberOfAxles) {
		this.numberOfAxles=numberOfAxles;
	}
	
	/**
	 * @return the numberOfAxles
	 */
	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	@Override
	public double calculateToll(int distance) {
		double tollRate=.04;

		if(numberOfAxles>=8) {
			tollRate=0.048;
		} else if(numberOfAxles==6) {
			tollRate=.045;
		} else if(numberOfAxles==4) {
			tollRate=.04;
		}
		return tollRate*distance;
	}
	public String getDescription() {

		return "Truck ("+numberOfAxles+" axles)";

	}

}
