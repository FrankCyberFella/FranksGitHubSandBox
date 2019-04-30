package com.techelevator.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;
import com.techelevator.park.Park;
import com.techelevator.site.Site;

public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;
	public Reservation reservation = new Reservation();

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	
	@Override
	public Long addInReservation(Long id, String name, LocalDate beginDate, LocalDate departureDate) {
			String sqlDisplayCampgrounds = "INSERT INTO reservation (site_id, name, from_date, to_date) " + "VALUES (?, ?, ?, ? )";
			jdbcTemplate.update(sqlDisplayCampgrounds, id, name, beginDate, departureDate);
			String sqlDisplayCampground = "SELECT reservation_id " + "FROM reservation " + "ORDER by reservation_id DESC LIMIT 1";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayCampground);
			if(results.next()) {
		return results.getLong("reservation_id");
			}
			return (long) 0;
		}
		

	private Reservation mapRowToReservation(SqlRowSet results) {
		Reservation reservation = new Reservation();
		reservation.setReservationId(results.getLong("reservation_id"));
		reservation.setSiteId(results.getLong("site_id"));
		reservation.setName(results.getString("name"));
		reservation.setFromDate(results.getDate("from_date").toLocalDate());
		reservation.setToDate(results.getDate("to_date").toLocalDate());
		reservation.setCreateDate(results.getDate("create_date").toLocalDate());
		return reservation;
	}

}
