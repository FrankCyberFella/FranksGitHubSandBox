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

public class Registration {
	
	@NotBlank(message="field required")
	@Size(max = 20, message="First name must be under 20 characters")
	private String firstName;
	
	@NotBlank(message="field required")
	@Size(max = 20, message="Last name must be under 20 characters")
	private String lastName;
	
	@NotBlank(message="field required")
	@Email(message="please enter a valid email address")
	private String email;
	
	@NotBlank(message="field required")
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
	
	@NotBlank(message="field required")
	@Size(min = 8, message="Password must be at least 8 characters long")
	private String password;
	
	@NotBlank(message="field required")
	private String confirmPassword;
	
	
	
	@NotBlank(message="field required")
	@Pattern(regexp="^\\d{2}\\/\\d{2}\\/\\d{4}$", message="Please enter a valid date(mm/dd/yyyy)")
	private String birthDate;
	
	@NotNull(message="field required")
	@Min(value=1, message="number of tickets must be greater than 0")
	@Max(value=10, message="number of tickets may not exceed 10")
	private int numberOfTickets;
	public String getFirstName() {
		return firstName;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public void setEmailMatching(boolean emailMatching) {
		this.emailMatching = emailMatching;
	}

	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}
}
