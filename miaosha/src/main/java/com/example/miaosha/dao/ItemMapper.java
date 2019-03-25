package com.example.miaosha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.miaosha.entity.Item;

public interface ItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    int insert(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    int insertSelective(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    Item selectByPrimaryKey(Integer id);
    
    List<Item> listItem();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    int updateByPrimaryKeySelective(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Fri Mar 15 11:11:54 CST 2019
     */
    int updateByPrimaryKey(Item record);
    
    int increaseSales(@Param("id")Integer id, @Param("amount")Integer amount);    
    
    
}