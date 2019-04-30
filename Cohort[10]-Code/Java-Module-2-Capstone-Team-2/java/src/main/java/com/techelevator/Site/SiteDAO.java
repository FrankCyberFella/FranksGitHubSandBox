package com.techelevator.Site;

import java.time.LocalDate;
import java.util.List;


public interface SiteDAO {



	
public double calculateStayCost(LocalDate arrivalDate, LocalDate departureDate, String campgroundName);


public void showAllAvailableSites(String campgroundName, LocalDate arrivalDate, LocalDate departureDate);
	

	
	
	
}
