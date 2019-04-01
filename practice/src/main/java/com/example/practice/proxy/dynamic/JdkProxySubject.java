package com.example.practice.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.example.practice.proxy.pattern.RealSubject;

public class JdkProxySubject implements InvocationHandler{
	
	RealSubject realSubject;	
	

	public JdkProxySubject(RealSubject realSubject) {
		super();
		this.realSubject = realSubject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before");
		Object object = null;
		try {
			//真正对象开始执行方法,方法反射调用
			object = method.invoke(realSubject, args);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ex:" + e.getMessage());
			throw e;
		}finally{
			System.out.println("after");
		}
		
		return object;
	}

}
