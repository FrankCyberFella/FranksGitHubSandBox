package com.techelevator.model.park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	ParkDao parkDao;
	
	@Override
	public Map<String, Integer> getAllSurveys() {
		Map<String, Integer> surveyMap = new HashMap<String, Integer>();
		String sqlSelectAllSurveys = "SELECT parkcode, COUNT(*) FROM survey_result GROUP BY parkcode ORDER BY COUNT(*) DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			surveyMap.put(parkDao.getParkByCode(results.getString("parkcode")).getParkName(), results.getInt("count"));
		}
		
		return surveyMap;
	}

//	@Override
//	public List<Survey> getAllSurveys() {
//		List<Survey> allSurveys = new ArrayList<>();
//		String sqlSelectAllSurveys = "SELECT COUNT(parkcode) FROM survey_result GROUP BY parkcode";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
//		while(results.next()) {
//			Survey survey = new Survey();
//			survey.setSurveyId(results.getInt("surveyid"));
//			survey.setParkCode(results.getString("parkcode"));
//			survey.setEmailAddress(results.getString("emailaddress"));
//			survey.setState(results.getString("state"));
//			survey.setActivityLevel(results.getString("activitylevel"));
//			allSurveys.add(survey);
//		}
//		return allSurveys;
//	}

	@Override
	public void save(Survey survey) {
		int surveyId = getNextId();
		String sqlInsertPost = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, surveyId, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		survey.setSurveyId(surveyId);
	}
	
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return id;
	}

}
