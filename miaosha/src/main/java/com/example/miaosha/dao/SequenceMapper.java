package com.example.miaosha.dao;

import com.example.miaosha.entity.Sequence;

public interface SequenceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    int insert(Sequence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    int insertSelective(Sequence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    Sequence selectByPrimaryKey(String name);

    Sequence selectByName(String name);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    int updateByPrimaryKeySelective(Sequence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    int updateByPrimaryKey(Sequence record);
}