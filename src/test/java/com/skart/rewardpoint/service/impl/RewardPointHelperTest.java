package com.skart.rewardpoint.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class RewardPointHelperTest {
	
	@InjectMocks
	RewardPointHelper rewardPointHelper;
	
	@Test
	public void testCalculateRewardPoint() {
		Integer response = rewardPointHelper.calculateRewardPoint(120);
		Assertions.assertEquals(90, response);
	}
	
	@Test
	public void withNullValue_TestCalculateRewardPoint() {
		Integer response = rewardPointHelper.calculateRewardPoint(null);
		Assertions.assertEquals(0, response);
	}
	
	@Test
	public void withZeroValue_TestCalculateRewardPoint() {
		Integer response = rewardPointHelper.calculateRewardPoint(0);
		Assertions.assertEquals(0, response);
	}

}

