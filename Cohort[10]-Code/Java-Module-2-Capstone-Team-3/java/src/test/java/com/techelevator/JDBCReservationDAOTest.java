package com.techelevator;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.park.JDBCParkDAO;
import com.techelevator.reservation.JDBCReservationDAO;
import com.techelevator.site.Site;

public class JDBCReservationDAOTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCReservationDAO dao;

	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	@Before
	public void setup() {
//		String sqlInsertReservation = "INSERT INTO reservation ( site_id, name, from_date, to_date, create_date)" 
//									+ "VALUES (285, 'Reservation Name', '2019-02-28', '2019-03-01', '2019-01-01')" 
//								;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		jdbcTemplate.batchUpdate(sqlInsertReservation);
		dao = new JDBCReservationDAO(dataSource);
		
	}
	
//	@Test 
//	public void create_reservation_tes() {
//		Site site = new Site();
//		createTheReservation(site, "Reservation Name", LocalDate.parse("2019-02-28"), LocalDate.parse("2019-03-01"));
//		
//	}
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	protected DataSource getDataSource() {
		return dataSource;
	}
}
