package com.techelevator.reservation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.park.Park;

public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;
	// created a constructor. The parameters are of type DataSource. 
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// This is the required method from the interface. Hence the override
	@Override
	public int createNewReservation(String name,int siteId, LocalDate fromDate, LocalDate toDate, LocalDate createDate) {
			
		String sqlCreateNewReservation = "INSERT INTO reservation (site_id,from_date,to_date,create_date,name) VALUES (?,?,?,?,?)"; 
		
		jdbcTemplate.update(sqlCreateNewReservation,siteId,fromDate,toDate,createDate,name);
		
		String sqlCheckReservation = "SELECT reservation_id FROM reservation WHERE name=? AND site_id=? AND from_date=? AND to_date=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCheckReservation,name,siteId,fromDate,toDate);
		
		if(results.next()) {
			return results.getInt("reservation_id");
		}
		return 0;
		
	}
//// This is the required method from the interface. Hence the override
	@Override
	public List<Reservation> viewReservations() {
		// TODO Auto-generated method stub
		return null;
	}

}
