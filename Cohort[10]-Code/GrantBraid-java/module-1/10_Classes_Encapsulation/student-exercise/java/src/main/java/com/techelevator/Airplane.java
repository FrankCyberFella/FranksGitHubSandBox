package com.techelevator;

public class Airplane {

	private String planeNumber;
	private int bookedFirstClassSeats = 0;
	private int availableFirstClassSeats; // derive this next time dont declare it
	private int totalFirstClassSeats;
	private int bookedCoachSeats = 0;
	private int availableCoachSeats; // derive this dont decalre it
	private int totalCoachSeats;
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
	/**
	 * @return the availableFirstClassSeats
	 */
	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats;
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
	/**
	 * @return the availableCoachSeats
	 */
	public int getAvailableCoachSeats() {
		return availableCoachSeats;
	}
	/**
	 * @return the totalCoachSeats
	 */
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		availableFirstClassSeats = totalFirstClassSeats;
		availableCoachSeats = totalCoachSeats;
		
	}
	
	
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass) {
			if (availableFirstClassSeats >= totalNumberOfSeats) {
				availableFirstClassSeats -= totalNumberOfSeats;
				bookedFirstClassSeats += totalNumberOfSeats; 
				return true;
			}
		} else {
			if (availableCoachSeats >= totalNumberOfSeats) {
				availableCoachSeats -= totalNumberOfSeats;
				bookedCoachSeats += totalNumberOfSeats;
				return true;
			}
		}
		
		return false; 	
	}
}
