package com.techelevator.model.survey;

import java.util.List;

public interface SurveyDAO {

	//to retrieve all the survey results
	List<Survey> getAllSurveys();
	
	//to put a survey into our results
	void saveSurvey(Survey survey);


	
	//get next survey Id
	long getNextSurveyId();

	
	
}
