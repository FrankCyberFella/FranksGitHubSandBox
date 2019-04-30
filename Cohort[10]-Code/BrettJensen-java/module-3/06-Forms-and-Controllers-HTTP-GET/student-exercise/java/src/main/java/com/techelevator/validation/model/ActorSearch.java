package com.techelevator.validation.model;

import org.hibernate.validator.constraints.NotBlank;

public class ActorSearch {

	@NotBlank(message="Field cannot be blank")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
