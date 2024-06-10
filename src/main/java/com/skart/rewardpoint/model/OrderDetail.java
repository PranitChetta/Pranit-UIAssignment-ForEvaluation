package com.skart.rewardpoint.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This is model class for order details
 *
 */

@Setter
@Getter
@ToString
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private User user;

	private Product product;

	private Integer quantity;

	private Integer amount;

	private String orderOn;

	private String status;

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Integer id, User user, Product product, Integer quantity, Integer amount, String orderOn, String status) {
		this.id= id;
		this.user =  user;
		this.product = product;
		this.quantity =  quantity;
		this.amount = amount;
		this.orderOn = orderOn;
		this.status = status;
	}

}

