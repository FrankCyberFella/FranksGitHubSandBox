package com.techelevator.campground;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.Month;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.park.Park;

public class JDBCCampgroundDAO implements CampgroundDAO{
	private JdbcTemplate jdbcTemplate;
	
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//A method that returns a list of campgrounds
	@Override 
	public List<Campground>selectCampgroundByParkId(int parkID) {
	// instantiate the array list
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sqlSelectCampgroundByParkId = "SELECT * FROM campground WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCampgroundByParkId,parkID);
		while(results.next()) {
			Campground theCampground = mapRowToCampground(results);
			campgrounds.add(theCampground);
		}
		return campgrounds;
		
	}
	
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
	
	//This method will go through an ArrayList of campgrounds and turn it into an ArrayList of strings of the name of the park
	public List<String> getCampgroundNames(List<Campground> campgrounds,Park thePark) {
		Date openMonth = new Date();
		
		List<String> campGroundName = new ArrayList<String>();
		System.out.println(thePark.getName()+" National Park Campgrounds\n");
		
		System.out.println(String.format("%-8s%-36s%-12s%-12s%s"
				," "
				,"NAME"
				,"OPEN FROM"
				,"OPEN TO"
				,"DAILY FEE"));
		
		for(Campground theCampGround:campgrounds) {
			String campDeets = String.format("%-8s%-36s%-12s%-12s$%.2f"
											,"#"+theCampGround.getCampgroundId()
											,theCampGround.getName()
											,Month.of(Integer.parseInt(theCampGround.getOpenFromMm())).name()
											,Month.of(Integer.parseInt(theCampGround.getOpenToMm())).name()
											,theCampGround.getDailyFee());
			campGroundName.add(campDeets);
			System.out.println(campDeets);
		}
	
		return campGroundName;
	}
	
}
