package com.techelevator.site;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO implements SiteDAO {

	private JdbcTemplate jdbcTemplate;
	
	List<Site> siteList = new ArrayList<Site>();




	public JDBCSiteDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	private Site mapRowToSite(SqlRowSet results) {
		Site theSite;
		theSite = new Site();

		theSite.setCampground_id(results.getInt("campground_id"));
		theSite.setSite_id(results.getInt("site_id"));
		theSite.setSite_number(results.getInt("site_number"));
		theSite.setMax_occupancy(results.getInt("max_occupancy"));
		theSite.setAccessible(results.getBoolean("accessible"));
		theSite.setMax_rv_length(results.getInt("max_rv_length"));
		theSite.setUtilities(results.getBoolean("utilities"));

		return theSite;
	}

	@Override
	public void listSites(int id, LocalDate d1, LocalDate d2) {
		
		Site newSite = new Site();
		int days = numberOfDays(d1, d2);
		String totalCost = "SELECT (daily_fee * ?) AS cost FROM campground WHERE campground.campground_id = ?";
		SqlRowSet costResults = jdbcTemplate.queryForRowSet(totalCost, days, id);
		double stayCost = 0;
		while (costResults.next()) {
			stayCost = costResults.getDouble("cost");
		}
		String sites = "SELECT * FROM site\n" + "JOIN campground\n"
				+ "ON site.campground_id = campground.campground_id\n" + "\n" + "WHERE site.campground_id = ? \n" + "\n"
				+ "AND (((site.site_id  NOT IN (SELECT reservation.site_id FROM reservation WHERE (from_date  BETWEEN ? AND ?)))\n"
				+ "AND (site.site_id  NOT IN (SELECT reservation.site_id FROM reservation WHERE (to_date  BETWEEN ? AND ?))))\n"
				+ ")\n" + "\n" + "ORDER BY site.site_id\n" + "LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sites, id, d1, d2, d1, d2);
		siteList.clear();
		while (results.next()) {
			newSite = mapRowToSite(results);
			siteList.add(newSite);
		}
		System.out.println("\nResults Matching Your Criteria\n");
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Site No.", "Max Occup.", "Accessible?",
				"Max RV Length", "Utility", "Cost");
		for (Site site : siteList) {
			System.out.printf("%-20d %-20d %-20b %-20d %-20b %-20.2f\n", site.getSite_number(), site.getMax_occupancy(),
					site.isAccessible(), site.getMax_rv_length(), site.isUtilities(), stayCost);
		}

	}

	public int numberOfDays(LocalDate from, LocalDate to) {
		int counter = 0;
		while (from.isBefore(to)) {
			counter++;
			from = from.plusDays(1);
		}
		return counter;
	}
}
