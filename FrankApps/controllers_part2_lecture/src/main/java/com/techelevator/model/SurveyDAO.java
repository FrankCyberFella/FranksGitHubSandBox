package com.techelevator.model;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class SurveyDAO {
	
	private PrintWriter writer;

	public SurveyDAO(OutputStream outputDestination) {
		this.writer = new PrintWriter(outputDestination, true);
	}
	
	public void saveSurvey(Survey aSurvey) {
		LocalDateTime now = LocalDateTime.now();
		writer.println(aSurvey.toString());
	}
}
