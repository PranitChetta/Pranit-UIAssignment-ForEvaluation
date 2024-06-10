/**
 * 
 */
package com.skart.rewardpoint.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response model for reward points user wise
 *
 */
@Getter
@Setter
@ToString
public class UserRewardPoint implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private Map<String, Integer> rewardPoints;
	
	private Integer totalPoints;

	
}

