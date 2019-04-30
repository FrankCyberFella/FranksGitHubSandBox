package com.techelevator;

import java.math.BigDecimal;

public class Bank_Teller {
	
	public static void main(String[] args) {
		
		BankAccount acct1 = new CheckingAccount("01234", new BigDecimal("15000.00"));
		SavingsAccount acct2 = new SavingsAccount("Tom & Jake", new BigDecimal("15000.00"));
		
		BankCustomer jake = new BankCustomer("Jake", "123 myStreet", "8675309");
		jake.addAccount(acct1);
		jake.addAccount(acct2);
		
		System.out.println(jake.getIsVip());
		
		System.out.println(acct1.getBalance());
		
		System.out.println(jake.getAddress());
		
		System.out.println("Jake has " + acct1.getBalance() + " in checking and also has " + acct2.getBalance() + " in savings");
		System.out.println("Is Jake a VIP: true or false " + jake.getIsVip());
		
		
		
		System.out.println(acct1.getBalance());
		acct1.withdraw(new BigDecimal("75.00"));
		System.out.println(acct1.getBalance());
		acct1.deposit(new BigDecimal("25.00"));
		System.out.println(acct1.getBalance());
		acct1.withdraw(new BigDecimal("105.00"));
		System.out.println(acct1.getBalance());
		
		
		System.out.println(acct2.getBalance());
		acct2.deposit(new BigDecimal("150.00"));
		System.out.println(acct2.getBalance());
		acct2.withdraw(new BigDecimal("200.00"));
		acct2.getBalance();
		System.out.println(acct2.getBalance());
		System.out.println(acct2.addInterest());
		acct1.transfer(acct2, (new BigDecimal("10.00")));
		System.out.println(acct1.getBalance());
		System.out.println(acct2.getBalance());
		acct2.transfer(acct1, (new BigDecimal("50.00")));
		System.out.println(acct1.getBalance());
		System.out.println(acct2.getBalance());
		
		System.out.printf("%s %s $%.2f", jake.getName(), jake.getPhoneNumber(), jake.getBalance());
		
		
		
	/****************************************************************************
	 * 
	 * Use this application program to test your classes.
	 * 
	 * You should instantiate objects of your class using each of the ctors
	 * created for the class.
	 * 
	 * Use those objects to test each of the methods you have for a class.
	 * 
	 * (Hint: The exercise description has "Sample usage", feel free to use)
	 * 
	 * Consider adding a "show()" method to each class which will display the
	 * values in the data members of the object used to invoke it to make it
	 * easy to verify the processing of your methods
	 * 
	 ****************************************************************************
	 */

	}

}
