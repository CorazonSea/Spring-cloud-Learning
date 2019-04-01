package com.example.practice.proxy.chain;

import lombok.Data;
/*
 * 多个AOP作用于同一个对象时如何叠加：采用责任链方式
 * AOP责任连
*/
@Data
public abstract class Handler {
	
	private Handler sucessor;		
	
	public void execute(){
		handleProcess();
		if (sucessor != null){
			sucessor.execute();
		}
	}
	
	protected abstract void handleProcess(); 
}
