package com.techelevator.validation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	
	@NotBlank(message="First name is required")
	@Size(max=20, message="First name cannot be more than 20 characters")
	private String firstName;
	
	@NotBlank(message="Last name is required")
	@Size(max=20, message="Last name cannot be more than 20 characters")
	private String lastName;
	
	@NotBlank(message="Email address required")
	@Email(message="Please enter a valid email address")
	private String email;
	
	private String verifyEmail;
	
	@NotBlank(message="Password is required")
	@Size(min=8, message="Password must be at least 8 characters")
	private String password;
	
	private String verifyPassword;
	
   
	@Past(message="Please enter a valid date")
	private Date birthDate;
	
	@Min(value = 1,message="You must purchase at least one ticket")
	@Max(value = 10,message="YOu cannot purchase more than ten tickets")
	private int tickets;
	
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
	 * @return the verifyEmail
	 */
	public String getVerifyEmail() {
		return verifyEmail;
	}
	/**
	 * @param verifyEmail the verifyEmail to set
	 */
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
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	/**
	 * @param emailMatching the emailMatching to set
	 */
	public void setEmailMatching(boolean emailMatching) {
		this.emailMatching = emailMatching;
	}
	/**
	 * @param passwordMatching the passwordMatching to set
	 */
	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}

	private boolean emailMatching;
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email!=null) {
			return email.equals(verifyEmail);
		} else {
			return false;
		}
		
	}
	
	private boolean passwordMatching;
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if(password!=null) {
			return password.equals(verifyPassword);
		} else {
			return false;
		}
	}
}
