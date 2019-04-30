package com.techelevator.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private int surveyId;
	
	@NotBlank(message="Field is required.")
	private String parkCode;
	
	@NotBlank(message="Field is required.")
	@Email(message="Email must be a valid email address.")
	private String emailAddress;
	
	@NotBlank(message="Field is required.")
	private String state;
	
	@NotBlank(message="Field is required.")
	private String activityLevel;
	
	public Survey() {
		
	}

	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the parkCode
	 */
	public String getParkCode() {
		return parkCode;
	}

	/**
	 * @param parkCode the parkCode to set
	 */
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the activityLevel
	 */
	public String getActivityLevel() {
		return activityLevel;
	}

	/**
	 * @param activityLevel the activityLevel to set
	 */
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	

}
