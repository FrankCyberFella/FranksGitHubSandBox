package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;


public class Cookout {
	
	private int cookoutId;
	private String cookoutName;
	private String description;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate cookoutDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime startTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime endTime;
	private String street;
	private String city;
	private String state;
	private int zip;
	private int host;
	

	public int getCookoutId() {
		return cookoutId;
	}
	public void setCookoutId(int cookoutId) {
		this.cookoutId = cookoutId;
	}
	public String getCookoutName() {
		return cookoutName;
	}
	public void setCookoutName(String cookoutName) {
		this.cookoutName = cookoutName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCookoutDate() {
		return cookoutDate;
	}
	public String getFormattedCookoutDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM d, yyyy");
		String text = cookoutDate.format(formatter);
	    return text;
	}
	public void setCookoutDate(LocalDate cookoutDate) {
		this.cookoutDate = cookoutDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public String getFormattedStartTime() {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		String text = startTime.format(formatter);
	    return text;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public String getFormattedEndTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		String text = endTime.format(formatter);
	    return text;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getHost() {
		return host;
	}
	public void setHost(int host) {
		this.host = host;
	}

}
