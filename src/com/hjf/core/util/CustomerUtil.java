package com.hjf.core.util;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.jxjz.common.util.secret.DesUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.LogUtil;

import com.hjf.core.bean.reqBean.RegisterReqBean;
import com.hjf.entity.Customer;


/**
 * 账户工具类
 * lihaijun
 * 2014-12-03
 */
public class CustomerUtil { 
	static Logger log=LogUtil.getLogger();
	
	/**
	 * 初始化账户
	 */
	public static  Customer createCustomer(RegisterReqBean  q) {
		String password=SecUtil.encrypt(q.getPassword());
		Customer cst=new Customer();
		cst.setPassword(password);
		cst.setTelephone(q.getTelephone());
		cst.setRegistTime(new Date());
		return cst;
	}	  
	 	
	
	/**
	 * 创建token
	 */
	public static  void createToken(Customer  c) {
		try {
			String token=DesUtil.encrypt(c.getTelephone()+"-"+c.getCustomerId()+"-"+UUID.randomUUID(), ConfigUtil.sys_secKey);
			c.setUserToken(token);
		} catch (Exception e) {
			log.error("创建登录账户token  失败"+e.getMessage());
			 e.getStackTrace();
		}
	}
	
}
