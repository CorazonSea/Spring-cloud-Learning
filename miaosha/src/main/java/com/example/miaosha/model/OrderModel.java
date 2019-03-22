package com.example.miaosha.model;

import java.math.BigDecimal;

import lombok.Data;

//交易模型
@Data
public class OrderModel {
	private String id;
	private Integer userId;
	private Integer itemId;
	
	private BigDecimal itemPrice;
	//购买数量
	private Integer amount;
	//购买金额
	private BigDecimal orderPrice;
	
	
}
