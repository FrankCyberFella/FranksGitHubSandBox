package com.techelevator.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

//TODO Modify the app so that the user can modify password, username, etc.

public class User {	
	//TODO Come back and figure out this validation, need to change something in the JSP
	@Email(message = "Must be valid email address")
	private String emailAddress;
	private String userName;
	@Size(min = 10, message = "Password too short, must be at least 10")
	@Pattern.List({ @Pattern(regexp = ".*[a-z].*", message = "Must have a lower case"),
			@Pattern(regexp = ".*[A-Z].*", message = "Must have a capital") })
	private String password;
	private String confirmPassword;
	private String role;


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
