package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Registration {
	
	@NotBlank(message="First name is required")	
	private String firstName;
	
	@NotBlank(message="Last name is required")	
	private String lastName;
	
	
	@NotBlank(message="Email address is required")
	@Email(message="Email must be a valid email address")	
	private String email;
	
	@NotBlank(message="Verify email address is required")
	private String confirmEmail;
	
	@NotBlank(message="Email address is required")
	private String password;
	
	@NotBlank(message="Verify email address is required")
	private String confirmPassword;
	
	@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$", message="Please enter a valid birthdate, MM-DD-YYYY")
	private String birthday;
	
	@Min(value=1, message="Must buy at least 1")
	@Max(value=10, message="Can't buy more than 10")
	private int tickets;
	
	@SuppressWarnings("unused")
	private boolean emailMatching; 				  
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
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the tickets
	 */
	public int getTickets() {
		return tickets;
	}
	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(confirmEmail);		
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private boolean passwordMatching; 				  
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(confirmPassword);		
		} else {
			return false;
		}
	}

}
