package com.example.practice.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

import com.example.practice.proxy.pattern.RealSubject;
import com.example.practice.proxy.pattern.Subject;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RealSubject.class);
		enhancer.setCallback(new DemoMethodInterceptor());
		Subject subject = (Subject) enhancer.create();
		subject.hello();
		
	}

}
