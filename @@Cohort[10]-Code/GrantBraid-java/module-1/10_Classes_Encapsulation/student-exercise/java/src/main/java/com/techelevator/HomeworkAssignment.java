package com.techelevator;

public class HomeworkAssignment {

	
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	/**
	 * @return the totalMarks
	 */
	public int getTotalMarks() {
		return totalMarks;
	}
	/**
	 * @param totalMarks the totalMarks to set
	 */
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
		if (totalMarks / (double)possibleMarks >= .90) {
			letterGrade = "A";
			
		} else if (totalMarks / (double)possibleMarks >= .80){
			letterGrade = "B";
			
		} else if (totalMarks / (double)possibleMarks >= .70) {
			letterGrade = "C";
		} else if (totalMarks / (double)possibleMarks >= 0.6) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
	}
	/**
	 * @return the submitterName
	 */
	public String getSubmitterName() {
		return submitterName;
	}
	/**
	 * @param submitterName the submitterName to set
	 */
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	/**
	 * @return the possibleMarks
	 */
	public int getPossibleMarks() {
		return possibleMarks;
	}
	/**
	 * @return the letterGrade
	 */
	public String getLetterGrade() {
		return letterGrade;
	}
	
	
	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
		


	}
}
