package com.techelevator;

public class Elevator {

	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;
	
	
	
	/**
	 * @return the currentFloor
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}

	/**
	 * @return the numberOfFloors
	 */
	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	/**
	 * @return the doorOpen
	 */
	public boolean isDoorOpen() {
		return doorOpen;
	}

	public Elevator (int totalNumberOfFloors) {
		this.numberOfFloors = totalNumberOfFloors;
	}
	
	public void openDoor() {
		doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		if (!doorOpen) {
			if (desiredFloor >= 1 && currentFloor < desiredFloor && desiredFloor <= numberOfFloors) {
				currentFloor = desiredFloor;
			}
		}
	}
	
	public void goDown(int desiredFloor) {
		if (!doorOpen) {
			if (desiredFloor >= 1 && currentFloor > desiredFloor && desiredFloor <= numberOfFloors) {
				currentFloor = desiredFloor;
			}
		}
	}

}
