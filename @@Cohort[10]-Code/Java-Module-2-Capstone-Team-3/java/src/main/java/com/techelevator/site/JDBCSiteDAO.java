package com.techelevator.site;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;


public class JDBCSiteDAO implements SiteDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Site> getAvailableSiteByDate(int campgroundId, String arrivalDate, String departureDate, int amountOfDays){
		List<Site> availableSites = new ArrayList<Site>();
		String sqlFindAvailableSites = "SELECT *, (? * campground.daily_fee :: numeric) AS cost FROM site " +
									 "INNER JOIN campground ON campground.campground_id = site.campground_id "+
									 "WHERE site.campground_id = ? " +
									 "AND site.site_id NOT IN (SELECT site_id FROM reservation " + 
									 "WHERE (reservation.from_date >= ? AND reservation.from_date <= ? ) OR (reservation.to_date >= ? AND reservation.to_date <= ?))"+
									 "LIMIT 5";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAvailableSites, amountOfDays, campgroundId, LocalDate.parse(arrivalDate), LocalDate.parse(departureDate), LocalDate.parse(arrivalDate), LocalDate.parse(departureDate));
		
		while(results.next()) {
			Site site = mapRowToSite(results);
			availableSites.add(site);
		}
		if(availableSites.size() > 0) {
			int i = 1;
			DecimalFormat format = new DecimalFormat("#0.00");
			Campground campName = new Campground();
			String siteNumber = "SITE NUMBER";
			String maxOccupancy = "MAX OCCUPANCY";
			String accessible = "ACCESSIBLE?";
			String rvLength = "MAX RV LENGTH";
			String utility = "UTILITIES?";
			String cost = "COST";
			System.out.printf(String.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", siteNumber, maxOccupancy, accessible, rvLength, utility, cost));
			for(Site site : availableSites) {
				System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",i+ ") "+ site.getSiteNumber(), site.getMaxOccupancy(), site.isAccessible(), site.getMaxRvLength(), site.isUtilities(), "$" + format.format(site.getCost()));
				i++;
			}
		}
		return availableSites;	
	}


	
//*************************************ADVANCED SEARCH OPTIONS*****************************//
//	public List<Site> getAvailableSiteByDate(int campgroundId, String arrivalDate, String departureDate, int amountOfDays, int maxOccupancy, int accessible, int rvLength, int utilities){
//	
//	String sqlFindAvailableSites = "SELECT *, (? * campground.daily_fee) AS cost FROM site " + 
//									"INNER JOIN campground ON campground.campground_id = site.campground_id " + 
//									"WHERE site.campground_id = ? " + 
//									"AND site.max_occupancy >= ? AND  site.accessible = ? AND site.max_rv_length >= ? AND site.utilities = ?  " + 
//									"AND site.site_id NOT IN (SELECT site_id FROM reservation " + 
//									"WHERE (reservation.from_date >= ? AND reservation.from_date <= ? ) OR (reservation.to_date >= ? AND reservation.to_date <= ?)) " + 
//									"LIMIT 5";
//		
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAvailableSites, amountOfDays, campgroundId, maxOccupancy, accessible, rvLength, utilities, LocalDate.parse(arrivalDate), LocalDate.parse(departureDate), LocalDate.parse(arrivalDate), LocalDate.parse(departureDate));
//																	
//		while(results.next()) {
//			Site site = mapRowToSite(results);
//			availableSites.add(site);
//		}
//		if(availableSites.size() > 0) {
//			int i = 1;
//			DecimalFormat format = new DecimalFormat("#0.00");
//			Campground campName = new Campground();
//			String siteNumber = "SITE NUMBER";
//			String maxOccupancyTitle = "MAX OCCUPANCY";
//			String accessibleTitle = "ACCESSIBLE?";
//			String rvLengthTitle = "MAX RV LENGTH";
//			String utility = "UTILITIES?";
//			String cost = "COST";
//			System.out.printf(String.format("%-15s%-15s%-15s%-15s%-15s%-15s\n", siteNumber, maxOccupancyTitle, accessibleTitle, rvLengthTitle, utility, cost));
//			for(Site site : availableSites) {
//				System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",i+ ") "+ site.getSiteNumber(), site.getMaxOccupancy(), site.isAccessible(), site.getMaxRvLength(), site.isUtilities(), "$" + format.format(site.getCost()));
//				i++;
//			}
//		}
//		return availableSites;
//	}
	
	
	@Override
	public boolean isAccessible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Map returned site rows to site objects
	private Site mapRowToSite(SqlRowSet results) { 
		Site site = new Site();	
		site = new Site();  

		site.setSiteId(results.getLong("site_id"));
		site.setCampgroundId(results.getInt("campground_id"));
		site.setSiteNumber(results.getInt("site_id"));
		site.setMaxOccupancy(results.getInt("max_occupancy"));
		site.setAccessible(results.getBoolean("accessible"));
		site.setMaxRvLength(results.getInt("max_rv_length"));
		site.setUtilities(results.getBoolean("utilities"));
		site.setCost(results.getDouble("cost"));

		return site;
	} 

}
