package com.example.miaosha.entity;

import lombok.Data;

@Data
public class ItemStock {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_stock.id
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_stock.stock
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_stock.item_id
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    private Integer itemId;


}