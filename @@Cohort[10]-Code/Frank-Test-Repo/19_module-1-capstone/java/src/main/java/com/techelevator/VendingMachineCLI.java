package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.techelevator.view.Menu;
/**************************************************************************************************************************
*  This is your Vending Machine class
*  
*  You code should be placed in here
***************************************************************************************************************************/
	public class VendingMachineCLI {

		private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
		private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
		private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
		private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
														    MAIN_MENU_OPTION_PURCHASE,
														    MAIN_MENU_OPTION_EXIT
														    };
	
	private Menu menu; // Variables logffile and Sales Report
		final static File inventoryFile = new File("‎⁨vendingmachine.txt");
		
		//create a string map of slots. string is the key and slot is value
		private static Map<String, Slot> vendingMachineInventory = new TreeMap<String, Slot>(); //shift command o imports all classes that need to be imported
		static Set <String> slotKeys;// decalring keyset 
	
		// Menu object to be used by an instance of this class
	// Constructor - user will pas a menu for this class to use
	// Make the Menu the user object passed, the menu
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // initiate the scanningInventory method
		scanningInventory();//called method
		this.menu = menu;  
		
	}
	
	//Inventory will be in a file so the scan inventory will make it another file object. 
	//first the while is loop while the file has a next line
	
	public static void scanningInventory() throws FileNotFoundException { // created method for scanning inventory
		
		//copy and pasted from lecture
		
		try(Scanner fileScanner = new Scanner(inventoryFile)) { // encapsulated the object called file scanner
			while(fileScanner.hasNextLine()) {       // loop while the file has a next line
				String line = fileScanner.nextLine();//read a line from the file 
				String[] itemLine = line.split("\\|"); //splitting the line into an array of strings.
				//creating a new item and setting values in the constructor(i.e. name [1], price[2], food type[3])
				Item newItem = new Item(itemLine[1], Double.parseDouble(itemLine[2]), itemLine[3]);
				// adding item to the vending machine slot and assigning the slot a slot number[0]
				Slot fillSlot = new Slot(5, newItem, itemLine[0]);
				
				//create a string map of slots. string is the key and slot is value
				vendingMachineInventory.put(fillSlot.getSlotNumber(), fillSlot); //putting the slot in its postion
			}
			slotKeys = vendingMachineInventory.keySet(); //after the import, got the keys which is the slotnumber
			
		}
	}
	
	
	public void run() {
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) { // if they choose 1
				// display vending machine items- good place for a places
				for(String slotNumber: slotKeys) { //for each string of slot number in slotkeys
					/*
					 * Create shortcut variables to easily input in the System.out.println() code snippet
					 */
					String itemName = vendingMachineInventory.get(slotNumber).getStuffToEat().getName();
					double itemPrice = vendingMachineInventory.get(slotNumber).getStuffToEat().getPrice();
					int quanity = vendingMachineInventory.get(slotNumber).getItemsLeftInSlot();
					
					/*
					 * Print out a list of the items in the vending machine
					 */
					System.out.println(slotNumber+" "+itemName+" "+itemPrice+" "+quanity);
					
				}
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) { //if they choose 2
				// do purchase - good place for a method
			}
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) { // if they choose 3
					// do end of program processing - good place for a method
					return;  // exit the process (ie. shut down the vending machine)
			}
		}
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
