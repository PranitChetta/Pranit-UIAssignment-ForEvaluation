/**
 * 
 */
package com.skart.rewardpoint.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class for product details
 *
 */

@Setter
@Getter
@ToString
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private Integer price;
	
	/**
	 * Constructor to create record
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(Integer id, String name, Integer price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

}

