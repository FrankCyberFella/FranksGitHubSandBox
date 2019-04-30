package com.techelevator.Site;

public class Site {

	private int siteId;
	private int siteNumber;
	private int maxOccupancy;
	private int MaxRvLength;
	private boolean accessible;
	private boolean utilities;
	private double cost;
	/**
	 * @return the siteId
	 */
	public int getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return the siteNumber
	 */
	public int getSiteNumber() {
		return siteNumber;
	}
	/**
	 * @param siteNumber the siteNumber to set
	 */
	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}
	/**
	 * @return the maxOccupancy
	 */
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	/**
	 * @param maxOccupancy the maxOccupancy to set
	 */
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	/**
	 * @return the maxRvLength
	 */
	public int getMaxRvLength() {
		return MaxRvLength;
	}
	/**
	 * @param maxRvLength the maxRvLength to set
	 */
	public void setMaxRvLength(int maxRvLength) {
		MaxRvLength = maxRvLength;
	}
	/**
	 * @return the accessible
	 */
	public boolean isAccessible() {
		return accessible;
	}
	/**
	 * @param accessible the accessible to set
	 */
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}
	/**
	 * @return the utilities
	 */
	public boolean isUtilities() {
		return utilities;
	}
	/**
	 * @param utilities the utilities to set
	 */
	public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}
	
	public void getCost(double days) {
		
	}
	public void setDailyFee() {
		// TODO Auto-generated method stub
		
	}
	
}
