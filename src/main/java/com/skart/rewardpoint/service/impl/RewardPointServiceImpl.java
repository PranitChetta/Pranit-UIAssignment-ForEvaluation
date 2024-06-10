/**
 * 
 */
package com.skart.rewardpoint.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skart.rewardpoint.exception.DateParseErrorException;
import com.skart.rewardpoint.model.OrderDetail;
import com.skart.rewardpoint.model.RewardPointResponse;
import com.skart.rewardpoint.model.UserRewardPoint;
import com.skart.rewardpoint.service.RewardPointService;
import com.skart.rewardpoint.util.CommonUtil;

/**
 * Implementation class for hanl all service method for reward points
 *
 */
@Service
public class RewardPointServiceImpl implements RewardPointService {

	@Autowired
	private RewardPointHelper rewardPointHelper;

	@Override
	public RewardPointResponse getRewardPointSummary() {
		
		try {
			RewardPointResponse response = new RewardPointResponse(HttpStatus.OK.value(), "Successful", null);
			Map<Integer, UserRewardPoint> userRewardPoints = new HashMap<>();
			// Currently creating dummy data or API,finally it will be change to
			// fetch exact data
			List<OrderDetail> orderDetails = rewardPointHelper.createDummyData();

			Map<String, Integer> rewardPoint = null;

			for (OrderDetail orderDetail : orderDetails) {
				UserRewardPoint userRewardPointObj = null;
				if (userRewardPoints.get(orderDetail.getUser().getId()) != null) {
					//User Object already exists
					userRewardPointObj = userRewardPoints.get(orderDetail.getUser().getId());
					rewardPoint = userRewardPointObj.getRewardPoints();
					
					Integer calculatedRewardPoints = rewardPointHelper.calculateRewardPoint(orderDetail.getAmount());
					
					Date orderOn = CommonUtil.StringToDateConverter("dd-MM-yyyy", orderDetail.getOrderOn());
					String month = CommonUtil.getMonthInt(orderOn);
					Integer year = CommonUtil.getYearInt(orderOn);
					
					String str = month + ", " + year;
					if(rewardPoint.get(str)!=null) {
						Integer rp = rewardPoint.get(str) + calculatedRewardPoints;
						rewardPoint.put(str, rp);
					} else {
						rewardPoint.put(str, calculatedRewardPoints);
					}
					Integer existingTotalPoints = userRewardPointObj.getTotalPoints();
					userRewardPointObj.setTotalPoints(existingTotalPoints + calculatedRewardPoints);

					

				} else {
					//Need to initialize objects
					userRewardPointObj = new UserRewardPoint();
					rewardPoint = new HashMap<>();

					userRewardPointObj.setUser(orderDetail.getUser());

					Integer calculatedRewardPoints = rewardPointHelper.calculateRewardPoint(orderDetail.getAmount());
					
					System.out.println(calculatedRewardPoints + "sdsdsd " + orderDetail.getAmount());
					Date orderOn = CommonUtil.StringToDateConverter("dd-MM-yyyy", orderDetail.getOrderOn());
					String month = CommonUtil.getMonthInt(orderOn);
					Integer year = CommonUtil.getYearInt(orderOn);
					
					rewardPoint.put((month + ", " + year), calculatedRewardPoints);
					userRewardPointObj.setRewardPoints(rewardPoint);

					userRewardPointObj.setTotalPoints(calculatedRewardPoints);

					userRewardPoints.put(orderDetail.getUser().getId(), userRewardPointObj);
				}

			}
			response.setData(userRewardPoints);
			return response;
		} catch (ParseException e){
			throw new DateParseErrorException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Exception while parsing the orderOnDate", e);
		}
		
	}

}

