package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	
	private String name = "";
	private String address = "";
	private String phoneNumber = "";
	private List<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public BankCustomer() {
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the accounts
	 */
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void addAccount(BankAccount newAccount) {
		accounts.add(newAccount);
	}
	
	public boolean getIsVIP(List<BankAccount> accounts) {
		double totalSum = 0;
		
		for (BankAccount tempAccount : accounts) {	
			totalSum += tempAccount.getBalance().doubleValue();	
		}
		
		if (totalSum >= 25000) {
			return true;
		}
		return false;
	}
	
}
