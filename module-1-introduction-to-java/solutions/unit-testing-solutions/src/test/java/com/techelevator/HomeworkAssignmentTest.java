package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class HomeworkAssignmentTest {
	
	/*
	 * HomeworkAssignment doesn't address what to do if TotalMarks is greater than PossibleMarks or 
	 * less than 0 in the original m1-java-oop-with-encapsulation-solutions, so unsure of what to 
	 * do about it here in here m1-java-unit-testing-solutions
	 */
	
	@Test
	public void homeworkAssignmentInitializedCorrectly() {
		HomeworkAssignment ha = new HomeworkAssignment(100);
		Assert.assertEquals(100, ha.getPossibleMarks());
	}
	
	@Test
	public void setGetTotalMarks() {
		HomeworkAssignment ha = new HomeworkAssignment(100);
		ha.setTotalMarks(80);
		Assert.assertEquals(80, ha.getTotalMarks());
	}
	
	@Test
	public void setGetSubmitterName() {
		HomeworkAssignment ha = new HomeworkAssignment(100);
		ha.setSubmitterName("Jane Doe");
		Assert.assertEquals("Jane Doe", ha.getSubmitterName());
	}

	@Test
	public void calculatesLetterGradesCorrectly() {
		HomeworkAssignment ha = new HomeworkAssignment(100);
		ha.setTotalMarks(99);
		Assert.assertEquals("A", ha.getLetterGrade());
		ha.setTotalMarks(90);
		Assert.assertEquals("A", ha.getLetterGrade());
		ha.setTotalMarks(89);
		Assert.assertEquals("B", ha.getLetterGrade());
		ha.setTotalMarks(80);
		Assert.assertEquals("B", ha.getLetterGrade());
		ha.setTotalMarks(79);
		Assert.assertEquals("C", ha.getLetterGrade());
		ha.setTotalMarks(70);
		Assert.assertEquals("C", ha.getLetterGrade());
		ha.setTotalMarks(69);
		Assert.assertEquals("D", ha.getLetterGrade());
		ha.setTotalMarks(60);
		Assert.assertEquals("D", ha.getLetterGrade());
		ha.setTotalMarks(59);
		Assert.assertEquals("F", ha.getLetterGrade());
		ha.setTotalMarks(0);
		Assert.assertEquals("F", ha.getLetterGrade());
	}
}
