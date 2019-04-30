package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

/**************************************************************************************************************************
*  This is your Vending Machine class
*  
*  You code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private Menu menu; // Menu object to be used by an instance of this class
	private List<Slot> inventory = new ArrayList<Slot>();
	private Stack<Item> stackOfItems = new Stack<Item>();
	private Transaction account = new Transaction(0.00);

	// log.txt file
	String timeStamp = new SimpleDateFormat("MM/dd/yyyy KK:mm:ss a").format(new java.util.Date());
	private File logFile = new File("Log.txt");
	private PrintWriter printer = new PrintWriter(logFile);

	// salesreport.txt file
//	File salesFile = new File("SalesReport.txt");
//	FileWriter salesWriter = new FileWriter(salesFile, true);
//	BufferedWriter bufferedSalesWriter = new BufferedWriter(salesWriter);

	public VendingMachineCLI(Menu menu) throws FileNotFoundException { // Constructor - user will pas a menu for this
																		// class to use
		this.menu = menu;
		stockMachine();
		// Make the Menu the user object passed, our Menu
	}

	public void run() {
		try {
			while (true) { // loop until user indicates they want to exit
		
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			 if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println("inventory");
				displayInventory();

				// display vending machine items- good place for a places
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// System.out.println("purchase");
				displayPurchaseMenu();

				// display sub menu for purchasing 1) Feed Money 2) Select Product 3)Back To
				// Main Menu
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				auditTransactionsChangeBack();
				System.out.println("Thank you!");
				salesReport();

				// salesPrinter.println(iventory.getStackOfItems().elementAt(1) + "|" + (5 -
				// stackOfItems.size()));
				printer.close();
				// to clear buffer zone when we exit
				// do end of program processing - good place for a method
				return; // exit the process (ie. shut down the vending machine)
			}
		} 
	} catch (Exception e) {
	}
	}
	
	public void displayInventory() {
		DecimalFormat format = new DecimalFormat("#0.00");
		for (Slot aSlot : inventory) {
			System.out.println(aSlot.getSlotNumber() + " " + (format.format(aSlot.getPrice())) + " "
					+ aSlot.getStackOfItems().elementAt(1));
		}
	}

	public void displayPurchaseMenu() {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("1) Feed Money \n2) Select Product \n3) Back To Main Menu");
			System.out.println();
			System.out.print("Please choose an option >>> ");
			String purchaseSelection = userInput.nextLine();
			
			if(!(purchaseSelection.equals("1") || purchaseSelection.equals("2") || purchaseSelection.equals("3"))) {
				System.out.println("Error: Invalid entry. Please try again.");
			}

			else if (purchaseSelection.equals("1")) {
				account.feedMoney();
				auditTransactionsFeedMoney();
			}
			else if (purchaseSelection.equals("2")) {
				selectAndPurchase();

			}
			else if (purchaseSelection.equals("3")) {
				account.finishTransaction();
				break;
			}
		}
	}

	public void selectAndPurchase() {
		try {
			Scanner userSelectProduct = new Scanner(System.in);
			System.out.println();
			System.out.print("Please select product to purchase >>> ");
			String slotChosen = userSelectProduct.nextLine();
			DecimalFormat format = new DecimalFormat("#0.00");
			
			// Error for invalid entry. When put in the forEach loop, when selection was correct it spit out the error message a lot of times along with completing purchase.
			if   (!(slotChosen.equalsIgnoreCase("A1") || slotChosen.equalsIgnoreCase("A2") || slotChosen.equalsIgnoreCase("A3") || slotChosen.equalsIgnoreCase("A4") ||
					slotChosen.equalsIgnoreCase("B1") || slotChosen.equalsIgnoreCase("B2") || slotChosen.equalsIgnoreCase("B3") || slotChosen.equalsIgnoreCase("B4") ||
					slotChosen.equalsIgnoreCase("C1") || slotChosen.equalsIgnoreCase("C2") || slotChosen.equalsIgnoreCase("C3") || slotChosen.equalsIgnoreCase("C4") ||
					slotChosen.equalsIgnoreCase("D1") || slotChosen.equalsIgnoreCase("D2") || slotChosen.equalsIgnoreCase("D3") || slotChosen.equalsIgnoreCase("D4"))) {
				System.out.println("Error: Invalid entry. Please try again.");
			}

			for (Slot slot : inventory) {
				if (slot.getSlotNumber().equalsIgnoreCase(slotChosen) && slot.getPrice() <= account.getBalance()
						&& (slot.getStackOfItems().size() > 0)) {
					account.setBalance(account.getBalance() - slot.getPrice());
					slot.getStackOfItems().pop();
					double previousBalance = account.getBalance() + slot.getPrice();
					// System.out.println("QTY: " + slot.getStackOfItems().size());
					System.out.println("Your current balance: $" + (format.format(account.getBalance())));
					// System.out.println("You purchased " + slot.getStackOfItems().elementAt(1));
					System.out.println(slot.getStackOfItems().lastElement().makeSound());
					printer.printf(String.format("%-25s%-25s%-5s%-8s%-6s\n", timeStamp, slot.getStackOfItems().elementAt(1), 
					slot.getSlotNumber(),(format.format(previousBalance)), (format.format(account.getBalance()))));
					

					// salesPrinter.println(slot.getStackOfItems().elementAt(1) + "|" + (5 -
					// stackOfItems.size()));
					// above prints out every time an item is chosen but doesn't give list of items
					// with the size of their stack minus the size of their stack remaining
				} else if (slot.getSlotNumber().equalsIgnoreCase(slotChosen) && slot.getPrice() > account.getBalance()) {
					System.out.println("Error: Feed more money");
				} else if (slot.getSlotNumber().equalsIgnoreCase(slotChosen) && slot.getStackOfItems().size() == 0) {
					System.out.println("Error: Product is currently out of stock.");
				} 

			}
		} catch (Exception e) {
		}
	}

//		for (Slot slot : inventory) {
//			if (slot.getSlotNumber().equals(slotChosen) && slot.getPrice() <= account.getBalance()) {
//				account.setBalance(account.getBalance() - slot.getPrice());
//				slot.getStackOfItems().pop();
//				//System.out.println("QTY: " + slot.getStackOfItems().size());
//				System.out.println("Your current balance: $" + (format.format(account.getBalance())));
//				System.out.println(slot.getStackOfItems().lastElement().makeSound());
//				//printer.println(timeStamp + " "+ slot.getStackOfItems().elementAt(1) +" "+ slot.getSlotNumber() + " " +((format.format(account.getBalance())+ slot.getPrice())) + " " + (format.format(account.getBalance())));
//				printer.println(timeStamp + " "+ slot.getStackOfItems().firstElement() +" "+ slot.getSlotNumber() + " " +((format.format(account.getBalance())+ slot.getPrice())) + " " + (format.format(account.getBalance())));
//
//			} else if (slot.getSlotNumber().equals(slotChosen) && slot.getPrice() > account.getBalance()) {
//				System.out.println("Error: Feed more money");
//			}
//		}
//	}

	public void stockMachine() throws FileNotFoundException {
		try {
			File vending = new File("vendingmachine.csv");
			Scanner fileScanner = new Scanner(vending);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] splitLine = line.split("\\|");
				String slotNumber = splitLine[0];
				Item newItem = new Item(splitLine[1], splitLine[3]);
				Stack<Item> stackOfItems = new Stack<Item>();
				for (int i = 0; i < 5; i++) {
					stackOfItems.push(newItem);
				}
				Slot slot = new Slot(slotNumber, Double.parseDouble(splitLine[2]), stackOfItems);
				inventory.add(slot);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//Audits and Sales Report/////////////////////////////////////

	public void auditTransactionsFeedMoney() {
		DecimalFormat format = new DecimalFormat("#0.00");
		String feedMoney = "FEED MONEY:";

		try {
			// System.out.println(timeStamp + "FEED MONEY: " + " $" + account.getBalance());
			printer.println(String.format("%-25s%-30s%-5s" , timeStamp , feedMoney,(format.format(account.getBalance()))));
			//printer.println(timeStamp + " FEED MONEY: " + (format.format(account.getBalance())));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void auditTransactionsPurchaseItem() {

		try {
			printer.print(timeStamp + " " + account.getBalance());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void auditTransactionsChangeBack() {
		DecimalFormat format = new DecimalFormat("#0.00");
		String giveChange = "GIVE CHANGE:";

		try {
			printer.printf(String.format("%-25s%-30s%-8s%-6s", timeStamp, giveChange, (format.format(account.getBalance())), (format.format(account.getBalance() - account.getBalance()))));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	

	// Method to access our Sales Report

	public void salesReport() {
		
		try { 	
			FileWriter salesFileWriter = new FileWriter("SalesReport.txt", true);
			BufferedWriter bufferedSalesWriter = new BufferedWriter(salesFileWriter);
			PrintWriter salesPrinterWriter = new PrintWriter(bufferedSalesWriter);

			//PrintWriter salesPrinter = new PrintWriter(bufferedSalesWriter);
		
			DecimalFormat format = new DecimalFormat("#0.00");
			double totalSale = 0;
			
			for (Slot printLine : inventory) {
				salesPrinterWriter.write(
				String.format("\n%-25s | %3s", printLine.getStackOfItems().elementAt(1), (5 - printLine.getStackOfItems().size())));
				totalSale += printLine.getPrice() * (5 - printLine.getStackOfItems().size());
// goes to line starting at 235 in case buffered writer doesn't work
//				salesPrinter.println(
//						printLine.getStackOfItems().elementAt(1) + " | " + (5 - printLine.getStackOfItems().size()));
//				totalSale += printLine.getPrice() * (5 - printLine.getStackOfItems().size());
				
			}
// change to salesPrinter.println() if buffered writer does not work
			salesPrinterWriter.write("\n\n**TOTAL SALES**" + "  " + "$" + (format.format(totalSale)));
			// salesPrinter.println("**TOTAL SALES**" + " " + (printLine.getPrice() * (5 -
			// printLine.getStackOfItems().size())));
			// }
			bufferedSalesWriter.close();
			salesPrinterWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/*************************************************************************************************************************
	 * This is the application program to instantiate a Vending Machine as start it
	 * running
	 * 
	 * DO NOT PUT ANY NEW CODE HERE! @throws
	 ***************************************************************************************************************************/

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out); // Instantiate a menu for Vending Machine to use
		VendingMachineCLI cli = new VendingMachineCLI(menu); // Instantiate a Vending Machine passing it the Menu object
																// to use
		cli.run();
	}
}
