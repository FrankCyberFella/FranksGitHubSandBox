package com.techelevator.site;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.Campground;
import com.techelevator.park.Park;

public class JDBCSiteDAO implements SiteDAO {

	private JdbcTemplate jdbcTemplate;
	public Site site = new Site();

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Site> listOfSites(Long id, String beginDate, String departureDate) {
		Site site = new Site();
		List<Site> sites = new ArrayList<>();
		LocalDate d1 = LocalDate.parse(beginDate);
		LocalDate d2 = LocalDate.parse(departureDate);
		String sqlDisplaySites = "SELECT * " + "FROM site " + " WHERE campground_id = ? AND  site_id NOT IN "
				+ "(SELECT site_id FROM reservation " + "WHERE (( to_date BETWEEN ? AND ? ) "
				+ "OR (from_date BETWEEN ? AND ? )) " + ") LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDisplaySites, id, d1, d2, d1, d2);
		while (results.next()) {
			site = mapRowToSite(results);
			sites.add(site);
		}
		return sites;
	}

	@Override
	public double costOfStay(String beginDate, String departureDate) {
		int dayDiff = 0;
		LocalDate d1 = LocalDate.parse(beginDate);
		LocalDate d2 = LocalDate.parse(departureDate);
		String numOfDays = "SELECT ? - ? " + "FROM reservation ";
		SqlRowSet countOfDays = jdbcTemplate.queryForRowSet(numOfDays, d2, d1);
		while (countOfDays.next()) {
			dayDiff = countOfDays.getInt(1) + 1;
			return dayDiff;
		}
		return dayDiff;
	}

	private Site mapRowToSite(SqlRowSet results) {
		Site site = new Site();
		site.setSiteId(results.getLong("site_id"));
		site.setCampgroundId(results.getLong("campground_id"));
		site.setSiteNumber(results.getInt("site_number"));
		site.setMaxOccupancy(results.getInt("max_occupancy"));
		site.setAccessible(results.getBoolean("accessible"));
		site.setMaxRvLength(results.getInt("max_rv_length"));
		site.setUtilities(results.getBoolean("utilities"));
		return site;
	}
}
