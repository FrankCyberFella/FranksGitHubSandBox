package com.techelevator;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;
import com.techelevator.campground.CampgroundDAO;
import com.techelevator.campground.JDBCCampgroundDAO;
import com.techelevator.menu.Menu;
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
	// THIS MENU IS THE FIRST MENU THE USER SEES
	// USED TO SELECT PARK OF INTEREST
	private static final String MAIN_MENU_OPTION_PARK_NAMES = "List Park Names";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit Out";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_PARK_NAMES,
			MAIN_MENU_OPTION_EXIT };

	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";
	private static final String MENU_OPTION_RETURN_TO_PREVIOUS_SCREEN = "Return to Previous Screen";

	// MENU TO SELECT FROM CAMPGROUND OPTIONS WITHIN ACADIA
	private static final String PICK = "Search";
	private static final String[] MENU_OPTIONS_PARK_SELECTION = new String[] { PICK, MENU_OPTION_RETURN_TO_MAIN };

	// MENU TO SELECT FROM CAMPGROUND OPTIONS WITHIN ARCHES
	private static final String VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String VIEW_RESERVATIONS = "Search for Reservation";
	private static final String[] MENU_OPTIONS_CAMPGROUNDS = new String[] { VIEW_CAMPGROUNDS, VIEW_RESERVATIONS,
			MENU_OPTION_RETURN_TO_PREVIOUS_SCREEN };

	private static final String VIEW_AVAILABLE_RESERVATIONS = "Search for Available Reservation";
	private static final String[] RESERVATION_MENU = new String[] { VIEW_AVAILABLE_RESERVATIONS,
			MENU_OPTION_RETURN_TO_MAIN }; // **UPDATE TO RETURN TO PREVIOUS MENU, CURRENTLY RETURNING TO MAIN MENU**

	private static final String PROMPT_CHOICE_YES = "YES";
	private static final String PROMPT_CHOICE_NO = "NO";
	private static final String[] PROMPT_CHOICE_MENU = new String[] { PROMPT_CHOICE_YES, PROMPT_CHOICE_NO };

	private static final String RESERVE_SITE = "Book a reservation";
	private static final String[] RESERVE_YOUR_SITE_MENU = new String[] { RESERVE_SITE, MENU_OPTION_RETURN_TO_MAIN }; // **UPDATE
																														// TO
																														// RETURN
																														// TO
																														// PREVIOUS
																														// MENU,
																														// CURRENTLY
																														// RETURNING
																														// TO
																														// MAIN
																														// MENU**

	private Menu menu;
	private CampgroundDAO campgroundDAO;
	private ParkDAO parkDAO;
	private ReservationDAO reservationDAO;
	private SiteDAO siteDAO;
	private Park park = new Park();
	private String[] array = new String[1];

	public CampgroundCLI(DataSource datasource) {
		this.menu = new Menu(System.in, System.out);

		// create your DAOs here
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		parkDAO = new JDBCParkDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);

	}

	public CampgroundCLI(Menu menu) throws FileNotFoundException { // Constructor - user will pass a menu for this class
																	// to use
		this.menu = menu; // Make the Menu the user object passed, our Menu
	}

	// *************************************************************************************************************************************
	// *************************************************************************************************************************************
	// ******************************* MENU OPTIONS
	// ***************************************************************************************
	// *************************************************************************************************************************************

	public void run() {
		while (true) {
			printHeading("Welcome to the National Park Campsite Reservation Application");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_PARK_NAMES)) {
				System.out.println("");
				listParkNamesMainMenu();
				parkSelection();

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("\n See you again soon!");
				System.exit(0);
			}
		}
	}

	// METHOD TO HAVE USER SELECT THE PARK
	private void parkSelection() {
		printHeading("Pick a Park");
		String choice = (String) menu.getChoiceFromOptions(MENU_OPTIONS_PARK_SELECTION);
		if (choice.equals(PICK)) {
			System.out.println("");
			Park park = searchIdDisplayPark();
			System.out.println("");
			displayCampgroundMenu(park);
		} else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
		}
	}

	/* METHOD TO OPEN NEXT MENU FOR ACCESSING CAMPGROUNDS */
	private void displayCampgroundMenu(Park park) {
		printHeading("Select a Command");
		String choice = (String) menu.getChoiceFromOptions(MENU_OPTIONS_CAMPGROUNDS);
		if (choice.equals(VIEW_CAMPGROUNDS)) {
			allCampgrounds(park);
			makeReservation();
		} else if (choice.equals(VIEW_RESERVATIONS)) {
			allCampgrounds(park);
			useCampgroundToFindSites();
		} else if (choice.equals(MENU_OPTION_RETURN_TO_PREVIOUS_SCREEN)) {
			parkSelection();
		}
	}

	/* METHOD TO OPEN MENU TO SELECT FROM AVAILABLE RESERVATIONS */
	private void makeReservation() {
		printHeading("Select a Command");
		String choice = (String) menu.getChoiceFromOptions(RESERVATION_MENU);
		if (choice.equals(VIEW_AVAILABLE_RESERVATIONS)) {
			useCampgroundToFindSites();
			scheduleYourReservation();
		} else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
		}
	}

	/*
	 * METHOD TO OPEN MENU TO ASK USER IF THEY WANT TO TRY A NEW DATE IF CHOSEN DATE
	 * WAS UNAVAILABLE
	 */
	private void promptForADifferentReservationDate() {
		printHeading("Please choose");
		String choice = (String) menu.getChoiceFromOptions(PROMPT_CHOICE_MENU);
		if (choice.equals(PROMPT_CHOICE_YES)) {
			useCampgroundToFindSites();
			scheduleYourReservation();
		} else if (choice.equals(PROMPT_CHOICE_NO)) {
			run();
		}
	}

	/* METHOD TO BRING UP MENU ASKING USER WHICH SITE THEY WANT TO RESERVE */
	private void scheduleYourReservation() {
		String choice = (String) menu.getChoiceFromOptions(RESERVE_YOUR_SITE_MENU);
		if (choice.equals(RESERVE_SITE)) {
			// bookReservation();
		} else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
		}
	}

	// *************************************************************************************************************************************
	// *************************************************************************************************************************************
	// ******************************* MENU OPTIONS
	// ***************************************************************************************
	// *************************************************************************************************************************************

	/* METHOD TO HELP US SEE PARK INFO */
	private Park searchIdDisplayPark() {
		String id = getUserInput("Search Park ID: ");
		Long newLong = Long.valueOf(id).longValue();
		Park park = parkDAO.seeSpecificPark(newLong);
		List<Park> numOfParks = parkDAO.seeAllParks();
		try {
			DecimalFormat formatter = new DecimalFormat("#,###");
			
			if (newLong <= numOfParks.size()) {
				System.out.println(park.getName() + " National Park" + "\n----------------------\n" + "Park ID: "
						+ park.getParkId() + "\n" + "Location: " + park.getLocation() + "\n" + "Established: "
						+ park.getEstablishDate() + "\n" + "Area: " + formatter.format(park.getArea()) + "\n"
						+ "Annual Visitors: " + formatter.format(park.getVisitors()) + "\n" + "\n"
						+ park.getDescription().replaceAll(".{79}(?=.)", "$0\n"));
				System.out.println("________________________________________________________________________");
			} else {
				System.out.println("");
				System.out.println("****************************");
				System.out.println("Please enter a valid Park ID");
				System.out.println("****************************");
				parkSelection();
			}
		} catch (NumberFormatException e) {
			System.out.println("");
			System.out.println("****************************");
			System.out.println("Please enter a valid Park ID");
			System.out.println("****************************");
			parkSelection();
		}
		return park;
	}

	/* METHOD TO HELP US SEE PARK INFO */
	private void listParkNamesMainMenu() {
		List<Park> parkNames = parkDAO.seeAllParks();
		for (Park park : parkNames) {
			System.out.println(park.getParkId() + ".  " + park.getName());
		}
	}

//*************************************************************************************************************************************
//*************************************************************************************************************************************
// *******************************   	 CAMPGROUNDS					***************************************************************
//*************************************************************************************************************************************

	/* METHOD TO HELP US SEE CAMPGROUND INFO */
	private void allCampgrounds(Park park) {
		printHeading("Park Campgrounds");
		List<Campground> campgroundsList = campgroundDAO.seeAllCampgrounds(park);
		System.out.println(
				"              " + "Name           " + "Open               " + "Close              " + "Daily Fee");
		for (Campground campground : campgroundsList) {
			DecimalFormat df = new DecimalFormat();
			df.setMinimumFractionDigits(2);
			System.out.printf("%n%-10s%-20s%-20s%-20s%-20s%n%n", "#" + campground.getCampgroundId(),
					campground.getName(), campground.getOpenFrom(), campground.getOpenTo(),
					"$" + df.format(campground.getDailyFee()));
		}

	}

//*************************************************************************************************************************************
//*************************************************************************************************************************************
// *******************************   	 CAMPGROUNDS					***************************************************************
//*************************************************************************************************************************************

	// need try catch block for exceptions in case they get any part of the date input wrong, added the DateTimeParseException
		private void useCampgroundToFindSites() {
			try {
		String id = getUserInput("Enter Campground ID: ");
		String beginDate = getUserInput("What is the arrival date YYYY-MM-DD: ");
		String departureDate = getUserInput("What is the departure date YYYY-MM-DD: ");
		Site site2 = new Site();
		System.out.println("_________________________________________________________________________________________");
		Long newLong = Long.valueOf(id).longValue();
		Campground campground = campgroundDAO.getTheCampground(newLong);
		List<Site> sites = siteDAO.listOfSites(newLong, beginDate, departureDate);
		double cost = campground.getDailyFee() * siteDAO.costOfStay(beginDate, departureDate);
			if (sites.isEmpty()) {
				System.out.println("There are no campsites available for this date");
				promptForADifferentReservationDate();
			} else {
				System.out.println("Site No.          " + "Max Occup.          " + "Accessible?      "
						+ "Max RV Length            " + "Utility              ");
				for (Site site : sites) {
					System.out.printf("%n%-20s%-20s%-20s%-20s%-20s%n%n", site.getSiteNumber(), site.getMaxOccupancy(),
							site.isAccessible(), site.getMaxRvLength(), site.isUtilities());
				}
				DecimalFormat df = new DecimalFormat();
				df.setMinimumFractionDigits(2);
				System.out.println("");
				System.out.println("********************************************************************");
				System.out.println(
						"The total cost for your stay at these campgrounds would be " + "$" + df.format(cost) + ".");
				System.out.println("********************************************************************");
			}
			scheduleYourReservation();
			String reservationId = getUserInput("Which site should be reserved: ");
			Long siteId = Long.valueOf(reservationId).longValue();
			String name = getUserInput("What name should the reservation be made under?: ");
			System.out.println(
					"_______________________________________________________________________________________________________________________");
			LocalDate d1 = LocalDate.parse(beginDate);
			LocalDate d2 = LocalDate.parse(departureDate);
			Long reserve = reservationDAO.addInReservation(siteId, name, d1, d2);
			System.out.println("***************************************************************");
			System.out.println("The reservation has been made and the confirmation id is " + reserve);
			System.out.println("***************************************************************");
			run();
		} catch (DateTimeParseException e) {
			System.out.println("");
			System.out.println("****************************");
			System.out.println("Please enter a valid date in the format YYYY-MM-DD");
			System.out.println("****************************");
			makeReservation();
		} catch (NumberFormatException e) {
			System.out.println("");
			System.out.println("****************************");
			System.out.println("Please enter a valid date in the format YYYY-MM-DD");
			System.out.println("****************************");
			makeReservation();
		}
	}

	private void printHeading(String headingText) {
		System.out.println("\n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	@SuppressWarnings("resource")
	private String getUserInput(String prompt) {
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}

// *********************************************************************************************************************
// MAIN METHOD TO RUN OUR PROGRAM
// *********************************************************************************************************************

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundCLI application = new CampgroundCLI(dataSource);

		application.run();
	}
}
