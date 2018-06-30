package com.dyz.myBatis.dao;

import com.dyz.myBatis.model.Payment;
import com.dyz.myBatis.model.PaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int countByExample(PaymentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int deleteByExample(PaymentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String ordernum);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int insert(Payment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int insertSelective(Payment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	List<Payment> selectByExample(PaymentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	Payment selectByPrimaryKey(String ordernum);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Payment record,
			@Param("example") PaymentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Payment record,
			@Param("example") PaymentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Payment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table payment
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Payment record);
}