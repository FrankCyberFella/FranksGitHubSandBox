package com.techelevator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.view.Menu;

public class CashierTest {

	private ByteArrayOutputStream output;
	
	
	
	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}
	
	@Test
	public void TestFeedMoney2() {
		Menu menu = getMenuOption2ForTesting();
		Cashier bob = new Cashier(menu);
		Assert.assertEquals(2.0,bob.feedMoney(),.0001);

	}
	
	@Test
	public void TestFeedMoney1() {
		Menu menu = getMenuForTesting();
		Cashier bob = new Cashier(menu);
		Assert.assertEquals(1.0,bob.feedMoney(),.0001);
		
	}
	
	@Test
	public void TestFeedMoney3() {
		Menu menu = getMenuOption3ForTesting();
		Cashier bob = new Cashier(menu);
		Assert.assertEquals(5.0,bob.feedMoney(),.0001);
		
	}
	
	@Test
	public void TestFeedMoney4() {
		Menu menu = getMenuOption4ForTesting();
		Cashier bob = new Cashier(menu);
		Assert.assertEquals(10.0,bob.feedMoney(),.0001);
		
	}
	@Test(expected = NoSuchElementException.class)
	public void TestFeedMoney5() {
		Menu menu = getMenuOption5ForTesting();
		Cashier bob = new Cashier(menu);
		bob.feedMoney();
		
	}
	@Test
	public void TestChargeMoney() {
		Menu menu = getMenuOption4ForTesting();
		Cashier bob = new Cashier(menu);
		bob.feedMoney();
		Slot slot = new Slot("A1",new Item("Steak Sauce", "Snack", 9.15));
		
		Assert.assertEquals(.85,bob.chargeMoney(slot),.0001);
	}
	
	@Test
	public void TestReturnChange() {
		Menu menu = getMenuOption4ForTesting();
		Cashier bob = new Cashier(menu);
		bob.feedMoney();
		Slot slot = new Slot("A1",new Item("Steak Sauce", "Snack", 9.15));
		bob.chargeMoney(slot);
		
		ByteArrayOutputStream output2 = new ByteArrayOutputStream();
		bob.returnChange(output2);
		
		Assert.assertEquals("Returned: 3 quarters\n"
				+ "Returned: 1 dimes\n"
				+ "Returned: 0 nickels\n", 
				output2.toString());
	
	}
	
	
	
	
	private Menu getMenuForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new Menu(input, output);
	}

	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1\n");
	}	
	private Menu getMenuOption2ForTesting() {
		return getMenuForTestingWithUserInput("2\n");
	}
	private Menu getMenuOption3ForTesting() {
		return getMenuForTestingWithUserInput("3\n");
	}
	private Menu getMenuOption4ForTesting() {
		return getMenuForTestingWithUserInput("4\n");
	}
	private Menu getMenuOption5ForTesting() {
		return getMenuForTestingWithUserInput("5\n");
	}
	
}
