package com.techelevator;

public class HomeworkAssignment {

	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	
	//create an object
	//runs the constructer
	
	public HomeworkAssignment(int possibleMarks){
	this.possibleMarks = possibleMarks;
	}
	
	public int getTotalMarks() {
		return totalMarks;
	}
	
	
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
		
		if((double)totalMarks / (double)(possibleMarks) >= 0.90) {
			letterGrade = "A";
		}
		else if((double)totalMarks / (double)(this.possibleMarks) >= 0.80) {
			letterGrade = "B";
		}
		else if((double)totalMarks / (double)(this.possibleMarks) >= 0.70) {
			letterGrade = "C";
		}
		else if((double)totalMarks / (double)(this.possibleMarks) >= 0.60) {
			letterGrade = "D";
		}
		else letterGrade = "F";
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
}
