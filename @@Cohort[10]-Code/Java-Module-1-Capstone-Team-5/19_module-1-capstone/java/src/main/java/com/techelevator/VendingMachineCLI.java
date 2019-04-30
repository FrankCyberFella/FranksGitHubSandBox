package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**************************************************************************************************************************
*  This is your Vending Machine class
*  
*  You code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	String lineReport = "";
	private int counter = 0;
	private double balance = 0.0;
	File newFile = new File("log.txt");
	File salesReport = new File ("salesreport.txt");
	
	/**
	 * @return the balance
	 */
	//**********************************
	// Getters and Setters
	//**********************************
	public double getBalance() {
		return balance;
	}
	private void setBalance(double money) {
		this.balance = money;
	}
	
	public void feedMoney() throws IOException {
		System.out.println("Insert dollar amount");
		String[] dollarAmounts = {"1","2","5","10"};
		String choice = "";
		choice = (String)menu.getChoiceFromOptions(dollarAmounts);
		int dollar = Integer.parseInt(choice);
		double holder = getBalance();
		dollar += getBalance();
		setBalance(dollar);
		transactionLog("FEED MONEY:" , holder, getBalance());
	}
	

	public VendingMachineCLI() {
		balance = 0.0;
	}
	
	//****************************
	//Created variables
	//****************************
	private List<Items> options = new ArrayList<Items>();
	//static Items doritos = new Chips("a1", "doritos", 1.50);
	//static Items BillsKettleChips = new Chips("a1", "Bills Kettle BBQ Chips", 1.50);
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_EXIT,
													    };

	
	
	private Menu menu;   // Menu object to be used by an instance of this class
	//private Menu menu2;
	public VendingMachineCLI(Menu menu) {  // Constructor - user will pas a menu for this class to use
		this.menu = menu;                  // Make the Menu the user object passed, our Menu
	}
	
	//*************************************
	// Run method
	//*************************************
	public void run() throws IOException {
		if (newFile.exists()) {
			newFile.delete();
		}
		if (salesReport.exists()) {
			salesReport.delete();
		}
		salesReport.createNewFile();
		VendingMachineCLI vM = new VendingMachineCLI();
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);	
			
			
			//*************************************
			// Display items option
			//*************************************
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				DisplayOptions();

				//*************************************
				// Purchase option
				//*************************************
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				while (choice != "Finish Transaction") {
					System.out.printf("\nCurrent money provided %.2f", getBalance());
					LocalDateTime ldt = LocalDateTime.now();
					//System.out.println(ldt);
					choice = (String)menu.getChoiceFromOptions(purchaseOptions());
					
					if (choice.equals("Feed Money")) {
						feedMoney();
					}			

					if (choice.equals("Select Product")) {
						List<String>choices = new ArrayList<String>();
						choices = fileReader();
						String[] choicess = new String[choices.size()];
						int count = 0;
						for (String option: choices) {
							choicess[count] = option;
							count++;
						}
						counter++;
//					 String[] ITEM_OPTIONS = {doritos.toString(), BillsKettleChips.toString()};
						
						choice = (String)menu.getChoiceFromOptions(choicess);
						purchaseItem(choice);
						}
				}
				finishingTransaction();
				

			}
			//*************************************
			// Exit option
			//*************************************
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {

						lineReport = toSalesReport(options);
						

						String[] lineReportArray = lineReport.split(",");

						int size = options.size();
						
						if (counter == 0) { // Dont have a sales report .txt if nothing was purchased
							counter++;
						}
						
						counter = lineReportArray.length/counter;
						String result = "";
						for (int i = 0; i < counter ; i++) {
							result += lineReportArray[i] ;
						}

						File inputReport = new File("salesreport.txt");
						Scanner reader = new Scanner(inputReport);
						try (PrintWriter writer = new PrintWriter(inputReport) ){
							writer.println(result);
							
						}

					return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}
	//*************************************
	// Methods
	//*************************************
	public void DisplayOptions() throws IOException {
		List<String> result = new ArrayList<String>();
		String line = "";
		File inputFile = new File("OptionList.txt");
		Scanner fileScanner = new Scanner(inputFile);
		while(fileScanner.hasNextLine()) {
			line += fileScanner.nextLine() +"\n";
				}
		line = "\n" + line;

		
		System.out.println(line);
	}
	
	public String[] purchaseOptions() {
		String[] choices = {"Feed Money","Select Product","Finish Transaction"};
		return choices;
	}

	public List<String> fileReader() throws IOException {
		List<String> result = new ArrayList<String>();
		String line = "";
		File inputFile = new File("OptionList.txt");
		Scanner fileScanner = new Scanner(inputFile);
		while(fileScanner.hasNextLine()) {
			line += fileScanner.nextLine();
				}
		line = line.replaceAll("Chip", "Chip|");
		line = line.replaceAll("Candy", "Candy|");
		line = line.replaceAll("Drink", "Drink|");
		line = line.replaceAll("Gum", "Gum|");
		line = line.substring(0,line.length()-1);
      //line = line.replaceAll("\\|", " ");
		result = menuReader(line);
	
		return result;
	}
	public List <String> menuReader(String line) {
		List<String>result = new ArrayList<String>();
		
		String[]splitItems = line.split("\\|");
		 for(int i = 0; i < splitItems.length; i++) {
			 if(i % 4 == 1) {
			result.add(splitItems[i]);
			
			}
			 
			 if (i % 4 == 3) {
				 String name = splitItems[i - 2];
				 double price = Double.parseDouble(splitItems[i-1]);
				 String slotNumber = splitItems[i-3];
				 if(splitItems[i].equals("Chip")) {
				 options.add(new Chips(slotNumber,name,price));
				 }
				 if(splitItems[i].equals("Candy")) {
					 options.add(new Candy(slotNumber,name,price));
				 }
				 if(splitItems[i].equals("Drink")) {
					 options.add(new Drink(slotNumber,name,price));
				 }
				 if(splitItems[i].equals("Gum")) {
					 options.add(new Gum(slotNumber,name,price));
					 
				 }
				 
			 }
			 
		}
		 	return result;
		
	}
	//***************************
	//Purchase item method
	//***************************
	public void purchaseItem(String name) throws IOException {// have to compare purchase price to currentBalance
		int count = 0;
		double holder = getBalance();
		String purchaseName = "";
		String line = "";
		File inputReport = new File("salesreport.txt");
		Scanner reader = new Scanner(inputReport);
		


			
		for(Items item : options) {
	
			if (item.getName().equals(name) && count == 0){
				if(getBalance() >= item.getPrice() && item.getInventory() >= 1) {	
					setBalance(getBalance() - item.getPrice() );
					count++;
					item.setInventory();
					item.setNumberBought();
					purchaseName = item.getName() + " " + item.getSlotNumber();
					transactionLog(purchaseName, holder, getBalance());

					//System.out.println("You current inventory is: " + item.getInventory());
				}
				else {
					if(getBalance() < item.getPrice()){
						System.out.println("Insufficient Funds");
						count++;
					}
					else {
						System.out.println("Out of stock");
						count++;
					}
				}

			
			}

			//System.out.println(getBalance());
		}

	}
	public String toSalesReport(List<Items> item ) throws IOException {
	
		if (!salesReport.exists()) {
			salesReport.createNewFile();
		}
		//System.out.println("Hello brudda");
		for (Items items : item) {
			lineReport += items.getName() + "|" + (5-items.getInventory()) + ",\n";

		}
		//lineReport += item.getName() + "|" + (5-item.getInventory()) + "\n";

		File inputReport = new File("salesreport.txt");
		Scanner reader = new Scanner(inputReport);
		int count = 0;
		
		return lineReport;
//		line += reader.nextLine();
//		try(PrintWriter writer = new PrintWriter(inputReport)) {
//			writer.println(line);
//			writer.println(item.getName() + "|" + (5-item.getInventory()));
//		}
//		if (!reader.hasNextLine()) {
//			try (PrintWriter writer = new PrintWriter(inputReport) ){
//				//System.out.println(item.getName() + "|" + (5-item.getInventory()));
//				writer.println(item.getName() + "|" + (5-item.getInventory()));
//			}
//			
//		}
//		while(reader.hasNextLine()&& counter == 0) {
//			line += reader.nextLine();
//			line = line.replaceAll(",", "\n");
//			System.out.println(line);
//		
//		}
//		try (PrintWriter writer = new PrintWriter(inputReport) ){
//			writer.println( item.getName() + "|" + (5-item.getInventory()) + ",");
//			count++;
//		}
		
		//while(reader.hasNextLine()) {
//			line += reader.nextLine() + ",";
//			line = line.replaceAll(",","\n");
//
//			}
//
//		while(reader.hasNextLine()) {
//			line += reader.nextLine() + ",";
//			line = line.replaceAll(",","\n");
//
//			}
//		try (PrintWriter writer = new PrintWriter(salesReport)){
//			writer.println(line + "|" + (5 - item.getInventory()));
//		}
//		if (reader.hasNext()) {
//			line += reader.nextLine() + item.getName() + " " + (5-item.getInventory());
//			try (PrintWriter writer = new PrintWriter(inputReport)) {
//				writer.println(line);
//				writer.println(item.getName() + " " + (5-item.getInventory()));
//			}
//			
//		} else {
//			try (PrintWriter writer = new PrintWriter(inputReport)) {
//			writer.println(item.getName() + " " + (5-item.getInventory()));
//		}
//		}
		
//		while (reader.hasNextLine()) {
//			line += reader.nextLine() + "|";
//			System.out.println(line);
//			if (!reader.hasNextLine()) {
//					line +=   item.getName() + " " + (5-item.getInventory());
//				
//			}
//
//		}

//		line = line.replace("|", "\n");
//		System.out.println("****************" + line);
//		try (PrintWriter writer = new PrintWriter(inputReport)) {
//			writer.println(line);
		//}

		
	}
	
	public String finishingTransaction() throws IOException{
		System.out.println("You are finishing your purchasing order");
		double test1;
		int[] amountOfChange1 = {0,0,0};
		double testOneBal = 10.15; //to test that we give back correct change
	double holder = getBalance();
	double changeReturned = getBalance();
	double quarter = 0.25;
	double nickle = 0.05;
	double dime = 0.10;
	int[] amountOfChange = {0,0,0}; //array first containing number of quarters, then dimes, then nickels
	
	while (changeReturned >= quarter) { // increase quarter by one every time a quarter is subtracted
		changeReturned -= quarter;
		 amountOfChange[0]++;
	}
	while (changeReturned >= dime) { // increase dime by one every time a dime is subtracted
		changeReturned -= dime;
		amountOfChange[1]++;
	}
	
	while (changeReturned >= nickle) { // increase nickel by one every time it is subtracted by one
		changeReturned -= nickle;
		amountOfChange[2]++;
	}
	setBalance(0);
	
	while (testOneBal >= quarter) { // Only for testing purposes
		testOneBal -= quarter;
		 amountOfChange1[0]++;
	}
	while (testOneBal >= dime) { // Only for testing Purposes
		testOneBal -= dime;
		amountOfChange1[1]++;
	}
	
	while (testOneBal >= nickle) { // only for testing purposes
		testOneBal -= nickle;
		amountOfChange1[2]++;
	}
	
	
	System.out.println("\nChange returned:"); 
	System.out.println("quarters: " + amountOfChange[0]);
	System.out.println("   dimes: " + amountOfChange[1]);
	System.out.println(" nickels: " + amountOfChange[2]);
	System.out.println("\n");
	for(Items item: options) {
		//System.out.println(item.getNumberBought());
		for(int i = 0; i<item.getNumberBought(); i ++) {
			item.Consumed();
		}
		item.resetNumberBought();
	}

	transactionLog("GIVE CHANGE: ", holder, getBalance());
	String tester1 = "";
	for (int num: amountOfChange1) {
		tester1 += num;
	}
	return tester1;
	//transactionLog("hi");
	//transactionLog("hello");
	//transactionLog("sup");

	
	
	}
	public void transactionLog(String name, double beforePurchase, double afterPurchase) throws IOException {
		
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		
		//System.out.println(timeStamp);
		
		if (!newFile.exists()) {
			newFile.createNewFile();
		}
		String reader = "";
		File inputFile = new File("Log.txt");
		Scanner fileScanner = new Scanner(inputFile);
		while(fileScanner.hasNextLine()) {
			reader += fileScanner.nextLine() + ",";
			reader = reader.replaceAll(",","\n");

			}
		try (PrintWriter writer = new PrintWriter(newFile)){
			//fileScanner.nextLine();
			//writer.println(reader + "\n" + timeStamp + " PM " + name + " $" + beforePurchase + " $" + afterPurchase );
			writer.printf("%S\n%S %18S $%.2f $%.2f",reader, timeStamp, name, beforePurchase, afterPurchase);
		}

		
		

	}
/*************************************************************************************************************************
*  This is the application program to instantiate a Vending Machine as start it running
*  
*  DO NOT PUT ANY NEW CODE HERE!
 * @throws IOException 
***************************************************************************************************************************/
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out); 
		// Instantiate a menu for Vending Machine to use
		VendingMachineCLI cli = new VendingMachineCLI(menu); // Instantiate a Vending Machine passing it the Menu object to use
		cli.run();                                            // Tell the Vending Machine to start running
	}
}

