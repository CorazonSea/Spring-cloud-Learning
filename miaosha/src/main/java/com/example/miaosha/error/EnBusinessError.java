package com.example.miaosha.error;


public enum EnBusinessError implements CommonError {
	//通用错误类型10001
	PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
	UNKNOWN_ERROR(10002, "未知错误"),
	
		
	//20000开头为用户信息错误相关定义
	USER_NOT_EXIST(20001,"用户不存在"),
	LOGIN_ERROR(2002,"用户手机号码或者密码错误"),
	ITEM_NOT_EXIST(20001,"商品不存在"),
	USER_NOT_LOGIN(20002,"用户未登录"),
	
	
	//30000库存信息错误定义
	STOCK_NOT_ENOUGH(30001,"库存不足"),
	
	
	;
	
	private int errCode;
	private String errMsg;
	
	private EnBusinessError(int errCode, String errMsg){		
		this.errCode = errCode;
		this.errMsg = errMsg;		
	}
	
	
	@Override
	public int getErrCode() {
		// TODO Auto-generated method stub
		return this.errCode;
	}

	@Override
	public String getErrMsg() {
		// TODO Auto-generated method stub
		return this.errMsg;
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		// TODO Auto-generated method stub
		this.errMsg = errMsg;
		return this;
	}

}
