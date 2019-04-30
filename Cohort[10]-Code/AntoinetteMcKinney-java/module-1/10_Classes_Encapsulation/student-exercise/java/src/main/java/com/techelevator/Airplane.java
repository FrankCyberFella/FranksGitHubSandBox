package com.techelevator;

public class Airplane {

	//Assignment corrected in class
	//VARIABLES OR DATA MEMBERS
		private String planeNumber; //These are what the object knows
		private int totalFirstClassSeats;
		private  int bookedFirstClassSeats = 0;
		private int totalCoachSeats;
		private int bookedCoachSeats = 0;
	
		
		

		
		
		//CONSTRUCTORS // method to create an instance of a class.
		public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
			this.planeNumber = planeNumber;
			this.totalFirstClassSeats = totalFirstClassSeats;
			this.totalCoachSeats = totalCoachSeats;
		}
		
		
		/*GETTERS & SETTERS 
		*Getters & Setters are public.
		*They allow the values for the private 
		*variabless to be set to a given value and retrive that value when used
		*/
		
	
		
		 public String getPlaneNumber() {
			return planeNumber;
		}


		public int getBookedFirstClassSeats() {
			return bookedFirstClassSeats;
		}


		public int getAvailableFirstClassSeats() {
			return totalFirstClassSeats - bookedFirstClassSeats;
		}

		public int getAvailableCoachSeats() {
			return totalCoachSeats - bookedCoachSeats;
		}
		
		public int getTotalFirstClassSeats() {
			return totalFirstClassSeats;
		}


		public int getBookedCoachSeats() {
			return bookedCoachSeats;
		}


		public int getTotalCoachSeats() {
			return totalCoachSeats;
		}

		
		public boolean reserveSeats(boolean firstClass, int totalNumberOfSeats) {
			if (firstClass) {
				if (totalNumberOfSeats> getAvailableFirstClassSeats()) {
					return false;
				}
			
				bookedFirstClassSeats += totalNumberOfSeats;
			}
			else {
				if(totalNumberOfSeats > getAvailableCoachSeats()) {
				return false;	
	
			}
			bookedCoachSeats += totalNumberOfSeats;
			}
		return true;
	}
	
}

	
		 
		 
		

