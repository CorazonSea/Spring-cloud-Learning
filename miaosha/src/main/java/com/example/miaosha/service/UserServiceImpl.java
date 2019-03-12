package com.example.miaosha.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miaosha.VOModel.UserVO;
import com.example.miaosha.dao.UserInfoMapper;
import com.example.miaosha.dao.UserPasswordMapper;
import com.example.miaosha.entity.UserInfo;
import com.example.miaosha.entity.UserPassword;
import com.example.miaosha.model.UserModel;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoMapper usermapper;

	@Autowired
	private UserPasswordMapper userPasswordMapper;
	
	@Override
	public UserVO getUserById(Integer id) {
		// TODO Auto-generated method stub
		//userMapper获取到对应的entity
		UserInfo userInfo = usermapper.selectByPrimaryKey(id);
		if (userInfo == null){
			return null;
		}
		//UserPassword userPassword = userPasswordMapper.selectByUserId(id);
		return convertFromUserEntity(userInfo);
	}
	
	private UserModel convertFromUserEntity(UserInfo userInfo, UserPassword userPassword){
		UserModel userModel = new UserModel();
		if(userInfo == null){
			return null;
		}
		BeanUtils.copyProperties(userInfo, userModel);
		if (userPassword != null){
			userModel.setEncrptPassword(userPassword.getEncrptPassword());			
		}
		return userModel;
	}
	private UserVO convertFromUserEntity(UserInfo userInfo){
		UserVO userVO = new UserVO();
		if(userInfo == null){
			return null;
		}
		BeanUtils.copyProperties(userInfo, userVO);		
		return userVO;
	}
	
	

}
