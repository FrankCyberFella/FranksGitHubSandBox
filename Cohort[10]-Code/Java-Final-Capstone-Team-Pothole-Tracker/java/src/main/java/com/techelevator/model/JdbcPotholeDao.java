package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcPotholeDao implements PotholeDao{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcPotholeDao(DataSource datasource) {
		 this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Pothole> getAllPotholes() {
		Pothole getPotholes = new Pothole();
		List<Pothole> potholeList = new ArrayList<Pothole>();
		String row = "SELECT * FROM potholes ORDER BY pothole_id ASC ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while (results.next()) {
			getPotholes = mapRowToPothole(results);
			potholeList.add(getPotholes);
		}
		return potholeList;
	}
	
	@Override
	public List<Pothole> getAllPotholesInspectedReported() {
		Pothole getPotholesIR = new Pothole();
		List<Pothole> potholeListIR = new ArrayList<Pothole>();
		String row = "SELECT * FROM potholes WHERE repair_status = 'Reported' OR repair_status = 'Inspected'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while (results.next()) {
			getPotholesIR = mapRowToPothole(results);
			potholeListIR.add(getPotholesIR);
		}
		return potholeListIR;
	}
	
	@Override
	public List<Pothole> getAllPotholesRepaired() {
		Pothole getPotholesRepaired = new Pothole();
		List<Pothole> potholeListRepaired = new ArrayList<Pothole>();
		String row = "SELECT *, (date_fixed - date_reported) AS daysbetweenrepair FROM potholes WHERE repair_status = 'Repaired'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while (results.next()) {
			getPotholesRepaired = mapRowToTable(results);
			potholeListRepaired.add(getPotholesRepaired);
		}
		return potholeListRepaired;
	}
	
	
	@Override
	public Pothole getAPothole(Long id) {
		Pothole aPothole = new Pothole();
		String sqlGetPothole = "SELECT * FROM potholes WHERE pothole_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetPothole, id);
		while (results.next()) {
			aPothole = mapRowToPothole(results);
		}
		return aPothole;
	}
		
		
	@Override
	public void savePothole(Pothole pothole) {
//		Long id = getNextId();
		String sqlInsertPothole = "INSERT INTO potholes(location, size, date_reported, date_fixed, image, repair_status, severity, date_inspected, latitude, longitude) VALUES (?,?, CURRENT_DATE,'9999-12-31',?,'Reported',0,'9999-12-31',?,?)";
		jdbcTemplate.update(sqlInsertPothole, pothole.getLocation(), pothole.getSize(), pothole.getImage(), pothole.getLatitude(), pothole.getLongitude());
//		pothole.setPotholeId(id);
	
	}
	
	
	
	@Override
	public void updateRepairStatus(Pothole pothole) {
		String sqlUpdateRepairStatus = "UPDATE potholes SET repair_status = ? WHERE pothole_id = ?";
		jdbcTemplate.update(sqlUpdateRepairStatus, pothole.getRepairStatus(), pothole.getPotholeId());
		if(pothole.getRepairStatus().equalsIgnoreCase("repaired")) {
			String sqlUpdateRepairDate = "UPDATE potholes SET date_fixed = CURRENT_DATE, repair_status = 'Repaired' WHERE pothole_id = ? ";
			jdbcTemplate.update(sqlUpdateRepairDate, pothole.getPotholeId());

		} else if (pothole.getRepairStatus().equalsIgnoreCase("inspected")) {
			String sqlUpdateInspectedDate = "UPDATE potholes SET date_inspected = CURRENT_DATE, repair_status = 'Inspected' WHERE pothole_id = ? ";
			jdbcTemplate.update(sqlUpdateInspectedDate, pothole.getPotholeId());

		}
	}
	
	@Override
	public void updatePotholeSeverity(Pothole pothole) {
		String sqlUpdateRepairStatus = "UPDATE potholes SET severity = ? WHERE pothole_id = ?";
		jdbcTemplate.update(sqlUpdateRepairStatus, pothole.getSeverity(), pothole.getPotholeId());
	}
	
	@Override
	public void deleteDuplicatePothole(Pothole pothole ) {
		String sqlDeletePothole = "DELETE FROM potholes WHERE pothole_id = ? ";
		jdbcTemplate.update(sqlDeletePothole, pothole.getPotholeId());
	}
	
	private Pothole mapRowToPothole(SqlRowSet results) {
		Pothole thePothole = new Pothole();
		thePothole.setLocation(results.getString("location"));
		thePothole.setSize(results.getString("size"));
		thePothole.setDateReported(results.getDate("date_reported").toLocalDate());
		thePothole.setDateFixed(results.getDate("date_fixed").toLocalDate());
		thePothole.setDateInspected(results.getDate("date_inspected").toLocalDate());
		thePothole.setImage(results.getString("image"));
		thePothole.setPotholeId(results.getLong("pothole_id"));
		thePothole.setRepairStatus(results.getString("repair_status"));
		thePothole.setSeverity(results.getInt("severity"));
		thePothole.setLatitude(results.getFloat("latitude"));
		thePothole.setLongitude(results.getFloat("longitude"));
		return thePothole;
		
		
	}
	
	private Pothole mapRowToTable(SqlRowSet results) {
		Pothole thePothole = new Pothole();
		thePothole.setLocation(results.getString("location"));
		thePothole.setSize(results.getString("size"));
		thePothole.setDateReported(results.getDate("date_reported").toLocalDate());
		thePothole.setDateFixed(results.getDate("date_fixed").toLocalDate());
		thePothole.setDateInspected(results.getDate("date_inspected").toLocalDate());
		thePothole.setImage(results.getString("image"));
		thePothole.setPotholeId(results.getLong("pothole_id"));
		thePothole.setRepairStatus(results.getString("repair_status"));
		thePothole.setSeverity(results.getInt("severity"));
		thePothole.setDaysBetweenRepair(results.getInt("daysbetweenrepair"));
		return thePothole;
		
		
	}

	
}



