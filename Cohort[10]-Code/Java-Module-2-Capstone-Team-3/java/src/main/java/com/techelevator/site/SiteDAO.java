package com.techelevator.site;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {

	public boolean isAccessible();
	
	public List<Site> getAvailableSiteByDate(int campgroundId, String arrivalDate, String departureDate, int amountOfDays);
//	public List<Site> getAvailableSiteByDate(int campgroundId, String arrivalDate, String departureDate, int amountOfDays, int maxOccupancy, int accessible, int rvLength, int utilities);

}
