package com.techelevator.model.survey;


import java.util.List;

import com.techelevator.model.park.ParkDao;


public interface SurveyDao {
	
	public List<SurveyCount> getParkSurveyCount(ParkDao parkDao);
	
	public boolean save(Survey survey);

}
