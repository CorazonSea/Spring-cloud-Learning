package com.example.practice.proxy.chain;

import java.util.List;

public class Chain {
	
	private List<ChainHandler> Handlers;	

	public Chain(List<ChainHandler> Handlers) {
		super();
		this.Handlers = Handlers;
	}

	private int index = 0;
	
	public void proceed(){
		if (index >= Handlers.size()){
			return;
		}
		Handlers.get(index++).execute(this);
	}
	
}
