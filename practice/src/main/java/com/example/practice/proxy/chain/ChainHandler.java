package com.example.practice.proxy.chain;

public abstract class ChainHandler {
	
	
	public void execute(Chain chain){
		handleProcess();
		chain.proceed();
		
	}
	protected abstract void handleProcess();  

}
