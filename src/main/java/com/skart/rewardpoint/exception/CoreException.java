/**
 * 
 */
package com.skart.rewardpoint.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Extends runtime exception and fix error code message etc
 * Set response in case of exception
 *
 */
@Getter
@Setter
@ToString
public class CoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;

	private String errorMessage;

	private Object data;

	private Throwable exception;
	
	/**
	 * Blank Constructor
	 */
	public CoreException() {
	}
	
	/**
	 *  Exception constructor with params
	 * @param Code
	 * @param message
	 * @param exc
	 */
	public CoreException(int errorCode, String errorMessage, Object data) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}
	
	/**
	 *  Exception constructor with params
	 * @param Code
	 * @param message
	 */
	public CoreException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	

}

