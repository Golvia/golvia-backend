package com.backend.golvia.usermgt.exceptions;

public class SQLIntegrityConstraintViolationException extends RuntimeException {

	 public SQLIntegrityConstraintViolationException(String message) {
	        super(message);
	    }
}