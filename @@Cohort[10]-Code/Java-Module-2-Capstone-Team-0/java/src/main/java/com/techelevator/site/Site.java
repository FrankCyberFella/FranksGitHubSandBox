package com.techelevator.site;

public class Site {
	//defined the data members
	private int siteId;
	private int campgroundId;
	private int siteNumber;
	private int maxOccupancy;
	private boolean accessible;
	private int maxRvLength;
	private boolean utilities;
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
	 * @return the campgroundId
	 */
	public int getCampgroundId() {
		return campgroundId;
	}
	/**
	 * @param campgroundId the campgroundId to set
	 */
	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
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
	 * @return the maxRvLength
	 */
	public int getMaxRvLength() {
		return maxRvLength;
	}
	/**
	 * @param maxRvLength the maxRvLength to set
	 */
	public void setMaxRvLength(int maxRvLength) {
		this.maxRvLength = maxRvLength;
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
	

}
