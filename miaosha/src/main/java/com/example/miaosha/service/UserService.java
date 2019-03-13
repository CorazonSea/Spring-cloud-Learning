package com.example.miaosha.service;

import com.example.miaosha.VOModel.UserVO;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.model.UserModel;

public interface UserService {
	
	public UserVO getUserById(Integer id);
	
	public void userRegister(UserModel userModel)throws BusinessException;
	
	public UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException;

}
