package com.techelevator.model.survey;

public class SurveyCount {

	private int count;
	private String parkCode;
	private String parkName;
	
	/**
	 * @return the parkName
	 */
	public String getParkName() {
		return parkName;
	}

	/**
	 * @param parkName the parkName to set
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public SurveyCount() {}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the parkcode
	 */
	public String getParkCode() {
		return parkCode;
	}

	/**
	 * @param parkcode the parkcode to set
	 */
	public void setParkCode(String parkcode) {
		this.parkCode = parkcode;
	}
	
	public String toString() {
		return this.parkName;
	}
	
}
