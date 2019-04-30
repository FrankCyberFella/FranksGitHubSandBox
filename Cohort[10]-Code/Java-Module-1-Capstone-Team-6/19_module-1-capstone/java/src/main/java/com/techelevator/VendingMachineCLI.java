package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

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

	Transaction transaction = new Transaction(0);
	Log log = new Log();
	String salesFileName = "SalesReport.txt";
	File salesFile = new File(salesFileName);
	private Map<String, Item> inventory = new TreeMap<String, Item>();
	private Set <String> keys = inventory.keySet();
	NumberFormat formatter = new DecimalFormat("#0.00");    
	private Menu menu;   // Menu object to be used by an instance of this class
	private double totalSales = 0.0;
	
	
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // Constructor - user will pass a menu for this class to use
		this.menu = menu;
		loadInventory();
		log.createAuditLog();
		createSalesReport();
		  // Make the Menu the user object passed, our Menu
	}	
	

	public void run() throws FileNotFoundException {
		while (true) { // loop until user indicates they want to exit
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items- good place for a method
				displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase - good place for a method
				displayPurchaseOptions();
				  //finish transaction
			}
			  else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
					// do end of program processing - good place for a method
				    log.writeToAuditLog();
  			  	    writeSalesReport();
					return;  // exit the process (ie. shut down the vending machine)
					
			}
		}
	}
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}

	

	
	
//*************************************SalesReport Methods**********************************************
		public void createSalesReport() {
			try {
				salesFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void  writeSalesReport() {
			try(PrintWriter salesWriter= new PrintWriter(salesFile)) {
					salesWriter.println("TOTAL SALES:");
					salesWriter.println("");
				 for(String key : keys) {
					 salesWriter.println(inventory.get(key).getName() + "|" + inventory.get(key).getSales());
				 }
				 	 salesWriter.println("");
				     salesWriter.println("***Total Sales***  $" + formatter.format(totalSales));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
		}
	

//**************************************Load Inventory********************************************************
	private void loadInventory() throws FileNotFoundException {
		File inventoryFile = new File("vendingmachine.txt");
		Scanner fileScan = new Scanner(inventoryFile);
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			String[] lineSplit = line.split("\\|");
			Item item = new Item(lineSplit[1], lineSplit[2], lineSplit[3], 5);
			inventory.put(lineSplit[0], item);
		} 

	}
	
	public void displayItems() {
		 Set <String> itemSlots = inventory.keySet();
		 for(String slot : itemSlots) {
			 System.out.println(slot + " " + inventory.get(slot).toString());
		 }
	}

	
	
//**********************************************Display MENU***************************************************

Scanner userInput = new Scanner(System.in);
public void displayPurchaseOptions() {
	System.out.println("1) Insert Money: ");
	System.out.println("2) Select Product: ");
	System.out.println("3) Finish Transaction");
	String optionSelected = userInput.nextLine();
	if(optionSelected.equals("1")){
		feedMoney();
	} else {
		if(optionSelected.equals("2")) {
			selectProduct();
		} else { 
			if(optionSelected.equals("3")) {
				finishTransaction();
			}else {
				System.out.println("Please enter 1, 2 or 3");
			}
		
		}
	} 
	
}

//String auditOffer = String.format("%-15s %-10s $%-5.2f $%-5.2f \n", 
//		getCurrentTimeStamp(), "FEED MONEY:  $", money ,transaction.getCurrentMoney());


public void feedMoney() {
		System.out.println("Please enter $1, $2, $5, $10");
		try{String moneyEntered = userInput.nextLine();
		double money = Double.parseDouble(moneyEntered);
	    if(money - Math.floor(money) != 0) {
			System.out.println("Please enter only whole dollar amounts");
			return;
		} else { 
		transaction.addCurrentMoney(money);
		transaction.printBalance();
		String auditOffer = String.format("%-15s %-21s $%-5.2f $%-5.2f", 
				getCurrentTimeStamp(), "FEED MONEY: ", money ,transaction.getCurrentMoney());
		log.auditList.offer(auditOffer);
//		log.auditList.offer(getCurrentTimeStamp() + "  " + "FEED MONEY:  $" + formatter.format(money) + "  $" + 
//				formatter.format(transaction.getCurrentMoney()));
		displayPurchaseOptions();
			}
		}catch(Exception e) {
			System.out.println("Please try again");
		}
	}


public void selectProduct() {
		System.out.println("Please select an item: ");
		displayItems();
		String itemSelected = userInput.nextLine().toUpperCase();
		//double originalBalance = transaction.getCurrentMoney();
		if(inventory.containsKey(itemSelected) &&
				inventory.get(itemSelected).getPriceToDouble() <= transaction.getCurrentMoney() &&
				inventory.get(itemSelected).getAmount() > 0){
			transaction.subtractCurrentMoney(inventory.get(itemSelected).getPriceToDouble());
			System.out.println("You have selected " + inventory.get(itemSelected).getName() + " $" + inventory.get(itemSelected).getPrice());
			System.out.println(inventory.get(itemSelected).message());
			inventory.get(itemSelected).reduceAmount();
			inventory.get(itemSelected).addSale();
			totalSales += inventory.get(itemSelected).getPriceToDouble();
			transaction.printBalance();
			String auditOffer = String.format("%-15s %-21s $%-5s $%-5.2f ", 
					getCurrentTimeStamp(), inventory.get(itemSelected).getName() + " " + itemSelected,inventory.get(itemSelected).getPrice()  ,transaction.getCurrentMoney());
			log.auditList.offer(auditOffer);
			//log.auditList.offer(getCurrentTimeStamp() + "  " + inventory.get(itemSelected).getName() + " " + itemSelected  + " $" + 
			//		inventory.get(itemSelected).getPrice() + "  $" + formatter.format(transaction.getCurrentMoney()));
			displayPurchaseOptions();
		} else {
			if(inventory.containsKey(itemSelected) && 
					inventory.get(itemSelected).getPriceToDouble() > transaction.getCurrentMoney()) {
					System.out.println("Please enter additional money");
					transaction.printBalance();
					displayPurchaseOptions();
			} else {
				if(!inventory.containsKey(itemSelected)) {
					System.out.println("Not a valid option");
					displayPurchaseOptions();
				} else {
					if(inventory.get(itemSelected).getAmount() <= 0) { 
						System.out.println("SOLD OUT!");
						displayPurchaseOptions();
					}
				}
			}
		}
		
	}

public void finishTransaction() {
	 //log.auditList.offer(getCurrentTimeStamp() + "  " + "GIVE CHANGE:  $" + formatter.format(transaction.getCurrentMoney()) + "  $0.00");
	 String auditOffer = String.format("%-15s %-21s $%-5.2f $%-5.2f", 
				getCurrentTimeStamp(), "GIVE CHANGE: ", transaction.getCurrentMoney(), 0.00);
		log.auditList.offer(auditOffer);
	 transaction.calculateChange();
	 transaction.resetChange();
}



/*************************************************************************************************************************
	 * This is the application program to instantiate a Vending Machine as start it
	 * running
	 * 
	 * DO NOT PUT ANY NEW CODE HERE!
	 * 
	 * @throws FileNotFoundException
	 ***************************************************************************************************************************/

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out); // Instantiate a menu for Vending Machine to use
		VendingMachineCLI cli = new VendingMachineCLI(menu); // Instantiate a Vending Machine passing it the Menu object
																// to use
		cli.run(); // Tell the Vending Machine to start running
	}
}
