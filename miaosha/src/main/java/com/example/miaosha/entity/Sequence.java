package com.example.miaosha.entity;

public class Sequence {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.name
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.current_value
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    private Integer currentValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.step
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    private Integer step;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.name
     *
     * @return the value of sequence.name
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.name
     *
     * @param name the value for sequence.name
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.current_value
     *
     * @return the value of sequence.current_value
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    public Integer getCurrentValue() {
        return currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.current_value
     *
     * @param currentValue the value for sequence.current_value
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.step
     *
     * @return the value of sequence.step
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    public Integer getStep() {
        return step;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.step
     *
     * @param step the value for sequence.step
     *
     * @mbg.generated Fri Mar 22 14:15:17 CST 2019
     */
    public void setStep(Integer step) {
        this.step = step;
    }
}