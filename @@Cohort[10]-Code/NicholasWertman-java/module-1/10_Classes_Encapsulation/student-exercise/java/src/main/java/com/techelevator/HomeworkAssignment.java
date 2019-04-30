package com.techelevator;

public class HomeworkAssignment {

	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;

	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
		this.totalMarks = totalMarks;
		this.submitterName = submitterName;
		this.letterGrade = letterGrade;
				
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
	//public String getLetterGrade() {
	//	return letterGrade;
	//}

	public String getLetterGrade() {
		
		double percentage =  (possibleMarks/ totalMarks)* 100;
		
		if ((percentage >= 90)) {
			return "A";
		} else 
			if (( percentage >= 80 && ( percentage < 90))) {
			 return "B";
		} else 
			if ((percentage >= 70 && (percentage < 80))) {
			return "C";
		} else
			if ((percentage >= 60 && (percentage < 70))) {
			return "D";
		} else {
			return "F";
		}
	}
}
