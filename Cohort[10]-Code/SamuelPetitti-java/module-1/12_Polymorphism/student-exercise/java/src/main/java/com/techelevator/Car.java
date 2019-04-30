package com.techelevator;

public class Car implements Vehicle {
	
	private boolean hasTrailer;
	
	
	public Car(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
	
	
	@Override
	
	public double calculateToll(int distance) {
		double toll = distance * 0.020;
		if(hasTrailer) {
			return toll + 1.00;
		} return toll;
	}


	/**
	 * @return the hasTrailer
	 */
	public boolean isHasTrailer() {
		return hasTrailer;
	}
	
	
	@Override
	
	public String getDescription() {
		if(hasTrailer) {
			return "Car(with Trailer)";
		} 
		return "Car";
	}

	
	
}
