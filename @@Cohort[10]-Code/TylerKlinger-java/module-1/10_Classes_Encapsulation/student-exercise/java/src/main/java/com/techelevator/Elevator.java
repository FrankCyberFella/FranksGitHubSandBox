package com.techelevator;

public class Elevator {
	//Class data members
	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen;
	//CTOR
	Elevator (int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	//Getters and Setters
	public int getCurrentFloor() {
		return currentFloor;
	}
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public boolean isDoorOpen() {
		return doorOpen;
	}
	
	//Return
}