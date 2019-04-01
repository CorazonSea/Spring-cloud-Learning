package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.anno.AdminOnly;
import com.example.practice.entity.Product;

@Service
public class LogService implements Loggable {

	@Override
	//@AdminOnly
	public void log() {
		// TODO Auto-generated method stub
		System.out.println("log from logService");
	}
	
	public void argsAnno(Product product){
		System.out.println("excute args annotation from logService");
	}

}
