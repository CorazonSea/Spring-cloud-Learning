package com.example.practice.thread;

import java.util.concurrent.Callable;

public class ThreadByCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("call()方法被自动调用," + Thread.currentThread().getName());   
		return "Callable接口创建线程";
	}

}
