package com.techelevator;

import java.util.Scanner;

public class makeChange {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
        double amount = 0.0;

        int halfs     = 0;
        int quarters  = 0;
        int dimes     = 0;
        int nickels   = 0;
        int pennies   = 0;
        
        int combos    = 0;

        int total     = 0;
        
        boolean weWannaLoop = true;
        
        while (weWannaLoop) {
	
        System.out.print("Please enter an amount or stop to end: ");
        String response = keyboard.nextLine();
        
        if (response.toLowerCase().equals("stop")) {
        	weWannaLoop = false;
        	break;
        	}
        else {
        	amount = Double.parseDouble(response);
             }
        
        total = (int)(amount*100);
        
        System.out.println("\nAmount: " + String.format("%1.2f", amount) + "\n");
        
        for (halfs = 0; halfs <= total / 50; halfs++) {
        	
        	int total_less_halfs = total - (halfs * 50);
    
        	for (quarters = 0; quarters <= total_less_halfs / 25; quarters++) {
        		
        		int total_less_quarters = total_less_halfs - (quarters * 25);
        		
        		for (dimes = 0; dimes <= total_less_quarters / 10; dimes++) {
        			
        			int total_less_quarters_dimes = total_less_quarters - (dimes * 10);
        			for (nickels = 0; nickels <= total_less_quarters_dimes / 5; nickels++) {
        				pennies = total_less_quarters_dimes - (nickels * 5);
                  
        				System.out.print((halfs != 0) ? halfs + " Half-dollars  " : "");
        				System.out.print((quarters != 0) ? quarters + " Quarters  " : "");
        				System.out.print((dimes != 0) ? dimes + " Dimes  ": "");
        				System.out.print((nickels != 0) ? nickels + " Nickels " : "");
        				System.out.println((pennies != 0) ? pennies + " Pennies " : "");
                  
        				combos++;
        			}
        		}
        	 }
         }     
         System.out.println("\nNum combinations: "  + combos);
         System.out.println("--------------------------------------------------------------------\n");
}
        System.out.println("\nThanks for your patronage!");
} 
}