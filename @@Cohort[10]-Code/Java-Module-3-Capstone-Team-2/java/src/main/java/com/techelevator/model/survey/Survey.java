package com.techelevator.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	long surveyId;
	
	@NotBlank(message="Park Name is required")
	String parkCode;
	
	@NotBlank(message="E-mail is required")
	@Email(message="Must enter a valid e-mail")
	String emailAddress;
	
	@NotBlank(message="Must enter a State of Residence")
	String state;
	
	@NotBlank(message="Must select an activity level")
	String activityLevel;
	/**
	 * @return the surveyId
	 */
	public long getSurveyId() {
		return surveyId;
	}
	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(long surveyId) {
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
