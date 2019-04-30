package com.techelevator;

public class TimeStamp {

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	public TimeStamp (int year,int month, int day, int hour, int minute, int second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		TimeStamp timer= new TimeStamp(year, month, day, hour, minute , second);
	}
	
//	public String createLogTxt() {
//		
//	
//		}
}	
