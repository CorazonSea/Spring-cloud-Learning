package com.example.miaosha.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.miaosha.VOModel.UserVO;
import com.example.miaosha.dao.UserInfoMapper;
import com.example.miaosha.dao.UserPasswordMapper;
import com.example.miaosha.entity.UserInfo;
import com.example.miaosha.entity.UserPassword;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EnBusinessError;
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
	
	@Override
	@Transactional
	public void userRegister(UserModel userModel) throws BusinessException {
		// TODO Auto-generated method stub
		if (userModel == null){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR);
		}
		if (StringUtils.isEmpty(userModel.getTelephone()) 
				|| StringUtils.isEmpty(userModel.getName())
				|| userModel.getAge() == null
				|| userModel.getGender() == null
				){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR);
		}
		UserInfo userInfo = convertFromUserModel(userModel);
		usermapper.insertSelective(userInfo);
		
		userModel.setId(userInfo.getId());
		
		UserPassword userPassword = convertPasswordFromUserModel(userModel);
		userPasswordMapper.insertSelective(userPassword);
		return;
	}
	
	
	@Override
	public UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException {
		// TODO Auto-generated method stub
		//获取用户信息
		UserInfo userInfo = usermapper.selectByTelphone(telphone);
		if (userInfo == null){
			throw new BusinessException(EnBusinessError.LOGIN_ERROR);
		}
		UserPassword userPassword = userPasswordMapper.selectByUserId(userInfo.getId());
		//验证密码是否正确
		//为何转化为model类型？？？
		UserModel userModel = convertFromUserEntity(userInfo, userPassword);		
		if ( !userPassword.getEncrptPassword().trim().equals(encrptPassword)){
			throw new BusinessException(EnBusinessError.LOGIN_ERROR);
		}
		return userModel;
		
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
	private UserInfo convertFromUserModel(UserModel userModel){
		UserInfo userInfo = new UserInfo();
		if (userModel == null){
			return null;
		}
		BeanUtils.copyProperties(userModel, userInfo);
		return userInfo;
	}

	private UserPassword convertPasswordFromUserModel(UserModel userModel){
		UserPassword userPassword =  new UserPassword();
		if (userModel == null){
			return null;
		}
		userPassword.setEncrptPassword(userModel.getEncrptPassword());
		userPassword.setUserId(userModel.getId());
		return userPassword;
	}

	

}
