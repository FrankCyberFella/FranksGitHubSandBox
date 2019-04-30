package com.techelevator.dao.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FilmSearch {


@NotNull(message="You must enter a value") 
@Min(value=0, message="You must enter a number greater than 0")
private int minLength;

@NotNull (message="You must enter a value")
private int maxLength;

private String a;
//
//@SuppressWarnings("unused")
//private boolean maxGreaterThanMin;
//@AssertTrue(message="Max Length must be greater than Min Length")
//public boolean isMaxGreaterthanMin() {
//	if(maxLength > minLength) {
//		return 	;
//	}
//	return fa
//}


/**
 * @return the minLength
 */
public int getMinLength() {
	return minLength;
}

/**
 * @param minLength the minLength to set
 */
public void setMinLength(int minLength) {
	this.minLength = minLength;
}

/**
 * @return the maxLength
 */
public int getMaxLength() {
	return maxLength;
}

/**
 * @param maxLength the maxLength to set
 */
public void setMaxLength(int maxLength) {
	this.maxLength = maxLength;
}

}
