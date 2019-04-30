package com.techelevator;

import java.math.BigDecimal;

public class BankCustomer extends BankAccount{
	
	private String name = "";
	private String address = "";
	private String phoneNumber = "";
	private BankAccount[] accounts = new BankAccount[0];
	
	
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
	public BankAccount[] getAccounts() {
		return accounts;
	}
	public BankCustomer() {
		
	}
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public void addAccount(BankAccount newAccount) {
		BankAccount[] additionalAccounts = new BankAccount[accounts.length + 1];
		for(int i = 0; i < accounts.length; i++) {
			additionalAccounts[i] = accounts[i];
		}
		additionalAccounts[additionalAccounts.length - 1] =newAccount;
		accounts = additionalAccounts;
	}
	public boolean getIsVip() {
		BigDecimal result = new BigDecimal ("0.00");
		for(BankAccount totalAccounts: accounts) {
			result = totalAccounts.getBalance().add(result);
			if(result.doubleValue() >= 25000) {
				return true;
			}
				
		}
				return false;
	}
}
