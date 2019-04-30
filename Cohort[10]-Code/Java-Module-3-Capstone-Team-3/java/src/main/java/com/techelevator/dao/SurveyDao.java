package com.techelevator.dao;

import java.util.Map;

public interface SurveyDao {

	public Map<String, Integer> getAllSurveyCounts();
	
	public void saveSurvey(String parkCode, String email, String state, String activityLevel);
	
}
