package com.techelevator.validation.model;



import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Registration {
	
private int birthday;
	
	private int tickets;
	
	private String password;
	
	private String verifyPassword;
	
	
	@NotBlank(message="First name is required") //"message=" is optional - helpful to user
	private String firstName;
	
	@NotBlank(message="Last name is required") //"message=" is optional - helpful to user
	private String lastName;
	
	@NotBlank(message="Email address is required")
	@Email(message="Email must be a valid email address")//validates the format of the email
	private String email;
	
	@NotBlank(message="Email addresses must match")
	private String verifyEmail;

	
	public int getBirthday() {
		return birthday;
	}
	
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	public int getTickets() {
		return tickets;
	}
	
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	
	
	@SuppressWarnings("unused")
	private boolean emailMatching; // Dummy property to get matching vaildation working
	@AssertTrue(message="Emails must match")
	public boolean isEmailMatching() {
		if(email != null) {
			return email.equals(verifyEmail);
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


}
