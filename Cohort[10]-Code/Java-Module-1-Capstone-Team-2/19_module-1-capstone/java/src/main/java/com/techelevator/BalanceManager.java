package com.techelevator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BalanceManager {

	private double currentBalance;
	private int quarters;
	private int dimes;
	private int nickels;
	
	public BalanceManager () {
		currentBalance = 0;
	}
	
	public void printCurrentBalance() {
		NumberFormat decimalPlaces = new DecimalFormat("#0.00");
		
		
		System.out.println("Current Balance: $" + decimalPlaces.format(getCurrentBalance()));
	}
	public double getCurrentBalance() {
		
		return currentBalance;
	}
	
	public double addToBalance(double amountToAdd) {
		return currentBalance += amountToAdd;
}
	public double subtractFromBalance(double amountToSubtract) {
		return currentBalance -= amountToSubtract;
	}
	

	@Override
	public String toString() {
		NumberFormat decimalPlaces = new DecimalFormat("#0.00");
		return String.valueOf(decimalPlaces.format(currentBalance));
	}
	
	
	public void makeChange() {
		  quarters = 0;
		  dimes = 0;
		  nickels = 0;
		  printCurrentBalance();
		  
		  
		  int newBalance = (int) ((currentBalance +.002) * 100);
		
		  while(newBalance > 0) {
			  if (newBalance >= 25) {
				  newBalance -= 25;
				  quarters ++;
			  }
			  else {
				  if(newBalance >= 10) {
					  newBalance -= 10;
					  dimes ++;
				  }
				  else {
					  if(newBalance >= 5) {
						  newBalance -= 5;
						  nickels ++;
					  }
					  else {
						  System.out.println("you have " + newBalance );
					  }
				  }
			  }
		  }
			
		  System.out.println("\nCHING CHING CHING CHING You hit the JackPot! \nYour winnings sir, or madame: " + quarters + " quarters, " + dimes + 
					" dimes, " + nickels + " nickels.\n");
		  currentBalance = 0;
		  printCurrentBalance(); 
	
	
	}
	
	
	
}
