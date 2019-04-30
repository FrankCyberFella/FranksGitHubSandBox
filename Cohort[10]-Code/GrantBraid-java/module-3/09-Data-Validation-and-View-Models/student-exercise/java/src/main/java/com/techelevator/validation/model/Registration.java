package com.techelevator.validation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Registration {
	
	@NotBlank(message="you need a firstName")
	private String firstName;
	
	@NotBlank(message="Hey I want your email")
	@Email(message="we need a valid email")
	private String email;

	@NotBlank(message="you need a lastName")
	private String lastName;
	
	@NotBlank(message="you need to confirm your email")
	private String confirmEmail;
	
	
	@NotBlank(message="you need a password")
	@Size(min = 8, message="your need a password of atleast 8 characters")
	private String password;
	
	@NotBlank(message="you need to confirm your password")
	private String passwordConfirm;
	
	@NotBlank(message="please enter a date")
	@Pattern(regexp="\\d{2}\\/\\d{2}\\/\\d{4}" , message="Please enter a valid date in mm/dd/yyyy")
	
	private String date;
	
	@NotBlank(message="please enter ticket amount")
	@Pattern(regexp="^(\\d|\\d{2})$" , message="please enter a number from 1 to 10")
	@Min(1)
	@Max(10)
	private String ticket;
	
	
	@SuppressWarnings("unused")
	private boolean passwordMatching;
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(passwordConfirm);
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private boolean emailMatching; // Dummy property to get matching vaildation working
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(confirmEmail); // return true of false
		} else {
			return false;
		}
	}
	
	
	



	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}






	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}






	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}






	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}






	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}



	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	 * @return the confirmEmail
	 */
	public String getConfirmEmail() {
		return confirmEmail;
	}


	/**
	 * @param confirmEmail the confirmEmail to set
	 */
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
