package com.techelevator.Park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		// TODO Auto-generated method stub
		List<Park> parks  = new ArrayList<>();
		String sqlFindPark = "SELECT park_id, name, location, establish_date, area, visitors, description " +
							 "FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindPark);
		while(results.next()) {
			Park park = mapRowToPark(results);
			parks.add(park);
		}
		 return parks;
	}
	
	@Override
	public List<String> getAllParkNames() {
		// TODO Auto-generated method stub
		List<String> parkNames  = new ArrayList<>();
		String sqlFindPark = "SELECT name " +
							 "FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindPark);
		while(results.next()) {
			String parkName = mapParkName(results);
			parkNames.add(parkName);
		}
		 return parkNames;
	}


	@Override
	public void selectPark() {
		// TODO Auto-generated method stub
		
	}
	
	public void showParkDescription(String parkSearch){
		List<Park> parks = new ArrayList<>();
		String sqlFindParkInfo = "SELECT park_id, name, location, establish_date, area, visitors, description " +
				 "FROM park " +
				 "WHERE name = ?";
		
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindParkInfo, parkSearch);
		 while(results.next()) {
			 Park park = mapRowToPark(results);
			 parks.add(park);
		 }
		System.out.println("Park Information Screen");
		System.out.println(parks.get(0).getName() + " National Park");
		System.out.printf("%-20s %-15s \n", "Location", parks.get(0).getLocation());
		System.out.printf("%-20s %-15s \n", "Established:", parks.get(0).getEstablishDate().toString());
		System.out.printf("%-20s %-15d \n", "Area" ,parks.get(0).getArea());
		System.out.printf("%-20s %-15d\n","Annual Visitors",parks.get(0).getVisitors());
		System.out.println("\n");
		System.out.printf(parks.get(0).getDescription());
	 }
	 
	
	public Park mapRowToPark(SqlRowSet results) {
		Park park;
		park = new Park();
		park.setParkId(results.getInt("park_id"));
		park.setName(results.getString("name"));
		park.setLocation(results.getString("location"));
		park.setEstablishDate(results.getDate("establish_date").toLocalDate());
		park.setArea(results.getInt("area"));
		park.setVisitors(results.getInt("visitors"));
		park.setDescription(results.getString("description"));
		
		return park;
	}
	
	public String mapParkName(SqlRowSet results) {
		String parkName;
		parkName = results.getString("name");
		return parkName;
	}

}
