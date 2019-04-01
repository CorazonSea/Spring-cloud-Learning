package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.anno.NeedSecured;

@Service
//@NeedSecured
/*@NeedSecuredSource
@NeedSecuredClass*/
public class ProductService {

	public void insert(Long id){
		System.out.println("insert product");
	}
	
	public void delete(){
		System.out.println("delete product");
	}
}
