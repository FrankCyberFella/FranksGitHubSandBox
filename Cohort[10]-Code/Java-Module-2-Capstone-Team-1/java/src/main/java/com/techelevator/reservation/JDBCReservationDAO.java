package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO{
	
private JdbcTemplate JdbcTemplate;
	
	public JDBCReservationDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return null;
	}
	
	private Reservation mapRowToReservation(SqlRowSet results) {
		
		Reservation theRes = new Reservation();
		theRes.setResId(results.getLong("reservation_id"));
		theRes.setSiteId(results.getLong("site_id"));
		theRes.setName(results.getString("name"));
		
		return theRes;
	}

	@Override
	public Reservation createReservation(long campgroundId, int theSiteNumber, String reserveName, LocalDate larrivalDate,
			LocalDate ldepartureDate) {
		Reservation theRes = null;
		LocalDate currentDate = LocalDate.now();
		
		String insertReservation = "insert into reservation " +
									"(site_id, name, from_date, to_date, create_date) " +
									"values ((SELECT site_id FROM site where campground_id = ? AND site_number = ?),?,?,?,?) ";
		JdbcTemplate.update(insertReservation,campgroundId,theSiteNumber,reserveName,larrivalDate,ldepartureDate,currentDate);
		
		return theRes;
		
	}
	

}
