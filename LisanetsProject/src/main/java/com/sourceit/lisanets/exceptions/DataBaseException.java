package com.sourceit.lisanets.exceptions;

public class DataBaseException extends RuntimeException {

	Throwable cause;

	public DataBaseException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}

	@Override
	public synchronized Throwable getCause() {

		return cause;
	}

}
