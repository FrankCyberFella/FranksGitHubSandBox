package com.techelevator.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	@Email(message = "Please input a valid email address")
	@NotBlank(message = "Cannot be blank")
	private String emailAddress;
	
	
	private Long surveyId;
	
	private Long countPark;
	private Long countAll;

	private String parkName;
	
	@NotBlank(message="Please enter a state")
	private String state;
	
	@NotBlank(message="Please enter an activity level")
	private String activityLevel;

	@NotBlank(message="Please enter a park")
	private String parkCode;
	
	public Long getCountPark() {
		return countPark;
	}

	public void setCountPark(Long countPark) {
		this.countPark = countPark;
	}

	public Long getCountAll() {
		return countAll;
	}

	public void setCountAll(Long countAll) {
		this.countAll = countAll;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}
	
	

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}