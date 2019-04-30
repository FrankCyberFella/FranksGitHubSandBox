package com.techelevator;

public class HomeworkAssignment {

	private int totalMarks;

	private int possibleMarks;

	private String submitterName;

	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;

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
	public String getLetterGrade() {

		int numGrade = (int) (((double) totalMarks / (double) possibleMarks) * 100);

		if (numGrade >= 90) {
			return "A";
		} else 
			if (numGrade >= 80 && numGrade < 90) {
				return "B"; 
			} 
			else 
				if (numGrade >= 70 && numGrade < 80) {
					return "C";
				} else 
					if (numGrade >= 60 && numGrade < 70) {
						return "D";
					} else {
						return "F";
					}

	}


}

