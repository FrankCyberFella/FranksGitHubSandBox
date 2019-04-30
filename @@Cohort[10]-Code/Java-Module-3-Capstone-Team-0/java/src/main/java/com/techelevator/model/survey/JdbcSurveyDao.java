package com.techelevator.model.survey;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.park.ParkDao;

@Component
public class JdbcSurveyDao implements SurveyDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SurveyCount> getParkSurveyCount(ParkDao parkDao) {
		
		List<SurveyCount> surveyList = new ArrayList<SurveyCount>();
		
		String sqlParkSurveyCount = "SELECT COUNT(*) AS surveyCount, survey_result.parkcode, parkname FROM survey_result JOIN park ON survey_result.parkcode=park.parkcode GROUP BY survey_result.parkcode, parkname ORDER BY surveyCount DESC, parkname";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkSurveyCount);
		
		while(results.next()) {

			surveyList.add(mapRowToSurveyCount(results));
		}
		
		
		
		return surveyList;
	}
	

	@Override
	public boolean save(Survey survey) {
		String sqlSave="INSERT INTO survey_result (parkcode,emailaddress,state,activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlSave,survey.getParkCode(),survey.getEmailAddress(),survey.getState(),survey.getActivityLevel());
		String sqlSaveCheck = "SELECT * FROM survey_result WHERE parkcode = ? AND emailaddress = ? AND state = ? AND activitylevel = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSaveCheck,survey.getParkCode(),survey.getEmailAddress(),survey.getState(),survey.getActivityLevel());
		if(results.next()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey = new Survey();
		theSurvey.setSurveyId(results.getInt("surveyid"));
		theSurvey.setParkCode(results.getString("parkcode"));
		theSurvey.setEmailAddress(results.getString("emailaddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activitylevel"));
		return theSurvey;
	}
	public SurveyCount mapRowToSurveyCount(SqlRowSet results) {
		SurveyCount theCount = new SurveyCount();
		try {
			theCount.setCount(results.getInt("surveyCount"));
			theCount.setParkCode(results.getString("parkcode"));
			theCount.setParkName(results.getString("parkname"));
		} catch(NullPointerException e) {}
		return theCount;
	}

}
