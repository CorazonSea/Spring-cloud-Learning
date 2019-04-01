package com.example.practice.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class DemoMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before cglib");
		Object object = null;
		try {
			object = proxy.invokeSuper(arg0, arg2);
			
		} catch (Exception e) {			
			// TODO: handle exception
			System.out.println("ex:" + e.getMessage());
			throw e;
		}finally{
			System.out.println("after cglib");
		}
		
		return object;
	}

}
