package com.techelevator.Reservation;

import java.time.LocalDate;
import java.util.List;



public interface ReservationDAO {

	public List <String> reservationSearch();
	
	public void reservationId();
	
	public void notAvailable();

	void bookReservation(LocalDate fromDate, LocalDate toDate);
	
}
