package com.techelevator.dao.model;

import org.hibernate.validator.constraints.NotBlank;

public class ActorSearch {
	
	@NotBlank(message="insert something")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
