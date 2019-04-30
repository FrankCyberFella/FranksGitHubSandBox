package com.techelevator.park;

import java.util.ArrayList;
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
	public List<Park> seeAllParks() {
		ArrayList<Park> parkList = new ArrayList<>();
		String sqlDisplayParks = "SELECT * " + "FROM park ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayParks);
		while (results.next()) {
			Park park = mapRowToPark(results);
			parkList.add(park);
		}
		return parkList;
	}
	
	@Override
	public Park seeSpecificPark(Long id) {
		Park park = new Park();
		String sqlDisplayParks = "SELECT * " + "FROM park " + "WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayParks, id);
		while (results.next()) {
			 park = mapRowToPark(results);
		}
		return park;
	}
	

	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkId(results.getLong("park_id"));
		park.setName(results.getString("name"));
		park.setLocation(results.getString("location"));
		park.setEstablishDate(results.getDate("establish_date").toLocalDate());
		park.setArea(results.getInt("area"));
		park.setVisitors(results.getInt("visitors"));
		park.setDescription(results.getString("description"));
		return park;
	}


}
