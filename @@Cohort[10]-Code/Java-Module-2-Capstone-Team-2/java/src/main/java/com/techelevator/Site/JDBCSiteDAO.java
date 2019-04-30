package com.techelevator.Site;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Campground.Campground;
import com.techelevator.Reservation.Reservation;
import com.techelevator.*;

public class JDBCSiteDAO implements SiteDAO {
	
	JdbcTemplate jdbcTemplate;
	
	
	
	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public void showAllAvailableSites(String campgroundName, LocalDate arrivalDate, LocalDate departureDate) {
		List <Site> availableSites = new ArrayList<>();
		String sqlFindSites = "Select site.site_id, site.max_occupancy, accessible, max_rv_length, utilities "+
				"FROM site "+
		        "full outer join "+
		        "reservation "+
		        "on site.site_id = reservation.site_id "+
		        "inner join "+
		        "campground "+
		        " on site.campground_id = campground.campground_id "+
		"WHERE campground.name = ? and reservation_id IS null or  "
		+ "campground.name = ? and (reservation.from_date  not between ? and  ?) "
		+ "AND (reservation.to_date not between ? and  ?) "+
		"GROUP BY site.site_id, site.max_occupancy, accessible, max_rv_length, utilities, campground.name "+
		"ORDER BY 1 ASC LIMIT 5 ";
				

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindSites, campgroundName, campgroundName, arrivalDate, departureDate, arrivalDate, departureDate);
		while(results.next()) {
			Site site = mapRowToSites(results);
			 availableSites.add(site);
		}
		
		
		double cost = calculateStayCost(arrivalDate, departureDate, campgroundName);
		System.out.println("Results Matching your Search Criteria");
		System.out.printf("%-10s %-20s %-15s %-15s %-15s %-15s \n", "Site No.", "Max Occup.", "Accessible?", "Max RV Length", "Utility", "Cost");
		if(availableSites.size() == 0) {
			System.out.println("Please enter an alternate date range: ");
			
		}
		for(Site site: availableSites) {
		System.out.printf("%-10s %-20s %-15s %-15s %-15s $%.2f \n", site.getSiteId(), site.getMaxOccupancy(), 
																	site.isAccessible(), site.getMaxRvLength(), site.isUtilities(), cost);
		
			
		}
	}
	
	public double calculateStayCost(LocalDate arrivalDate, LocalDate departureDate, String campgroundName) {
		double calculatedCost = 0;
		String sqlCalculate = "SELECT (? - ? + 1) * daily_fee :: numeric AS cost " +
							  "FROM campground " +
							  "WHERE name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCalculate, departureDate, arrivalDate, campgroundName);
		while(results.next()) {
			calculatedCost = mapCost(results);
		}
		return calculatedCost;
		
	}
	
	public Site mapRowToSites(SqlRowSet results) {
			Site site;
			Campground campground = new Campground();
			
			site = new Site();
			site.setSiteId(results.getInt("site_id"));
			site.setMaxOccupancy(results.getInt("max_occupancy"));
			site.setAccessible(results.getBoolean("accessible"));
			site.setMaxRvLength(results.getInt("max_rv_length"));
			site.setUtilities(results.getBoolean("utilities"));
			return site;
	
		}
	
	public double mapCost(SqlRowSet results) {
		double cost;
		cost = results.getDouble("cost");
		return cost;
	}



}
	
	
	


