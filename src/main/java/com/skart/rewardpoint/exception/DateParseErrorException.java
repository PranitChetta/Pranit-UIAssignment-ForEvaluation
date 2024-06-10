/**
 * 
 */
package com.skart.rewardpoint.exception;

/**
 * Custom - Invalid input exception
 *
 */
public class DateParseErrorException extends CoreException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DateParseErrorException(int errorCode, String errorMessage, Object data ) {
		super(errorCode, errorMessage, data);
	}
	
	public DateParseErrorException(int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
	
	
	public DateParseErrorException(int errorCode, String errorMessage, Throwable exception) {
		super(errorCode, errorMessage, exception);
	}

}

