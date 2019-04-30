package com.techelevator.campground;

import java.time.LocalDate;

public class Campground {
	
	private long campgroundId;
	private long parkId;
	private String name;
	private String openFromMonth;
	private String openToMonth;
	private String dailyFee;
	
	
	
	public long getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(long campgroundId) {
		this.campgroundId = campgroundId;
	}
	public long getParkId() {
		return parkId;
	}
	public void setParkId(long parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenFromMonth() {
		return openFromMonth;
	}
	public void setOpenFromMonth(String openFromMonth) {
		//int number = Integer.parseInt(openFromMonth);
		String month = "";
		switch (openFromMonth) {
			case "01": month = "January";
					break;
			case "02": month = "February";
					break;
			case "03": month = "March";
					break;
			case "04": month = "April";
					break;
			case "05": month = "May";
					break;
			case "06": month = "June";
					break;
			case "07": month = "July";
					break;
			case "08": month = "August";
					break;
			case "09": month = "September";
			         break;
			case "10": month = "October";
				     break;
			case "11": month = "November";
					break;
			case "12": month = "December";
					 break;
			default: month = "yellow";
					break;
		}
				
		
		this.openFromMonth = month;
	}
	public String getOpenToMonth() {
		return openToMonth;
	}
	public void setOpenToMonth(String openToMonth) {
		String month = "";
		switch (openToMonth) {
			case "01": month = "January";
					break;
			case "02": month = "February";
					break;
			case "03": month = "March";
					break;
			case "04": month = "April";
					break;
			case "05": month = "May";
					break;
			case "06": month = "June";
					break;
			case "07": month = "July";
					break;
			case "08": month = "August";
					break;
			case "09": month = "September";
			         break;
			case "10": month = "October";
				     break;
			case "11": month = "November";
					break;
			case "12": month = "December";
					 break;
			default: month = "yellow";
					break;
		}
				
		
		this.openToMonth = month;
	}
	public String getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(String dailyFee) {
		this.dailyFee = dailyFee;
	}
	

}
