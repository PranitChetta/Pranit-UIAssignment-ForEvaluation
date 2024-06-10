package com.skart.rewardpoint;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.skart.rewardpoint.exception.DateParseErrorException;
import com.skart.rewardpoint.model.OrderDetail;
import com.skart.rewardpoint.model.Product;
import com.skart.rewardpoint.model.RewardPointResponse;
import com.skart.rewardpoint.model.User;
import com.skart.rewardpoint.model.UserRewardPoint;
import com.skart.rewardpoint.service.impl.RewardPointHelper;
import com.skart.rewardpoint.service.impl.RewardPointServiceImpl;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class RewardPointApplicationTests {
	
	@InjectMocks
	RewardPointServiceImpl rewardPointServiceImpl;
	
	@Mock
	RewardPointHelper rewardPointHelper;
	
	public RewardPointApplicationTests() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGetRewardPointSummary() {
		List<OrderDetail> orderDetails = new ArrayList<>();
		User user1 = new User(1, "Martin", "Grunt", "14 street");
		Product product1 = new Product(1, "Chair", 40);
		OrderDetail ordeDetail1 = new OrderDetail(1, user1, product1, 4, product1.getPrice() * 4, "05-02-2023",
				"Completed");
		orderDetails.add(ordeDetail1);

		//Mock the result from helper class
		Mockito.when(rewardPointHelper.createDummyData()).thenReturn(orderDetails);
		RewardPointResponse response = null;
		response = rewardPointServiceImpl.getRewardPointSummary();
		Map<Integer, UserRewardPoint> result = (Map<Integer, UserRewardPoint>) response.getData();
		
		//Only 1 record should be there as per our dataset
		Assertions.assertEquals(1, result.size());
	}
	
	
	@Test
	public void withWrongDateFormat_TestGetRewardPointSummary() {
		List<OrderDetail> orderDetails = new ArrayList<>();
		User user1 = new User(1, "Martin", "Grunt", "14 street");
		Product product1 = new Product(1, "Chair", 40);
		OrderDetail ordeDetail1 = new OrderDetail(1, user1, product1, 4, product1.getPrice() * 4, "05-2023",
				"Completed");
		orderDetails.add(ordeDetail1);

		//Mock the result from helper class
		Mockito.when(rewardPointHelper.createDummyData()).thenReturn(orderDetails);
		RewardPointResponse response = null;
		try {
			//Should throw DateParseErrorException exception
			response = rewardPointServiceImpl.getRewardPointSummary();			
		} catch (DateParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void withDefinedAmount_TestGetRewardPointSummary() {
		List<OrderDetail> orderDetails = new ArrayList<>();
		User user1 = new User(1, "Martin", "Grunt", "14 street");
		Product product1 = new Product(1, "Chair", 40);
		OrderDetail ordeDetail1 = new OrderDetail(1, user1, product1, 4, product1.getPrice() * 3, "05-02-2023",
				"Completed");
		orderDetails.add(ordeDetail1);

		//Mock the result from helper class
		Mockito.when(rewardPointHelper.createDummyData()).thenReturn(orderDetails);
		Mockito.when(rewardPointHelper.calculateRewardPoint(120)).thenReturn(90);
		RewardPointResponse response = null;
		response = rewardPointServiceImpl.getRewardPointSummary();
		Map<Integer, UserRewardPoint> result = (Map<Integer, UserRewardPoint>) response.getData();
		UserRewardPoint userRewardPoint = result.get(1);
		//Only 1 record should be there as per our dataset
		Assertions.assertEquals(90, userRewardPoint.getTotalPoints());
	}
	
	@Test
	public void withZeroAmount_TestGetRewardPointSummary() {
		List<OrderDetail> orderDetails = new ArrayList<>();
		User user1 = new User(1, "Martin", "Grunt", "14 street");
		Product product1 = new Product(1, "Chair", 40);
		OrderDetail ordeDetail1 = new OrderDetail(1, user1, product1, 4, product1.getPrice() * 3, "05-02-2023",
				"Completed");
		orderDetails.add(ordeDetail1);

		//Mock the result from helper class
		Mockito.when(rewardPointHelper.createDummyData()).thenReturn(orderDetails);
		Mockito.when(rewardPointHelper.calculateRewardPoint(0)).thenReturn(0);
		RewardPointResponse response = null;
		response = rewardPointServiceImpl.getRewardPointSummary();
		Map<Integer, UserRewardPoint> result = (Map<Integer, UserRewardPoint>) response.getData();
		UserRewardPoint userRewardPoint = result.get(1);
		//Only 1 record should be there as per our dataset
		Assertions.assertEquals(0, userRewardPoint.getTotalPoints());
	}
	
	@Test
	public void withNullAmount_TestGetRewardPointSummary() {
		List<OrderDetail> orderDetails = new ArrayList<>();
		User user1 = new User(1, "Martin", "Grunt", "14 street");
		Product product1 = new Product(1, "Chair", 40);
		OrderDetail ordeDetail1 = new OrderDetail(1, user1, product1, 4, product1.getPrice() * 3, "05-02-2023",
				"Completed");
		orderDetails.add(ordeDetail1);

		//Mock the result from helper class
		Mockito.when(rewardPointHelper.createDummyData()).thenReturn(orderDetails);
		Mockito.when(rewardPointHelper.calculateRewardPoint(null)).thenReturn(0);
		RewardPointResponse response = null;
		response = rewardPointServiceImpl.getRewardPointSummary();
		Map<Integer, UserRewardPoint> result = (Map<Integer, UserRewardPoint>) response.getData();
		UserRewardPoint userRewardPoint = result.get(1);
		//Only 1 record should be there as per our dataset
		Assertions.assertEquals(0, userRewardPoint.getTotalPoints());
	}
}
