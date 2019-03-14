package com.example.miaosha.validate;

import java.util.HashMap;

import org.apache.tomcat.util.buf.StringUtils;

import lombok.Data;

@Data
public class ValidationResult {

	private boolean isError = false;
	
	private HashMap<String, String> errMsgMap = new HashMap<>();
	
	public String getErrMsg(){
		
		return StringUtils.join(errMsgMap.values());
	}
	
}
