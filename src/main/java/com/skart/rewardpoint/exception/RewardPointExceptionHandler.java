/**
 * 
 */
package com.skart.rewardpoint.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skart.rewardpoint.model.RewardPointResponse;

/**
 * Handle all custom generated exception
 *
 */
@ControllerAdvice
public class RewardPointExceptionHandler {

	@ExceptionHandler({ CustomErrorException.class })
	public @ResponseBody RewardPointResponse handleCustomErrorException(HttpServletRequest requset,
			HttpServletResponse response, Exception e) {
		RewardPointResponse rewardPointResponse = new RewardPointResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something bad happened, please contact system admin.",
				"");
		return rewardPointResponse;
	}
	
	@ExceptionHandler({ DateParseErrorException.class })
	public @ResponseBody RewardPointResponse handleDateParseException(HttpServletRequest requset,
			HttpServletResponse response, Exception e) {
		RewardPointResponse rewardPointResponse = new RewardPointResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error while parsing the date",
				"");
		return rewardPointResponse;
	}

}

