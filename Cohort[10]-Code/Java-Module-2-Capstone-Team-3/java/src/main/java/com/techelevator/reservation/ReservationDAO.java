package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.site.Site;

public interface ReservationDAO {

	public List<Reservation> getAllReservations();
	public List<Reservation> getReservationById(int reservationId);
	public List<Reservation> getReservationByName();
	public void createTheReservation(Site site, String name, LocalDate arrival, LocalDate departure);
	
	
}
