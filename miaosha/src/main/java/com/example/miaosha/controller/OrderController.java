package com.example.miaosha.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EnBusinessError;
import com.example.miaosha.model.UserModel;
import com.example.miaosha.response.CommonReturnType;
import com.example.miaosha.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*" )
public class OrderController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@PostMapping("create")
	public CommonReturnType createOrder(/*@RequestParam("userId") Integer userId*/
			@RequestParam("itemId") Integer itemId,
			@RequestParam("amount") Integer amount) throws BusinessException{
		//用户登陆之后下单
	/*	Boolean isLogin = (Boolean) httpServletRequest.getAttribute("IS_LOGIN");
		if (isLogin == null || !isLogin){
			throw new BusinessException(EnBusinessError.USER_NOT_EXIST,"用户未登录");
		}*/
		//UserModel userModel = (UserModel) httpServletRequest.getAttribute("LOGIN_USER");
		//创建订单
		orderService.createOrder(1, itemId, amount);
		
		return CommonReturnType.create(null);
	}
}
