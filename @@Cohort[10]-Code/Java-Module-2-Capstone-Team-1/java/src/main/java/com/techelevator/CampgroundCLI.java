package com.techelevator;



import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;
import com.techelevator.projects.view.Menu;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.campground.Campground;
import com.techelevator.campground.CampgroundDAO;
import com.techelevator.campground.JDBCCampgroundDAO;
import com.techelevator.park.JDBCParkDAO;
import com.techelevator.park.Park;
import com.techelevator.park.ParkDAO;
import com.techelevator.reservation.JDBCReservationDAO;
import com.techelevator.reservation.Reservation;
import com.techelevator.reservation.ReservationDAO;
import com.techelevator.site.JDBCSiteDAO;
import com.techelevator.site.Site;
import com.techelevator.site.SiteDAO;



public class CampgroundCLI {
	//first menu options
	private static final String MAIN_MENU_OPTION_PARKS = "Parks";
	private static final String MAIN_MENU_OPTION_CAMPGROUNDS = "Campground";
	private static final String MAIN_MENU_OPTION_RESERVATIONS = "Reservation";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	public static final String[] MAIN_MENU_OPTIONS = new String[] {
			MAIN_MENU_OPTION_PARKS,
			
			MAIN_MENU_OPTION_EXIT
	};
	
	//park menu options
	
	private static final String MAIN_MENU_PARK_NAMES = "Display park names";
	private static final String MAIN_MENU_PARK_INFO = "Display park information";
	private static final String[] MAIN_MENU_PARK_OPTIONS = new String[] {
			MAIN_MENU_PARK_NAMES,
			MAIN_MENU_PARK_INFO,
			MAIN_MENU_OPTION_EXIT			
	};
	
	private static final String MAIN_MENU_CAMPGROUNDS = "View Campgrounds";
	private static final String MAIN_MENU_SEARCH_RESERVATION = "Search for Reservation";
	private static final String MAIN_MENU_RETURN = "Return to Previous Screen";
	private static final String[] MAIN_MENU_CAMPGROUND_RESERVATION = new String[] {
							MAIN_MENU_CAMPGROUNDS,
							MAIN_MENU_SEARCH_RESERVATION,
							MAIN_MENU_RETURN
	};
	
	private static final String MAIN_MENU_RESERVATIONS = "View Reservations";
	private static final String[] MAIN_MENU_AVAILABLE_RESERVATIONS = new String[] {
			MAIN_MENU_RESERVATIONS,
			MAIN_MENU_RETURN
	};
	
	private Menu menu;
	private ParkDAO parkDAO;
	private CampgroundDAO campgroundDAO;
	private SiteDAO siteDAO;
	private ReservationDAO reservationDAO;
	
	

	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		
		CampgroundCLI application = new CampgroundCLI(dataSource);
		System.out.println("Welcome to National Park Campsite Reservation!");
		application.run();
	}

	public CampgroundCLI(DataSource datasource) {
		// create your DAOs here
		this.menu = new Menu(System.in, System.out); 
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		campgroundDAO = new JDBCCampgroundDAO(dataSource);
		parkDAO = new JDBCParkDAO(dataSource);
		siteDAO = new JDBCSiteDAO(dataSource);
		reservationDAO = new JDBCReservationDAO(dataSource);
		
	}
	
	
	
	public void run() {
		
		
		while(true) {
			printHeading("Main Menu");
			
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(choice.equals(MAIN_MENU_OPTION_PARKS)) {
				handleParks(); 
			}
			else if (choice.equals(MAIN_MENU_OPTION_CAMPGROUNDS)) {
				handleCampgrounds();
			}
			else if (choice.equals(MAIN_MENU_OPTION_RESERVATIONS)) {
				handleReservations();
			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				handleExit();
			}
			
		}
	}
	
	public void handleParks() {
		printHeading("Parks");
		
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_PARK_OPTIONS);
			// MAYBE PUT INTO WHILE LOOP
			//make methods
			if(choice.equals(MAIN_MENU_PARK_NAMES)) {
			displayParkNames();			
			run();
			}		
			else if(choice.equals(MAIN_MENU_PARK_INFO)) {
				//printHeading("Park Info");
				displayParkInfo();
				
			}
			else if(choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				run();
			}
	}
	
	//method to display park information
	public void displayParkInfo() {
		printHeading("Park Information");
		List<Park> allParks = parkDAO.getAllParks();
		String[] allParkNames = listStringParks(allParks);
		
		String choice = (String)menu.getChoiceFromOptions(allParkNames);
		listParkInfo(choice);
		chooseReservation(choice); // take our string name for our park and now choose what to do
		
	}
	
	public void chooseReservation(String parkName) {
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_CAMPGROUND_RESERVATION);
		if (choice.equals(MAIN_MENU_CAMPGROUNDS)) {
			viewCampgrounds(parkName);
		}
		if (choice.equals(MAIN_MENU_SEARCH_RESERVATION)) {
			availableReservations(parkName);
		}
		if (choice.equals(MAIN_MENU_RETURN)) {
			displayParkInfo();
		}
		
	}

	public void viewCampgrounds(String parkName) {
		printHeading("Park Campgrounds");
		List<Campground> allCampgrounds = campgroundDAO.getAllCampgrounds(parkName);
		listCampgrounds(allCampgrounds);
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_AVAILABLE_RESERVATIONS);
		
		if(choice.equals(MAIN_MENU_RESERVATIONS)) {
			availableReservations(parkName);
		}
		else if(choice.equals(MAIN_MENU_RETURN)) {
			chooseReservation(parkName);
		}
		
	}
	//Lists available campgrounds and then asks which campground find reservations
	public void availableReservations(String parkName) {
		printHeading("Available Campgrounds");
		List<Campground> allCampgrounds = campgroundDAO.getAllCampgrounds(parkName);
		listCampgrounds(allCampgrounds);
		System.out.println();
		System.out.print("Which campground (enter 0 to cancel)?: ");
		Scanner keyboard = new Scanner (System.in);
		int campgroundNumber = keyboard.nextInt();
		if(campgroundNumber == 0) {
			viewCampgrounds(parkName);
		
		} else if (campgroundNumber > allCampgrounds.size() ) { // If number is not in specified size run method again
			System.out.println("\nSorry not a valid campground\nTry again\n");
			availableReservations(parkName);
		}
		Campground campToReserve = null;
		campToReserve = allCampgrounds.get(campgroundNumber-1);
		String arrivalDate;
		String departureDate;
		System.out.print("Please enter your arrival date (YYYY/MM/DD): ");
		arrivalDate = keyboard.next();
		System.out.print("Please enter your departure date (YYYY/MM/DD): ");
		departureDate = keyboard.next();
		
		getAvailableSites(parkName, campToReserve, arrivalDate, departureDate);
	}
	
	public void getAvailableSites(String parkName, Campground campToReserve, String arrivalDate, String departureDate) {
		System.out.println();
		printHeading("Available Sites");
		List<Site> allAvailableSites = siteDAO.getAvailableSites(parkName, campToReserve,arrivalDate,departureDate);
		
		String[] splitDate = arrivalDate.split("-");
		LocalDate larrivalDate = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
		splitDate = departureDate.split("-");
		LocalDate ldepartureDate = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
		
		Period period = Period.between(larrivalDate, ldepartureDate);
		int daysBetween = period.getDays();
		
		long[] siteList = listSites(allAvailableSites, daysBetween,campToReserve);
		reserveTheSite(allAvailableSites,campToReserve,larrivalDate,ldepartureDate,siteList);
	}
	
	public void reserveTheSite(List<Site> allAvailableSites,Campground campToReserve,LocalDate larrivalDate,LocalDate ldepartureDate,long[] siteList) {
		Scanner keyboard = new Scanner(System.in);
		int theSiteNumber = 0;
		System.out.print("Which site should be reserved (enter 0 to cancel)? ");
		while (true) {
			int counter = 0;
			int chosenSite = keyboard.nextInt();
			theSiteNumber = chosenSite;
			if (chosenSite == 0) {
				displayParkInfo();
			}
			for (long num:siteList) {
				if (num == chosenSite) {
					counter ++;
					
				}
			}
			if (counter!= 0) {
				break;
			}
			System.out.print("That is not a valid site num\n\nPlease choose a valid Site Number: ");
		}
		System.out.print("Please enter first name for reservation: ");
		String reserveName = keyboard.next();
		System.out.print("Please enter last name for reservation: ");
		reserveName = reserveName + " " + keyboard.next();
		
		Reservation newReservation = reservationDAO.createReservation(campToReserve.getCampgroundId(),theSiteNumber,reserveName,larrivalDate,ldepartureDate);

		System.out.println("Thank you for making a reservation with us!\n");
		run();
		//********************* YOU ARE RIGHT HERE **********************

	
		//we are now reserving the site!	
	}
	
	public long[] listSites(List<Site> allAvailableSites, int daysBetween, Campground campToReserve) {
		long[] siteList = new long[300];
		double payment = Double.parseDouble(campToReserve.getDailyFee());
		int count = 0;
		System.out.println("Site No.   Max Occup.   Accessible?   Max Rv Length   Utility   Cost");
		for(Site theSite: allAvailableSites) {
			siteList[count] = theSite.getSiteNum();
			
			System.out.printf("%-10S %-12S %-13S %-15S %-9S %.2f\n",(siteList[count] + ""), (theSite.getMaxOccupancy() + ""), (theSite.isAccessible() + ""),(theSite.getMaxRvLength() + ""),(theSite.isHasUtil() + ""),(daysBetween*payment ) );
			count++;
		
		}
		return siteList;
	}
	
	public void listCampgrounds(List<Campground> allCampgrounds) {
		int counter = 0;
		
		for(Campground aCampground : allCampgrounds) {
			counter++;
			System.out.println("#" + counter + " " + aCampground.getName() +" " + aCampground.getOpenFromMonth() + " " + aCampground.getOpenToMonth() + "  $" + aCampground.getDailyFee());
			}
		//********************************************************OPEN/CLOSE MONTHS!!!
		
		
		System.out.println();		
	}
	
	//method to display park names
	public void displayParkNames() {
		printHeading("Park Names");
		List<Park> allParks = parkDAO.getAllParks();
		
		listParks(allParks);
		
		}
	
	public void handleCampgrounds() {
		printHeading("Campgrounds");
		
		String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
		
		if(choice.equals(MAIN_MENU_OPTION_PARKS)) {
			
		}
		
		handleExit();
	}
	
	public void handleReservations() {
		printHeading("Reservations");
		handleExit();
	}
	
	public void handleExit() {
		System.out.print("Thank you for using the National Park Reservation system!");
		System.exit(0);
	}
	
	private String[] listStringParks(List<Park> parks) {
		List<String> parkNames = new ArrayList<String>();
		
		if(parks.size() > 0) {
			for(Park singlePark: parks) {
				parkNames.add(singlePark.getName());
			}
		}
		String[] result = parkNames.toArray(new String[parkNames.size()]); //
		return result;
	}
	
	private void listParks(List<Park> parks) {
		System.out.println();
		if(parks.size() > 0) {
			for(Park singlePark: parks) {
				System.out.println(singlePark.getName());
			}
			
			}
		else {
			System.out.println("\n*** No results ***");
		}	
	}
	private void listParkInfo(String parkName) {
		parkDAO.getParkInfoByName(parkName);
		//System.out.println(parkName);
		//if()
	}
	

	private void printHeading(String heading) {
		System.out.println("\n" + heading);
		
		for (int i = 0; i < heading.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
