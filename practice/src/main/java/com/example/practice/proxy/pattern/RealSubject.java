package com.example.practice.proxy.pattern;

public class RealSubject implements Subject{

	@Override
	public void request() {
		// TODO Auto-generated method stub
		System.out.println("execute realsubject request method");
	}

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("execute realsubject hello method");
	}

}
