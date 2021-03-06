package com.example.miaosha.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ItemModel {

	private Integer id;
	//商品名称
	@NotBlank(message = "商品名称不能为空")
	private String title;
	
	//商品价格
	@NotNull(message = "商品价格不能为空")
	@Min(value = 0, message = "商品价格必须大于0")
	private BigDecimal price;
	
	//商品描述
	@NotBlank(message = "商品描述信息不能为空")
	private String description;
	
	//商品库存
	@NotNull(message = "库存不能为空")
	private Integer stock;
	
	//商品销量
	private Integer sales;
	
	//商品描述图片的url
	@NotBlank(message = "商品图片信息不能为空")
	private String imgUrl;	
	
	//使用聚合模型．即类的嵌套
	private PromoModel promoModel;	
	
	
}
