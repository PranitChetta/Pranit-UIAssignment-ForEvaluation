/**
 * 
 */
package com.skart.rewardpoint.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;

import com.skart.rewardpoint.model.RewardPointResponse;

/**
 * This class is used to mention all the end points.
 *
 */
@Service
public interface RewardPointService {
	
	/**
	 * This method will return reward point summary for all users
	 * @return Object
	 * @throws ParseException 
	 */
	public RewardPointResponse getRewardPointSummary();

}

