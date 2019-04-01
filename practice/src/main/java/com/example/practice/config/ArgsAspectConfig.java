package com.example.practice.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
 * 参数匹配
 * args(Long,..)常用
 * excution(**..find*(Long))

*/
@Aspect
@Component
public class ArgsAspectConfig {
	
/*	@Pointcut("args(Long) && within(com.example.practice.service.*)")
	public void matchCondition(){}
	
	@Before("matchCondition()")
	public void before(){
		System.out.println();
		System.out.println("######before");
		
	}*/
}
