package com.example.miaosha.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.security.MD5Encoder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.miaosha.VOModel.UserVO;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EnBusinessError;
import com.example.miaosha.model.UserModel;
import com.example.miaosha.response.CommonReturnType;
import com.example.miaosha.service.UserService;

import sun.misc.BASE64Encoder;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*" )
@MapperScan("com.example.miaosha.dao")
public class UserController extends BaseController{	
	
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
		System.out.println("telphone: "+ telphone + ", optcode: " + optCode);
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
	
	@PostMapping("/register")
	public CommonReturnType register(@RequestParam("telephone") String telephone, 
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("age") Integer age,
			@RequestParam("gender") short gender,
			@RequestParam("otpCode") String otpCode
			) throws BusinessException, NoSuchAlgorithmException, UnsupportedEncodingException{
		//1.验证手机号与验证码optcode一致
		if (StringUtils.isEmpty(otpCode)){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR, "验证码不能为空");		
		}
		String InsessionOptCode = (String)this.httpServletRequest.getSession().getAttribute(telephone);
		if (!StringUtils.isEmpty(InsessionOptCode) && !otpCode.equals(InsessionOptCode)){		
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR, "验证码不正确");			
		}
		//2.用户的注册流程
		UserModel userModel =  new UserModel();
		userModel.setAge(age);
		userModel.setEncrptPassword(encodeByMD5(password));
		userModel.setTelephone(telephone);
		userModel.setGender(gender);
		userModel.setName(name);	
		userModel.setRegisterMode("byPhone");
		userService.userRegister(userModel);
		
		return CommonReturnType.create(null);
	}
	
	@PostMapping("/login")
	public CommonReturnType login(@RequestParam("telephone") String telephone, 
			@RequestParam("password") String password) throws BusinessException, NoSuchAlgorithmException, UnsupportedEncodingException{
		//参数校验
		if (StringUtils.isEmpty(telephone) || StringUtils.isEmpty(password)){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR);
		}		
		//登陆模块,校验用户登陆是否合法		
		UserModel userModel = userService.validateLogin(telephone, this.encodeByMD5(password));
		
		//将登陆凭证加入到登陆成功的session内，假设用户单点登陆
		this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
		this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);
		return CommonReturnType.create(null);
	}
	
	private String encodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		return base64en.encode(md5.digest(str.getBytes("utf-8")));
	}

	
}
