package com.techelevator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.campground.Campground;
import com.techelevator.campground.JDBCCampgroundDAO;
import com.techelevator.park.*;
import com.techelevator.view.Menu;

// created class TravelAgent
public class TravelAgent {

	
	public void parkNameMenu(Menu menu, JDBCParkDAO parkDAO, JDBCCampgroundDAO campgroundDAO, String need) {
		List<Park> parks = parkDAO.selectAllParks();
		List<String> parkNameMenuOptions = parkDAO.getParkNames(parks);
		parkNameMenuOptions.add("Quit");
		String choice = menu.getChoiceFromOptions(parkNameMenuOptions.toArray()).toString();
		for(Park thePark:parks) {
			if(choice.equalsIgnoreCase(thePark.getName())) {
				if(need.equals("details")) {
					parkDetails(thePark);
				} else if(need.equals("campgrounds")) {
					campgroundFromParkMenu(menu, campgroundDAO, thePark);
				}
				
			}
		}
		
	}
	public void campgroundFromParkMenu(Menu menu, JDBCCampgroundDAO campgroundDAO, Park thePark){
		final String menuOption = "Search for Available Reservation";
		
		List<Campground> campgrounds = campgroundDAO.selectCampgroundByParkId(thePark.getParkId());
		campgroundDAO.getCampgroundNames(campgrounds, thePark);
		String[] resMenu = {menuOption,"Return to Previous Screen"};
		String choice = menu.getChoiceFromOptions(resMenu).toString();
		if(choice.equals(menuOption)) {
			searchForReservation(campgroundDAO, campgrounds, thePark);
		}
		
	}
	
	public void parkDetails(Park thePark) {
		System.out.println(thePark);
	}
	
	public void searchForReservation(JDBCCampgroundDAO campgroundDAO, List<Campground> campgrounds, Park thePark) {
		Scanner keyBoard = new Scanner(System.in);
		Date now = new Date();
		campgroundDAO.getCampgroundNames(campgrounds, thePark);
		Campground theCampground;
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;

		String campNumber="";
		String startDateInput="";
		LocalDate startDate;
		LocalDate today = LocalDate.now();
		
		boolean keepAsking = true;
		while(keepAsking) {
			System.out.print("\n Which campground (enter 0 to cancel)? ");
			try {
				campNumber = keyBoard.nextLine();
				if(campNumber.equals("0")) {
					keepAsking=false;
				} else {
					for(Campground camp:campgrounds) {
						if(camp.getCampgroundId()==Integer.parseInt(campNumber)) {
							theCampground=camp;
							keepAsking=false;
							System.out.println("You entered "+theCampground.getName()+" National Park");
						}
					}
					if(keepAsking) {
						System.out.println("Sorry, "+campNumber+" is not a valid option.");
					}
				}
			}catch(Exception e) {
				System.out.println("Sorry, "+campNumber+" is not a valid option.");
			}
		}
		keepAsking=true;
		while(keepAsking) {
			
			System.out.print("\n What is the arrival date? (YYYY-MM-DD)");
			try {
				startDateInput = keyBoard.nextLine();
				startDate = LocalDate.parse(startDateInput,dateFormat);
				
				if(startDate.toEpochDay()>today.toEpochDay()) {
					if(startDate.toEpochDay()<today.plusYears(1).toEpochDay()) {
						System.out.println("Start Date: "+startDate);
						keepAsking=false;
					} else {
						System.out.println("You cannot make a reservation more than 1 year out!");
					}
				} else {
					System.out.println("You cannot make a reservation that has already started!");
				}
				
			}catch(Exception e) {
				System.out.println("Sorry, "+startDateInput+" is not a valid option.");
			}
		}	
		keepAsking=true;
		while(keepAsking) {
			System.out.print("\n What is the departure date? (MM/DD/YYYY)");
			keepAsking=false;
		}
			
			
			
		
	}
}
