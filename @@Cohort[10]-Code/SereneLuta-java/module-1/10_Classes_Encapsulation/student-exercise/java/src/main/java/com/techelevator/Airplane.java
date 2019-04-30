package com.techelevator;

public class Airplane {
	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats = 0;
	private int totalCoachSeats;
	private int bookedCoachSeats = 0;
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalCoachSeats = totalCoachSeats;
		this.totalFirstClassSeats = totalFirstClassSeats;
	}
	

	public int getAvailableFirstClassSeats() {
	return totalFirstClassSeats - bookedFirstClassSeats;
	}
	
	public int getAvailableCoachSeats() {
	return totalCoachSeats - bookedCoachSeats;
	}
			
	public boolean reserveSeats(boolean firstClass, int totalNumberOfSeats) {
		if (firstClass) {
			if(totalNumberOfSeats > getAvailableFirstClassSeats()) {
				return false;
			}
			bookedFirstClassSeats += totalNumberOfSeats;
		}
		else {
			if(totalNumberOfSeats > getAvailableCoachSeats()) {
				return false;
			}
			bookedCoachSeats += totalNumberOfSeats;
		}
		return true;
		
	}
	
	public String getPlaneNumber() {
		return planeNumber;
	}


	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}


	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}


	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}


	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}

	
	
}
