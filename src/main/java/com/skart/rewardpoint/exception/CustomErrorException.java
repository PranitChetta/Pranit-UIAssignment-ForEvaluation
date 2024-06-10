/**
 * 
 */
package com.skart.rewardpoint.exception;

/**
 * Custom - Invalid input exception
 *
 */
public class CustomErrorException extends CoreException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CustomErrorException(int errorCode, String errorMessage, Object data ) {
		super(errorCode, errorMessage, data);
	}
	
	public CustomErrorException(int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
	
	
	public CustomErrorException(int errorCode, String errorMessage, Throwable exception) {
		super(errorCode, errorMessage, exception);
	}

}

