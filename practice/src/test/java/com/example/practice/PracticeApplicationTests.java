package com.example.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.practice.service.LogService;
import com.example.practice.service.ProductService;
import com.example.practice.service.SubService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracticeApplicationTests {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private SubService subService;

/*	@Test
	public void contextLoads() {
		
		
	}*/
	@Test
	public void annoInsert() {
		productService.insert((long)5);
		
	}
	@Test
	public void annoDelete() {
		productService.delete();
		
	}
	
	@Test
	public void annoLog() {
		logService.log();
		logService.argsAnno(null);
	}
	
	@Test
	public void annoSubDemo() {
		subService.demo();
		subService.delete();
		subService.insert((long)8);
		
	}

}
