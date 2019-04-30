package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Registration {
	
	@NotBlank(message="First name is required")	// message is optional
	private String firstName;
	
	@NotBlank(message="Last name is required")	// message is optional
	private String lastName;
	
	@NotBlank(message="Email address is required")
	@Email(message="Email must be a valid email address")	// validate the format of email NOT that is a real one
	private String email;
	
	@NotBlank(message="Verify email address is required")
	private String verifyEmail;
	
	@NotBlank(message="Password is required")	// message is optional
	private String password;
	
	@NotBlank(message="Verify password is required")
	private String verifyPassword;

	
	@SuppressWarnings("unused")
	private boolean emailMatching; // Dummy property to get matching validation working
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(verifyEmail);	// return true or false
		} else {
			return false;
		}
	}
	
	@Min(value=1, message="You must order at least 1 ticket")
	@Max(value=10, message="You cannot order more than 10 tickets")
	private Integer numOfTickets;
	
	@SuppressWarnings("unused")
	private boolean passwordMatching; // Dummy property to get matching validation working
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(verifyPassword);	// return true or false
		} else {
			return false;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the verifyPassword
	 */
	public String getVerifyPassword() {
		return verifyPassword;
	}

	/**
	 * @param verifyPassword the verifyPassword to set
	 */
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	/**
	 * @return the numOfTickets
	 */
	public Integer getNumOfTickets() {
		return numOfTickets;
	}

	/**
	 * @param numOfTickets the numOfTickets to set
	 */
	public void setNumOfTickets(Integer numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

}

