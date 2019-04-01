package com.example.practice.proxy.pattern;

/*
 * 代理模式
 * 代理对象不会真正执行逻辑，只是委托给真是的对象来执行
*/
public class Proxy implements Subject {

	private RealSubject realSubject;	
	
	
	public Proxy(RealSubject realSubject) {
		super();
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		// TODO Auto-generated method stub
		System.out.println("before");
		try {
			realSubject.request();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			System.out.println("finally");
		}
	}

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		
	}

}
