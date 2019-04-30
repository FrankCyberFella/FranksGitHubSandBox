package com.techelevator.site;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO implements SiteDAO{
	
private JdbcTemplate JdbcTemplate;
	
	public JDBCSiteDAO(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Site> getAllSites() {
		return null;
	}
	
	@Override
	public List<Site> getAvailableSites(String parkName, Campground campToReserve, String arrivalDate,String departureDate) {
		
		//Convert out string dates to localDates
		String[] splitDate = arrivalDate.split("-");
		LocalDate larrivalDate = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
		splitDate = departureDate.split("-");
		LocalDate ldepartureDate = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
		
		Site theSite = null;
		List<Site> allSites = new ArrayList<Site>();
		
		String sqlAvailableSites = "SELECT site.site_id, site.campground_id, site.site_number, site.max_occupancy, site.accessible, site.max_rv_length, site.utilities " +
								  "FROM site " + 
								  "INNER JOIN campground " +
								  "ON site.campground_id = campground.campground_id " + 
								  "INNER JOIN park " + 
								  "ON park.park_id = campground.park_id " + 
								  "WHERE site.site_id NOT IN (SELECT reservation.site_id FROM reservation WHERE (reservation.from_date >= ? AND reservation.from_date <= ?) " + 
								  "OR (reservation.to_date >= ? AND reservation.to_date <= ?)) " + 
								  "and park.name = ? " + 
								  "AND campground.campground_id = ? ";
		
		SqlRowSet results = JdbcTemplate.queryForRowSet(sqlAvailableSites, larrivalDate, ldepartureDate,larrivalDate,ldepartureDate, parkName, campToReserve.getCampgroundId());
		while(results.next()) {
			theSite = mapRowToSite(results);
			
			allSites.add(theSite);
		}
		
		return allSites;
	}
	
	private Site mapRowToSite(SqlRowSet results) {
	Site theSite = new Site();
	theSite.setSiteId(results.getLong("site_id"));
	theSite.setCampId(results.getLong("campground_id"));
	theSite.setSiteNum(results.getLong("site_number"));
	theSite.setMaxOccupancy(results.getInt("max_occupancy"));
	theSite.setAccessible(results.getBoolean("accessible"));
	theSite.setMaxRvLength(results.getInt("max_rv_length"));
	theSite.setHasUtil(results.getBoolean("utilities"));
	
	return theSite;
	}



}
