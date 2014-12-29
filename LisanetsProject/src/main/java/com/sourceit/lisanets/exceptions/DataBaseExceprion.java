package com.sourceit.lisanets.exceptions;

public class DataBaseExceprion extends RuntimeException {

	Throwable cause;

	public DataBaseExceprion(Throwable cause) {
		super(cause);
		this.cause = cause;
	}

	@Override
	public synchronized Throwable getCause() {

		return cause;
	}

}
