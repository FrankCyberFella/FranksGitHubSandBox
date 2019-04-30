package com.techelevator;

public class Airplane {
	
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int totalCoachSeats;
	
public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
	this.planeNumber = planeNumber;
	this.totalFirstClassSeats = totalFirstClassSeats;
	this.totalCoachSeats = totalCoachSeats;
}
	
	public String getPlaneNumber() {
		return planeNumber;
	}
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	public int getAvailableFirstClassSeats() {
		int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		return availableFirstClassSeats;
	}
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	public int getAvailableCoachSeats() {
		int availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		return availableCoachSeats;
	}
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
	
	if (forFirstClass == true) {
		if (getAvailableFirstClassSeats() < totalNumberOfSeats) {
			return false;
		}
		else {
		bookedFirstClassSeats += totalNumberOfSeats;
		}
		}
	if (forFirstClass == false) {
		if (getAvailableCoachSeats() < totalNumberOfSeats) {
			return false;
		}
		else {
		bookedCoachSeats += totalNumberOfSeats;
		}
	}
	return true;
}
	
}
