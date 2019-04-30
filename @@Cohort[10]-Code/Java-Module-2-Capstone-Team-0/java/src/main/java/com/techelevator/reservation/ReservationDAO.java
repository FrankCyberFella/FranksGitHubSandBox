package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {
	//created new reservation method
	public int createNewReservation(String name,int siteId, LocalDate fromDate, LocalDate toDate, LocalDate createDate);//* Will need parameters Dates, park, campground, site 
	//created signature of for the method to list the reservations
	public List<Reservation> viewReservations();
	
}
