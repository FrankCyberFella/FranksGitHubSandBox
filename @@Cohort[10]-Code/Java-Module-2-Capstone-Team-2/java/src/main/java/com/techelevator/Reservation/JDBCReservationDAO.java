package com.techelevator.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Campground.Campground;
import com.techelevator.Park.Park;

public class JDBCReservationDAO implements ReservationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	Reservation reservation = new Reservation();
	@Override
	public void bookReservation(LocalDate fromDate, LocalDate toDate) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter your reservation name ");
		String name = kb.nextLine();
        reservation.setName(name);
		try {
		System.out.println("Enter the site number: ");
		String siteString = kb.nextLine();
		int siteId = Integer.parseInt(siteString);
		
		//List<Reservation> createdReservation = new ArrayList<>();
		String sqlCreateReservation = "insert into reservation " +
									  "(site_id, name, from_date, to_date, create_date) " +
									  "values(?, ?, ?, ?, CURRENT_TIMESTAMP) ";
		jdbcTemplate.update(sqlCreateReservation, siteId, name, fromDate, toDate);
		} catch  (Exception e) { System.out.println("Could not confirm, Please enter information again.");
		bookReservation(fromDate, toDate);
			}
		
		
		
//		SqlRowSet results = jdbcTemplate.update(sqlCreateReservation, siteId, name, fromDate, toDate);
//		 while(results.next()) {
//			 Reservation reservation = mapRowToReservation(results);
//			 createdReservation.add(reservation);
	
		
	}
	public void reservationId() {
	
		String sqlReservationId = "SELECT reservation_id " +
				  "FROM reservation " +
				  "Where name = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlReservationId, reservation.getName());
		while(results.next()) {
			int reservationId = mapReservationId(results);
			System.out.println("Thank you for your placing your reservation with us: Your Reservation Id is " + reservationId );
		}
	}
	

	
	
	
	
	
	@Override
	public void notAvailable() {
		// TODO Auto-generated method stub
		
	}
	public Reservation mapRowToReservation(SqlRowSet results) {
		Reservation reservation;
		reservation = new Reservation();
		reservation.setSiteId(results.getInt("site_id"));
		reservation.setName(results.getString("name"));
		reservation.setFromDate(results.getDate("from_date").toLocalDate());
		reservation.setToDate(results.getDate("to_date").toLocalDate());
		reservation.setCreateDate(results.getDate("create_date").toLocalDate());
		
		return reservation;
		
	}
	
	public int mapReservationId(SqlRowSet results) {
		reservation.setReservationId(results.getInt("reservation_id"));	
		return reservation.getReservationId();
	 
	}

	@Override
	public List<String> reservationSearch() {
		// TODO Auto-generated method stub
		return null;
	}
}
