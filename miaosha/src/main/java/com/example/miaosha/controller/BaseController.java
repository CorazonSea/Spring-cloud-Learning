package com.example.miaosha.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EnBusinessError;
import com.example.miaosha.response.CommonReturnType;

public class BaseController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public Object handleException(HttpServletRequest request, Exception ex){
		HashMap<String, Object> responseData = new HashMap<>();
		
		if (ex instanceof BusinessException){
			BusinessException businessException = (BusinessException)ex;
			responseData.put("errCode", businessException.getErrCode());
			responseData.put("errMsg", businessException.getErrMsg());
			((BusinessException) ex).getErrCode();
		}else{
			responseData.put("errCode", EnBusinessError.UNKNOWN_ERROR.getErrCode());
			responseData.put("errMsg", EnBusinessError.UNKNOWN_ERROR.getErrMsg());
		}
		return CommonReturnType.create(responseData, "fail");
		
	}

	

}
