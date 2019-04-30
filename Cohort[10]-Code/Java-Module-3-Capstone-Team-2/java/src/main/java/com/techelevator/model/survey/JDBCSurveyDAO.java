package com.techelevator.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	//Get list of all surveys
	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> surveyList = new ArrayList<>();
		String sqlGetAllSurveys = "SELECT surveyId, "
				+ "parkCode, "
				+ "emailAddress, "
				+ "state, "
				+ "activityLevel "
				+ "FROM survey_result "
				+ "ORDER BY surveyId";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllSurveys);
		while(results.next()) {
			surveyList.add(mapRowToSurvey(results));
		}
		return surveyList;
	}
		
	
	

	//surveyId,  , survey.getSurveyId()
	// Save the survey
	@Override
	public void saveSurvey(Survey survey) {
		String sqlSurvey = "INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlSurvey 
			    , survey.getParkCode()
				, survey.getEmailAddress()
				, survey.getState()
				,survey.getActivityLevel());
//		survey.setSurveyId(getNextSurveyId());
	}
	
	
	// grab the next survey ID
	@Override
	public long getNextSurveyId()  {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextVal('seq_surveyId')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next Survey Id");
		}
	}
	
	
	

	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey s = new Survey();
		s.setSurveyId(results.getLong("surveyId"));
		s.setParkCode(results.getString("parkCode"));
		s.setEmailAddress(results.getString("emailAddress"));
		s.setState(results.getString("state"));
		s.setActivityLevel(results.getString("activityLevel"));
		return s;
	}

	

	
}
