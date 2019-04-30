package com.techelevator.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO{
	
private JdbcTemplate JdbcTemplate;
	
	public JDBCParkDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		Park thePark = null;
		List<Park> parkList = new ArrayList<Park>();
		
		String sqlListAllParks = "Select * " +
								"From park " +
								"order by name";
		
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlListAllParks);
		
		while (results.next()) {
			
			thePark = mapRowToPark(results);
			parkList.add(thePark);
			
		}
		return parkList;
	}

	@Override
	public List<String> displayParkInfo() {
		return null;
	}
	
	@Override
	public void getParkInfoByName(String parkName) {
		Park thePark = null;
		String sqlFindPark = "select * " +
							"from park " +
							"where name = ?";
		
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlFindPark, parkName);
		results.next();
		thePark = mapRowToPark(results);
		//*********************************************************
		//insert dates later, not the fruity kind
		System.out.println(thePark.getName());
		System.out.println("Location:        " + thePark.getLocation());
		System.out.println("Established:     *****"  );
		System.out.println("Area:            " + thePark.getArea());
		System.out.println("Annual Visitors: " + thePark.getVisitors());
		System.out.println();
		//**********************************************************8
		// worry about words ending on each line
		for (int i = 0 ; i < thePark.getDescription().length() ; i += 50) {
			int holder = 0;
			if (thePark.getDescription().length() > i + 50) {
				System.out.println(thePark.getDescription().substring(i,i+50));
			} else {
				holder = thePark.getDescription().length() % 50;
				System.out.println(thePark.getDescription().substring(i));
			}
			
		}
		
		
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		
		Park thePark = new Park();
		thePark.setParkId(results.getLong("park_id"));
		thePark.setName(results.getString("name"));
		thePark.setLocation(results.getString("location"));
		thePark.setArea(results.getInt("area"));
		thePark.setVisitors(results.getInt("visitors"));
		thePark.setDescription(results.getString("description"));
		
		return thePark;
		
		
	}

	

}
