package com.techelevator.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Attendee {
	private int attendeeId;
	@Email(message = "Not a valid email address")
	private String email;
	@NotEmpty(message = "First name required")
	@NotNull
	private String firstName;
	@NotEmpty(message = "Last name required")
	@NotNull
	private String lastName;
	
	
	public int getAttendee_id() {
		return attendeeId;
	}
	
	public void setAttendee_id(int attendee_id) {
		this.attendeeId = attendee_id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	
	
	
	
}
