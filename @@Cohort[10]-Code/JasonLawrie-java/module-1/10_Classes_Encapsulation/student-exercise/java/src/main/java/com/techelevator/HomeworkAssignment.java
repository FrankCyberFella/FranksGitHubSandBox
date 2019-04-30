package com.techelevator;

public class HomeworkAssignment {

	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks=possibleMarks;
	}

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
		double percent = (double)totalMarks/possibleMarks;
		if(percent>=0.9) {
			letterGrade="A";
		} else if(percent>=0.8) {
			letterGrade="B";
		} else if(percent>=0.7) {
			letterGrade="C";
		} else if(percent>=0.6) {
			letterGrade="D";
		} else {
			letterGrade="F";
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
	
}
