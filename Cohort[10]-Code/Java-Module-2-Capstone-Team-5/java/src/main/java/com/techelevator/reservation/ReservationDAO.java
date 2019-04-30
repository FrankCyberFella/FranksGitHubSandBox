package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {

	public Long addInReservation(Long id, String name, LocalDate beginDate, LocalDate departureDate);

}
