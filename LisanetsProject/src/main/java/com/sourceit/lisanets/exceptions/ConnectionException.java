package com.sourceit.lisanets.exceptions;

public class ConnectionException extends RuntimeException {
      
	  Throwable cause;
	
	   public ConnectionException(Throwable cause) {
		super(cause);
	   this.cause = cause;
	   }

	@Override
	public synchronized Throwable getCause() {
		
		return cause;
	}
	


}
