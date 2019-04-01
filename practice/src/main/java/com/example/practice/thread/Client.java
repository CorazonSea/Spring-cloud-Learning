package com.example.practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		System.out.println("main ...");
		
		
		ThreadByThread myThread =  new ThreadByThread();		
		myThread.start();
		
		
		Runnable runnable = new ThreadByRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
		
		
		Callable callable = new ThreadByCallable();
		//3.利用FutureTask类的构造方法public  FutureTask(Claaable<V> callable)
		//将Callable接口的对象传给FutureTask类
		//FutureTask 实现RunableFutrue接口，　RunableFutrue接口　extends Runable接口
		FutureTask task = new FutureTask(callable);
		//4.将FutureTask类的对象隐式地向上转型
		//从而作为Thread类的public Thread(Runnable runnable)构造方法的参数
		Thread thread1 = new Thread(task);
		//5.调用Thread类的start()方法
		thread1.start();
		//FutureTask的get()方法用于获取FutureTask的call()方法的返回值，为了取得线程的执行结果
		System.out.println(task.get());

		
		
		
		
	}

}
