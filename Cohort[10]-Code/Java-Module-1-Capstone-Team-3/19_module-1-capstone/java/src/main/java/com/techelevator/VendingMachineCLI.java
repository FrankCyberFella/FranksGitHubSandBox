package com.techelevator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT
													    };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY         = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT     = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH             = "Finish Transaction";
	private static final String PURCHASE_MENU_OPTION_EXIT               = "Main Menu";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH,
															PURCHASE_MENU_OPTION_EXIT
													    	};
	
	public Map<String, Stack<Product>> inventoryMap = new TreeMap<String, Stack <Product>>();
	
	public String[] productNames = new String[16];
	private int productNameCounter = 0;
	
	private double totalSales = 0;
	private Menu menu;
	private Ledger ledger;
	private Banker banker;
	
	public VendingMachineCLI(Menu menu) {  // Constructor - user will pas a menu for this class to use
		this.menu = menu;
		try {
			ledger = new Ledger();
			this.banker = new Banker(ledger);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
										// Make the Menu the user object passed, our Menu
	}

	public void loadInventory() throws IOException {
		
		File inputFile = new File("vendingmachine.csv");
		
		try(Scanner fileScanner = new Scanner(inputFile)) {
			
			String currentLine = "";
			
			while (fileScanner.hasNextLine()) {
				
				currentLine = fileScanner.nextLine();
				
				String[] array = currentLine.split("\\|");
				
				productNames[productNameCounter] = array[1] + " " + Double.parseDouble(array[2]) + " " + array[3];
				productNameCounter++;
				
				Stack<Product> aStack = new Stack<Product>();
				
				for(int i = 0; i < 5; i++) {
					aStack.push(new Product(array[1], Double.parseDouble(array[2]), array[3]));
				}
				
				inventoryMap.put(array[0], aStack);
			}	 
		}
	}
	
	public void displayInventory() {
		String[] purchaseArray = new String[16];
	
		purchaseArray = inventoryMap.keySet().toArray(new String[inventoryMap.size()]);
		
		System.out.println("----------------------------------");
		
		for (int i = 0; i < 16; i++) {
			
			
			if (inventoryMap.get(purchaseArray[i]).size() == 0) {
				System.out.println(purchaseArray[i] + " " + "SOLD OUT");
			}
			
			else {
			System.out.println(purchaseArray[i] + " | " + productNames[i] + " | " + "QTY: " + inventoryMap.get(purchaseArray[i]).size());
			}
		}
		System.out.println("----------------------------------");	
		
	}

	public void selectProduct() throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Select your product: ");
		
		String selection = input.nextLine();
		System.out.println();
		
		if (!inventoryMap.containsKey(selection)) {
			System.out.println("Invalid selection - Returning...");
		}
		
		else if (inventoryMap.get(selection).size() == 0) {
			System.out.println("Sold out! - Returning...");
		}
		
		else if (banker.getBalance() < inventoryMap.get(selection).get(0).getPrice()) {
			System.out.println("Sold out! - Returning...");
		}
		
		else {
			totalSales += inventoryMap.get(selection).get(0).getPrice();
			ledger.writeLogFile(inventoryMap.get(selection).get(0).getName() + " " + selection, banker.getBalance(), banker.getBalance() - inventoryMap.get(selection).get(0).getPrice());
			banker.updateBalance(banker.getBalance(), inventoryMap.get(selection).get(0).getPrice());
			
			switch (inventoryMap.get(selection).get(0).getType()) {
			
			case "Chip": {
				System.out.println("Crunch Crunch, Yum!");
				System.out.println();
				break;
			}
			
			case "Candy": {
				System.out.println("Munch Munch, Yum!");
				System.out.println();
				break;
			}
			
			case "Drink": {
				System.out.println("Glug Glug, Yum!");
				System.out.println();
				break;
			}
			
			case "Gum": {
				System.out.println("Chew Chew, Yum!");
				System.out.println();
				break;
			}
				
			
			}
			
			inventoryMap.get(selection).pop();
		}
		
	}
	
	public int[] calculateSaleCount() {
		int[] saleCount = new int[16];
		String[] purchaseArray = inventoryMap.keySet().toArray(new String[inventoryMap.size()]);
		
		
		for (int i = 0; i < 16; i++) {
			
			saleCount[i] = 5 - inventoryMap.get(purchaseArray[i]).size();
			
		}
		
		
		return saleCount;
	}
	
	public void finishTransaction() throws IOException {
		
		banker.setQuarterCount(0);
		banker.setDimeCount(0);
		banker.setNickelCount(0);
		
		double beforeBalance = banker.getBalance();
		
		banker.calculateChange(banker.getBalance());
		
		System.out.println();
		System.out.println("You will receive " + banker.getQuarterCount() + " Quarters");
		System.out.println("You will receive " + banker.getDimeCount() + " Dimes");
		System.out.println("You will receive " + banker.getNickelCount() + " Nickels");
		System.out.println();
		
		banker.setBalance(0);
		
		ledger.writeLogFile("GIVE CHANGE", beforeBalance, banker.getBalance());
		
	}
	
	public void purchaseMenu() throws IOException {
		
			while(true) {   // loop until user indicates they want to exit
				
				System.out.println("-------------------------------");
				System.out.printf("Current Money Provided: $%.2f\n", banker.getBalance());
				System.out.println("-------------------------------");
				
				String choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
				
				if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					banker.feedMoney();
				} 
				
				else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					selectProduct();
				}
				
				else if(choice.equals(PURCHASE_MENU_OPTION_FINISH)) {
					finishTransaction();
			    }
			
				else if(choice.equals(PURCHASE_MENU_OPTION_EXIT)) {
						// do end of program processing - good place for a method
						return;  // exit the process (ie. shut down the vending machine)
				}
				
		}
	}
		
	public void run() throws IOException {
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayInventory();  // display vending machine items- good place for a method
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu();
			}
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
					ledger.writeSalesReport(productNames, calculateSaleCount(), totalSales);
					ledger.closeLedger();
					return;  // exit the process (ie. shut down the vending machine)
			}
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
		cli.loadInventory();
		cli.run();                                            // Tell the Vending Machine to start running
	}
}
