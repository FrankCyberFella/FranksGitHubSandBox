package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
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
	private static final String MAIN_MENU_OPTION_ADD_FUNDS     = "Add Funds";
	private static final String MAIN_MENU_OPTION_GET_BALANCE   = "Current Balance";
	private static final String MAIN_MENU_OPTION_GET_CHANGE    = "Change Return";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_ADD_FUNDS,
													    MAIN_MENU_OPTION_GET_BALANCE,
													    MAIN_MENU_OPTION_GET_CHANGE,
													    MAIN_MENU_OPTION_EXIT
													 
													    };
	
	
	private static Map<String, Stack<Item>> inventory = new TreeMap<String, Stack<Item>>();
	private BalanceManager balance = new BalanceManager();
	private TransactionManager logger;
	private Set <String> slotList = inventory.keySet();
	private NumberFormat decimalPlaces;
	
	
	
	
	private Menu menu;   // Menu object to be used by an instance of this class
	
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // Constructor - user will pas a menu for this class to use
		this.menu = menu; // Make the Menu the user object passed, our Menu
		logger = new TransactionManager();
		loadInventory();
		decimalPlaces = new DecimalFormat("#0.00");
		
	}
	
	public void run() throws IOException {
		
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				displayItems();
				
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				runPurchaseOptions();
				
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_ADD_FUNDS)) {
				feedMoney();
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_GET_BALANCE)) {
				balance.printCurrentBalance();
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_GET_CHANGE)) {
				String initialBalance = balance.toString();
				balance.makeChange();
				String finalBalance = balance.toString();
				logger.addToLog("CHANGE RETURNED " + initialBalance + " " + finalBalance );
			}
			
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
					
					endTransaction();
					return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}

	

	
public void endTransaction() throws IOException {
	String initialBalance = balance.toString();
	//balance.makeChange();   // should we return change when the machine is turned off... i dont think. this clutters reports
	String finalBalance = balance.toString();
	//logger.addToLog("CHANGE RETURNED " + initialBalance + " " + finalBalance );
	
	logger.logTransaction();
	System.out.println("Thanks for the money now scram!");
	logger.printSalesReport();
	logger.closeLog();
	System.exit(1);
	
	
	
}
	
public void runPurchaseOptions() throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		balance.printCurrentBalance();
		System.out.println("1) Select Item");
		System.out.println("2) Enter Money");
		String input = keyboard.nextLine();
		boolean endLoop = false;
		
		while(!endLoop){
		if(input.contentEquals("1")) {
			purchaseItem();
		}
		if(input.contentEquals("2")) {
			
			feedMoney();
			endLoop = true;
		}else {
			System.out.println("Don't just push my buttons buddy, do something!");
			endLoop = true;
		}
		}
	}

public void feedMoney() throws FileNotFoundException {
	Scanner keyboard = new Scanner(System.in);
	System.out.println("FEED ME! Small bills only Please. Enter $1 $2 $5 $10 or EXIT");
	String input = keyboard.nextLine();
	
	if(input.equals("1") || input.equals("2") || input.equals("5") || input.equals("10")) {
		String initialBalance = balance.toString();
		balance.addToBalance(Double.parseDouble(input));
		balance.printCurrentBalance();
		logger.addToLog("FEED MONEY " + initialBalance + " " + balance.toString());
		//purchaseItem();
	}
	else {
		if(input.equalsIgnoreCase("EXIT")) {
			
			
		}else
		{
			System.out.println("Not a valid entry!");
			feedMoney();
		}
	}
		
}

public void purchaseItem() throws FileNotFoundException {
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter location of the item you wish to purchase, or EXIT");
	String userSelection = keyboard.nextLine();
	userSelection = userSelection.toUpperCase();
//If User wants to back out	
	if(userSelection.equalsIgnoreCase("EXIT")) {
	}
	else {
	if(inventory.containsKey(userSelection)) {             //maybe refactor with a itemCheck() method
		if(inventory.get(userSelection).size() == 0 ) {
			System.out.println("Sold Out Ha Ha");
			purchaseItem();
		}
		System.out.println("You have selected: " + inventory.get(userSelection).get(0) + ", is that correct?"); 
		String userAnswer = keyboard.nextLine();
//Path if the user has enough money to purchase selected item
		if(userAnswer.toLowerCase().contains("y")) {
			double itemPrice = inventory.get(userSelection).get(0).getPrice();
			double startingBalance = balance.getCurrentBalance();
			if(balance.getCurrentBalance() >= itemPrice) {
				balance.subtractFromBalance(itemPrice);
				inventory.get(userSelection).get(0).getSound();	
//adds to sales report ------------------------------------------------------------------------------------------------------------------------				
				String itemName = inventory.get(userSelection).get(1).getName();   //<--gets name of item at userSelection
				if(logger.containsSalesReportKey(itemName)) { //if key = name of user selection
					double quantity = logger.getQuantitySold(itemName) + 1.0; // set quantity = quantity at key value + 1
					logger.addToSalesReport(itemName, quantity);  //stores item , quantity sold 
				}
				else {  // otherwise creates a key and stores value 1 ie) first sale of item
					logger.addToSalesReport(itemName, 1.0); 
				}
//ends sales report add	-----------------------------------------------------------------------------------------------------------------------			
				inventory.get(userSelection).pop(); // remove item from inventory
				balance.printCurrentBalance();
				logger.addToLog(inventory.get(userSelection).get(0).toLogString() + " " 
						+ String.valueOf(decimalPlaces.format(startingBalance)) + " " + balance.toString());  //add item to the running log
			}
			else {
				System.out.println("Your funds are insufficient... FEED ME MORE MONEY!!!");
				feedMoney(); 
			}
		}
//If Selection was wrong User enters No and receives more instructions
		else {
			if(userAnswer.toLowerCase().contains("n")) {
				System.out.print("What would you like to do? \n1) Return to purchase menu. \n2) Return to main menu. \n");
				userAnswer = keyboard.nextLine();
				if(userAnswer.equals("1")) {
					runPurchaseOptions();	
				}
			}
		}
	}
	else{
		System.out.println("Not a valid selection");
		purchaseItem();
	}
	}	
}	
	

public void displayItems() throws FileNotFoundException {

	
		for(String slotNum : slotList) {
			String quantity;
			if(inventory.get(slotNum).size() >= 1) {
				quantity = String.valueOf(inventory.get(slotNum).size());	
				System.out.println(slotNum.toString() + " | " + inventory.get(slotNum).get(0) + " | Qty: " + quantity);
			}
			else {
				System.out.println(slotNum.toString() + "Too Late We Sold Out! Ha Ha");
			}
			
		}
	}
	

public void loadInventory() throws FileNotFoundException {
	File fileInput = new File("vendingmachine.csv");
	Scanner fileScan = new Scanner(fileInput);	
	while(fileScan.hasNextLine()) {
		String line = fileScan.nextLine();
		String[] parts =  line.split("\\|");
		Stack<Item> aStack = new Stack<Item>();
		for(int i = 0; i < 5; i++) {
			aStack.push( new Item(parts[0], parts[1], parts[2], parts[3]));
			logger.addToPriceList(parts[1], Double.parseDouble(parts[2]));   //<----key map with item name and price
		}
		inventory.put(parts[0], aStack);
	}
}




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
