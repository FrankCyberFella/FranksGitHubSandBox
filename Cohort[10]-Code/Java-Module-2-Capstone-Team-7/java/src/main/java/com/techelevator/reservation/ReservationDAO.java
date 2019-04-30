package com.techelevator.reservation;

import java.time.LocalDate;

public interface ReservationDAO {

	public void makeReservation(int site, String name, LocalDate from_date, LocalDate to_date);
}
