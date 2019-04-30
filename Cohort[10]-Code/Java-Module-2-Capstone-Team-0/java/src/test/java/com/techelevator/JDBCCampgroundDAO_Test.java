package com.techelevator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;
import com.techelevator.campground.JDBCCampgroundDAO;
import com.techelevator.park.Park;

public class JDBCCampgroundDAO_Test {

	//first variable is DAOIntgrationTest
	private JDBCCampgroundDAO campground; //called the class
	private static DAOIntegrationTest integration;
	private Park park;  // park class from JDBCCampgroundDAO
	private JdbcTemplate jdbcTemplate;
	private static SingleConnectionDataSource dataSource;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//integration.setupDataSource();	//setupBeforClass is establishing a connection to database 
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground_test");
		dataSource.setUsername("postgres");
		dataSource.setPassword("dimples");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
		
		
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//integration.closeDataSource(); //tearDownAfterClass is disconnecting the databae
		dataSource.destroy();
	
	}

	@Before
	public void setUp() throws Exception {
		// setting up database connection
		 // copied line 20 from JDBCCampgroundDAO
		park = new Park();
		jdbcTemplate = new JdbcTemplate(dataSource);
		campground = new JDBCCampgroundDAO(dataSource);
	
	
	}

	@After
	public void tearDown() throws Exception {
		//integration.rollback();// when done with test rollback will undo any changes 
		dataSource.getConnection().rollback();
	}

	@Test
	public void electCampgroundByParkIdTest() {
		int parkID = 1; // 1 value is for  the park Acadia
		//copied from JDBCCmpground to make sure method works
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sqlSelectCampgroundByParkId = "SELECT * FROM campground WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCampgroundByParkId,parkID);
		while(results.next()) {
			Campground theCampground = mapRowToCampground(results);
			campgrounds.add(theCampground);
		}
						//expected size should match                    actual campground size
		assertEquals("The expected size of the list should match the actual size, check database.",campgrounds.size(), campground.selectCampgroundByParkId(parkID).size());
		
	}
	//copied from JDBCCmpground to make sure method works
	private Campground mapRowToCampground(SqlRowSet results) {
		Campground theCampground = new Campground();
		theCampground.setCampgroundId(results.getInt("campground_id"));
		theCampground.setParkId(results.getInt("park_id"));
		theCampground.setDailyFee(results.getDouble("daily_fee"));
		theCampground.setName(results.getString("name"));
		theCampground.setOpenFromMm(results.getString("open_from_mm"));
		theCampground.setOpenToMm(results.getString("open_to_mm"));
		
		return theCampground;
	}
}
