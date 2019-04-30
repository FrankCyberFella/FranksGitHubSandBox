package com.techelevator;
import java.math.BigDecimal;
import java.util.ArrayList;
public class BankCustomer {

	//data members---------------
	private String name="";
	private String address="";
	private String phoneNumber="";
	//private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	private BankAccount[] accounts=new BankAccount[0];
	
	//ctor-----------------------
	public BankCustomer() {
		
	}
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	
	//getters and setters---------
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
	
	//methods---------------------
	public void addAccount(BankAccount newAccount) {
		BankAccount[] moreAccounts = new BankAccount[accounts.length+1];
		for(int i = 0; i<accounts.length;i++) {
			moreAccounts[i]=accounts[i];
		}
		moreAccounts[moreAccounts.length-1]=newAccount;
		accounts=moreAccounts;
	}
	public boolean getIsVIP() {
		BigDecimal sumOfBalances = new BigDecimal(0);
		boolean vip;
		for (int i = 0; i < accounts.length; i++) {
			sumOfBalances = accounts[i].getBalance().add(sumOfBalances);
		
		}
		System.out.println(sumOfBalances);
		if (sumOfBalances.doubleValue() >= 25000) {	
		
			return true;
		}
		else {
			return false;
		}
	}
	
}
