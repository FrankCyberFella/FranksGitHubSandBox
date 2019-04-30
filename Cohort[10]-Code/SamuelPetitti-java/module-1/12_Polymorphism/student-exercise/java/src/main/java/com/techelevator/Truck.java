package com.techelevator;

public class Truck implements Vehicle {
	
	private int numberOfAxles;
	
	public Truck(int numberOfAxles) {
		this.numberOfAxles  = numberOfAxles;
		
	}
	
	/**
	 * @return the numberOfAxles
	 */
	public int getNumberOfAxles() {
		return numberOfAxles;
	}
	
	@Override
	
	public double calculateToll(int distance) {
		if(this.numberOfAxles == 4) {
			return 0.040 * distance;
		} else {
			if(this.numberOfAxles == 6) {
				return 0.045 * distance; 
			} else {
				if(this.numberOfAxles == 8) {
					return 0.048 * distance;
				}
			}
		} return 0.0;

	}
	
@Override
	
	public String getDescription() {
		return "Truck (" +  this.numberOfAxles + " Axles)";
		
	}
	





	
}
