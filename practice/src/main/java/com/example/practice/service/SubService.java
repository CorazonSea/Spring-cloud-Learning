package com.example.practice.service;

import org.springframework.stereotype.Service;

@Service
public class SubService extends ProductService {
	
	public void demo(){
		System.out.println("excute sub service method");
		
	}

}
