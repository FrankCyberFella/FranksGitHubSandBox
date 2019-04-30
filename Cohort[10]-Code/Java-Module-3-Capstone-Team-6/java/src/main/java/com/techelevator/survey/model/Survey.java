package com.techelevator.survey.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

		private int surveyId;
		@NotBlank(message="Please choose a park")
		private String parkCode;
		
		@NotBlank(message="Email address is required")
		@Email(message="Must be a valid Email Address")
		private String emailAddress;
		
		@NotBlank(message="Please choose state")
		private String state;
		@NotBlank(message="Please choose activity level")
		private String activityLevel;
		/**
		 * @return the surveyId
		 */
		public int getSurveyId() {
			return surveyId;
		}
		/**
		 * @param surveyId the surveyId to set
		 */
		public void setSurveyId(int surveyId) {
			this.surveyId = surveyId;
		}
		/**
		 * @return the parkCode
		 */
		public String getParkCode() {
			return parkCode;
		}
		/**
		 * @param parkCode the parkCode to set
		 */
		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}
		/**
		 * @return the emailAddress
		 */
		public String getEmailAddress() {
			return emailAddress;
		}
		/**
		 * @param emailAddress the emailAddress to set
		 */
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}
		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * @return the activityLevel
		 */
		public String getActivityLevel() {
			return activityLevel;
		}
		/**
		 * @param activityLevel the activityLevel to set
		 */
		public void setActivityLevel(String activityLevel) {
			this.activityLevel = activityLevel;
		}
		
		
}
