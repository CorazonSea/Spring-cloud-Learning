package com.example.miaosha.response;

import lombok.Data;

@Data
public class CommonReturnType {
	//对应请求的返回处理结果，success,fail
	private String status;
	private Object data;
	
	//通用的创建方法
	public static CommonReturnType create(Object result){
		return CommonReturnType.create(result, "success");
	}
	
	public static CommonReturnType create(Object result, String status){
		CommonReturnType commonReturnType = new CommonReturnType();
		commonReturnType.setStatus(status);
		commonReturnType.setData(result);
		return commonReturnType;
	}
}
