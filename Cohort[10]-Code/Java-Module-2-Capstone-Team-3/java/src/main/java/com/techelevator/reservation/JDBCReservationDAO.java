package com.techelevator.reservation;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;
import com.techelevator.site.Site;

public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List <Reservation> getReservationById(int reservationId) {
		List<Reservation> reservation = new ArrayList<Reservation>();
		String sqlFindReservation = "SELECT * FROM reservation WHERE reservation_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindReservation, reservationId);
																	
		while(results.next()) {
			Reservation resStatement = mapRowToReservation(results);
			reservation.add(resStatement);
		}
		if(reservation.size() > 0) {
			DecimalFormat format = new DecimalFormat("#0.00");
			String siteId = "SITE ID";
			String name = "NAME";
			String fromDate = "FROM DATE";
			String toDate = "TO DATE";
			String createDate = "CREATE DATE";
			System.out.printf(String.format("%-15s%-35s%-15s%-15s%-15s\n", siteId, name, fromDate, toDate, createDate));
			for (Reservation resDisplay: reservation)
			System.out.printf("%-15s%-35s%-15s%-15s%-15s\n", resDisplay.getSiteId(), resDisplay.getName(), resDisplay.getFromDate(), resDisplay.getToDate(), resDisplay.getCreateDate());
		}
		return reservation;
	}


	@Override
	public List<Reservation> getReservationByName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void createTheReservation(Site site, String name, LocalDate arrivalDate, LocalDate departureDate) {
		Reservation reservation = new Reservation();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		String sqlInsertReservation = "INSERT INTO reservation (reservation_id, site_id, name, from_date, to_date, create_date) "+
									  "VALUES (?, ? , ?, ? ,? , ?)"
									  ;
		if(reservation.getReservationId() == null) {
			reservation.setReservationId(getNextReservationId());
		}
		jdbcTemplate.update(sqlInsertReservation,reservation.getReservationId()
												,site.getSiteId()
												,name
												,arrivalDate
												,departureDate
												,currentDate);
		System.out.println("Thank you " + name+ "!" +" Your reservation number is " + reservation.getReservationId() +".");
	}
	
	public long getNextReservationId() {
		SqlRowSet nextResId = jdbcTemplate.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
		if(nextResId.next()) {
			return nextResId.getLong(1);
		}
		else {
			throw new RuntimeException("Something went wrong while getting an id for the reservation");
		}
	}
	
	private Reservation mapRowToReservation(SqlRowSet results) { 
		Reservation reservation = new Reservation();	
		reservation = new Reservation();  

		reservation.setSiteId(results.getInt("site_id"));
		reservation.setName(results.getString("name"));
		reservation.setFromDate(results.getDate("from_date").toLocalDate());
		reservation.setToDate(results.getDate("to_date").toLocalDate());
		reservation.setCreateDate(results.getDate("create_date").toLocalDate());

		return reservation;
	} 

}
