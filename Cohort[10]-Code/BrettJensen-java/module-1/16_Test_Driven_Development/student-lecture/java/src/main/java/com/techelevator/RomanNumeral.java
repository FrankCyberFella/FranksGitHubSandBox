package com.techelevator;

import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class RomanNumeral {
 /**********************************************************************************************************
 * This class will store a Roman Numeral equivalent of a given Decimal Value
 * 
 *  Decimal values to Roman Numeral 
 *        1 = I, 5 = V, 10 = X, 50 = L, 100 = C, 500 = D, 1000 = M
 ************************************************************************************************************/	
/************************************************************************************************************
 *  member data
 ************************************************************************************************************/ 
    private String romanNumeral;
	private int    decimalValue;
	
	
	public RomanNumeral(int decimalValue) {
	   	this.decimalValue = decimalValue;
	    romanNumeral = determineRomanNumeral();
	}
/************************************************************************************************************
 *  member functions
 ************************************************************************************************************/ 
    private String determineRomanNumeral(){
        
        // TODO - return Roman Numeral for decimal value given when instantiating the class

            return null;
    }

/************************************************************************************************************
 *  getter / setters
 ************************************************************************************************************/ 

     public String getRomanNumeral() {
			return romanNumeral;
		}
		public void setRomanNumeral(String romanNumeral) {
			this.romanNumeral = romanNumeral;
		}
		public int getDecimalValue() {
			return decimalValue;
		}
		
    
/************************************************************************************************************
 *  End of Roman Numeral Class
 ************************************************************************************************************/ 

		public static void main(String[] args) {
			
	
			Map<String, String> items = new HashMap<String, String>();
			items.put("A1", "you chose item in A1");
			items.put("A2", "you chose item in A2");
			items.put("A3", "you chose item in A3");
			items.put("B1", "you chose item in B1");
			items.put("B2", "you chose item in B2");
			items.put("C1", "you chose item in C1");
			items.put("C2", "you chose item in C2");
			
			System.out.println(getCurrentTimeStamp());

//			DollarAmount money = new DollarAmount(0);
//			System.out.println("You have " + money.getDollars() + " dollars in your account");
//			DollarAmount newMoney = new DollarAmount(line);
//			money = money.plus(newMoney);
//			selectItem(items);
//			String amount1 = "3.05";
//			String amount2 = ".85";
//			String amount3 = "1.05";
//			
//			DollarAmount amount101 = convertToDollarAmount(amount1);
//			DollarAmount amount102 = convertToDollarAmount(amount2);
//			DollarAmount amount103 = convertToDollarAmount(amount3);
//			
//			System.out.println(amount102 + " subtracted from " + amount101 + " = " + amount101.minus(amount102));
//			amount101 = amount101.minus(amount102);
//			System.out.println(amount101);
			
//			getChangeDue(amount101);
//			getChangeDue(amount102);
//			getChangeDue(amount103);
			
			
		
		}	
		
		
		
		public static DollarAmount convertToDollarAmount(String amount) {
			String[] splitAmount = amount.split("\\.");
			int dollars = 0;
			int cents = 0;
			if(splitAmount[0].length() > 0) {
			 dollars += Integer.parseInt(splitAmount[0]);
			}
			 cents += Integer.parseInt(splitAmount[1]);
		
			DollarAmount newAmount = new DollarAmount(dollars, cents);
//			System.out.println(newAmount);
			return newAmount;
		}
		
		
		public static void getChangeDue(DollarAmount amount) {
			int amountInCents = amount.getTotalAmountInCents();
			DollarAmount amountIn = new DollarAmount(amountInCents);
			int quarters = 0;
			int dimes = 0;
			int nickels = 0;
			int pennies = 0;
			
			int quartersValue = 25;
			int dimesValue = 10;
			int nickelsValue = 5;
			int penniesValue = 1;
			
			while(amountInCents >= quartersValue) {
				quarters++;
				amountInCents -= quartersValue;
			}
			while(amountInCents >= dimesValue) {
				dimes++;
				amountInCents -= dimesValue;
			}
			while(amountInCents >= nickelsValue) {
				nickels++;
				amountInCents -= nickelsValue;
			}
			while(amountInCents >= penniesValue) {
				pennies++;
				amountInCents -= penniesValue;
			}
			
			String changeDue = "Quarters: " + quarters + "\n";
			changeDue += "Dimes: " + dimes + "\n";
			changeDue += "Nickels: " + nickels + "\n";
			changeDue += "Pennies: " + pennies + "\n";
			
			
			System.out.println(changeDue);
			System.out.println("Change due: " + amountIn + "\n");
			System.out.println("-----------------");
			
			
		}
		
		public static void selectItem(Map<String, String> items) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter your selection >>>");
			String selection = input.nextLine().toUpperCase();
			String choice = "";
			for(String name : items.keySet()) {
				if(selection.equals(name)) {
					String key = name.toString();
					choice = items.get(name);
				}
			}
			if(choice.length() > 0) {
				System.out.println(choice);
			} else {
				System.out.println("Not a valid selection");
			}
		}
		
		public static String getCurrentTimeStamp() {
		    return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a").format(new Date());
		}
		
		
		
		
		
}