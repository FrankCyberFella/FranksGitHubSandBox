package com.techelevator;

import com.techelevator.view.Menu;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import org.junit.experimental.theories.Theories;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";   // Define a constant for menu test
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";							  // Define a constant for menu text
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";									  // Define a constant for menu text
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,			  // Define an array with menu choices
													   MAIN_MENU_OPTION_PURCHASE,
													   MAIN_MENU_OPTION_EXIT};
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY,			  // Define an array with purchase menu choices
															PURCHASE_MENU_SELECT_PRODUCT,
															PURCHASE_MENU_FINISH_TRANSACTION};
	private static Inventory inventory;
	
	private double currentBalance = 0;
	private String productName = "";
	private Menu menu;
	private File logFile;
	
	
	
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		logFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/log.txt"); 
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);						// invoke the getChoiceFromOptions method
																									// with array of options
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (Map.Entry<Snack, Integer> snackEntry : inventory.getInventory().entrySet()) {
					System.out.println(snackEntry.getKey().getSlot() + " " + snackEntry.getKey().getCost()
							+ " " + snackEntry.getKey().getName() + " " + snackEntry.getValue());
				}

			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					String purchaseChoice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, this.getCurrentBalance());
					//System.out.println("Current Money Provided: $" + String.format("%.2f", currentBalance));
					
					if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						feedMoney();
					} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						selectProduct();
					} else if (purchaseChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						finishTransaction();
						break;
					}
				}
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.out.println("Thank you for using our vending machine. Have a good day.");
				
				System.out.println();
				Scanner salesReport = new Scanner(System.in);
				System.out.println("Sales manager, do you want the sales report? If yes, enter 'y'");
				if (salesReport.nextLine().equals("y")) {
					writeSalesReport();
				}
				
				System.exit(1);
			}
		}
	}
	
	private void writeSalesReport() {
		double totalSales = 0;
		System.out.println("------------------------------");
		System.out.println("SALES REPORT");
		System.out.println();
		
		for (Map.Entry<Snack, Integer> snackEntry : inventory.getInventory().entrySet()) {
			int sold = 5-snackEntry.getValue();
			totalSales += sold * snackEntry.getKey().getCost();
			System.out.println(snackEntry.getKey().getName() + " | " + sold);
		}
		
		System.out.println();
		System.out.println("**TOTAL SALES** $" + totalSales);
		
		
		
	}

	public void writeLog() {

		try {

			Scanner logScanner = new Scanner(logFile);
			String entireText = "";

			while (logScanner.hasNextLine()) {
				entireText += logScanner.nextLine() + "\n";
			}

			PrintWriter logWriter = new PrintWriter(logFile);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
			String dateString = dateFormat.format(new Date()).toString();

			String newLine = dateString + " GIVE CHANGE:       $" + String.format("%.2f", getCurrentBalance()) + "    $" + String.format("%.2f", 0.0) + "\n";
			entireText += newLine;

			logWriter.print(entireText);
			logWriter.close();
			logScanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Since the path of the text file for logging is hardcoded, please check again");
		}

	}
	
	
	/*
	 * All purchases will be audited and write a line of information in a file called Log.txt
	 */
	public void writeLog(double balance) {
		
		try {
			if (!logFile.exists()) {
				PrintWriter logWriter = new PrintWriter(logFile);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
				String dateString = dateFormat.format(new Date()).toString();
				
				logWriter.printf("%1$-20s %2$-18s %3$-8s %4$5s ", dateString, "FEED MONEY", "$" + String.format("%.2f", balance), "$" + String.format("%.2f", getCurrentBalance()));
				//logWriter.println(dateString  + " FEED MONEY  $" + String.format("%.2f", balance) + "     $" + String.format("%.2f", getCurrentBalance()));
				logWriter.close();
			}
			
			else {   // if the logFile does exist, get the entire text and add the new line to the text and write agin
				Scanner logScanner = new Scanner(logFile);
				String entireText = "";
				
				while (logScanner.hasNextLine()) {
					entireText += logScanner.nextLine() + "\n";
				}
			
				PrintWriter logWriter = new PrintWriter(logFile);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
				String dateString = dateFormat.format(new Date()).toString();
				
				String newLine = dateString  + "  $" + String.format("%.2f", balance) + "     $" + String.format("%.2f", getCurrentBalance()) + "\n";
				//entireText += newLine;
				
				logWriter.print(entireText);
				logWriter.printf("%1$-20s %2$-18s %3$-8s %4$5s ", dateString, "FEED MONEY", "$" + String.format("%.2f", balance),
						"$" + String.format("%.2f", getCurrentBalance()));
				logWriter.close();
				logScanner.close();
						
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Since the path of the text file for logging is hardcoded, please check again");
		}
		
	}
	
	public void writeLog(String slot, double price) {
		try {
			if (!logFile.exists()) {
				PrintWriter logWriter = new PrintWriter(logFile);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
				String dateString = dateFormat.format(new Date()).toString();
				String productName="";
				
				for (Map.Entry<Snack, Integer> snackEntry : inventory.getInventory().entrySet()) {
					if (snackEntry.getKey().getSlot().equals(slot)) {
						productName = snackEntry.getKey().getName();
					}
						
				}
				logWriter.printf("%1$-20s %2$-18s %3$-8s %4$5s ", dateString, productName + " " + slot, "$" + String.format("%.2f", getCurrentBalance()+price), "$" + String.format("%.2f", getCurrentBalance()));
				//logWriter.print(dateString + " " + productName +  " " + slot  + "   $" + String.format("%.2f", getCurrentBalance()+price) + "     $" + String.format("%.2f", getCurrentBalance()) + "\n");
				logWriter.close();
			}
			
			else {   // if the logFile does exist, get the entire text and add the new line to the text and write agin
				Scanner logScanner = new Scanner(logFile);
				String entireText = "";
				
				while (logScanner.hasNextLine()) {
					entireText += logScanner.nextLine() + "\n";
				}
			
				PrintWriter logWriter = new PrintWriter(logFile);
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
				String dateString = dateFormat.format(new Date()).toString();
				String productName = "";
				
				for (Map.Entry<Snack, Integer> snackEntry : inventory.getInventory().entrySet()) {
					if (snackEntry.getKey().getSlot().equals(slot)) {
						productName = snackEntry.getKey().getName();
					}
						
				}
				
				
				//entireText += newLine;
				entireText = entireText.substring(0, entireText.length()-2);
				logWriter.println(entireText);
				logWriter.printf("%1$-20s %2$-18s %3$-9s %4$5s ", dateString, productName + " " + slot, "$" + String.format("%.2f", getCurrentBalance()+price), "$" + String.format("%.2f", getCurrentBalance()));
				
				logWriter.print(entireText);
				logWriter.close();
				logScanner.close();		
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Since the path of the text file for logging is hardcoded, please check again");
		}
		
	}
	
	
	private void finishTransaction() {
		double balance = this.getCurrentBalance() * 100;
		int numNickles = 0;
		int numDimes = 0;
		int numQuarters = 0;
		double remainderForQuarters = 0;
		double remainderForDimes = 0;
		
		// Giving a change for the customer
		remainderForQuarters = balance % 25;
		numQuarters = (int)(balance / 25);
		remainderForDimes = remainderForQuarters%10;
		numDimes = (int)(remainderForQuarters / 10);
		numNickles = (int)(remainderForDimes/5);
		
		writeLog();
		
		// Printing out the change for the customer
		System.out.println("Your Change is: " + numQuarters + " Quarters " + numDimes + " Dimes " + numNickles + " Nickles");
		this.setCurrentBalance(0); // Setting the current balance back to 0.
		
		// Printing our the strange sound
		for (String type : inventory.getListTypes()) {
			if (type.equals("Chip"))
				System.out.println("Crunch Crunch, Yum!");
			else if (type.equals("Candy"))
				System.out.println("Munch Munch, Yum!");
			else if (type.equals("Drink"))
				System.out.println("Glug Glug, Yum!");
			else if (type.equals("Gum"))
				System.out.println("Chew Chew, Yum!");
		}
		
		// Writing the sales report
		
		
		
	}

	/*
	 * when the user selects the select product option, this method will be called
	 */
	private void selectProduct() {
		System.out.println("Please enter the slot of the product that you want to choose");
		Scanner slotScanner = new Scanner(System.in);
		String slot = slotScanner.nextLine();
		
		// If the product code does exist, we subtract
		if (inventory.slotExist(slot) ) {
			
			if (inventory.isSoldOut(slot)) {
				System.out.println("Sorry, the item with this product code is sold out.");
				
			}
			
			double price = inventory.subtract(slot);				// Subtracting the product from the inventory map and returning the price that should be dispensed
			this.setCurrentBalance(this.getCurrentBalance() - price);
			
			writeLog(slot, price);
			
		} else {
			System.out.println("Item with this product code does not exist");
		}
		

	}

	

	/*
	 * when the user selects the feed money option, this method will be called
	 */
	public void feedMoney() {
		System.out.println("Please insert money without dollar sign");
		Scanner balanceScanner = new Scanner(System.in);
		double balance = balanceScanner.nextDouble();
		this.setCurrentBalance(this.getCurrentBalance() + balance);
		writeLog(balance);
		
	}

	public static void main(String[] args) {
		File inputFile = new File("/Users/brianavsec/workspace/java-module-1-capstone-team-5/vendingmachine.csv");
		try {
			Scanner inputScanner = new Scanner(inputFile);			// Creating the scanner object to read the input file
			inventory = new Inventory(inputScanner);		// Creating the inventory from the input file that stores all the snack objects
			inputScanner.close();
		} catch (FileNotFoundException e ) {
			System.out.println("Since we hardcoded the file path, the file is not found because you are running in different laptop. Please change the code in order to run the program");
		}
		
		
		Menu menu = new Menu(System.in, System.out);													// Instantiate menu object (input source, output source)
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	

	
	
}
