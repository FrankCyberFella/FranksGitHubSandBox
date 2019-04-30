package com.techelevator;

public class HomeworkAssignment {
	 
	
	private int totalMarks; //set to private for each
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	private double percent;
	
	
	public HomeworkAssignment (int possibleMarks) {		
		this.possibleMarks = possibleMarks;
//makes this variable equal to the declared variable on line 7
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getSubmitterName() {
		return submitterName;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public int getPossibleMarks() {
		return possibleMarks;
	}

	public String getLetterGrade() {
	double percent = ((double) totalMarks / (double) possibleMarks) * 100;
	
	
	if (percent >= 90) { 
		letterGrade = "A";
	}
		else {
			if ((percent < 90) && (percent >= 80)) {
				letterGrade = "B";
			}
			else {
				if ((percent < 80) && (percent >= 70)) {
					letterGrade = "C";
		
				}
				else {
					if ((percent < 70) && (percent >= 60)) {
						letterGrade = "D";
					}
					else {
						letterGrade = "F";
					}
				}	
			}
		}
				
	
		return letterGrade;
	
	}
}
	
	
