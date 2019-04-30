package com.techelevator.survey.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.authentication.PasswordHasher;
import com.techelevator.user.model.User;
@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public JDBCSurveyDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveSurvey(Survey survey) {
		String sqlInsertSurvey ="INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		
		

//        Survey newSurvey = new Survey();
//        newSurvey.setParkCode(parkCode);
//        newSurvey.setEmailAddress(email);
//        newSurvey.setState(state);
//        newSurvey.setActivityLevel(activityLevel);
//
//        	return newSurvey;
      
    }

	

	private Survey mapResultToSurvey(SqlRowSet results) {
        Survey survey = new Survey();
        survey.setSurveyId(results.getInt("surveyid"));
        survey.setParkCode(results.getString("parkcode"));
        survey.setEmailAddress(results.getString("emailaddress"));
        survey.setState(results.getString("state"));
        survey.setActivityLevel(results.getString("activitylevel"));
        return survey;
    }
}
