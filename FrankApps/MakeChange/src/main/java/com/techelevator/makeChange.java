package com.techelevator;

import java.util.Scanner;

public class makeChange {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
        double amount = 0.0;    // value to be processed - entered by user

        int halfs     = 0;          // number of half dollars to be given in change
        int quarters  = 0;          // number of quarters to be given in change
        int dimes     = 0;          // number of dimes to be given in change
        int nickels   = 0;          // number of nickels to be given in change
        int pennies   = 0;          // number of pennies to be given in change
        
        int combos    = 0;          // number of possible combinations of change

        int total     = 0;          // amount to be processed converted to pennies
        
        boolean numericValueEntered = true;     // used in verification of value entered by user
        
        boolean weWannaLoop = true;             // loop control variable
        
        while (weWannaLoop) {  // loop until loop control variable is false
	
        System.out.print("Please enter an amount between 0 and 9999 or stop to end: ");  // prompt user for value to be processed
        String response = keyboard.nextLine();                                           // get value from keyboard as a string
        
        if (response.toLowerCase().equals("stop")) {     // if user wants to end...
        	weWannaLoop = false;                         //       set loop to end
        	continue;                                    //       and skip rest of loop process       
        	}
        else {                                           // if user entered a value we want to process...   		
        	try {
        		numericValueEntered = true;              // assume value entered s numeric
        		amount = Double.parseDouble(response);   // convert string to a double value
             }
        	catch(NumberFormatException e) {             // if conversion fails  
        		System.out.println("\nUh-oh unexpected value entered, please try again\n");  // Display message
        		numericValueEntered = false;             // indictate value enterted is not numeric
        	}
        if (!numericValueEntered) {  // if value entered is not numeric...
        	continue;                //      skip the rest of the processing 
        }
        total = (int)(amount*100);   // Convert amount entered to pennies
        
        System.out.println("\nAmount: " + String.format("%1.2f", amount) + "\n");   

        combos = 0;                  // Set number of possible combinations to 0
//----------------------------------------------------------------------------------------------------------------------------------------------
// This loop will calculate the number of each type of coin (half-dollar, quarter, dime, nickel, penny) required for the amount
// amount entered by the user 
// 
// It calculates from the lowest domination (pennies) to the highest (half-dollars)
//  ie. The higher denominations are not considered until all combinations of the lower denominations are determined
//---------------------------------------------------------------------------------------------------------------------------------------------
       
        for (halfs = 0; halfs <= total / 50; halfs++) {   // Loop for number of half dollars required for total amount
        	
        	int total_less_halfs = total - (halfs * 50);  // Calculate amount remaining after half dollars given 
    
        	for (quarters = 0; quarters <= total_less_halfs / 25; quarters++) {  // Loop for number of quarters required for amount remaining after half dollars given
        		
        		int total_less_halfs_quarters = total_less_halfs - (quarters * 25);  // Calculate amount remaining after half dollars and quarters given 
        		
        		for (dimes = 0; dimes <= total_less_halfs_quarters / 10; dimes++) {  // Loop for number of dimes required for amount remaining after half dollars and quarters given 
        			
        			int total_less_halfs_quarters_dimes = total_less_halfs_quarters - (dimes * 10);  // Calculate amount remaining after half dollars, quarters and dimes given 

        			for (nickels = 0; nickels <= total_less_halfs_quarters_dimes / 5; nickels++) {   // Loop for number of nickels required for amount remaining after half dollars. quarters and dimes given 

        				pennies = total_less_halfs_quarters_dimes - (nickels * 5);         // Calculate amount remaining after half dollars, quarters, dimes and nickels given 
                  
        				System.out.print((halfs != 0) ? halfs + " Half-dollars  " : "");   // Display current number of half dollars required if not 0
        				System.out.print((quarters != 0) ? quarters + " Quarters  " : ""); // Display current number of quarters required if not 0
        				System.out.print((dimes != 0) ? dimes + " Dimes  ": "");           // Display current number of dimes required if not 0
        				System.out.print((nickels != 0) ? nickels + " Nickels " : "");     // Display current number of nickels required if not 0
        				System.out.println((pennies != 0) ? pennies + " Pennies " : "");   // Display current number of pennies required if not 0
                  
        				combos++;  // increment number of combinations counter
        			}
        		}
        	 }
         }     
         System.out.println("\nNum combinations: "  + combos);   // Display number of combinations required
         System.out.println("--------------------------------------------------------------------\n");
}
} 
      System.out.println("\nThanks for your patronage!");        // Display end of process message
}
}