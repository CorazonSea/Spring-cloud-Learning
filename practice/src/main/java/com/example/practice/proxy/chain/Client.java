package com.example.practice.proxy.chain;

public class Client {
	
	static class HandlerA extends Handler{
		@Override
		protected void handleProcess() {
			// TODO Auto-generated method stub
			System.out.println("handler by a");
		}
		
	}
	static class HandlerB extends Handler{
		@Override
		protected void handleProcess() {
			// TODO Auto-generated method stub
			System.out.println("handler by b");
		}
		
	}
	static class HandlerC extends Handler{
		@Override
		protected void handleProcess() {
			// TODO Auto-generated method stub
			System.out.println("handler by c");
		}
		
	}

	public static void main(String[] args) {
		HandlerA handlerA = new HandlerA();
		HandlerB handlerB = new HandlerB();
		HandlerC handlerC = new HandlerC();
		
		handlerA.setSucessor(handlerB);
		handlerB.setSucessor(handlerC);
		
		
		handlerA.execute();
		
	}
}
