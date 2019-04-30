package com.techelevator.model;

import java.util.List;
import java.util.Map;

public interface SurveyDao {
	
	public void save(Survey survey);
	
	public Map<String, Integer> getSurveyResults();
	
	public int getTotalCount();

}
