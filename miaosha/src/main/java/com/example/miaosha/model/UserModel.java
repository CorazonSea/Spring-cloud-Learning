package com.example.miaosha.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserModel {
	
	private Integer id;
	
	@NotBlank(message = "用户名不能为空")
	private String name;
	
	@NotNull(message = "性别不能不填")
	private Short gender;
	
	@NotNull(message = "年龄不能不填")
	@Min(value = 0, message = "年龄不能小于0岁")
	@Max(value = 150, message = "年龄不能大于150岁")
	private Integer age;
	
	@NotBlank(message = "手机号不能为空")
	private String telephone;
	
	private String registerMode;
	
	private String thirdPartyId;
	
	@NotBlank(message = "密码不能为空")
	private String encrptPassword;

}
