package com.techelevator;

public class Elevator {

	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen;

	public Elevator(int totalNumberOfFloors) {
		numberOfFloors = totalNumberOfFloors;

		currentFloor = 1;

	}

	public void openDoor() {
		doorOpen = true;
	}

	public void closeDoor() {
		doorOpen = false;
	}

	public void goUp(int desiredFloor) {
		if ((doorOpen == false) && (desiredFloor <= numberOfFloors) && desiredFloor > currentFloor) {

			currentFloor = currentFloor + (desiredFloor - currentFloor);
		}
		
	}
	

	public void goDown(int desiredFloor) {
		if ((doorOpen == false) && (desiredFloor >= 1) && desiredFloor < currentFloor)  {

			currentFloor = currentFloor - (currentFloor - desiredFloor);
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
