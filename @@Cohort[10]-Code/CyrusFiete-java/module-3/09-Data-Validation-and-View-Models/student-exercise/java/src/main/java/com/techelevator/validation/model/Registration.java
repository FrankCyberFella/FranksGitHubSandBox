package com.techelevator.validation.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	
	@NotBlank(message="Required!")
	@Length(max=20, message="Please enter a first name under 20 characters.")
	private String firstName;
	
	@NotBlank(message="Required!")
	@Length(max=20, message="Please enter a last name under 20 characters.")
	private String lastName;
	
	@NotBlank(message="Required!")
	@Email(message="Email must be valid!")
	private String email;
	
	@NotBlank(message="Required!")
	private String verifyEmail;
	
	@NotBlank(message="Required!")
	@Length(min=8, message="Please enter a password at least 8 characters long.")
	private String password;
	
	@NotBlank(message="Required!")
	private String verifyPassword;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Past(message="Please enter a date from the past.")
	private Date birthDate;
	
	@Min(value=1, message="You must purchase at least one ticket.")
	@Max(value=10, message="You cannot purchase more than 10 tickets.")
	private Integer tickets;
	
	@SuppressWarnings("unused")
	private boolean emailMatching;
	@AssertTrue(message="Emails must match!")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(verifyEmail);
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private boolean passwordMatching; 
	@AssertTrue(message="Passwords must match!")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(verifyPassword);
		} else {
			return false;
		}
	}

	public String getFirstName() {
		return firstName;
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

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getVerifyPassword() {
		return verifyPassword;
	}
	
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Integer getTickets() {
		return tickets;
	}
	
	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}
}
