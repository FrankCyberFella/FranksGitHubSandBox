package com.techelevator.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UnauthorizedException
 */
@ResponseStatus(code=HttpStatus.FORBIDDEN) //if we through an unauth login, you will get a forbidden error
public class UnauthorizedException extends Exception {

    private static final long serialVersionUID = 1L; //object says we want a long series of char's

}