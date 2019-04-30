package com.techelevator;

public class Airplane {
	//Class Data Members----------------------------
	//Class Data Members----------------------------
		private String planeNumber;
		private int bookedFirstClassSeats;
		private int availableFirstClassSeats;
		private int totalFirstClassSeats;
		private int bookedCoachSeats;
		private int availableCoachSeats;
		private int totalCoachSeats;
		//CTOR ------------------------------------
		 public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
			 this.planeNumber = planeNumber;
			 this.totalFirstClassSeats = totalFirstClassSeats;
			 this.totalCoachSeats = totalCoachSeats;
		 
		 }
		public String getPlaneNumber() {
			return planeNumber;
		}
		public int getBookedFirstClassSeats() {
			return bookedFirstClassSeats;
		}
		public int getAvailableFirstClassSeats() {
			return totalFirstClassSeats - availableFirstClassSeats;
		}
		public int getTotalFirstClassSeats() {
			return totalFirstClassSeats;
		}
		public int getBookedCoachSeats() {
			return bookedCoachSeats;
		}
		public int getAvailableCoachSeats() {
			return totalCoachSeats - bookedCoachSeats;
		}
		public int getTotalCoachSeats() {
			return totalCoachSeats;
		}
		//Getters and Setters ----------------------------
		 
		//Return ---------------------------------------
		public boolean reserveSeats(boolean firstClass, int totalNumberOfSeats) {
			if (firstClass) {
				if (totalNumberOfSeats > getAvailableFirstClassSeats()) {
					return false;
				}
				bookedFirstClassSeats += totalNumberOfSeats;
			}
			else {
				if (totalNumberOfSeats > getAvailableCoachSeats()) {
					return false;
				}
				bookedCoachSeats += totalNumberOfSeats;
			}
			return true;
		}
	} 

		

