package com.techelevator;
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
	
	private Menu menu;   // Menu object to be used by an instance of this class
	private Inventory cliInventory = new Inventory();
	private Cashier cashier;
	
	public VendingMachineCLI(Menu menu) {  // Constructor - user will pas a menu for this class to use
		this.menu = menu;                  // Make the Menu the user object passed, our Menu
		this.cashier=new Cashier(menu);
											// We could keep passing this SAME menu option to the other classes - optional
	}
	
	public void run() {
		Auditor.initializeSalesReport(cliInventory.getMenuList());
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				cliInventory.displayInventoryWithLoc();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				cashier.buyItems(cliInventory);
			}
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
					Auditor.transLog();
					Auditor.salesReport();
					// do end of program processing - good place for a method
					return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}

/*************************************************************************************************************************
*  This is the application program to instantiate a Vending Machine as start it running
*  
*  DO NOT PUT ANY NEW CODE HERE!
***************************************************************************************************************************/
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);          // Instantiate a menu for Vending Machine to use
		VendingMachineCLI cli = new VendingMachineCLI(menu);  // Instantiate a Vending Machine passing it the Menu object to use
		cli.run();                                            // Tell the Vending Machine to start running
	}
}
