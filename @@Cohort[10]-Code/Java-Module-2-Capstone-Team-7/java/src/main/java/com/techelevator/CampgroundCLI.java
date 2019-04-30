package com.techelevator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


import com.techelevator.campground.CampgroundDAO;
import com.techelevator.campground.JDBCCampgroundDAO;
import com.techelevator.menu.Menu;
import com.techelevator.park.JDBCParkDAO;
import com.techelevator.park.ParkDAO;
import com.techelevator.reservation.JDBCReservationDAO;
import com.techelevator.reservation.ReservationDAO;
import com.techelevator.site.JDBCSiteDAO;
import com.techelevator.site.SiteDAO;

public class CampgroundCLI {

	private Scanner in = new Scanner(System.in);

	private static final String PARK_MENU_OPTION_CAMPGROUNDS = "See Campgrounds";
	private static final String PARK_MENU_OPTION_RESERVATION = "Make a Reservation";
	private static final String PARK_MENU_OPTION_EXIT = "Go back";
	private static final String[] PARK_MENU_OPTIONS = new String[] { PARK_MENU_OPTION_CAMPGROUNDS,
			PARK_MENU_OPTION_RESERVATION, PARK_MENU_OPTION_EXIT };

	private static final String CAMPGROUND_MENU_OPTION_SEARCH_RESERVATION = "Look for an available reservation";
	private static final String CAMPGROUND_MENU_OPTION_EXIT = "Go back";
	private static final String[] CAMPGROUND_MENU_OPTIONS = new String[] { CAMPGROUND_MENU_OPTION_SEARCH_RESERVATION,
			CAMPGROUND_MENU_OPTION_EXIT };

	private ParkDAO parkDAO;
	private CampgroundDAO campgroundDAO;
	private SiteDAO siteDAO;
	private ReservationDAO reservationDAO;
	private Menu menu;
	private MainParksMenu parkMenu;

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}

	public CampgroundCLI(DataSource datasource) {
		this.menu = new Menu(System.in, System.out);
		this.parkMenu = new MainParksMenu(System.in, System.out, datasource);
		parkDAO = new JDBCParkDAO(datasource);
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
	}

	public void run() {

		displayApplicationBanner();

		while (true) {
			int choice = parkMenu.getParkFromOptions(parkDAO.getParks()).getPark_id();
			handlePark(choice);

		}

	}

	private void handlePark(int id) {
		parkDAO.displayParkInfo(id);
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(PARK_MENU_OPTIONS);

			if (choice.equals(PARK_MENU_OPTION_CAMPGROUNDS)) {
				handleCampground(id);
			} else if (choice.equals(PARK_MENU_OPTION_RESERVATION)) {
				campgroundDAO.displayCampground(id);
				System.out.println();
				handleReservation(id);
			} else if (choice.equals(PARK_MENU_OPTION_EXIT)) {
				run();

			}
		}
	}

	private void handleCampground(int id) {
		campgroundDAO.displayCampground(id);
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(CAMPGROUND_MENU_OPTIONS);
			if (choice.equals(CAMPGROUND_MENU_OPTION_SEARCH_RESERVATION)) {
				handleReservation(id);

			} else if (choice.equals(CAMPGROUND_MENU_OPTION_EXIT)) {
				handlePark(id);

			}
		}
	}

	public void handleReservation(int id) {
		System.out.print("Which campground number? (enter 0 to cancel) ");
		String userCampNumber = in.nextLine();

		try {
			int campNum = Integer.parseInt(userCampNumber);
			if (campNum == 0) {
				handleCampground(id);
			} else if (campgroundDAO.searchCampExists(id).contains(campNum)) {
				System.out.print("What is your arrival date? (yyyy-mm-dd) ");
				String userArrivalDate = in.nextLine();
				LocalDate d1 = LocalDate.parse(userArrivalDate);
				if(d1.isBefore(LocalDate.now())) {
					System.out.println("\n*** You cannot book for a date that is in the past... ***\n");
					handleReservation(id);
				}
				System.out.print("What is your departure date? (yyyy-mm-dd) ");
				String userDepartureDate = in.nextLine();
				LocalDate d2 = LocalDate.parse(userDepartureDate);
				if(d2.isBefore(d1)) {
					System.out.println("\n*** Time doesn't work in that direction... ***\n");
					handleReservation(id);
				}
				siteDAO.listSites(campNum, d1, d2);
				System.out.print("What is the number of the campsite you would like to book? ");
				String userSite = in.nextLine();
				int siteNum = Integer.parseInt(userSite);
				System.out.print("What is the name you would like to book under? ");
				String userName = in.nextLine();
				reservationDAO.makeReservation(siteNum, userName, d1, d2);
				run();
				
				
			}

			else
				System.out.println("\n*** " + userCampNumber + " is not a valid option ***\n");
			handleReservation(id);
		} catch (NumberFormatException e) {
			System.out.println("\n*** " + userCampNumber + " is not a valid option ***\n");
			handleReservation(id);
		}
		  catch (DateTimeParseException e) {
			System.out.println("\n*** This is not a valid date format ***\n");
			handleReservation(id);
		  }
		  catch (Exception e) {
			  System.out.println("\n*** This reservation is not possible, please chose different dates or a different site ***\n");
			  handleReservation(id);
		  }

	}

	private void displayApplicationBanner() {
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("WELCOME TO THE NATIONAL PARK INFO CENTER!");
		System.out.println("Built by Matthew Colella & Chris Hall");
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("                                ");
		System.out.println("              /^\\              ");
		System.out.println("             /   \\             ");
		System.out.println("            /     \\            ");
		System.out.println("           /__   __\\           ");
		System.out.println("             /   \\             ");
		System.out.println("            /     \\            ");
		System.out.println("           /       \\           ");
		System.out.println("          /         \\          ");
		System.out.println("         /____   ____\\         ");
		System.out.println("______________| |_______________");

	}

}