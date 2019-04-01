package com.example.practice.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
 * 方法级别匹配　@annotation(）
 * 
 * 类级别匹配　@within(),target()
 * 
 * 参数级别匹配 @args()
*/
@Aspect
@Component
public class AnnoAspectConfig {
	
	/*//@Pointcut("@annotation(com.example.practice.anno.AdminOnly)")
	//@Pointcut("@within(com.example.practice.anno.NeedSecured) && within(com.example.practice.service.*)")
	//@Pointcut("@target(com.example.practice.anno.NeedSecured) && within(com.example.practice.service.*)")	
	//@Pointcut("@args(com.example.practice.anno.NeedSecured) && within(com.example.practice.service.*)")
	public void matchAnnotation(){}
	
	@Before("matchAnnotation()")
	public void before(){
		System.out.println();
		System.out.println("######before");
		
	}*/

}
