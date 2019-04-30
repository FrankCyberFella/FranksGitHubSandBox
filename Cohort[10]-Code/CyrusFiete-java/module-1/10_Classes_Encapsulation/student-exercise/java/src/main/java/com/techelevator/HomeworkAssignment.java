package com.techelevator;

public class HomeworkAssignment {
	
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	
public HomeworkAssignment(int possibleMarks) {
	
	this.possibleMarks = possibleMarks;
		
}

public String getLetterGrade() {
	
	String letterGrade = "";
	
	if ((((double)totalMarks/(double)possibleMarks))*100>=90) {
		letterGrade = "A";
	}
	else if ((((double)totalMarks/(double)possibleMarks))*100>=80) {
		letterGrade = "B";
	}
	else if ((((double)totalMarks/(double)possibleMarks))*100>=70) {
		letterGrade = "C";
	}
	else if ((((double)totalMarks/(double)possibleMarks))*100>=60) {
		letterGrade = "D";
	}
	else { letterGrade = "F"; }
	return letterGrade;
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
	public int getPossibleMarks() {
		return possibleMarks;
	}
	
}
