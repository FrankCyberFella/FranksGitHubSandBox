package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class TransactionManager {
private	String logText;
private File fileLog;
private File salesReport;
private PrintWriter logWriter;
private PrintWriter salesReportWriter;
private SimpleDateFormat dateFormat;
private Date dateNow;
private Queue<String> logQueue;
private Map<String, Double> salesList;
private Map<String, Double> priceList;
private String strDate;
private double totalSales;



//ctor
public TransactionManager() throws FileNotFoundException{
	 fileLog = new File("log.txt");
	 logWriter = new PrintWriter(fileLog);
	 
	 salesReport = new File("sales_report.txt");
	 salesReportWriter = new PrintWriter(salesReport);
	 
	 logQueue = new LinkedList<String>();
	 salesList = new TreeMap<String, Double>();
	 priceList = new HashMap<String, Double>();	 	
	 
	 dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	 totalSales = 0;
	
	
}


//methods
public void logTransaction() throws IOException {
	while(logQueue.size() > 0) {
		logWriter.println(logQueue.peek());
		logQueue.poll();
	}
}
	
public void addToLog(String textToAdd) {
	dateNow = new Date();
	strDate = dateFormat.format(dateNow);
	logQueue.add(strDate + " " + textToAdd);
	
}
	
public void closeLog() {
	logWriter.close();
	salesReportWriter.close();
}

public void addToSalesReport(String itemName, Double numberSold) {
	salesList.put(itemName, numberSold);
	
}


public void addToPriceList(String item, Double price) {
	priceList.put(item, price);
}

public boolean containsSalesReportKey(String itemName){
	if(salesList.containsKey(itemName)) {
		return true;
	}
	else {
		return false;
	}
}

public double getQuantitySold(String itemName) {
	return salesList.get(itemName);
}

public void printSalesReport() throws FileNotFoundException {
	Set<String> itemNames = salesList.keySet();
	NumberFormat decimalPlaces = new DecimalFormat("#0.00");
	NumberFormat onePlace = new DecimalFormat("#0");
	
	for(String item: itemNames) {
		double quantity = salesList.get(item);
		double price = priceList.get(item);
		totalSales += (quantity * price);
		salesReportWriter.println(item + " | " + onePlace.format(salesList.get(item)));	
	}
	salesReportWriter.println("**TOTAL SALES** $" + decimalPlaces.format(totalSales));		
}	

}
