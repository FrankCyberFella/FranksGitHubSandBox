package com.techelevator.model;

import java.time.LocalDateTime;

public class ShowTime {
	
	private String theatre;
	private LocalDateTime startTime;
	
	public ShowTime(LocalDateTime startTime, String theatre) {
		this.theatre = theatre;
		this.startTime = startTime;
	}
	
	public String getTheatre() {
		return theatre;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	
}
