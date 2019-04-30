package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.techelevator.view.Menu;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Cashier {
	//'                                         ________  h___
	//'  __        __      _____       ___     |        | |  L|_
	//'_/ L\__   _| L\__  |    L\_   _/  L\__  |        |_|     |
	//'-o---o-' '-o---o-' '-O---O-' '=o----o-' '-OO----`OO----O-'
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	//	    Declare CONSTANTS
	private final String[] ALLOWABLE_INPUT_VALUES= {"1.00","2.00","5.00","10.00"};
	private final String[] MENU_2_OPTIONS= {"Feed Money", "Select Product","Finish Transaction"};
	

	//'                                         ________  h___
	//'  __        __      _____       ___     |        | |  L|_
	//'_/ L\__   _| L\__  |    L\_   _/  L\__  |        |_|     |
	//'-o---o-' '-o---o-' '-O---O-' '=o----o-' '-OO----`OO----O-'
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	//	    Declare dataMembers
	private double currentUserBalance;
	private Menu menu; // Define Menu object with input and output sources (keyboard, screen)		
	private List<Slot> shoppingCart = new ArrayList<Slot>();
	private Auditor transactionLog = new Auditor();
	//'                                         ________  h___
	//'  __        __      _____       ___     |        | |  L|_
	//'_/ L\__   _| L\__  |    L\_   _/  L\__  |        |_|     |
	//'-o---o-' '-o---o-' '-O---O-' '=o----o-' '-OO----`OO----O-'
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	//	    Constructors
	public Cashier(Menu menu) {
		currentUserBalance=0;
		this.menu= menu;
	}
	
	public double feedMoney() {
		//for now we are deciding NOT to loop through this and to allow the user to select "FEED MONEY" again
		double choice = Double.parseDouble(menu.getChoiceFromOptions(ALLOWABLE_INPUT_VALUES).toString());
		currentUserBalance+=choice;
		
		
		//this should add a record of a user's deposit
		transactionLog.transaction("FEED MONEY:", choice, currentUserBalance);
		return currentUserBalance;
	}
	
	public double chargeMoney(Slot selection) {
		double oldBalance=currentUserBalance;
		currentUserBalance-=selection.getLocalItem().getPrice();
		transactionLog.addPurchase(selection);
		
		//this should add a record of a user's purchase
		transactionLog.transaction(selection.getLocalItem().getName()+" "+selection.getLocation(), oldBalance, currentUserBalance);
		return currentUserBalance;
	}
	
	public String userSelection(ArrayList<Slot> selections) {
		return menu.getChoiceFromOptions(selections.toArray()).toString();
	}
	
	public void returnChange(OutputStream output) {
		final double QUARTER = .25;
		final double DIME = .1;
		PrintWriter out = new PrintWriter(output);
		int numN = 0;
		
		double qBeforeRound = Math.round((currentUserBalance / QUARTER)*100)/100;
		
		int numQ = (int)qBeforeRound;
		
		double changeLeftAfterQuarters = currentUserBalance % QUARTER;
		double dimesBeforeRound = Math.round((changeLeftAfterQuarters / DIME)*100)/100;
		int numD = (int)dimesBeforeRound;
		
		double nickelsBeforeRound = changeLeftAfterQuarters - (DIME*numD);
		if(nickelsBeforeRound > 0.01) {
			numN++;
		}
		transactionLog.transaction("GIVE CHANGE:", currentUserBalance, 0);
		currentUserBalance=0;
		
		out.println("Returned: "+numQ+" quarters");
		out.println("Returned: "+numD+" dimes");
		out.println("Returned: "+numN+" nickels");
		out.flush();
	}
	
	public double getCurrentUserBalance(){
		return this.currentUserBalance;
	}
	
	
	
	public void buyItems(Inventory cliInventory) {
		while(true) {   // loop until user indicates they want to exit
			System.out.println("*********************************");
			System.out.printf( "* Current Money Provided: $%.2f *\n",currentUserBalance);
			System.out.println("*********************************");
			String choice = (String)menu.getChoiceFromOptions(MENU_2_OPTIONS);
			
			if(choice.equals(MENU_2_OPTIONS[0])) {
				feedMoney();
			} else if(choice.equals(MENU_2_OPTIONS[1])) {
				//System.out.println("Selected: "+userSelection(cliInventory.getMenuList()));
				String holdUserSelect = userSelection(cliInventory.getMenuList());
				String selectLocation = holdUserSelect.split(" ")[1];

				Slot selectedSlot = new Slot();
				for(Slot slot: cliInventory.getMenuList()) {
					if(slot.getLocation().equals(selectLocation)) {
						selectedSlot=slot;
						
					}
				}
				if(currentUserBalance > selectedSlot.getLocalItem().getPrice()) {
					if(selectedSlot.removeItem()) {
						chargeMoney(selectedSlot);
						shoppingCart.add(selectedSlot);
					}
				} else {
					System.out.println("********************");
					System.out.println("*Insufficient funds*");
					System.out.println("********************");
				}
			} else if(choice.equals(MENU_2_OPTIONS[2])) {
				// do end of program processing - good place for a method
				returnChange(System.out);
				System.out.println("*********************************");
				System.out.printf("* Current Money Provided: $%.2f *\n",currentUserBalance);
				System.out.println("*********************************\n");
				for(Slot slot: shoppingCart) {
					System.out.println(Item.consumedMap.get(slot.getLocalItem().getType()));
				}
				shoppingCart.clear();
				return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}
	
}
