package com.techelevator.model;

import java.util.List;

public interface AttendeeDAO {

	public void createAttendee(String email, String firstName, String lastName, int cookoutId);
	
	public List<Attendee> displayAttendees(int cookoutId);
		
}
