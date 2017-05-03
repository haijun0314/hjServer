package com.hjf.dao;

import java.util.Map;

import org.jxjz.base.mybatis.BaseIbatisDAO;
import org.springframework.stereotype.Repository;

import com.hjf.entity.Customer;

/**
 * 用户
 * lihaijun
 * 2014-12-01
 */
@Repository
public class CustomerDAO extends BaseIbatisDAO{
	
	 
	
	/**
	 *【重设账户登录密码】
	 */
	public int resetPassword( Customer c){
		return update(c,"resetPassword");
	}	
	
	/**
	 * 根据sessionId查询用户
	 */
	public Customer getCustomerById(Integer customerId) {
		return (Customer)getObjById(customerId);
	}	
	 
	 
	public Class getEntityClass() {
		return Customer.class;
	}	
	 
}