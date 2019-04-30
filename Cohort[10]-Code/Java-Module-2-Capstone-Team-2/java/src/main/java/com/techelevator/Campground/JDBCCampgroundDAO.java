package com.techelevator.Campground;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Park.Park;

public class JDBCCampgroundDAO implements CampgroundDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	
		public List<Campground> showAllCampgrounds() {
			// TODO Auto-generated method stub
			return null;
		
	}
	public void showCampground(int parkId){
		List<Campground> campgrounds = new ArrayList<>();
		String sqlFindCampgrounds = "SELECT campground_id, c.name, open_from_mm, open_to_mm, daily_fee " + 
				"FROM campground c inner join park p on p.park_id = c.park_id " +
				"Where c.park_id = ? ";
		int counter =0;
		
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCampgrounds, parkId);
		 while(results.next()) {
			 Campground campground = mapRowToCampground(results);
			 campgrounds.add(campground);
			 
		 }
		System.out.println("Park Campgrounds");
		System.out.printf("%-5s %-32s %-15s %-15s %-15s \n", " ", "Name", "Open", "Close", "Daily Fee");
		for(Campground campground : campgrounds) {
			counter++;
			System.out.printf("%-5s %-32s %-15s %-15s $%.2f \n" , "#"+counter, campground.getName(), campground.getOpenFromDate(), 
					campground.getOpenToDate(), campground.getDailyFee());
			}
		}
	
	
		public List<String> showCampgroundNames(int parkId){
		List<String> campgrounds = new ArrayList<>();
		String sqlFindCampgrounds = "SELECT c.name " + 
				"FROM campground c inner join park p on p.park_id = c.park_id " +
				"Where c.park_id = ? ";
		
		
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCampgrounds, parkId);
		 while(results.next()) {
			 String campground = mapRowToCampgroundName(results);
			 campgrounds.add(campground);
			 }
		 return campgrounds;
		}	

	
		public List<Campground> campGroundsToString(int parkId){
			List <Campground> campgrounds = new ArrayList<>();
			String sqlFindCampgrounds = "SELECT campground_id, c.name, open_from_mm, open_to_mm, daily_fee " + 
					"FROM campground c inner join park p on p.park_id = c.park_id " +
					"Where c.park_id = ? ";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCampgrounds, parkId);
			 while(results.next()) {
				 Campground campground = mapRowToCampground(results);
				 campgrounds.add(campground);
			 }
			  return campgrounds;
			}
		
		
		
		
	
	 
	public Campground mapRowToCampground(SqlRowSet results) {
		Campground campground;
		campground = new Campground();
		campground.setCampgroundId(results.getInt("campground_id"));
		campground.setName(results.getString("name"));
		campground.setOpenFromDate(results.getString("open_from_mm"));
		campground.setOpenToDate(results.getString("open_to_mm"));
		campground.setDailyFee(results.getDouble("daily_fee"));
		
		return campground;
	}
	public String mapRowToCampgroundName(SqlRowSet results) {
		String campground;
		campground= results.getString("name");
		return campground;
	}
	@Override
	public void selectCampground() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> showAvailableDates() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getParkName(String parkName) {
		List<Campground> campgrounds = new ArrayList<>();
		String SqlParkName = "Select p.name " +
							 "From park p inner join campground c on p.park_id = c.park_id " +
							 "Where c.park_id = ? " +
							 "group by p.name ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(SqlParkName, parkName);
		 while(results.next()) {
			 Campground campground = mapRowToCampground(results);
			 campgrounds.add(campground);
		 }
		return campgrounds.toString();
		 
	}
}
