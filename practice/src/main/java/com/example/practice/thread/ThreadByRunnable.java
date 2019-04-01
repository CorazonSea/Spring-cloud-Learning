package com.example.practice.thread;

public class ThreadByRunnable implements Runnable {
/*
 * 启动一个线程的唯一方法就是调用Thread类的start()方法，抓住这一点去建立与Thread类之间的关系
*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnable线程启动");
	}

}
