package com.example.miaosha.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.miaosha.VOModel.UserVO;
import com.example.miaosha.dao.UserInfoMapper;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.response.CommonReturnType;
import com.example.miaosha.service.UserService;

@RestController
@RequestMapping("/user")
@MapperScan("com.example.miaosha.dao")
public class UserController extends BaseController{
	
	@Autowired
	private UserInfoMapper userInfoMaper;
	
	@Autowired
	private UserService userService;
	
	@Autowired HttpServletRequest httpServletRequest;
	
	//用户获得otp短信接口
	@GetMapping("/getotp")
	public CommonReturnType getotp(@RequestParam("telphone") String telphone){
		//按照一定的规则生成opt验证码
		Random random = new Random();
		int randomInt = random.nextInt(99999);
		randomInt += 10000;
		String optCode = String.valueOf(randomInt);
		
		//将验证码和手机号关联，使用httpSession方式绑定手机号和验证码
		httpServletRequest.getSession().setAttribute(telphone, optCode);
		
		//将optCode通过短信通道发送给用户
		
		return CommonReturnType.create(null);
	}
	
	
	@GetMapping("/get")
	public CommonReturnType getUser(@RequestParam("id") Integer id) throws BusinessException{
		//从service层获取用户对象返回前端
		UserVO userVO = userService.getUserById(id);	
		if (userVO == null){
			userVO.setAge(66);
			//throw new BusinessException(EnBusinessError.USER_NOT_EXIST);
		}
		return CommonReturnType.create(userVO);
	}
	
}
