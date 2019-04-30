package com.techelevator;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.techelevator.park.JDBCParkDAO;
import com.techelevator.park.Park;
import com.techelevator.park.ParkDAO;

public class MainParksMenu {
	
	private ParkDAO parkDAO;
	
	private Scanner in = new Scanner(System.in);

	
	public MainParksMenu(InputStream input, OutputStream output, DataSource datasource) {
		this.in = new Scanner(input);
		parkDAO = new JDBCParkDAO(datasource);
	}
	
    
	
	
	


	
	private  void displayParkMenuOptions() {
		System.out.println();
		for(int i = 0; i < parkDAO.getParks().size(); i++) {
			int optionNum = i+1;
			System.out.println(optionNum+") "+ parkDAO.getParks().get(i).getName());
			
		}
		System.out.println((parkDAO.getParks().size() + 1) + ") Exit");
		System.out.print("\nPlease choose an option >>> ");
		System.out.flush();
	}
	
	private  Park getChoiceFromUserInput(List<Park> parkList) {
		Park choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			
			if((selectedOption < parkList.size() + 1) && selectedOption > 0) {
				choice = parkList.get(selectedOption - 1);
				return choice;
			}
		
			if(selectedOption == parkList.size() + 1) {
				
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("Your robot overlords thank you for visiting the National Park Info Center");
					System.out.println("-----------------------------------------------------------------------------------");
					System.exit(0);
				
			}
			else System.out.println("\n*** "+userInput+" is not a valid option ***\n");
			
		}
		 
		 catch(NumberFormatException e) {
			 System.out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		
		
		return choice;
	}

	
	public  Park getParkFromOptions(List<Park> parkList) {
		Park choice = null;
		while(choice == null) {
			displayParkMenuOptions();
			choice = getChoiceFromUserInput(parkList);
		}
		return choice;
	}
	
	
}
