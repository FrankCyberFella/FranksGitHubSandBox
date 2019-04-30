package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ledger {
	
	private String date;
	private String time;
	private static File logFile;
	private static File salesReport;
	private static PrintWriter writer;
	private static PrintWriter salesWriter;
	
	
	public Ledger() throws FileNotFoundException {
		salesReport = new File("Sales_Report.txt");
		salesWriter = new PrintWriter(salesReport);
		logFile = new File("Log.txt");
		writer = new PrintWriter(logFile);
	}

	public void closeLedger() {
		writer.close();
		salesWriter.close();
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		time = format.format(cal.getTime());
		
		return time;
	}

	/**
	 * @return the time
	 */
	
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
		time = format.format(cal.getTime());
		
		return time;
	}
	
	public File getLogFile() {
		return logFile;
	}
	
	public void writeLogFile(String action, double moneyIn, double balance) throws IOException {
		
		writer.printf(this.getDate() + " " + this.getTime() + " " + action + ": $%.2f     $%.2f\n", moneyIn, balance);
		writer.println();
	}
	
	public void writeSalesReport(String[] itemName, int[] itemQuantity, double totalSales) throws IOException {
		
		for (int i = 0; i < 16; i++ ) {
			salesWriter.println(itemName[i] + " | " + itemQuantity[i]);
		}
		
		salesWriter.println();
		salesWriter.printf("**TOTAL SALES** $%.2f", totalSales);
	}

	
	
}
