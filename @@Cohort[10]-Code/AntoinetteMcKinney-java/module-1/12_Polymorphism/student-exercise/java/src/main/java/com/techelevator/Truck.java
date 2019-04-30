package com.techelevator;

public class Truck implements Vehicle {

	// VARIABLES OR DATA MEMBERS
	private int numberOfAxles;

	// CONSTRUCTORS //
	public Truck(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}

	// GETTERS & SETTERS
	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	//METHODS
	@Override
	public double calculateToll(double distance) {
		double ratePerMile = 0.0;
		double toll = ratePerMile * distance;
		
		if(numberOfAxles == 4) {
			ratePerMile = 0.040;
		}else if (numberOfAxles == 6) {
			ratePerMile = 0.045;
		}else if(numberOfAxles >= 8) {
			ratePerMile = 0.048;
		}
		
		return toll;
	}

}
