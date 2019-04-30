package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Bank_Teller {

	public static void main(String[] args) {

		BankCustomer andyDevine = new BankCustomer("Devine", "12 Pine St", "216 -855-7463");
		// BankCustomer andyDevine = new BankCustomer();

		BankAccount checkingAccount = new CheckingAccount("24-987", new BigDecimal("45666"));
		BankAccount savingsAccount = new SavingsAccount("24-456", new BigDecimal("102000"));

		andyDevine.addAccount(checkingAccount);
		andyDevine.addAccount(savingsAccount);

		//System.out.printf("Andy Devine has %s accounts", andyDevine.getAccounts().size() + "\n");
		
		//System.out.println(andyDevine.getAccounts());
		
		//checkingAccount.withdraw(new BigDecimal ("2345"));
		
		//System.out.println(andyDevine.getAccounts());
		
		System.out.println(checkingAccount.getBalance());
		
		System.out.println(savingsAccount.getBalance());
		
		System.out.println(andyDevine.getIsVIP());
		
		

		/****************************************************************************
		 * 
		 * Use this application program to test your classes.
		 * 
		 * You should instantiate objects of your class using each of the ctors created
		 * for the class.
		 * 
		 * Use those objects to test each of the methods you have for a class.
		 * 
		 * (Hint: The exercise description has "Sample usage", feel free to use)
		 * 
		 * Consider adding a "show()" method to each class which will display the values
		 * in the data members of the object used to invoke it to make it easy to verify
		 * the processing of your methods
		 * 
		 ****************************************************************************
		 */

		
		  BankAccount aBankAccount = new BankAccount(); BankAccount anotherAcct = new
		  BankAccount("031952",new BigDecimal("19.95"));
		  System.out.println(anotherAcct);
		  
		  BankAccount aCheckingAccount = new CheckingAccount(); CheckingAccount
		  anotherCheckAcct = new CheckingAccount("083112", new BigDecimal("14.92"));
		  System.out.println(anotherCheckAcct);
		  
		  BigDecimal newBal = anotherCheckAcct.withdraw(new BigDecimal("1.00"));
		  System.out.println(newBal);
		  
		  BigDecimal newBalTwo = anotherAcct.withdraw(new BigDecimal("1.00"));
		  System.out.println(newBalTwo); 
		  BankAccount aSavingsAccount = new SavingsAccount(); 
		  BankAccount anotherSaveAcct = new
		  SavingsAccount("07041776", new BigDecimal("17.89"));
		  
		  
		  SavingsAccount thirdCheckAcct = new SavingsAccount("083112", new
		  BigDecimal("18.99")); System.out.println(thirdCheckAcct);
		  
		  BigDecimal newBal3 = thirdCheckAcct.withdraw(new BigDecimal("1.99"));
		  System.out.println(newBal3);
		  
		 

	}

}
