package com.techelevator;

public class Elevator {
	
	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator (int totalNumberOfFloors) {
		this.currentFloor = 1;
		this.numberOfFloors = totalNumberOfFloors;
		this.doorOpen = doorOpen;
	}

	public void openDoor() {
		doorOpen = true;
	}
	
	public void closeDoor() {
		doorOpen = false;
	}
	
	
	public void goUp(int desiredFloor) {
		if (doorOpen = false && numberOfFloors - desiredFloor > 0) {
			this.currentFloor = desiredFloor;
		}
	}
	
	@SuppressWarnings("unused")
	public void goDown(int desiredFloor) {
		if (doorOpen = false && desiredFloor >= 1 ) {
		currentFloor = currentFloor - desiredFloor;
		}
	}

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
	
}
