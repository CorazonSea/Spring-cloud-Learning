package com.example.practice.proxy.chain;

import java.util.Arrays;
import java.util.List;

public class ChainClient {
	
	static class ChainHandlerA extends ChainHandler{

		@Override
		protected void handleProcess() {
			// TODO Auto-generated method stub
			System.out.println("handler by chain a");
		}
		
	}
	
	static class ChainHandlerB extends ChainHandler{

		@Override
		protected void handleProcess() {
			// TODO Auto-generated method stub
			System.out.println("handler by chain b");
		}
		
	}
	
	static class ChainHandlerC extends ChainHandler{

		@Override
		protected void handleProcess() {
			// TODO Auto-generated method stub
			System.out.println("handler by chain c");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(),new ChainHandlerB(),new ChainHandlerC());	
		Chain chain = new Chain(handlers);
		chain.proceed();
	}

}
