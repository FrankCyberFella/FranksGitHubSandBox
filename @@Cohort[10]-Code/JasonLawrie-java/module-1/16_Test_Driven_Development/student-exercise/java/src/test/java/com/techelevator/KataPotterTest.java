package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataPotterTest {

	@Test
	public void Test_Any_One_Book() {
		assertEquals("One book is 8",8.0,new KataPotter().getCost(new int[]{1,0,0,0,0}),.001);
	}
	
	@Test
	public void Test_Two_Different_Books() {
		assertEquals("Two books is 5% off 16",16*.95,new KataPotter().getCost(new int[]{1,1,0,0,0}),.001);
	}
	
	@Test
	public void Test_Any_Single_Combo(){
		assertEquals("Three books is 10% off 24",24*.9,new KataPotter().getCost(new int[]{1,1,1,0,0}),.001);
		assertEquals("Four books is 20% off 32",32*.8,new KataPotter().getCost(new int[]{1,1,1,1,0}),.001);
		assertEquals("Five books is 25% off 40",40*.75,new KataPotter().getCost(new int[]{1,1,1,1,1}),.001);
	}
	
	@Test
	public void Test_Multiple_Combos() {
		assertEquals("These eight books are 51.2",51.2,new KataPotter().getCost(new int[]{2,2,2,1,1}),.001);
		assertEquals("These sixteen books are 102.4",102.4,new KataPotter().getCost(new int[]{4,4,4,2,2}),.001);
	}
}
