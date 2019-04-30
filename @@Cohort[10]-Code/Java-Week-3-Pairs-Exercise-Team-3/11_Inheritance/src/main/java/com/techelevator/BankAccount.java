package com.techelevator;

import java.math.BigDecimal;
import java.util.BitSet;

public class BankAccount { // class 
	
	//VARIABLES OR DATA MEMBERS
	private String accountNumber; //
	private BigDecimal balance;

	
	public BankAccount(){
		this.balance = new BigDecimal("0.00");
		this.accountNumber = "unknown";// default constructor has no return type	
	}
	public BankAccount(String accountNum, BigDecimal bal) {
		this.accountNumber = accountNum;
		this.balance = bal;
	}
	
		
		/*
		 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
		 * private variables to be set to a given value and retrive that value when
		 * used
		 */

		public String getAccountNumber() { //the getter for name variable
		return accountNumber;
		}

		public String setAccountNumber() { //set to private
			return accountNumber;
		}
		
		public BigDecimal getBalance() { //the getter for name variable
			return balance;
			}
		
		private BigDecimal  setBalance() {
			return balance;
		}
		
		// METHODS
		public BigDecimal deposit(BigDecimal amountToDeposit) { // Method
			this.balance = this.balance.add(amountToDeposit);
				return this.balance;
		
		}		
		public BigDecimal addInterest() {
			return this.balance;
		}
			
		public BigDecimal withdraw(BigDecimal amountToWithdraw) { // Method
			this.balance = this.balance.subtract(amountToWithdraw);
					return this.balance;
					
			}
		
		public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) { // Method
			
			this.balance = this.balance.subtract(transferAmount);
			destinationAccount.deposit(transferAmount);
		}
			
		public void showBankAccount() {
			System.out.println("Account balance: " +  getBalance() + "\n");
		
		}
	}


		
		
	

