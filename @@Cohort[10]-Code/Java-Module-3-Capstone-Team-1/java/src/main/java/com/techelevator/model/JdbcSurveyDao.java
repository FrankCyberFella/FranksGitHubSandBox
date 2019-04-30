package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {
	
	@Autowired
	private ParkDao parkDao;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void save(Survey survey) {
		Long id = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, id, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		survey.setSurveyId(id);
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return id;
	}
	
	public int getTotalCount() {
		int totalCount = 0;
		String row = "SELECT count(*) as totalCount FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while(results.next()) {
			totalCount = results.getInt("totalCount");
		}
		return totalCount;
	}
	
//	public List<Survey> getSurveyResults() {
//		Survey getSurvey = new Survey();
//		List<Survey> surveyResultList = new ArrayList<Survey>();
//		String row = " SELECT parkcode, count(*) " + 
//				"FROM survey_result " + 
//				"GROUP BY parkcode ";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
//		while(results.next()) {
//			getSurvey = mapRowToSurvey(results);
//			surveyResultList.add(getSurvey);
//			}
//		return surveyResultList;
//	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey = new Survey();
		theSurvey.setParkName(results.getString("parkname"));
		theSurvey.setCountAll(results.getLong("countall"));
		theSurvey.setCountPark(results.getLong("count"));
		
		return theSurvey;
	}
	
	public Map<String, Integer> getSurveyResults() {
		Map<String, Integer> mappy = new HashMap<String, Integer>();
		String row = " SELECT parkcode, count(*) " + 
				"FROM survey_result " + 
				" GROUP BY parkcode ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(row);
		while(results.next()) {
			mappy.put(parkDao.getParkById(results.getString("parkcode")).getParkName(), results.getInt("count"));
		}
		return mappy;
	}

}
