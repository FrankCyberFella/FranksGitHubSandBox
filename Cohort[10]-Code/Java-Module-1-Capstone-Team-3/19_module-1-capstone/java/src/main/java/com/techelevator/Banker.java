package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Banker {
	
	private double balance = 0.00;
	
	private final double QUARTER = 0.25;
	private final double    DIME = 0.10;
	private final double  NICKEL = 0.05;
	private final double   PENNY = 0.01;
	
	private int quarterCount = 0;
	private int    dimeCount = 0;
	private int  nickelCount = 0;
	private int   pennyCount = 0;
	
	Ledger ledger;
	
	public Banker(Ledger ledger) {
		this.ledger = ledger;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the quarterCount
	 */
	public int getQuarterCount() {
		return quarterCount;
	}

	/**
	 * @param quarterCount the quarterCount to set
	 */
	public void setQuarterCount(int quarterCount) {
		this.quarterCount = quarterCount;
	}

	/**
	 * @return the dimeCount
	 */
	public int getDimeCount() {
		return dimeCount;
	}

	/**
	 * @param dimeCount the dimeCount to set
	 */
	public void setDimeCount(int dimeCount) {
		this.dimeCount = dimeCount;
	}

	/**
	 * @return the nickelCount
	 */
	public int getNickelCount() {
		return nickelCount;
	}

	/**
	 * @param nickelCount the nickelCount to set
	 */
	public void setNickelCount(int nickelCount) {
		this.nickelCount = nickelCount;
	}

	/**
	 * @return the pennyCount
	 */
	public int getPennyCount() {
		return pennyCount;
	}

	/**
	 * @param pennyCount the pennyCount to set
	 */
	public void setPennyCount(int pennyCount) {
		this.pennyCount = pennyCount;
	}

	public void feedMoney() throws IOException {
		String moneyIn = "0";
		Scanner input = new Scanner(System.in);
		
		while(!moneyIn.equals("X")) {
			
			System.out.printf("Current Balance: $%.2f\n", this.getBalance());
			System.out.println("---");
			System.out.println("Enter X at any time to escape to the menu.");
			System.out.print("Please enter money($1, $2, $5, $10): ");
			moneyIn = input.nextLine();
			System.out.println();
			
			if(moneyIn.equals("1") || moneyIn.equals("2") || moneyIn.equals("5") || moneyIn.equals("10")) {
				
				this.balance += Double.parseDouble(moneyIn);
				ledger.writeLogFile("FEED MONEY", Double.parseDouble(moneyIn), getBalance());

			}
		}
	}
	
	public void updateBalance(double balance, double price) {
		this.balance -= price;
	}
	
	public void calculateChange(double balance) {
		
		int newValue = (int) ((balance + .0001) * 100);
		
		
		while(newValue > 0) {
			
			if (newValue >= 25) {
				newValue -= 25; 
				quarterCount++;
			}
			
			else if (newValue >= 10) {
				newValue -= 10;
				dimeCount++;
			}
			
			else if (newValue >= 5){
				newValue -= 5;
				nickelCount++;
			}
		
	   }
		
	}

}
