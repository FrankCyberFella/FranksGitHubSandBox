package com.techelevator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Transaction {

NumberFormat formatter = new DecimalFormat("#0.00"); 
private double quarters = 0; 
private double dimes = 0; 
private double nickels = 0; 
private double currentMoney = 0; 


public Transaction(double currentMoney) {
	this.currentMoney = currentMoney;
	}

	/**
	 * @return the quarter
	 */
	public double getQuarters() {
		return quarters;
	}


	/**
	 * @return the dime
	 */
	public double getDimes() {
		return dimes;
	}

	

	/**
	 * @return the nickel
	 */
	public double getNickels() {
		return nickels;
	}



	/**
	 * @return the currentMoney
	 */
	public double getCurrentMoney() {

		return currentMoney;
	}

	/**
	 * @param currentMoney the currentMoney to set
	 */
	public void setCurrentMoney(double currentMoney) {
		this.currentMoney = currentMoney;
	}

	//**************************************************Methods*******************************************

public void printBalance() {    
	System.out.println("Your current balance is: $" + formatter.format(getCurrentMoney()));
	
}

public void subtractCurrentMoney(double amount) {
	this.currentMoney = currentMoney - amount;
}

public void addCurrentMoney(double amount) {
		this.currentMoney = currentMoney + amount;
}


public void calculateChange() {
	int change = (int)Math.round(getCurrentMoney() * 100);
	while(change >= 25) {
		change = change - 25;
		this.quarters += .25;
	}
	while(change >= 10) {
		change = change - 10;
		this.dimes += .10;
	}
	while(change >= 5) {
		change = change - 5;
		this.nickels += .05;
	}
	System.out.println("Your change is: $" + formatter.format(getQuarters())
	+ " quarters, $" + formatter.format(getDimes()) + " dimes and $" + formatter.format(getNickels()) + " nickels");
	
	
}

public void resetChange() {
	this.currentMoney = 0;
	this.quarters = 0;
	this.dimes = 0;
	this.nickels = 0;
}



//public void calculateChange() {
//	while(this.currentMoney >= .25) {
//		this.currentMoney -= .25;
//		this.quarters += .25;
//	}
//	while(this.currentMoney >= .10) {
//		this.currentMoney -= .10;
//		this.dimes += .10;
//		
//	}
//	while(this.currentMoney >= .05) {
//		this.currentMoney -= .05;
//		this.nickels += .05;
//	}
//	System.out.println("Your change is: $" + formatter.format(getQuarters())
//	+ " quarters, $" + formatter.format(getDimes()) + " dimes and $" + formatter.format(getNickels()) + " nickels");
//	this.currentMoney = 0;
//	this.quarters = 0;
//	this.dimes = 0;
//	this.nickels = 0;
//}
//




}
