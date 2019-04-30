package com.techelevator.npgeek;

import java.util.List;

import com.techelevator.model.Survey;
import com.techelevator.model.Weather;

public interface SurveyDAO {
	
	public void insertSurvey(Survey survey);
	public List<Survey> getAllSurveys();

}
