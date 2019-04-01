package com.example.practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadByExecutor {
	
	
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();   
/*		ExecutorService executorService = Executors.newFixedThreadPool(5);  
 *      ExecutorService executorService = Executors.newScheduledThreadPool(); 
		ExecutorService executorService = Executors.newSingleThreadExecutor();  */
		
		//1.Executor执行Runnable任务
		for (int i = 0; i < 5; i++){   
            executorService.execute(new ThreadByRunnable());   
            System.out.println("************* a" + i + " *************");   
        }   
        executorService.shutdown(); 
        
        //2.Executor执行Callable任务
        ExecutorService executorService1 = Executors.newCachedThreadPool();   
        List<Future<String>> resultList = new ArrayList<Future<String>>();   
        for (int i = 0; i < 10; i++) {
        	//使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
        	Future<String> future =  executorService1.submit(new ThreadByCallable());
        	//将任务执行结果存储到List中   
        	resultList.add(future);   
		}
        
        
      //遍历任务的结果   
        /*
         * submit也是首先选择空闲线程来执行任务，如果没有，才会创建新的线程来执行任务。
         * 另外，需要注意：如果Future的返回尚未完成，则get（）方法会阻塞等待，直到Future完成返回，
         * 可以通过调用isDone（）方法判断Future是否完成了返回。
        */
        for (Future<String> future : resultList) {			 
			try {
				while(future.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成 
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 //启动一次顺序关闭，执行以前提交的任务，但不接受新任务  
                executorService1.shutdown();   
			}
			
		}
		
	}
}
