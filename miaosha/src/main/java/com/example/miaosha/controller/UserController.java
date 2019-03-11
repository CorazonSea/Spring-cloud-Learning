package com.example.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miaosha.dao.UserInfoMapper;
import com.example.miaosha.entity.UserInfo;

@RestController
public class UserController {
	
	@Autowired
	UserInfoMapper userInfoMaper;
	
	@GetMapping("/")
	public String getUsers(){
		UserInfo user = userInfoMaper.selectByPrimaryKey(1);
		if (user == null){
			return "用户对象不存在！";
		}else{
			return user.getName();
		}
		
		
	}
	
}
