package com.example.practice.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
 * 
 * //实现类，代理对象；
this(com.example.practice.service.Loggable)

//所有实现他的类
target(com.example.practice.service.Loggable)
//Introduction：动态生成方法,this可以拦截，target不可以拦截

//过滤spring托管的bean的实例，通过bean的名称进行过滤
bean(*Service)
*/
@Aspect
@Component
public class ObjectTypeAspectConfig {
	/*@Pointcut("bean(LogService)")
	public void matchCondition(){
		
	}
	
	@Before("matchCondition()")//advice通知
	public void before(){
		System.out.println();
		System.out.println("######before");
		
	}*/
	
}
