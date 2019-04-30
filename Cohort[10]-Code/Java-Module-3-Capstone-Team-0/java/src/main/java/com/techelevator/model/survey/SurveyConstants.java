package com.techelevator.model.survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

public class SurveyConstants {
	
	private static final String[] LIST_OF_STATES = {"Alabama", "Alaska", "Amorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
	private static final String[] ACTIVITY_LEVELS = {"Inactive","Sedentary","Active","Extremely Active"};
	
	
	public SurveyConstants() {
		
	}

	/**
	 * @return the listOfStates
	 */
	public static String[] getListOfStates() {
		return LIST_OF_STATES;
	}

	public static String[] getListOfActivityLevels() {
		return ACTIVITY_LEVELS;
	}
	
}
