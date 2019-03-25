package com.example.miaosha.VOModel;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Data;
@Data
public class ItemVO {
	private Integer id;
	//商品名称
	private String title;
	
	//商品价格
	private BigDecimal price;
	
	//商品描述
	private String description;
	
	//商品库存	
	private Integer stock;
	
	//商品销量
	private Integer sales;
	
	//商品描述图片的url
	private String imgUrl;	
	//秒杀活动状态０：没有秒杀活动，１：秒杀活动未开始，２秒杀活动正在进行中
	private Integer promoStatus;
	
	private BigDecimal promoItemPrice;
	
	private String startTime;
	
	private String endTime;
	
}
