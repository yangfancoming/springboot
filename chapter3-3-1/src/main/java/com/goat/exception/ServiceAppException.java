package com.goat.exception;

public class ServiceAppException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -3671305836179994715L;

	public ServiceAppException() {
	}

	public ServiceAppException(String message) {
		super(message);
	}

}
