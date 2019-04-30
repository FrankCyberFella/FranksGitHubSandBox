package com.techelevator.park;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	public Park park = new Park();

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Park getParkInformation(String name) {
		Park park = new Park();
		String sqlFindPark = "SELECT * "
							+ "FROM park  "
							+ "WHERE name = ? ";

		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindPark, name);
		if(results.next()) {
		park = mapRowToPark(results);
		}
		System.out.println("\n" + park);
		return park;
	}

	private Park mapRowToPark(SqlRowSet results) { //ALWAYS SHOULD HAVE: create an object of the class and assign
		Park park = new Park();	//Define an Obj to return   // assign the results form the SQL statement
//		employee = new Employee();  //Instantiate object to return (run constructor)
		
			park.setName(results.getString("name"));
			park.setLocation(results.getString("location"));
			park.setEstablishDate(results.getDate("establish_date").toLocalDate());
			park.setArea(results.getInt("area"));
			park.setVisitors(results.getInt("visitors"));
			park.setDescription(results.getString("description"));
		
		return park; //return the object
	}
}
