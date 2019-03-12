package com.example.miaosha.model;

import lombok.Data;

@Data
public class UserModel {
	
	private Integer id;
	
	private String name;
	
	private Short gender;
	
	private Integer age;
	
	private String telephone;
	
	private String registerMode;
	
	private String thirdPartyId;
	
	private String encrptPassword;

}
