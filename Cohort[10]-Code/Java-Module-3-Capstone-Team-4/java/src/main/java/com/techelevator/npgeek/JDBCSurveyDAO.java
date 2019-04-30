package com.techelevator.npgeek;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;
import com.techelevator.model.Survey;
import com.techelevator.model.Weather;

@Component	
public class JDBCSurveyDAO implements SurveyDAO {

private JdbcTemplate jdbcTemplate;
@Autowired	
	public JDBCSurveyDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}






	@Override
	public void insertSurvey(Survey survey) {
		String surveyInput;
		surveyInput = "INSERT INTO survey_result " + 
				"(parkcode, emailaddress, state, activitylevel) " + 
				"VALUES (?, ?, ?, ?)"; 
		
		jdbcTemplate.update(surveyInput, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivity());
		
	}




	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveyList = new ArrayList<Survey>();
		String sqlGetAllSurveys = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllSurveys);
		while (results.next()) {
			allSurveyList.add(mapRowToSurvey(results));
		}
		return allSurveyList;

	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey s = new Survey();
		s.setEmail(results.getString("emailaddress"));
		s.setActivity(results.getString("activitylevel"));
		s.setParkCode(results.getString("parkcode"));
		s.setState(results.getString("state"));
		return s;
	}

}
