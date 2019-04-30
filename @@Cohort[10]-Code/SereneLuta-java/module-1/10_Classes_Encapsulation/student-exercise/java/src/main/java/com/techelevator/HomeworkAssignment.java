package com.techelevator;

public class HomeworkAssignment {
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	

	
	public HomeworkAssignment (int possibleMarks) {
		this.possibleMarks = possibleMarks;
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

	public String getLetterGrade() {
		double percent = ((double)totalMarks / (double)possibleMarks) * 100;
		if (percent >= 90) {
			letterGrade = "A";
			return letterGrade;
		}
		else {
			if (percent >= 80) {
				letterGrade = "B";
				return "B";
			}
			else {
				if (percent >= 70) {
					letterGrade = "C";
					return letterGrade;
				}
				else {
					if (percent >= 60) {
						letterGrade = "D";
						return letterGrade;
					}
					else {
						if(percent < 60) {
							letterGrade = "F";
							return letterGrade;
						}
						return letterGrade;
					}
				}
			}
		}
	}

}
