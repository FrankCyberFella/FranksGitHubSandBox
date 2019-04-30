package com.techelevator;

public class Elevator {
	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen = false;

	
	public Elevator(int totalNumberOfFloors) {
		numberOfFloors = totalNumberOfFloors;
	}
	
	public void openDoor() {
		this.doorOpen = true;
	}
	
	public void closeDoor() {
		this.doorOpen = false;
	}
	
	public void goUp(int desiredFloor) {
		if(desiredFloor <= getNumberOfFloors()&& desiredFloor> getCurrentFloor() && !doorOpen) {
			this.currentFloor = desiredFloor;
		}
	}
	
	public void goDown(int desiredFloor) {
		if(desiredFloor >= 1 && desiredFloor < getCurrentFloor() && !doorOpen) {
			this.currentFloor = desiredFloor;
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
