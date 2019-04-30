package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer{
	//Data members
	private String name;
	private String address;
	private String phoneNumber;
	private List <BankAccount> accounts = new ArrayList <BankAccount>();

	
	//Default Constructor
	public BankCustomer() {
		
	}
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}
	
	//Methods
	public void addAccount(BankAccount newAccount) {
		accounts.add(newAccount);
		
	}
	
	public boolean getIsVIP() {
		BigDecimal total = new BigDecimal("");
		for(BankAccount account: accounts) {
			total = account.getBalance().add(total);
			System.out.println(account.getBalance());
			if(total.doubleValue() >= 25000.00) {
				return true;
			}
		}
		return false;
	}
	
	public void showBankAccount() {
		for(BankAccount account: accounts) {
			
		System.out.println("Account balance: " +  account.getBalance() + "\n");
		
		}
	}

}
