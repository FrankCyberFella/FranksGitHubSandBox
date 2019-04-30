package com.techelevator.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public Park getParkInformationById(int id) {
		Park gotPark = new Park();
		String row = "SELECT * " + " FROM park " + " WHERE ? = park_id ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row, id);
		while (results.next()) {
			gotPark = mapRowToPark(results);
		}
		return gotPark;

	}

	public void displayParkInfo(int id) {

		Park park = getParkInformationById(id);

		System.out.println();
		System.out.println(park.getName());
		System.out.println();
		System.out.printf("%-20s %-20s\n", "Location:", park.getLocation());
		System.out.printf("%-20s %-20s\n", "Established:", park.getEstablish_date().toString());
		System.out.printf("%-20s %-1s\n", "Area:", String.format("%,d", park.getArea()) + " sq km");
		System.out.printf("%-20s %-20s\n", "Annual Visitors:", String.format("%,d", park.getVisitors()));
		System.out.println();
		System.out.println(park.getDescription());
		System.out.println();

	}

	public List<Park> getParks() {
		Park gotPark = new Park();
		List<Park> parkList = new ArrayList<Park>();
		String row = "SELECT * " + " FROM park ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while (results.next()) {
			gotPark = mapRowToPark(results);
			parkList.add(gotPark);
		}
		return parkList;

	}

	private Park mapRowToPark(SqlRowSet results) {
		Park thePark;
		thePark = new Park();
		thePark.setPark_id(results.getInt("park_id"));
		thePark.setName(results.getString("name"));
		thePark.setLocation(results.getString("location"));
		thePark.setEstablish_date(results.getDate("establish_date").toLocalDate());
		thePark.setArea(results.getInt("area"));
		thePark.setVisitors(results.getInt("visitors"));
		thePark.setDescription(results.getString("description"));
		return thePark;
	}

}
