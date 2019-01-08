package com.techelevator.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.NotificationSignupDAO;
import com.techelevator.model.Survey;
import com.techelevator.model.SurveyDAO;

@Controller
public class SurveyController {

	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String showSurveyInput() {
		return "surveyInput";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String processSurveyInput(Survey survey) throws FileNotFoundException, IOException {
		
		// here we do something useful with the survey object
		try(FileOutputStream out = new FileOutputStream(getSurveyLogFile(), true)) {
			SurveyDAO log = new SurveyDAO(out);
			log.saveSurvey(survey);
		} 	
		return "redirect:/surveyResult";
	}
	
	@RequestMapping(path="/surveyResult", method=RequestMethod.GET)
	public String showSurveyResult() {
		return "surveyResult";
	}
	private File getSurveyLogFile() {
		String homeDirectory = System.getProperty("user.home");
		return new File(homeDirectory, "surveys.txt");
	}
}
