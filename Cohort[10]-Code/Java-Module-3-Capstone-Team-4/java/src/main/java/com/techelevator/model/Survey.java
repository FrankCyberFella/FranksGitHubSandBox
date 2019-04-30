package com.techelevator.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	@NotBlank
	String parkCode;
	
	@NotBlank(message="please enter an email")
	@Email(message="please enter a valid email")
	String email;
	
	@NotBlank
	String state;
	
	@NotBlank(message="please enter your activity")
	String activity;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	


}
