package com.techelevator;

public class HomeworkAssignment {
	
private int totalMarks;
private int possibleMarks;
private String submitterName;
private String letterGrade;

public HomeworkAssignment(int possibleMarks) {
	this.possibleMarks = possibleMarks;	
}

public String getLetterGrade() {
    double grade = (double)totalMarks / (double)possibleMarks * 100;
    
    if (grade >= 90 ) {
        letterGrade = "A";
    }
    
    if (grade >= 80 && grade <= 89) {
        letterGrade = "B";
    }
    
    if (grade >= 70 && grade <= 79) {
        letterGrade =  "C";
    }
    
    if (grade >= 60 && grade <= 69) {
        letterGrade = "D";
    }
    
    if (grade <= 59) {
        letterGrade = "F";
    }
    
    return letterGrade;
    
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


}
