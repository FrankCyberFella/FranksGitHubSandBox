package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {
	//may change return type
	public List<Reservation> getAllReservations();

	public Reservation createReservation(long campgroundId, int theSiteNumber, String reserveName,
			LocalDate larrivalDate, LocalDate ldepartureDate);

}
