package com.techelevator;

public class ChangeDispenser {
//	If items in the  slot runs out of items then either another purchse
//	 * will be made or money will be reurned. Figure out where to put this
//	
		// VARIABLES OR DATA MEMBERS
		double paymentRecieved;
		
		// CONSTRUCTORS // only set variables 
		public ChangeDispenser() {

		}
			/*GETTERS & SETTERS 
			*Getters & Setters are public.
			*They allow the values for the private 
			*variables to be set to a given value and retrieve that value when used */


		// METHODS
		
	/*
	 * When a purchase is made, money inserted is subtracted from the cost of items
	 */
		
		/*
		 * If a person inserts money into the machine, the machine will calculate the
		 * money inserted verse what is bought. Then the machine will return change if
		 * there is any.
		 */
		public double changeDispenser(double paymentRecieved, double totalCost) { //REMEMBER JUNIT TEST
			double change = 0;
			
			if (paymentRecieved > totalCost) {
				change = paymentRecieved - totalCost;

			}
			return change;
		}

}