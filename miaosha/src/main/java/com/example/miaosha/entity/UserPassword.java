package com.example.miaosha.entity;

import lombok.Data;

@Data
public class UserPassword {/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_password.id
	 * @mbg.generated  Wed Mar 13 16:11:51 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_password.encrpt_password
	 * @mbg.generated  Wed Mar 13 16:11:51 CST 2019
	 */
	private String encrptPassword;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_password.user_id
	 * @mbg.generated  Wed Mar 13 16:11:51 CST 2019
	 */
	private Integer userId;

	

}