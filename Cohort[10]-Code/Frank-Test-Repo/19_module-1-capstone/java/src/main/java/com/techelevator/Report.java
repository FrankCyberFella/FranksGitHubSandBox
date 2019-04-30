//Package & Imports
package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Report {
	// Variables logffile and Sales Report
	
	final File logfile = new File( 
			"‎⁨/Users⁩/⁨antoinettemckinney⁩/workspace⁩/antoinettes-module-1-capstone⁩/19_module-1-capstone⁩/Log.csv");

	final File salesReport = new File(
			"‎⁨/Users⁩/⁨antoinettemckinney⁩/workspace⁩/antoinettes-module-1-capstone⁩/19_module-1-capstone⁩/SalesReport.txt");

	// Constructors
	public Report() {

	}

	// Getters & Setters --Not needed
	// Add method to generate date, time, action, starting balance, ending balance
	// Methods In lecture F/O DAY 2
	/*
	 * PrintStream return type is used to allow this method to return the print
	 * string in the format that I prefer to use.
	 */
	public static PrintStream getTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();

		return System.out.printf("%d/%02d/%02d,%02d:%02d:%02d", month, day, year, hour, minute, second);
	}

	/*
	 * method block created. Paramerters
	 */
	public void logFileReport(String action, double startingBalance, double endingBalance) throws IOException {
		PrintWriter writer = new PrintWriter(logfile);
		// Checking to see if file exist at the expected location
		if (!logfile.exists()) {
			logfile.createNewFile();// Creates the file at the specified location
			writer.print("date,time,action,starting balance,ending balance");// Creates file headers
		}

		// write the information to the file
		writer.print(getTimeStamp() + "," + action + ",$" + startingBalance + ",$" + endingBalance);
		writer.close();
	}

	/*
	 * The Sales Report will print a list of each item sold with the total sales amount vendored for each item
	 */
	public void salesReport(String itemName, double totalItemSales) throws IOException {
		PrintWriter writer = new PrintWriter(salesReport);

		if (!salesReport.exists()) {
			salesReport.createNewFile();
			writer.print("Item Name|Total Item Sales");
		}

		// write the information to the file
		writer.print(itemName + "|" + totalItemSales);
		writer.close();

	}
	
	
	
	
	// first see if file exist, if it dosent exist create the file

	// method for creating log file
	// method to generate sales report

}
