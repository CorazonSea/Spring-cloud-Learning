package com.example.miaosha.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Promo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column promo.id
	 * @mbg.generated  Mon Mar 25 13:52:16 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column promo.promo_name
	 * @mbg.generated  Mon Mar 25 13:52:16 CST 2019
	 */
	private String promoName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column promo.promo_item_price
	 * @mbg.generated  Mon Mar 25 13:52:16 CST 2019
	 */
	private BigDecimal promoItemPrice;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column promo.item_id
	 * @mbg.generated  Mon Mar 25 13:52:16 CST 2019
	 */
	private Integer itemId;
	
	private Integer promoId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column promo.start_time
	 * @mbg.generated  Mon Mar 25 13:52:16 CST 2019
	 */
	private Date startTime;
	
	private Date endTime;

	
}