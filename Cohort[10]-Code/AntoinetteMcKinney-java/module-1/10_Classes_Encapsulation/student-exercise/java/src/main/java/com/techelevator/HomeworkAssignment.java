package com.techelevator;

public class HomeworkAssignment {// class

	//VARIABLES OR DATA MEMBERS
		private int totalMarks; // These are what the object knows
		private int possibleMarks;
		private String submitterName;
		private String letterGrade;

		
		public HomeworkAssignment(int possibleMarks) { // CONSTRUCTORS // method to create an instance of a class
			this.possibleMarks = possibleMarks;
		}
	
		 
		/*
		 * GETTERS & SETTERS Getters & Setters are public. They allow the values for the
		 * private variabless to be set to a given value and retrive that value when
		 * used
		 */

		public int getTotalMarks() {// The Getter for name variable
			return totalMarks;
		}

		public void setTotalMarks(int totalMarks) {// recieve
			this.totalMarks = totalMarks; // .this is referencing the name varialbe in the class.
		}

		public int getPossibleMarks() {// The Getter for name variable
			return possibleMarks;
		}

		
		public String getSubmitterName() {// The Getter for name variable
			return submitterName;
		}

		public void setSubmitterName(String submitterName) {// recieve
			this.submitterName = submitterName; // .this is referencing the name varialbe in the class.
		}

		public String getLetterGrade() {// The Getter for name variable
			
			if (totalMarks >= 90) {
				letterGrade = "A";
			
			}else if((totalMarks >= 80) && (totalMarks <= 89)) {
				letterGrade = "B";
				
			}else if(totalMarks >= 70 && totalMarks <= 79) {
				letterGrade = "C";
				
			}else if(totalMarks >= 60 && totalMarks <= 69) {
				letterGrade = "D";
				
			}else {
				letterGrade = "F";
			}
			return letterGrade;
		}
		

}
