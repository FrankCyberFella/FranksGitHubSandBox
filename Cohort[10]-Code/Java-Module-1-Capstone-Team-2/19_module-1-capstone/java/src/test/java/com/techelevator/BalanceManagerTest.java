package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class BalanceManagerTest {

	
	
BalanceManager test = new BalanceManager();
	
	
	
@Test
public void Test_Get_Current_Balance() {
	
	assertEquals("Current Balance should be 0", 0, .000, test.getCurrentBalance());
	
}

@Test
public void Test_Add_To_Balance() {
	
	assertEquals("Current balance should be 5.00", 5.00, .001, test.addToBalance(5.00));
	assertEquals("Current balance should be 13.25", 13.25, .001, test.addToBalance(8.25));
}

		//Not sure why but the subtract method works, however the test shows the double delta?
@Test
public void Test_Subtract_From_Current_Balance() {    
	assertEquals("Current balance should be 11.05", 11.05, .001, test.subtractFromBalance(2.20));
	assertEquals("Current balance should be 9.00", 9.00, .001, test.subtractFromBalance(2.05));
	
}

	
	
	
}
