package com.hjf.core.util;

import org.apache.log4j.Logger;
import org.jxjz.common.util.secret.DesUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.LogUtil;

import com.hjf.entity.Customer;


/**
 * 账户工具类
 * lihaijun
 * 2014-12-03
 */
public class CustomerUtil { 
	static Logger log=LogUtil.getLogger();
	/**
	 * 创建token
	 */
	public static  void createToken(Customer  c) {
		try {
			String tokenKey=ConfigUtil.sys_secKey;
			String token=DesUtil.encrypt(c.getTelephone()+"-"+c.getPassword()+"-"+c.getCustomerId(), tokenKey);
			c.setUserToken(token);
		} catch (Exception e) {
			log.error("创建登录账户token  失败"+e.getMessage());
			 e.getStackTrace();
		}
	}
	
}
