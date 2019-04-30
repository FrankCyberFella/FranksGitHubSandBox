package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**************************************************************************************************************************
*  This is your Vending Machine class
*  
*  You code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT
													    };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT     = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION         = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
													    PURCHASE_MENU_OPTION_SELECT_PRODUCT,
													    PURCHASE_MENU_OPTION_FINISH_TRANSACTION
													    };
	//private static BigDecimal CurrentMoneyProvided;
	
	private Menu menu;   // Menu object to be used by an instance of this class
	private static Map<String, Slot> inventory = new TreeMap<String, Slot>();
	private static Logs logFile;
	private static Logs salesFile;
	private static DollarAmount totalSales = new DollarAmount(0);
	
	public VendingMachineCLI(Menu menu) {  // Constructor - user will pas a menu for this class to use
		this.menu = menu;                  // Make the Menu the user object passed, our Menu
	}
	
	public void run() throws IOException {
		fillMachine();
		logFile = new Logs("Log File", "Log.txt");
		salesFile = new Logs("Sales Report", "SalesReport.txt");
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayVendingMachineItems();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				runPurchaseMenu();
			}
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
					salesFile.logToFile(generateSalesReport());
					return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}
	
	
	public static void fillMachine() throws FileNotFoundException {
		File file = new File("vendingmachine.csv");
		try(Scanner input = new Scanner(file)){
			while(input.hasNextLine()) {
				String item = input.nextLine();
				String[] itemSplit = item.split("\\|");
				String slotName = itemSplit[0];
				String itemName = itemSplit[1];
				String itemPrice = itemSplit[2];
				String itemType = itemSplit[3];
				Slot slot = new Slot(slotName, itemPrice, itemType, itemName);
				inventory.put(slotName, slot);
			}
		}
	}
	
	public static void displayVendingMachineItems() {
		for(String name : inventory.keySet()) {
			String key = name.toString();
			System.out.print(inventory.get(key).getName() + " " + inventory.get(key).getItemName() + " " + inventory.get(key).getPrice() + " ");
			if(inventory.get(key).getCurrentQuantity() < 1) {
				System.out.println("SOLD OUT");
			}
			System.out.println("Quantity: " + inventory.get(key).getCurrentQuantity());
		}
		
	}
	public static String generateSalesReport() {
		String salesReport = "";
		for(String name : inventory.keySet()) {
			String key = name.toString();
			salesReport += inventory.get(key).getItemName() + " | " + (inventory.get(key).getMaxQuantity() - inventory.get(key).getCurrentQuantity()) + "\n";
		}
		return salesReport += "**TOTAL SALES**" + " " + totalSales;
		
	}
	
	public void runPurchaseMenu() throws FileNotFoundException {
		Transaction newTransaction = new Transaction();
		while(true) {   // loop until user indicates they want to exit
			System.out.println();
			System.out.println("Current Money Provided: " + newTransaction.getCurrentMoneyProvided());
			String choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				newTransaction.feedMoney();
			} else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				newTransaction.selectItem();
			}
				else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					newTransaction.finishTransaction();
					return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}
	
//	public void createLogs() throws IOException {
//		String logFileName = "Log.txt";
//		String salesFileName = "SalesReport.txt";
//		Logs logFile = new Logs("Log File", logFileName);
//		Logs salesFile = new Logs("Sales Report", salesFileName);
//	}
	
	
	public static Map<String, Slot> getInventory(){
		return inventory;
	}
	
	public static Logs getLogFile(){
		return logFile;
	}
	
	public static Logs getSalesReport(){
		return salesFile;
	}
	
	public static void addSale(DollarAmount amountAdd) {
		totalSales = totalSales.plus(amountAdd);
	}
	
	//public void

/*************************************************************************************************************************
*  This is the application program to instantiate a Vending Machine as start it running
*  
*  DO NOT PUT ANY NEW CODE HERE!
 * @throws IOException 
***************************************************************************************************************************/
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);          // Instantiate a menu for Vending Machine to use
		VendingMachineCLI cli = new VendingMachineCLI(menu);  // Instantiate a Vending Machine passing it the Menu object to use
		cli.run();                                            // Tell the Vending Machine to start running
	}
}
