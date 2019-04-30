package com.techelevator.reservation;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void makeReservation(int site, String name, LocalDate d1, LocalDate d2) {

		String sqlReservation = "INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (?, ?, ?, ?);\n";

		jdbcTemplate.update(sqlReservation, site, name, d1, d2);
		String newRes = "SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1";
		SqlRowSet confirmationNumber = jdbcTemplate.queryForRowSet(newRes);
		int finalInt = 0;
		while (confirmationNumber.next()) {
			finalInt = confirmationNumber.getInt("reservation_id");
		}
		System.out.println("\nThank you for booking! Your reservation number is #" + finalInt + "\n");

	}
}
