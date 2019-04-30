package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.ParkDao;
import com.techelevator.dao.SurveyDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

@Component
public class JDBCSurveyDao implements SurveyDao {
	
private JdbcTemplate myJdbcTemplate;						// Define a jdbctemplate object for the DAO
	@Autowired
	private ParkDao parkDao;

	@Autowired
	public JDBCSurveyDao(DataSource aDataSource) {				// constructor for DAO - receive a data source
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);    // instantiate a jdbctemplate object for the DAO
	}
	
	@Override
	public Map<String, Integer> getAllSurveyCounts() {
		Map<String, Integer> surveys = new TreeMap<>();
		String sqlSurveys = "SELECT parkcode, count(*) AS numberofsurveys "+
							"FROM survey_result "+
							"GROUP BY parkcode "+
				            "ORDER BY numberofsurveys, parkcode DESC";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlSurveys);
		while(results.next()) {
			String parkCode = results.getString("parkcode");
			String parkName = parkDao.getParkByCode(parkCode).getParkName();
			Integer surveyNumber = results.getInt("numberofsurveys");
			surveys.put(parkName, surveyNumber);
		}
		return surveys;
	}
	
	public void saveSurvey(String parkCode, String email, String state, String activityLevel) {
		 String sqlInsertSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) "+
				  				  "VALUES (?, ? , ?, ?)";
		 myJdbcTemplate.update(sqlInsertSurvey
							,parkCode
							,email
							,state
							,activityLevel);
	}

	
//	private Survey mapRowToSurvey(SqlRowSet results) {
//		Survey theSurvey;
//		theSurvey = new Survey();
//		theSurvey.setParkCode(results.getString("parkcode").toLowerCase());
//		theSurvey.setEmailAddress(results.getString("emailaddress"));
//		theSurvey.setState(results.getString("state"));
//		theSurvey.setActivityLevel(results.getString("activitylevel"));
//		
//		return theSurvey;
//	}

}
