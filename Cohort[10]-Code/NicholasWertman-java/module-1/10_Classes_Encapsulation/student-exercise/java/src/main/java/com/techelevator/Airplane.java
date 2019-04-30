package com.techelevator;

public class Airplane {
	private String planeNumber;
	private	int bookedFirstClassSeats = 0;
	private int totalFirstClassSeats;
	private int bookedCoachSeats = 0;
	private int totalCoachSeats;
	
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	/**
	 * @return the planeNumber
	 */
	public String getPlaneNumber() {
		return planeNumber;
	}
	/**
	 * @return the bookedFirstClassSeats
	 */
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	
	public int getAvailableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}
	/**
	 * @return the totalFirstClassSeats
	 */
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	/**
	 * @return the bookedCoachSeats
	 */
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	
	public int getAvailableCoachSeats( ) {
		return totalCoachSeats - bookedCoachSeats;
	}
	/**
	 * @return the totalCoachSeats
	 */
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	public boolean reserveSeats (boolean firstClass, int totalNumberOfSeats) {
		if (firstClass) {
			if (totalNumberOfSeats > getAvailableFirstClassSeats()) {
				return false;
			}
			bookedFirstClassSeats += totalNumberOfSeats;
		}
		else {
			if (totalNumberOfSeats > getAvailableCoachSeats()) {
				return false;
			}
			bookedCoachSeats += totalNumberOfSeats;
		}
		return true;
	}
	
	

}
