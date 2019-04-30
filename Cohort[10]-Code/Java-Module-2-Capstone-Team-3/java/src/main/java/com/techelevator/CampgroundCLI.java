package com.techelevator;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.campground.Campground;
import com.techelevator.campground.CampgroundDAO;
import com.techelevator.campground.JDBCCampgroundDAO;
import com.techelevator.menu.Menu;
import com.techelevator.park.JDBCParkDAO;
import com.techelevator.park.ParkDAO;
import com.techelevator.reservation.JDBCReservationDAO;
import com.techelevator.reservation.Reservation;
import com.techelevator.reservation.ReservationDAO;
import com.techelevator.site.JDBCSiteDAO;
import com.techelevator.site.Site;
import com.techelevator.site.SiteDAO;

public class CampgroundCLI {

	private static final String MAIN_MENU_OPTION_PARK_1 = "Acadia";
	private static final String MAIN_MENU_OPTION_PARK_2 = "Arches";
	private static final String MAIN_MENU_OPTION_PARK_3 = "Cuyahoga Valley";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_PARK_1, 
																	 MAIN_MENU_OPTION_PARK_2, 
																	 MAIN_MENU_OPTION_PARK_3, 
																	 MAIN_MENU_OPTION_EXIT };

	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return To Main Menu";
	
	
//******************************CAMPGROUND/SITE/RESERVATION MENU DATAMEMBERS*************************************//
	private static final String VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String SEARCH_FOR_RESERVATION = "Search For Reservation";
	private static final String[] CAMPGROUND_AND_RESERVATION_MENU_OPTIONS = new String[] { VIEW_CAMPGROUNDS,
																		   SEARCH_FOR_RESERVATION,
																		   MENU_OPTION_RETURN_TO_MAIN};
	
	
	
	private static final String SEARCH_AVAILABLE_RESERVATIONS = "Search for Available Reservation";
	private static final String RETURN_TO_PREVIOUS = "Return to Previous Screen";
	private static final String[] SEARCH_RESERVATION_MENU = new String[] { SEARCH_AVAILABLE_RESERVATIONS,
																	 RETURN_TO_PREVIOUS};
	

	private static Menu menu;
	private CampgroundDAO campgroundDAO;
	private SiteDAO siteDAO;
	private ParkDAO parkDAO;
	private ReservationDAO reservationDAO;
	
	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}

	public CampgroundCLI(DataSource datasource) {	
		menu = new Menu(System.in, System.out);		
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
		parkDAO = new JDBCParkDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
	}
	
	
	public void run() {
		while(true) {
			displayApplicationBanner();
			printHeading("Please Choose A Park");
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
				if(choice.equals(MAIN_MENU_OPTION_PARK_1)) {
					parkDAO.getParkInformation(MAIN_MENU_OPTION_PARK_1);
					runCampgroundAndReservationMenu(MAIN_MENU_OPTION_PARK_1);
			} else if(choice.equals(MAIN_MENU_OPTION_PARK_2)) {
					parkDAO.getParkInformation(MAIN_MENU_OPTION_PARK_2);
					runCampgroundAndReservationMenu(MAIN_MENU_OPTION_PARK_2);
			} else if(choice.equals(MAIN_MENU_OPTION_PARK_3)) {
					parkDAO.getParkInformation(MAIN_MENU_OPTION_PARK_3);
					runCampgroundAndReservationMenu(MAIN_MENU_OPTION_PARK_3);
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.print(" _____ _                 _                        \n" + 
						"|_   _| |__   __ _ _ __ | | __  _   _  ___  _   _ \n" + 
						"  | | | '_ \\ / _` | '_ \\| |/ / | | | |/ _ \\| | | |\n" + 
						"  | | | | | | (_| | | | |   <  | |_| | (_) | |_| |\n" + 
						"  |_| |_| |_|\\__,_|_| |_|_|\\_\\  \\__, |\\___/ \\__,_|\n" + 
						"                                |___/              \n For Visiting National Parks Reservations!\n We hope to see you again soon.");
				System.exit(0);
			}
			
		}
		  
		
	}
//**************************************************************************************	
//****************** Campground And Reservation MENU ***********************************
//**************************************************************************************	

	public void runCampgroundAndReservationMenu(String parkName) {
		while(true) {
			printHeading("Select A Command");
			String choice = (String)menu.getChoiceFromOptions(CAMPGROUND_AND_RESERVATION_MENU_OPTIONS);
			if(choice.equals(VIEW_CAMPGROUNDS)) {
				handleListAllCampgrounds(parkName);
			} else if (choice.equals(SEARCH_FOR_RESERVATION)) {
				List<Reservation> resId = reservationDAO.getReservationById(getReservationId());
				if(resId.size() == 0) {
					System.out.println("Error: Reservation ID does not exist. Please try again.");
				}
			} else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
				run();
				}
			}
		}
	

	//**************************** Listing All Campgrounds *********************************//
	
	
	public void handleListAllCampgrounds(String parkName) {
		String park = parkName;
		printHeading(parkName + " Campground Information");
		List<Campground> allCampgrounds = campgroundDAO.getAllCampgrounds(park);
		listCampgroundInfo(allCampgrounds);		
		while(true) {
			printHeading("Select A Command");
			String choice = (String)menu.getChoiceFromOptions(SEARCH_RESERVATION_MENU);
			if(choice.equals(SEARCH_AVAILABLE_RESERVATIONS)) {
				System.out.println("Which campground (enter 0 to cancel)");
				int campgroundNumber = getUserOption();
				if(campgroundNumber == 0) {
					break;
				} 
				else if (campgroundNumber > allCampgrounds.size()){ 
					//In case of future error: changed above from >= to > b/c we were not able to select
					//the last campsite option on all National Parks
					System.out.println("\n***** Must enter a valid number ****");
					break;
				} 
				else {
					long campGround = allCampgrounds.get(campgroundNumber-1).getCampgroundId();
					int campGroundInt = (int)campGround;
					String arrivalDate = getArrivalDate();
					if(arrivalDate == null) {
						break;
					}
					String departureDate = getDepartureDate(arrivalDate);
					if(departureDate == null) {
						break;
					}
					
					int amountOfDays = compareDates(arrivalDate, departureDate);
//					int maxOccupancy = getOccupancy();
//					int accessible = getAccessibility();
//					int rvLength = getRvLength();
//					int utilities = getUtility();
//					List <Site> sites = siteDAO.getAvailableSiteByDate(campGroundInt, arrivalDate, departureDate, amountOfDays, maxOccupancy, accessible, rvLength, utilities);
					List <Site> sites = siteDAO.getAvailableSiteByDate(campGroundInt, arrivalDate, departureDate, amountOfDays);

					if(sites.size() > 0 ) {
						int siteNumber = getSiteNumber();
						if(siteNumber == 0) {
							break;
						}
						String reservationName = getReservationName();
						Site siteToReserve = sites.get(siteNumber - 1);
//						System.out.println(siteNumber + " " + reservationName + " " + siteToReserve);
						reservationDAO.createTheReservation(siteToReserve, reservationName,LocalDate.parse(arrivalDate) , LocalDate.parse(departureDate));
					}
//					else if((siteDAO.getAvailableSiteByDate(campGroundInt, arrivalDate, departureDate, amountOfDays, maxOccupancy, accessible, rvLength, utilities).size() == 0 )) {
					else if((siteDAO.getAvailableSiteByDate(campGroundInt, arrivalDate, departureDate, amountOfDays).size() == 0 )) {
	
						System.out.println("No campsites available for criteria entered. Please try again.");					
						};
					
					break;
				}
			} else if (choice.equals(RETURN_TO_PREVIOUS)) {
				break;
			}
		}
	}
	
	//**************************** Listing Campground Info *********************************//
	
	private void listCampgroundInfo(List<Campground> campgrounds) {
		DecimalFormat format = new DecimalFormat("#0.00");
		String name = "NAME";
		String open = "OPEN MONTH";
		String close = "CLOSE MONTH";
		String dailyFee = "DAILY FEE";
		System.out.printf(String.format("%-35s%-15s%-15s%-10s", name, open, close, dailyFee));
		System.out.println();
		if(campgrounds.size() > 0) {
			int i = 1;
			for(Campground camps : campgrounds) {
					System.out.println(String.format("%-3s%-35s%-15s%-15s%-10s", i+") ", camps.getName(), camps.getOpenFrom(), camps.getOpenTo(), "$"+format.format(camps.getDailyFee())));
					i++;
			}
		} else {
				System.out.println("\n*** No Campgrounds Found For This National Park ***");
		}
	}
	
//********************************METHODS FOR MAKING A RESERVATION*********************************//
	
	public int getUserOption() {
		Scanner input = new Scanner(System.in);
		try {
			int userInput = Integer.parseInt(input.nextLine());
			return userInput;
		} catch (NumberFormatException e) {
			System.out.println("\n***** Must enter a valid number ****");
			return 0;
		}
	}
	
	public String getArrivalDate() {
		try {
			Scanner input = new Scanner(System.in);
			LocalDate currentDate = LocalDate.now();
			System.out.println("What is the arrival date? (YYYY-MM-DD)");
			String arrivalDate = input.nextLine();
			if(isGoodDate(arrivalDate)) {
				if( LocalDate.parse(arrivalDate).isBefore(currentDate) || LocalDate.parse(arrivalDate).isEqual(currentDate) ) {				
					System.out.println("Please enter a valid date");
					return null;
				}
				return arrivalDate;
				}
			} catch (DateTimeParseException exception) {
				System.out.println("Error: Not a valid date. Please try again.");
			}
		return null;
	}

	
	public String getDepartureDate(String arrivalDate) {
		try{
			Scanner input = new Scanner(System.in);
			System.out.println("What is the departure date? (YYYY-MM-DD)");
			String departureDate = input.nextLine();
			if(isGoodDate(departureDate)) {
				if( LocalDate.parse(departureDate).isBefore(LocalDate.parse(arrivalDate)) || LocalDate.parse(departureDate).equals(LocalDate.parse(arrivalDate))) {
					System.out.println("Error: Please enter valid departure date");
					return null;
				}
				return departureDate;
			}
		} catch (DateTimeParseException exception) {
				System.out.println("Error: Not a valid date. Please try again.");
		}
		return null;
	}
	
	public boolean isGoodDate(String date) {
		String newDate = date;
		int length = newDate.length();
		String[] parts = newDate.split("-");
		if(length == 10 && parts.length == 3) {
			return true;
		}
		System.out.println("Error: Invalid date entry. Please try again.");
		return false;
	}
	
	public int compareDates(String arrival, String departure) {
		int days = 0;
		LocalDate arrivalDate = LocalDate.parse(arrival);
		LocalDate departureDate = LocalDate.parse(departure);
		while(arrivalDate.isBefore(departureDate)) {
			arrivalDate = arrivalDate.plusDays(1);
				days++;
		}
			return days;
	}
		
	
	public int getSiteNumber() {
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("Which site should be reserved");
		int siteNumberInput = Integer.parseInt(input.nextLine());
		if(siteNumberInput <= 0 || siteNumberInput > 5) {
			System.out.println("Error: Invalid campsite number. Please try again.");
			return 0;
		}
		
		return siteNumberInput;
		} catch (NumberFormatException exception) {
			System.out.println("Error: Invalid campsite number. Please try again.");
		}
		return 0;
	}
	
	public String getReservationName() {
		Scanner input = new Scanner(System.in);
		System.out.println("What name should the reservation be made under?");
		String reservationNameInput = input.nextLine();
		
		return reservationNameInput;
	}
	
	public int getReservationId() {
		try{ 
			Scanner input = new Scanner(System.in);
			System.out.println("What is the reservation ID?");
			int reservationNameInput = Integer.parseInt(input.nextLine());
			return reservationNameInput;
		
			}
			catch (NumberFormatException exception) {
//			System.out.println("Error: User input invalid. Please try again.");
		}
		return 0;
	}
//*************************************Advanced Search**************************//
//	private int getOccupancy() {
//		try {
//			Scanner input = new Scanner(System.in);
//			System.out.println("What is your max occupancy?");
//			int maxInput = Integer.parseInt(input.nextLine());
//			return maxInput;}
//			catch (NumberFormatException exception) {
//				System.out.println("Error: User input invalid. Please try again.");
//			}
//		return 0;
//		
//	}
//	
//	private int getAccessibility() {
//		try {
//			Scanner input = new Scanner(System.in);
//			System.out.println("Does it need to be wheelchair accessible?('Yes' or 'No')");
//			String accessibleInput = input.nextLine();
//			if (accessibleInput.equalsIgnoreCase("No")) {
//				return 0;
//			}
//				else if(accessibleInput.equalsIgnoreCase("Yes")) {
//				return 1;
//		}
//		}
//			catch (Exception exception) {
//				System.out.println("Error: User input invalid. Please try again.");
//			}
//		return 0;
//		
//	}
//	
//	private int getRvLength() {
//		try {
//			Scanner input = new Scanner(System.in);
//			System.out.println("What is your RV's length? If no RV, type 0.");
//			int rvInput = Integer.parseInt(input.nextLine());
//			return rvInput;}
//			catch (NumberFormatException exception) {
//				System.out.println("Error: User input invalid. Please try again.");
//			}
//		return 0;
//		
//	}
//	
//	
//	private int getUtility() {
//		try {
//			Scanner input = new Scanner(System.in);
//			System.out.println("Do you need a utility hookup?('Yes' or 'No')");
//			String utilityInput = input.nextLine();
//			if(utilityInput.equalsIgnoreCase("Yes")) {
//				return 1;
//			}
//			else if(utilityInput.equalsIgnoreCase("No")) {
//				return 0;
//			}
//		}
//			catch (Exception exception) {
//				System.out.println("Error: User input invalid. Please try again.");
//			}
//		return 0;
//		
//	}
	
	private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	private void displayApplicationBanner() {
		System.out.println(
				" __        __     _                                _____        _   _         _    _                       _  \n" + 
				" \\ \\      / /___ | |  ___  ___   _ __ ___    ___  |_   _|___   | \\ | |  __ _ | |_ (_)  ___   _ __    __ _ | | \n" + 
				"  \\ \\ /\\ / // _ \\| | / __|/ _ \\ | '_ ` _ \\  / _ \\   | | / _ \\  |  \\| | / _` || __|| | / _ \\ | '_ \\  / _` || | \n" + 
				"   \\ V  V /|  __/| || (__| (_) || | | | | ||  __/   | || (_) | | |\\  || (_| || |_ | || (_) || | | || (_| || | \n" + 
				"    \\_/\\_/  \\___||_| \\___|\\___/ |_| |_| |_| \\___|   |_| \\___/  |_| \\_| \\__,_| \\__||_| \\___/ |_| |_| \\__,_||_| \n" + 
				"                                                                                                              \n" + 
				"  ____               _           ____                                      _    _                     _       \n" + 
				" |  _ \\  __ _  _ __ | | __ ___  |  _ \\  ___  ___   ___  _ __ __   __ __ _ | |_ (_)  ___   _ __   ___ | |      \n" + 
				" | |_) |/ _` || '__|| |/ // __| | |_) |/ _ \\/ __| / _ \\| '__|\\ \\ / // _` || __|| | / _ \\ | '_ \\ / __|| |      \n" + 
				" |  __/| (_| || |   |   < \\__ \\ |  _ <|  __/\\__ \\|  __/| |    \\ V /| (_| || |_ | || (_) || | | |\\__ \\|_|      \n" + 
				" |_|    \\__,_||_|   |_|\\_\\|___/ |_| \\_\\\\___||___/ \\___||_|     \\_/  \\__,_| \\__||_| \\___/ |_| |_||___/(_)      \n" + 
				"                                                                                                                                                                         \n" + 
				"                                                                            ");
		
	}
}
