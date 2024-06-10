package com.skart.rewardpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skart.rewardpoint.model.OrderDetail;
import com.skart.rewardpoint.model.Product;
import com.skart.rewardpoint.model.User;

/**
 * 
 * This is a helper class to create helper method for rewardPoint
 *
 */
@Service
public class RewardPointHelper {

	/**
	 * Create dummy data for order
	 * 
	 * @return (@OrderDetail)
	 */
	public List<OrderDetail> createDummyData() {
		List<OrderDetail> orderDetails = new ArrayList<>();

		User user1 = new User(1, "Martin", "Grunt", "14 street");
		User user2 = new User(2, "Luther", "Alex", "new villa");

		Product product1 = new Product(1, "Chair", 40);
		Product product2 = new Product(2, "Table", 10);
		Product product3 = new Product(3, "Glass", 20);
		Product product4 = new Product(4, "Beauty cream", 10);
		Product product5 = new Product(5, "Headphone", 60);

		OrderDetail ordeDetail1 = new OrderDetail(1, user1, product1, 4, product1.getPrice() * 4, "05-02-2023",
				"Completed");
		OrderDetail ordeDetail2 = new OrderDetail(2, user2, product2, 1, product2.getPrice() * 1, "05-01-2023",
				"Completed");
		OrderDetail ordeDetail3 = new OrderDetail(3, user2, product3, 3, product3.getPrice() * 3, "13-01-2023",
				"Completed");
		OrderDetail ordeDetail4 = new OrderDetail(4, user1, product2, 1, product2.getPrice() * 1, "27-01-2023",
				"Completed");
		OrderDetail ordeDetail5 = new OrderDetail(5, user2, product5, 2, product5.getPrice() * 2, "01-02-2023",
				"Completed");
		OrderDetail ordeDetail6 = new OrderDetail(6, user1, product4, 5, product4.getPrice() * 5, "15-01-2023",
				"Completed");

		orderDetails.add(ordeDetail1);
		orderDetails.add(ordeDetail2);
		orderDetails.add(ordeDetail3);
		orderDetails.add(ordeDetail4);
		orderDetails.add(ordeDetail5);
		orderDetails.add(ordeDetail6);

		return orderDetails;

	}

	/**
	 * This method will calculate reward points based upon the order amount by
	 * user
	 * 
	 * @return
	 */
	public Integer calculateRewardPoint(Integer orderAmount) {

		Integer rewardPoints = 0;
		if (orderAmount != null && orderAmount > 50 && orderAmount <= 100) {
			rewardPoints = (orderAmount - 50) * 1;
		} else if (orderAmount != null && orderAmount > 100) {
			rewardPoints = ((orderAmount - 100) * 2) + 50;
		}
		return rewardPoints;
	}

}
