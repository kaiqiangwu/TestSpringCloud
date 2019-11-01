package com.cy.hisystem.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 5843835376260549700L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
		super(message);
	} 
	public ServiceException(Throwable cause) {
		super(cause);
	}
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	
}

