package com.techelevator.dao.model;

import org.hibernate.validator.constraints.NotBlank;

public class actorSearch {

	
	 @NotBlank(message = "Last Name is required")
	 private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
