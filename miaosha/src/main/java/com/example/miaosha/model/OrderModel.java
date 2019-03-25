package com.example.miaosha.model;

import java.math.BigDecimal;

import lombok.Data;

//交易模型
@Data
public class OrderModel {
	private String id;
	private Integer userId;
	private Integer itemId;
	//如果非空，则订单为活动商品
	private Integer promoId;
	//若promoId非空，价钱为活动时价钱
	private BigDecimal itemPrice;
	//购买数量
	private Integer amount;
	//购买金额
	private BigDecimal orderPrice;
	
	
	
	
}
