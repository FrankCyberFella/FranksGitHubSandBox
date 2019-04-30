package com.techelevator.validation.model;


import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	

	@Size(min=1, max= 20, message="please enter between 1 and 20 characters")
	@NotBlank(message= "First Name is required")
	String firstName;
	
	@Size(min=1, max= 20, message="please enter between 1 and 20 characters")
	@NotBlank(message= "Last Name is required")
	String lastName;
	
	
	@NotBlank(message="Email address is required")
	@Email(message="Email must be a valid email address")//validate the format of email NOT that it is a real one 
	private String email;
	
	
	@NotBlank(message="Matching Email address is required")
	private String confirmEmail;
	
	@SuppressWarnings("unused")
	private boolean emailMatching;
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(confirmEmail);
		} else {
			return false;
		}
	}
	
	@Size(min=8, message="please enter 8 or more characters")
	@NotBlank(message= "Password is required")
	String password;
	
	@NotBlank(message="Must match password")
	private String confirmPassword;
	
	
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
	
//	@NotBlank(message= "required")
	@DateTimeFormat(pattern="MM/dd/yyyy")
    @Past 
    private Date birthDate;
	
	
	@Min(value=1, message= "Tickets must be between 1 and 10")
	@Max(value=10,message= "Tickets must be between 1 and 10")
	private int numberOfTickets;
	
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
	 * @return the date
	 */
	public Date getbirthDate() {
		return birthDate;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the numberOfTickets
	 */
	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	/**
	 * @param numberOfTickets the numberOfTickets to set
	 */
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}	
	

	

}
