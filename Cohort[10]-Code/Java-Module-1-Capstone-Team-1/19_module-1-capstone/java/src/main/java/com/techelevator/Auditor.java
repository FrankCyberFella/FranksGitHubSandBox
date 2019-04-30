package com.techelevator;


import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Map;


public class Auditor {

	
	private static Queue<String> auditEntry = new LinkedList<String>();
	private static Map<String, Integer> salesString = new TreeMap<String, Integer>();
	private static double totalSales = 0.0;
	
	public Auditor() {
		
	}
	
	public void transaction(String description, double startB, double endB) {
		Calendar now = Calendar.getInstance();
		String aMPM="";
		if(now.get(Calendar.AM_PM)==0) {
			aMPM="AM";
		} else {
			aMPM="PM";
		}
		String fullEntry = String.format("%02d/%02d/%4d %02d:%02d:%02d %2s %-24s\t$%.2f\t$%.2f", 
										now.get(Calendar.MONTH)+1,
										now.get(Calendar.DAY_OF_MONTH),
										now.get(Calendar.YEAR),
										now.get(Calendar.HOUR),
										now.get(Calendar.MINUTE),
										now.get(Calendar.SECOND),
										aMPM,
										description,
										startB,
										endB);
		//System.out.println(fullEntry);
		auditEntry.offer(fullEntry);
	}
	
	public static void transLog() {
		File fileName = new File("Log.txt");
		try(PrintWriter writer = new PrintWriter(fileName)){
			for(String line : auditEntry) {
			writer.println(line);
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("Unable to write to file");
		}
	}
	
	public static void salesReport() {
		File salesOutput = new File("SalesReport.txt");
		try(PrintWriter writer = new PrintWriter(salesOutput)){
			Set<String> nameSet = salesString.keySet();
			for(String line: nameSet) {
				writer.println(line+"|"+salesString.get(line));
				
			}
			writer.printf("\n**TOTAL SALES** $%,.2f\n", totalSales);
		} catch(FileNotFoundException e) {
			
		}
			
		
	}
	
	public static void initializeSalesReport(ArrayList<Slot> reportNames) {
		for(Slot slot: reportNames) {
			salesString.put(slot.getLocalItem().getName(), 0);
		}
	}
	
	public void addPurchase(Slot name) {
		if(salesString.containsKey(name.getLocalItem().getName())) {
			salesString.put(name.getLocalItem().getName(), salesString.get(name.getLocalItem().getName())+1);
			totalSales+=name.getLocalItem().getPrice();
		} 
			
		
	}
	
	
}
