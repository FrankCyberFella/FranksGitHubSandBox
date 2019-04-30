package com.techelevator.model;

import java.time.LocalDate;


public class Pothole {
	
	
	private String location;
	private String size;
	private LocalDate dateReported; 
	private LocalDate dateFixed;
	private LocalDate dateInspected;
	private String image;
	private Long potholeId;
	private String repairStatus;
	private int severity = 1;
	private int daysBetweenRepair;
	private float latitude;
	private float longitude;
	private String formValue;
	

	public String getFormValue() {
		return formValue;
	}
	
	public void setFormValue(String formValue) {
		 this.formValue = formValue;
	}
	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getPotholeId() {
		return potholeId;
	}
	public void setPotholeId(Long potholeId) {
		this.potholeId = potholeId;
	}
	public String getRepairStatus() {
		return repairStatus;
	}
	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}

	public LocalDate getDateReported() {
		return dateReported;
	}
	public void setDateReported(LocalDate dateReported) {
		this.dateReported = dateReported;
	}
	public LocalDate getDateInspected() {
		return dateInspected;
	}
	public void setDateInspected(LocalDate dateInspected) {
		this.dateInspected = dateInspected;
	}
	public LocalDate getDateFixed() {
		return dateFixed;
	}
	public void setDateFixed(LocalDate dateFixed) {
		this.dateFixed = dateFixed;
	}
	
	public int getDaysBetweenRepair() {
		return daysBetweenRepair;
	}
	public void setDaysBetweenRepair(int daysBetweenRepair) {
		this.daysBetweenRepair = daysBetweenRepair;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	
}
