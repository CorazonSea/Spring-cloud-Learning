package com.example.miaosha.entity;


import lombok.Data;

@Data
public class UserInfo {
	
	private Integer id;

	private String name;
	
	private Short gender;

	private Integer age;
	
	private String telephone;
	
	private String registerMode;
	
	private String thirdPartyId;



}