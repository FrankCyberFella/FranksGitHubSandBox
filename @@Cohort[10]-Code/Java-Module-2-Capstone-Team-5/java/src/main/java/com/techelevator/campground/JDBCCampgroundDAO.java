package com.techelevator.campground;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.park.Park;




public class JDBCCampgroundDAO implements CampgroundDAO {
	
	 private Long id;
	
	private JdbcTemplate jdbcTemplate;
	public Campground campground = new Campground();

	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// method to put the campgrounds into a list
	@Override
	public List<Campground> seeAllCampgrounds(Park park) {
			ArrayList<Campground> campgroundList = new ArrayList<>();
			String sqlDisplayCampgrounds = "SELECT * " + "FROM campground " + "WHERE park_id = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayCampgrounds, park.getParkId());
			while (results.next()) {
				Campground campground = mapRowToCampground(results);
				campgroundList.add(campground);
			}
			return campgroundList;
	}
	
	//method to retrieve the campground being selected by the user
	public Campground getTheCampground(Long id) {
		Campground campground = new Campground();
		String sqlDisplayCampground = "SELECT * " + "FROM campground " + "WHERE campground_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplayCampground, id);
		while (results.next()) {
		campground = mapRowToCampground(results);
		return campground;
		}
	return campground;
	}
	
	private Campground mapRowToCampground(SqlRowSet results) {
		Campground campground = new Campground();
		campground.setCampgroundId(results.getLong("campground_id"));
		campground.setParkId(results.getLong("park_id"));
		campground.setName(results.getString("name"));
		campground.setOpenFrom(results.getString("open_from_mm"));
		campground.setOpenTo(results.getString("open_to_mm"));
		campground.setDailyFee(results.getDouble("daily_fee"));
		return campground;
	}
	
}
