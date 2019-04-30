package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Transaction {

	private static DollarAmount currentMoneyProvided = new DollarAmount(0);
	private static final DollarAmount MAX_MONEY_IN = new DollarAmount(10000);
	String productSelected;

	public void feedMoney() throws FileNotFoundException {
		try {
			Scanner inputMoney = new Scanner(System.in);
			System.out.print("How much money would you like to insert? >>> $");
			String input = inputMoney.nextLine();
			Double inputDouble = Double.parseDouble(input);
			if (inputDouble <= 10 && inputDouble % 1 == 0) {
				String logString = getCurrentTimeStamp() + " " + "FEED MONEY: " + currentMoneyProvided;
				String inputString = Double.toString(inputDouble);
				currentMoneyProvided = currentMoneyProvided.plus(DollarAmount.convertToDollarAmount(inputString));
				logString += " " + currentMoneyProvided;
				writeToLog(logString);
				System.out.println();
			} else {
				System.out.println();
				System.out.println("Not a valid amount");
			}
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("Please input a number amount");
		}
	}

	public static void selectItem() throws FileNotFoundException {
		if (!currentMoneyProvided.equals(DollarAmount.ZERO_DOLLARS)) {
			Map<String, Slot> inventory = VendingMachineCLI.getInventory();
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter your selection >>>");
			String selection = input.nextLine().toUpperCase();
			Slot choice = null;
			for (String name : inventory.keySet()) {
				if (selection.equals(name)) {
					String key = name.toString();
					choice = inventory.get(key);
				}
			}
			if (choice != null) {
				vend(choice);
			} else {
				System.out.println();
				System.out.println("*** " + selection + " Not a valid selection ***");
			}
		} else {
			System.out.println("*** You have not fed any money ***");
		}
	}

	public void finishTransaction() throws FileNotFoundException {
		String logString = getCurrentTimeStamp() + " " + "GIVE CHANGE: " + currentMoneyProvided;
		getChangeDue(currentMoneyProvided);
		logString += " " + currentMoneyProvided;
		writeToLog(logString);
	}
	
	public static void writeToLog(String thing) throws FileNotFoundException {
		Logs logFile = VendingMachineCLI.getLogFile();
		logFile.logToFile(thing);
	}
	
	public static void writeToSalesReport(String thing) throws FileNotFoundException {
		Logs salesFile = VendingMachineCLI.getLogFile();
		salesFile.logToFile(thing);
	}
	
	public static void vend(Slot choice) throws FileNotFoundException {
		if (choice.getCurrentQuantity() > 0) {
			if(currentMoneyProvided.isGreaterThanOrEqualTo(choice.getPrice())) {
				choice.decrementCurrentQuantity();
				VendingMachineCLI.addSale(choice.getPrice());
				String logString = getCurrentTimeStamp() + " " + choice.getItemName() + " " + choice.getName() + " " + currentMoneyProvided;
				currentMoneyProvided = currentMoneyProvided.minus(choice.getPrice());
				logString += " " + currentMoneyProvided;
				writeToLog(logString);
				System.out.println();
				System.out.println("Thank you for purchasing a " + choice.getItemName() + "\n");
				System.out.println(choice.consumeSound());
			} else {
				System.out.println();
			System.out.println("*** Sorry, you have not fed enough money for this item ***");
			}
		} else {
			System.out.println();
			System.out.println("*** Sorry, that product is currently SOLD OUT ***");
		}
	}
	
	public DollarAmount getCurrentMoneyProvided() {
		return currentMoneyProvided;
	}
	
	public static void getChangeDue(DollarAmount amount) {
		int amountInCents = amount.getTotalAmountInCents();
		DollarAmount amountIn = new DollarAmount(amountInCents);
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		int quartersValue = 25;
		int dimesValue = 10;
		int nickelsValue = 5;
		int penniesValue = 1;
		
		while(amountInCents >= quartersValue) {
			quarters++;
			amountInCents -= quartersValue;
		}
		while(amountInCents >= dimesValue) {
			dimes++;
			amountInCents -= dimesValue;
		}
		while(amountInCents >= nickelsValue) {
			nickels++;
			amountInCents -= nickelsValue;
		}
		while(amountInCents >= penniesValue) {
			pennies++;
			amountInCents -= penniesValue;
		}
		
		String changeDue = "Quarters: " + quarters + "\n";
		changeDue += "Dimes: " + dimes + "\n";
		changeDue += "Nickels: " + nickels + "\n";
		changeDue += "Pennies: " + pennies + "\n";
		
		System.out.println();
		System.out.println(changeDue);
		System.out.println("Change due: " + amountIn + "\n");
		System.out.println("-----------------");
		
		reset();
	}
	
	public static String getCurrentTimeStamp() {
		return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
	}
	
	public static void reset() {
		currentMoneyProvided = DollarAmount.ZERO_DOLLARS;
	}

}
