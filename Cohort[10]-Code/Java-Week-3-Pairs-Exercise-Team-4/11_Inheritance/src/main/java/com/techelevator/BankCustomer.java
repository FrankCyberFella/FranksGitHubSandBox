package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

	private String name;
	private String address;
	private String phoneNumber;
	private List<BankAccount> accounts;

	
	
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
	public void getAccounts() {
		for(BankAccount account : accounts) {
			System.out.println(account);
			System.out.println("----------------");
		}
	}

	public BankCustomer() {
		accounts = new ArrayList<BankAccount>();
	}
	
	public void addAccount(BankAccount newAccount) {
		accounts.add(newAccount);
	}
	
	public boolean getIsVip() {
		BigDecimal holder = new BigDecimal("0.0");
		for (BankAccount account : accounts) {
			holder = holder.add(account.getBalance());
			System.out.println(holder);
		}
		if (holder.doubleValue() >= 25000) {
			return true;
		}
		return false;
	}
	
@Override
	
	public String toString() {
	String acctInfo = "";
	for (BankAccount account: accounts) {
		 acctInfo = "Acct#: " + account.getAccountNumber() + "\n";
		acctInfo += "Balance: " + account.getBalance() + "\n";
		
	}

		return acctInfo;
	}
	
	
	
}
