package com.example.miaosha.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.id
     *
     * @mbg.generated Mon Mar 18 10:41:13 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.item_id
     *
     * @mbg.generated Mon Mar 18 10:41:13 CST 2019
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.user_id
     *
     * @mbg.generated Mon Mar 18 10:41:13 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.item_price
     *
     * @mbg.generated Mon Mar 18 10:41:13 CST 2019
     */
    private BigDecimal itemPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.amount
     *
     * @mbg.generated Mon Mar 18 10:41:13 CST 2019
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.order_price
     *
     * @mbg.generated Mon Mar 18 10:41:13 CST 2019
     */
    private BigDecimal orderPrice;
    
    private Integer promoId;

   
}