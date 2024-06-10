/**
 * 
 */
package com.skart.rewardpoint.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class for user details
 *
 */

@Setter
@Getter
@ToString
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	/**
	 * Constructor to create user record
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	public User(Integer id, String firstName, String lastName, String address) {
		this.id= id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

}

