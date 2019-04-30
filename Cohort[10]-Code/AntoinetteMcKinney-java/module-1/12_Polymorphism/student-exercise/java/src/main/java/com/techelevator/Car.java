package com.techelevator;

public class Car implements Vehicle {
	// VARIABLES OR DATA MEMBERS
	private boolean hasTrailer;

	// CONSTRUCTORS //
	public Car(boolean hasTrailer) {// Creates a new car indicating whether or not it is pulling a trailer.
		this.hasTrailer = hasTrailer;
	}

	// GETTERS & SETTERS Getters & Setters are public
	public boolean isHasTrailer() {
		return hasTrailer;
	}

	//METHODS
	@Override
	public double calculateToll(double distance) { // is distance suppose to be double instead of int
		double toll = distance * 0.020;
		if (hasTrailer) {
			toll += 1.00;
		}
		return toll;
	}

}
