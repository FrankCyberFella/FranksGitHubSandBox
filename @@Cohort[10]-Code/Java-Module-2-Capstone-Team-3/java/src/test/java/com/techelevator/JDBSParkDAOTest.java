package com.techelevator;

import static org.junit.Assert.assertEquals;

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
import com.techelevator.park.Park;


public class JDBSParkDAOTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCParkDAO dao;

	
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
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	@Before
	public void setup() {
		String sqlInsertPark = "INSERT INTO park (name, location, establish_date, area, visitors, description) VALUES( 'National Park', 'Ohio','2019-02-28', 55555, 7777777, 'Park Description') " 
								;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(sqlInsertPark);
		dao = new JDBCParkDAO(dataSource);
		
	}
	

	@Test
	public void get_Park_Information_Test() {
		Park newPark = new Park();
		newPark = dao.getParkInformation("National Park");
		
		assertEquals("National Park", newPark.getName());
		assertEquals("Ohio", newPark.getLocation());
		assertEquals(LocalDate.parse("2019-02-28"), newPark.getEstablishDate());
		
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
	
	private void assertParksAreEqual(Park expected, Park actual) {
		assertEquals(expected.getParkId(), actual.getParkId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getLocation(), actual.getLocation());
		assertEquals(expected.getEstablishDate(), actual.getEstablishDate());
		assertEquals(expected.getArea(), actual.getArea());
		assertEquals(expected.getVisitors(), actual.getVisitors());
		assertEquals(expected.getDescription(), actual.getDescription());




	}
}
