package com.example.practice.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.example.practice.proxy.pattern.RealSubject;
import com.example.practice.proxy.pattern.Subject;
/*
 * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
 * 生成的字节码保存起来
 * Proxy.newProxyInstance
 * getProxyClass0，
 * 
*/
public class Client {

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		
		Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), 
				new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));
		subject.request();
		subject.hello();
	}

}
