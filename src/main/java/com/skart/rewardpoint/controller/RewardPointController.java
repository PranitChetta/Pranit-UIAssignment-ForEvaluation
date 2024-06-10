/**
 * 
 */
package com.skart.rewardpoint.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skart.rewardpoint.exception.CustomErrorException;
import com.skart.rewardpoint.exception.DateParseErrorException;
import com.skart.rewardpoint.model.RewardPointResponse;
import com.skart.rewardpoint.service.RewardPointService;

/**
 * 
 * This class will work as controller and will used to match end points
 */
@RestController
@CrossOrigin
@RequestMapping("/v1")
public class RewardPointController {

	@Autowired
	private RewardPointService rewardPointService;

	@RequestMapping(value = "/rewardpoint", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public RewardPointResponse sortAndConvertString(HttpServletRequest request, HttpServletResponse response) {
			return rewardPointService.getRewardPointSummary();
	}

}

