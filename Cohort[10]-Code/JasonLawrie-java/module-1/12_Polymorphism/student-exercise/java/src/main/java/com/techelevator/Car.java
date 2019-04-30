package com.techelevator;

public class Car implements Vehicle {

	private boolean hasTrailer=false;
	
	public Car(boolean hasTrailer) {
		this.hasTrailer=hasTrailer;
	}
	/**
	 * @return the hasTrailer
	 */
	public boolean isHasTrailer() {
		return hasTrailer;
	}
	@Override
	public double calculateToll(int distance) {
		double toll=distance*.02;
		if(hasTrailer) {
			toll+=1;
		}
		return toll;
	}
	@Override
	public String getDescription() {
		if(hasTrailer) {
			return "Car (with trailer)";
		} else {
			return "Car";
		}
	}

}
