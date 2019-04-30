package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.campground.*;
import com.techelevator.park.*;
import com.techelevator.reservation.*;
import com.techelevator.site.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class CampgroundCLI { // Application Class

	private Menu menu;
	private JDBCCampgroundDAO campgroundDAO;
	private JDBCParkDAO parkDAO;
	private JDBCReservationDAO reservationDAO;
	private JDBCSiteDAO siteDAO;
	
	public static void main(String[] args) {
		
		//connect to the database. This code was provided
		BasicDataSource dataSource = new BasicDataSource();
		//dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		//dataSource.setPassword("postgres1");
		dataSource.setPassword("dimples");
		
		// Instantiate the application object to campground class
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}
	// created a constructor for the class CampgroundClI and set parameters to datasource
	public CampgroundCLI(DataSource datasource) {
		// Define Menu object with input and output sources (keyboard, screen)
		this.menu = new Menu(System.in, System.out);  		
		//Instantiate new DAO objects
		this.campgroundDAO = new JDBCCampgroundDAO(datasource);
		this.parkDAO = new JDBCParkDAO(datasource);
		this.reservationDAO = new JDBCReservationDAO(datasource);
		this.siteDAO = new JDBCSiteDAO(datasource);
		
		
	}
	
	public void run() {
		
		/********************************************************************************
		 * Define String constants for the menu option text/choices
		 * ((IF WE ADD PASSWORD ABOVE, THEN WE CAN BUILD THE ARRAY BELOW BASED ON PERMISSIONS))
		 *******************************************************************************/ 

		
		final String   MAIN_MENU_OPTION_1    = "View Parks";
		final String   MAIN_MENU_OPTION_2    = "Make a Reservation By Campground";
		final String   MAIN_MENU_OPTION_3    = "UNDER CONSTRUCTION! Make a Reservation";
		final String   MAIN_MENU_OPTION_4    = "UNDER CONSTRUCTION! View reservations";
		final String   MAIN_MENU_OPTION_EXIT = "Exit";
		
		final String[] MAIN_MENU_OPTIONS	= {MAIN_MENU_OPTION_1
		                                	   ,MAIN_MENU_OPTION_2
		                                	   ,MAIN_MENU_OPTION_3
		                                	   ,MAIN_MENU_OPTION_4
		                                	   ,MAIN_MENU_OPTION_EXIT};
		
		//Let's have a friendly greeting here
		
		System.out.println("\n********************************************");
		System.out.println("Welcome To the Campground Reservation Suite!");
		System.out.println("  (                 ,&&&.\n" + 
				"             )                .,.&&\n" + 
				"            (  (              \\=__/\n" + 
				"                )             ,'-'.\n" + 
				"          (    (  ,,      _.__|/ /|\n" + 
				"           ) /\\ -((------((_|___/ |\n" + 
				"         (  // | (`'      ((  `'--|\n" + 
				"       _ -.;_/ \\\\--._      \\\\ \\-._/.\n" + 
				"      (_;-// | \\ \\-'.\\    <_,\\_\\`--'|\n" + 
				"      ( `.__ _  ___,')      <_,-'__,'\n" + 
				"       `'(_ )_)(_)_)'\n" + 
				"");
		System.out.println("********************************************");
		//end friendly greeting
		
		boolean keepRunning = true;
		
		//run continuously until the user selects an EXIT/QUIT option
		while(keepRunning) {
			//Let's get the user's input here
			String choice = menu.getChoiceFromOptions(MAIN_MENU_OPTIONS).toString();
			switch(choice) {
				case MAIN_MENU_OPTION_1:{
					parkNameMenu ("details");
					break;
				}
				case MAIN_MENU_OPTION_2:{
					parkNameMenu("campgrounds");
					break;
				}
				case MAIN_MENU_OPTION_3:{
					break;
				}
				case MAIN_MENU_OPTION_EXIT:{
					keepRunning = false;
					break;
				}
			}
		}
		System.out.println("\n*****************************************************");
		System.out.println("Thank you for using the Campground Reservation Suite!");
		System.out.println("*****************************************************");
	}
	public void parkNameMenu(String need) {
		List<Park> parks = parkDAO.selectAllParks();
		List<String> parkNameMenuOptions = parkDAO.getParkNames(parks);
		parkNameMenuOptions.add("Quit");
		String choice = menu.getChoiceFromOptions(parkNameMenuOptions.toArray()).toString();
		for(Park thePark:parks) {
			if(choice.equalsIgnoreCase(thePark.getName())) {
				if(need.equals("details")) {
					parkDetails(thePark);
				} else if(need.equals("campgrounds")) {
					campgroundFromParkMenu(thePark);
				}
				
			}
		}
		
	}
	public void campgroundFromParkMenu(Park thePark){
		final String menuOption = "Search for Available Reservation";
		
		List<Campground> campgrounds = campgroundDAO.selectCampgroundByParkId(thePark.getParkId());
		campgroundDAO.getCampgroundNames(campgrounds, thePark);
		String[] resMenu = {menuOption,"Return to Previous Screen"};
		String choice = menu.getChoiceFromOptions(resMenu).toString();
		if(choice.equals(menuOption)) {
			searchForReservation(campgrounds, thePark);
		}
		
	}
	public void parkDetails(Park thePark) {
		System.out.println(thePark);
	}
	public void searchForReservation(List<Campground> campgrounds, Park thePark) {
		
		campgroundDAO.getCampgroundNames(campgrounds, thePark);
		Campground theCampground = new Campground();
		String campNumber="";
		
		Site theSite = new Site();
		String siteNumber = "";
		
		String resName = "";
		
		Scanner keyBoard = new Scanner(System.in);
		LocalDate startDate;
		LocalDate endDate;
		LocalDate today = LocalDate.now();

		boolean keepAsking = true;
		while(keepAsking) {
			System.out.print("\n Which campground (enter 0 to cancel)? ");
			try {
				campNumber = keyBoard.nextLine();
				if(campNumber.equals("0")) {
					System.out.println("Operation cancelled!");
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
		startDate=stayDate("arrival",today,today.plusYears(1),"You cannot make a reservation that has already started!","You cannot make a reservation more than 1 year out!");
		System.out.println("Start Date: "+startDate);
		endDate=stayDate("departure",startDate,startDate.plusYears(1),"You cannot leave before you've arived!","You cannot make a reservation lasting more than 1 year!");
		System.out.println("End Date: "+endDate);

		List<Site> fiveSites = siteDAO.selectAvilableSitesbyCampgroundId(theCampground.getCampgroundId(), startDate, endDate);
		if(fiveSites.size()>0) {
			System.out.println("\nResults Matching Your Search Criteria:");
			siteDAO.getSiteDescriptions(fiveSites, theCampground,startDate,endDate);
			
			keepAsking = true;
			while(keepAsking) {
				System.out.print("\n Which site should be reserved (enter 0 to cancel)? ");
				try {
					siteNumber = keyBoard.nextLine();
					if(siteNumber.equals("0")) {
						System.out.println("Operation cancelled!");
						keepAsking=false;
					} else {
						for(Site site:fiveSites) {
							if(site.getSiteNumber()==Integer.parseInt(siteNumber)) {
								theSite=site;
								keepAsking=false;
								System.out.println("You entered site number "+theSite.getSiteNumber()+"!");
							}
						}
						if(keepAsking) {
							System.out.println("Sorry, "+siteNumber+" is not a valid option.");
							break;
						}
						
						System.out.print("\n What name should the reservation be made under? ");
						try {
							resName = keyBoard.nextLine();
							int resId=reservationDAO.createNewReservation(resName, theSite.getSiteId(), startDate, endDate,today);
							if(resId!=0) {
								System.out.println("The reservation has been made and the confirmation id is "+resId+"!");
							} else{
								System.out.println("Sorry, there was an error placing the reservation!");
							}
						}catch(Exception e) {
							System.out.println("Sorry, there was an error with the name input!");
						}

					}
				}catch(Exception e) {
					System.out.println("Sorry, "+siteNumber+" is not a valid option.");
				}
			}
			
		} else {
			System.out.println("Sorry, there were no available sites!");
			System.out.println("Would you like to enter alternate dates? (Y/N)");
			try {
				String retryRes = keyBoard.nextLine();
				if(retryRes.equalsIgnoreCase("Y")) {
					searchForReservation(campgrounds, thePark);
				}
			}catch(Exception e) {
				System.out.println("Sorry, there was an error with the name input!");
			}
		}
	}
	public LocalDate stayDate(String dateType,LocalDate earlyLimit,LocalDate lateLimit,String earlyError,String lateError) {
		
		Scanner keyBoard = new Scanner(System.in);
		DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;
		String dateInput="";
		LocalDate date = LocalDate.now();
		boolean keepAsking=true;
		while(keepAsking) {
			
			System.out.print("\n What is the "+dateType+" date? (YYYY-MM-DD)");
			try {
				dateInput = keyBoard.nextLine();
				date = LocalDate.parse(dateInput,dateFormat);		
				if(date.toEpochDay()>earlyLimit.toEpochDay()) {
					if(date.toEpochDay()<lateLimit.toEpochDay()) {
						
						keepAsking=false;
					} else {
						System.out.println(lateError);
					}
				} else {
					System.out.println(earlyError);
				}
			}catch(Exception e) {
				System.out.println("Sorry, "+dateInput+" is not a valid option.");
			}
		}	

		return date;
	}
	
}
	