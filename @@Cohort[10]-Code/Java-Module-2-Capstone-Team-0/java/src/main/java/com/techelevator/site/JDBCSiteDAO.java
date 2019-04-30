package com.techelevator.site;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;
import com.techelevator.park.Park;
// created class JDBCSiteDAO 
public class JDBCSiteDAO implements SiteDAO{

	private JdbcTemplate jdbcTemplate;
	// created constructor with DataSource as Datatype within the parameters. 
	public JDBCSiteDAO(DataSource dataSource) {
		//instantate JdbcTemplate
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override //// This is the required method from the interface.
	public List<Site> selectAvilableSitesbyCampgroundId(int campgroundId, LocalDate startDate, LocalDate endDate) {
		List<Site> sitesAvailable = new ArrayList<Site>();
														// Sql query to select all columns from table site and do a 
														//full outer join of table 
														// site and reservation. This will allow rows without reservations
														// in the reservation table to be populated with null values.
		String sqlSelectAvailabelSitesByCampgroundId = "SELECT * FROM site "+ 
														"WHERE campground_id = ? "+
														"AND site_id NOT IN (SELECT site_id FROM reservation "+
														"WHERE from_date BETWEEN ? AND ? "+
														"OR to_date BETWEEN ? AND ? ) "+
														"ORDER BY site_id "+
														"LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAvailabelSitesByCampgroundId,campgroundId, startDate, endDate,startDate,endDate);
		while(results.next()) {
				 Site theSite = mapRowToSite(results);
				sitesAvailable.add(theSite);
	
		}
		return sitesAvailable;
	}
	
	public List<String> getSiteDescriptions(List<Site> sites,Campground theCampground,LocalDate startDate, LocalDate endDate){
		List<String> siteDescriptions = new ArrayList<String>();
		
		System.out.printf("\n%-12s%-12s%-16s%-16s%-16s%-12s\n"
				,"Site No."
				,"Max Occup."
				,"Accessible?"
				,"Max RV Length"
				,"Utilities"
				,"Cost");
		
		for(Site site:sites) {
			String campDeets = String.format("%-12d%-12d%-16s%-16s%-16s$%,-12.2f"
											,site.getSiteNumber()
											,site.getMaxOccupancy()
											,site.isAccessible() ? "Yes":"No"
											,site.getMaxRvLength()==0 ? "N/A" : site.getMaxRvLength()
											,site.isUtilities() ? "Yes":"N/A"
											,theCampground.getDailyFee()*(endDate.toEpochDay()-startDate.toEpochDay()));
			siteDescriptions.add(campDeets);
			System.out.println(campDeets);
		}
		
		
		return siteDescriptions;
	}

	private Site mapRowToSite(SqlRowSet result) {
		Site theSite = new Site();
		theSite.setCampgroundId(result.getInt("campground_id"));
		theSite.setAccessible(result.getBoolean("accessible"));
		theSite.setMaxOccupancy(result.getInt("max_occupancy"));
		theSite.setMaxRvLength(result.getInt("max_rv_length"));
	    theSite.setSiteId(result.getInt("site_id"));
	    theSite.setSiteNumber(result.getInt("site_number"));
	    theSite.setUtilities(result.getBoolean("utilities"));
	    
	    return theSite;
	   
	}
}
