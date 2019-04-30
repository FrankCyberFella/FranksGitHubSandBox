package com.techelevator.dao.model;

import javax.validation.constraints.NotNull;

public class FilmSearch {
	
	
		private String genre;
		
		@NotNull(message="Required field")
		private int minLength;
		
		@NotNull(message="Required field")
		private int maxLength;

		public int getMinLength() {
			return minLength;
		}

		public void setMinLength(int minLength) {
			this.minLength = minLength;
		}

		public int getMaxLength() {
			return maxLength;
		}

		public void setMaxLength(int maxLength) {
			this.maxLength = maxLength;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}


}
