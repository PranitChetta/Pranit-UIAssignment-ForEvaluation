/**
 * 
 */
package com.skart.rewardpoint.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Standard response class for customized demo project response
 *
 */
@Getter
@Setter
@ToString
public class RewardPointResponse {

	/**
	 * Will contain response code 200 - for success, 400 - Bad Request etc
	 */
	private int code;

	/**
	 * Will contain response message line "Success", "Invalid input" etc
	 */
	private String message;

	/**
	 * Will contain response data
	 */
	private Object data;

	public RewardPointResponse(int code, String message, String data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

}

