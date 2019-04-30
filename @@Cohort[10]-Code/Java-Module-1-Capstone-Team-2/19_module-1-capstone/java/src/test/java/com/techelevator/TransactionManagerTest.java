package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TransactionManagerTest {
	
	
	

@Test
public void Test_Get_Quantity_Sold() throws FileNotFoundException {
	TransactionManager test = new TransactionManager();
	test.addToSalesReport("Taco", 37.0);
	test.addToSalesReport("Fish",2.0);
	test.addToSalesReport("Chaps", 0.0);
	
	assertEquals("Value returned should be double 37", 37,.001, test.getQuantitySold("Taco")) ;
	assertEquals("Value returned should be double 2", 2,.001, test.getQuantitySold("Fish")) ;
	assertEquals("Value returned should be double 0", 0,.000, test.getQuantitySold("Chaps")) ;
}
@Test
public void Test_Contains_Sales_Report_Key() throws FileNotFoundException {
	TransactionManager test = new TransactionManager();
	test.addToSalesReport("Norway", 2.0);
	test.addToSalesReport("Germany",12.0);
	test.addToSalesReport("Japan", 44.0);
	
	assertEquals("The value should be true",true, test.containsSalesReportKey("Germany"));
	assertEquals("The value should be false", false, test.containsSalesReportKey("France"));
}
	

}
