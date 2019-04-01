package com.example.practice.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
 * execution表达式
*/
@Aspect
@Component
public class ExcutionAspectConfig {

	@Pointcut("execution(public * com.example.practice.service.*Service.*(..))")
	public void matchCondition(){}
	
	@Before("matchCondition()")
	public void before(){
		System.out.println("");
		System.out.println("######before");
	}
}
