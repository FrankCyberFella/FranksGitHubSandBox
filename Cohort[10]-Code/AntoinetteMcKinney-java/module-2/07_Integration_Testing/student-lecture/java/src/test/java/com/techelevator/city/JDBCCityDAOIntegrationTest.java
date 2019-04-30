package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ"; // constant( word final) that may be used in any test
														// global constant (global variable)
														// static - anyone in class can reference it

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao; // defined the dao

	/*
	 * Before any tests are run, this method initializes the datasource for testing.
	 */
	@BeforeClass // things you want to do once before testes run
	public static void setupDataSource() {// 1. this is setting up the data source only need once
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass // things once after dest
	public static void closeDataSource() throws SQLException {
		dataSource.destroy(); // 2. when all done we ternimate it this disconnects
	}

	// 3. use @Before
	@Before // put data in database before method is run
	public void setup() {
		// column
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		dao = new JDBCCityDAO(dataSource);
	}

	/*
	 * After each test, we rollback any changes that were made to the database so
	 * that everything is clean for the next test
	 */
	// 4. Rollback
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test // testing the save method. Create a new city, save it, and read it
	// put in table then read out table

	public void save_new_city_and_read_it_back() throws SQLException {
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);
		// getCity is city tried to add
		dao.save(theCity);
		City savedCity = dao.findCityById(theCity.getId());
		// test to make sure findCityById was right. the method using to test.
		// test all the finds

		assertNotEquals(null, theCity.getId()); // (ensure) make sure row is in table.
		assertCitiesAreEqual(theCity, savedCity); // (makes sure city retrived from table has same values
													// as what we thought we wrote (insert)
	}

	@Test
	public void returns_cities_by_country_code() { // testig for multiple cities
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		dao.save(theCity);
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);// find using test country code

		assertNotNull(results); // make sure row is in table
		assertEquals(1, results.size()); // make sure ther is only one row
		City savedCity = results.get(0); // the "0" get the first city object in the list that was returned by
											// findCityByCountry
		assertCitiesAreEqual(theCity, savedCity); // Verify the City retrived is the one we created and save'd
	}

	@Test
	public void returns_multiple_cities_by_country_code() {

		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));

		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		assertNotNull(results);
		assertEquals(2, results.size());
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator"; // local test
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
	// These are only used for testing. This is a common processing. Create a method
	// apart of test code to call
	// This method constructs a City object.

	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

// needed to determin if citys are equal. So instead of repeating asserts. create a method so do not 
	// need to repeat data
	// passed to cities the assert will tell is the expected city value
	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
