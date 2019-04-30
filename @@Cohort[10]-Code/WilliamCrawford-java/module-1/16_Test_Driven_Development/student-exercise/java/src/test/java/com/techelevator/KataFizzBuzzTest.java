package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	KataFizzBuzz test = new KataFizzBuzz();
@Test
public void Method_Returns_Int_As_String() {
	
	assertEquals("Int did not properly convert to String", "1", test.fizzBuzz(1));
}
@Test
public void Number_Range_One_To_A_Hundred() {
	assertEquals("Int is not within the range 1 to 100", "", test.fizzBuzz(0));
	assertEquals("Int is not within the range 1 to 100", "", test.fizzBuzz(101));
}
@Test
public void Number_Is_Multiple_Of_Three() {
	assertEquals("Int is not a multiple of 3", "Fizz", test.fizzBuzz(3));

}
@Test
public void Number_Is_Multiple_Of_Five() {
	assertEquals("Integer is not a multiple of 5", "Buzz", test.fizzBuzz(5));
	
}

}
}
