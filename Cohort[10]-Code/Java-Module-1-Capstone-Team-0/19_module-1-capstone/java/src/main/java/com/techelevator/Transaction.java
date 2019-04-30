package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class Transaction {

	private double balance = 0;

	public Transaction(double balance) {
		this.balance = 0.00;
	}

	public double getBalance() {
		return balance;
	}

	public void finishTransaction() {
		int acctBalance = (int) (balance * 100);
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		int penny = 1;

		int totalQuarter = (acctBalance / quarter);
		acctBalance %= quarter;
		int totalDime = (acctBalance / dime);
		 acctBalance %= dime;

		int totalNickel = (acctBalance / nickel);
		acctBalance %= nickel;

		int totalPenny = (acctBalance / penny);
		acctBalance %= penny;
		
		
		System.out.println("Quarters: " + totalQuarter);
		System.out.println("Dimes: " + totalDime);
		System.out.println("Nickel: " + totalNickel);
		System.out.println("Pennies: " + totalPenny);

	}
	

	public double feedMoney() {
		Scanner userFedMoney = new Scanner(System.in);
		System.out.println();
		System.out.print("Please insert money >>> ");
		String amount = userFedMoney.nextLine();
		DecimalFormat format = new DecimalFormat("#0.00");

		if (amount.equals("1")) {
			System.out.println("Your current balance: $" + (format.format(balance + 1.00)));
			balance += 1;
		} else if (amount.equals("2")) {
			System.out.println("Your current balance: $" + (format.format(balance + 2.00)));
			balance += 2;
		} else if (amount.equals("5")) {
			System.out.println("Your current balance: $" + (format.format(balance + 5.00)));
			balance += 5;
		} else if (amount.equals("10")) {
			System.out.println("Your current balance: $" + (format.format(balance + 10.00)));
			balance += 10;
		} else if ((!(amount.equals("1"))) || (!(amount.equals("2"))) || (!(amount.equals("5")))
				|| (!(amount.equals("10")))) {
			System.out.println("Error: Please insert $1's, $2's, $5's or $10's");
		}
		return balance;

	}

	public void setBalance(double balance) {
		
		this.balance = balance;
	}



}
