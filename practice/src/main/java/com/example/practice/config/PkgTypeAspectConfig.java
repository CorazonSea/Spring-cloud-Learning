package com.example.practice.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
匹配包或者类
within()
within(com.example.practice.service.ProductService)
within(com.example.practice.service.*)
*/
@Aspect
@Component
public class PkgTypeAspectConfig {
/*	@Pointcut("within(com.example.practice.service.*)")
	public void matchType(){
		
	}
	
	@Before("matchType()")//advice通知
	public void before(){
		System.out.println();
		System.out.println("######before");
		
	}
	*/

}
 