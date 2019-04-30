package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.Campground.CampgroundDAO;
import com.techelevator.Campground.JDBCCampgroundDAO;
import com.techelevator.Park.JDBCParkDAO;
import com.techelevator.Park.Park;
import com.techelevator.Park.ParkDAO;
import com.techelevator.Reservation.JDBCReservationDAO;
import com.techelevator.Reservation.ReservationDAO;
import com.techelevator.Site.JDBCSiteDAO;
import com.techelevator.Site.SiteDAO;


public class CampgroundCLI {
	
	
	
	
	private Menu menu;
	private ParkDAO parkDAO;
	private SiteDAO siteDAO;
	private ReservationDAO reservationDAO;
	private CampgroundDAO campgroundDAO;

	
	
	private static final String MAIN_MENU_OPTION_PARKS = "Parks";
	private static final String MAIN_MENU_OPTION_CAMPGROUNDS = "Campgrounds";
	private static final String MAIN_MENU_OPTION_RESERVATIONS = "Campground Reservations";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	
	private static final String[] MAIN_MENU_OPTIONS = new String[] {MAIN_MENU_OPTION_PARKS,
																	MAIN_MENU_OPTION_CAMPGROUNDS,
																	MAIN_MENU_OPTION_RESERVATIONS,
																	MAIN_MENU_OPTION_EXIT
	};
	private int parkChoiceIndex = -1;
	private int parkChoiceId = -1;
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	
	

	
	private void run() {
		
		printHeading("\n" + "   ___  ___  ___  ___ ____    ___  ____    ___   __ __ __  __ ____  \n"
				+ "  //   // \\\\ ||\\\\//|| || \\\\  // \\\\ || \\\\  // \\\\  || || ||\\ || || \\\\ \n"
				+ " ((    ||=|| || \\/ || ||_// (( ___ ||_// ((   )) || || ||\\\\|| ||  ))\n"
				+ "  \\\\__ || || ||    || ||     \\\\_|| || \\\\  \\\\_//  \\\\_// || \\|| ||_// \n"
				+ "                                                                    \n"
				+ "   ___ __    __                                                     \n"
				+ "  //   ||    ||                                                     \n"
				+ " ((    ||    ||                                                     \n"
				+ "  \\\\__ ||__| ||                                                     \n"
				+ "                                                                    \n" + "");
		
		while(true) {
			printHeading("Main Menu");
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_PARKS)) {
				handleParks();
			} else if(choice.equals(MAIN_MENU_OPTION_CAMPGROUNDS)) {
				parkChoiceId = -1;
				handleCampgrounds();
			} else if(choice.equals(MAIN_MENU_OPTION_RESERVATIONS)) {
				handleAvailableSites();
			 } else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			}
		}
	}
 
   public void handleParks() {
	   String choice = (String) menu.getChoiceFromOptions(parkDAO.getAllParkNames().toArray());
	   		for(int i = 0; i < parkDAO.getAllParkNames().size(); i++) {
			if(choice.equals(parkDAO.getAllParkNames().get(i))) {
			parkChoiceIndex = i;
			parkChoiceId = parkDAO.getAllParks().get(i).getParkId();
			parkDAO.showParkDescription(parkDAO.getAllParkNames().get(parkChoiceIndex));
			choice = (String) menu.getChoiceFromOptions(parkOptions());
			if(choice.equals("View Campgrounds")){
				handleCampgrounds();
			} else{
				if(choice.equals("Search for Available Reservation")) {
					handleAvailableSites();
					return;
				} else {
					if(choice.equals("Return to Previous Screen")) {
						handleParks();
					} 
				}
			}
		}
	}
}
   
   
   public void handleCampgrounds() {
	   if(parkChoiceId == -1) {
		System.out.println("Please choose a park: ");
		 String choice = (String) menu.getChoiceFromOptions(parkDAO.getAllParkNames().toArray());
			for (int i = 0; i < parkDAO.getAllParkNames().size(); i++) {
				if (choice.equals(parkDAO.getAllParkNames().get(i))) {
					parkChoiceIndex = i;
					parkChoiceId = parkDAO.getAllParks().get(i).getParkId();
					campgroundDAO.showCampground(parkChoiceId);
					choice = (String) menu.getChoiceFromOptions(campgroundOptions());
					} if(choice.equals("Search for Available Reservation")) {
						 handleAvailableSites();
						 return;
					} 
			 	}
	   } else {
		   campgroundDAO.showCampground(parkChoiceId);
		   String choice = (String) menu.getChoiceFromOptions(campgroundOptions());
		   if(choice.equals("Search for Available Reservation")) {
			   handleAvailableSites();
			   return;
		   }
	   }
}
   
   public void handleAvailableSites() {
	   if(parkChoiceId == -1) {
		   System.out.println("Please choose a park: ");
		   String choice = (String) menu.getChoiceFromOptions(parkDAO.getAllParkNames().toArray());
		   for (int i = 0; i < parkDAO.getAllParkNames().size(); i++) {
			   if (choice.equals(parkDAO.getAllParkNames().get(i))) {
				   parkChoiceIndex = i;
				   parkChoiceId = parkDAO.getAllParks().get(i).getParkId();
				   parkDAO.showParkDescription(parkDAO.getAllParkNames().get(parkChoiceIndex));
				   campgroundDAO.showCampground(parkChoiceId);
				   choice = (String) menu.getChoiceFromOptions(campgroundDAO.showCampgroundNames(parkChoiceId).toArray());
				   for (int j = 0; j < campgroundDAO.showCampgroundNames(parkChoiceId).size(); j++) {
					   if (choice.equals(campgroundDAO.showCampgroundNames(parkChoiceId).get(j))) {
						   getArrival();
						   getDeparture();
						 //  siteDAO.showAllAvailableSites(campgroundDAO.showCampgroundNames(parkChoiceId).get(j), arrivalDate, departureDate);
						   siteDAO.showAllAvailableSites(campgroundDAO.showCampgroundNames(parkChoiceId).get(j), arrivalDate, departureDate);
						   choice = (String) menu.getChoiceFromOptions(campgroundReservations());
						   if(choice.equals("Make a reservation")) {
							   reservationDAO.bookReservation(arrivalDate, departureDate);
							   reservationDAO.reservationId();
							   parkChoiceId = -1;
							   return;
						   } 
					   }
				   } 
			   }
		   }
	   } else {
		   campgroundDAO.showCampground(parkChoiceId);
		   String choice = (String) menu.getChoiceFromOptions(campgroundDAO.showCampgroundNames(parkChoiceId).toArray());
	   for (int j = 0; j < campgroundDAO.showCampgroundNames(parkChoiceId).size(); j++) {
		   if (choice.equals(campgroundDAO.showCampgroundNames(parkChoiceId).get(j))) {
			   getArrival();
			   getDeparture();
			   siteDAO.showAllAvailableSites(campgroundDAO.showCampgroundNames(parkChoiceId).get(j), arrivalDate, departureDate);
			   choice = (String) menu.getChoiceFromOptions(campgroundReservations());
			   if(choice.equals("Make a reservation")) {
				   reservationDAO.bookReservation(arrivalDate, departureDate);
				   reservationDAO.reservationId();
				   parkChoiceId = -1;
				   return;
			   }
		   }
	   }
	 }

   }
    
   public void getArrival() {
	   try {
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		    Scanner kb = new Scanner(System.in);
		    System.out.println("What is the arrival date? yyyy-mm-dd");
			String arrivalDateString = kb.nextLine();
			try {
				arrivalDate = LocalDate.parse(arrivalDateString);
				System.out.println("Arrival Date: " + arrivalDate);
			} catch (DateTimeException e) {
				System.out.println("Please enter date in correct format yyyy-mm-dd");
				getArrival();
				} 
				}finally {
	   }
}
			
	public void	getDeparture() {	
			System.out.println("What is the departure date? yyyy-mm-dd");
			 Scanner kb = new Scanner(System.in);
			String departureDateString = kb.nextLine();
			try {
				departureDate = LocalDate.parse(departureDateString);
				System.out.println("Departure Date: " + departureDate);
			} catch (DateTimeException e) {
				System.out.println("Please enter date in correct format yyyy-mm-dd");
				getDeparture();
			
			} finally { 
	   }
	   
 } 
		   
	   

   
	public String[] parkOptions() {
		String[] choices = {"View Campgrounds", "Search for Available Reservation", "Return to Previous Screen", "Return to Main Menu"};
		return choices;
	}
	public String [] campgroundOptions() {
		String[] choices = {"Search for Available Reservation", "Return to Main Menu"};
		return choices;
	}
	public String [] campgroundReservations() {
		String[] choices = {"Make a reservation", "Return to home page"};
		return choices;
		
	}
   
   

		private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	 }
	
	public static void main(String[] args) throws IOException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}
	
	

	
	public CampgroundCLI(DataSource datasource) {
		this.menu = new Menu(System.in, System.out);
		parkDAO = new JDBCParkDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
		campgroundDAO = new JDBCCampgroundDAO(datasource);
	}

}
