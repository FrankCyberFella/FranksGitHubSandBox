package com.techelevator.model.park;

import java.util.List;
import java.util.Map;


public interface SurveyDao {
	
	public Map<String, Integer> getAllSurveys();
	public void save(Survey survey);


}
