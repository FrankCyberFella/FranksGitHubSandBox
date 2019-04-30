package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {
	
	
	@Test
	public void Test_Empty_String_Sum() {
		assertEquals("The blank string added to nothing should have been nothing",0,new KataStringCalculator().add(""));
	}
	
	@Test
	public void Test_Single_String_Sum() {
		assertEquals("The single string added to nothing should have been itself", 1, new KataStringCalculator().add("1"));
	}
	
	@Test
	public void Two_Value_Sum() {
		assertEquals("The string did not return the sum of two values: ", 5, new KataStringCalculator().add("2,3"));
	}
	
	@Test
	public void Test_Many_Value_Sum() {
		assertEquals("The string did not return the sum of all the values", 12, new KataStringCalculator().add("1,6,5"));
	}
	
	@Test
	public void Test_Sum_Of_New_Lines() {
		assertEquals("The string did not return the sum of all the values", 20, new KataStringCalculator().add("4,5\n8,3"));
	}
	
	@Test
	public void Test_Other_Delimiters() {
		assertEquals("The delimiter did not work",8,new KataStringCalculator().add("//;\n5;3"));
		assertEquals("The two character delimiter did not work",11,new KataStringCalculator().add("//;p\n5;p3;p3"));
		assertEquals("The escaped regex did not work",11,new KataStringCalculator().add("//*\n5*3*3"));
		assertEquals("The escaped regex did not work",11,new KataStringCalculator().add("//;\n;4;4;3;"));
	}
}
