package com.example.eurekaclientfeign.controller;

import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "120_1_5411_15_12_1_2151_5_35_32_511_3";
		String [] array = str.split("_");
		String out = "";
		for(int i=0; i<array.length; i++){
			if (i%2 == 0 && i != array.length-1){
				out += array[i] + "_";
			}else{
				out += array[i] + " ";
			}
		}
		String out1 = str.replace("\\d+_\\d_", "\\d+");
		
		System.out.println("out:" + out);
		System.out.println("out1:" + out1);
	
	}

}
