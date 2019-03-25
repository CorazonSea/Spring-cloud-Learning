package com.example.miaosha.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Data;

@Data
public class PromoModel {
	
	private Integer id;
	
	private String promoName;
	
	private Integer itemId;
	
	private BigDecimal promoItemPrice;
	
	private DateTime startTime;
	
	private DateTime endTime;

	//秒杀活动的状态1:活动秒杀还未开始，2:活动秒杀正在进行中,3:活动已经结束
	private Integer status;
}
