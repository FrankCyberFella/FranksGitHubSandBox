package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Registration {
	
	@Size(min=1, max=20, message="First name needs to be between 1 and 20 characters.")
	private String firstName;
	
	@Size(min=1, max=20, message="Last name needs to be between 1 and 20 characters.")
	private String lastName;
	
	@NotBlank(message="Field is required.")
	@Email(message="Email must be a valid email address.")
	private String email;
	
	@NotBlank(message="Field is required.")
	private String confirmEmail;
	
	@NotBlank(message="Field is required.")
	@Size(min=8, max=20, message="Password needs to be at least 8 characters long.")
	private String password;
	
	@NotBlank(message="Field is required.")
	private String confirmPassword;
	
	@NotBlank(message="Field is required.")
	@Pattern(regexp="^\\d{2}\\/\\d{2}\\/\\d{4}$", message="Must follow dd/mm/yyyy format.")
	private String birthDate;
	
	@NotNull(message="Field is required.")
	@Min(value=1, message="Minimum number of tickets is 1.")
	@Max(value=10, message="Maximum number of tickets is 10.")
	private Integer numberOfTickets;
	
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
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the numberOfTickets
	 */
	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}

	/**
	 * @param numberOfTickets the numberOfTickets to set
	 */
	
	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	@SuppressWarnings("unused")
	private boolean emailMatching;
	@AssertTrue(message="Emails must match.")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(confirmEmail);
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private boolean passwordMatching;
	@AssertTrue(message="Passwords must match.")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(confirmPassword);
		} else {
			return false;
		}
	}
	
}
