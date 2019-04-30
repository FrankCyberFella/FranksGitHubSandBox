package com.techelevator.campground;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCampgroundDAO implements CampgroundDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	private Campground mapRowToCampground(SqlRowSet results) {
		Campground theCampground;
		theCampground = new Campground();

		theCampground.setCampground_id(results.getInt("campground_id"));
		theCampground.setName(results.getString("name"));
		theCampground.setOpen_from_mm(results.getString("open_from_mm"));
		theCampground.setOpen_to_mm(results.getString("open_to_mm"));
		theCampground.setDaily_fee(results.getDouble("daily_fee"));
		return theCampground;
	}

	@Override
	public List<Campground> getCampgroundInformationById(int id) {
		Campground gotCampground = new Campground();
		List<Campground> campList = new ArrayList<Campground>();
		String row = "SELECT * " + " FROM campground " + " WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row, id);
		while (results.next()) {
			gotCampground = mapRowToCampground(results);
			campList.add(gotCampground);
		}
		return campList;

	}

	public List<Integer> searchCampExists(int id) {

		List<Integer> intList = new ArrayList<Integer>();
		Campground newCamp;
		String campgroundStatement = "SELECT * " + " FROM campground " + " WHERE park_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(campgroundStatement, id);

		while (results.next()) {
			newCamp = mapRowToCampground(results);
			intList.add(newCamp.getCampground_id());
		}

		return intList;

	}

	public void displayCampground(int id) {

		System.out.println();
		System.out.printf("%-20s %-30s %-15s %-15s %-10s\n", "Campground Number", "Name", "Open Month", "Close Month",
				"Daily Fee");
		System.out.println(
				"----------------------------------------------------------------------------------------------");

		for (Campground camp : getCampgroundInformationById(id)) {
			System.out.printf("%-20d %-30s %-15s %-15s $%-10.2f\n", camp.getCampground_id(), camp.getName(),
					camp.getOpen_from_mm(), camp.getOpen_to_mm(), camp.getDaily_fee());
		}

	}
}
