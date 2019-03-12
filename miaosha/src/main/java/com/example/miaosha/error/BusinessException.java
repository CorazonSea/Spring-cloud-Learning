package com.example.miaosha.error;
//包装器模式　业务异常类实现
public class BusinessException extends Exception implements CommonError {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommonError commonError;
	
	//直接接收EnBusinessError参数用于构造业务异常
	public BusinessException(CommonError commonError){
		super();
		this.commonError = commonError;		
	}
	//接收自定义的errMsg构造业务异常
	public BusinessException(CommonError commonError, String errMsg){
		super();
		this.commonError = commonError;	
		this.commonError.setErrMsg(errMsg);
	}

	@Override
	public int getErrCode() {
		// TODO Auto-generated method stub
		return this.commonError.getErrCode();
	}

	@Override
	public String getErrMsg() {
		// TODO Auto-generated method stub
		return this.commonError.getErrMsg();
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		// TODO Auto-generated method stub
		this.commonError.setErrMsg(errMsg);
		return this;
	}

}
