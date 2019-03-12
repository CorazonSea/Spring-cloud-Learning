package com.example.miaosha.error;


public enum EnBusinessError implements CommonError {
	//通用错误类型10001
	PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
	UNKNOWN_ERROR(10002, "未知错误"),
		
	//20000开头为用户信息错误相关定义
	USER_NOT_EXIST(20001,"用户不存在"),
	
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
