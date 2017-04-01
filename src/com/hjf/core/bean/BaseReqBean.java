package com.hjf.core.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jxjz.common.util.secret.DesUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.LogUtil;


/**
 * 请求实体共用
 * author lihaijun
 * createTime   2014-12-02
 */
public class BaseReqBean {
	private String   userToken; 
	private Integer  customerId;		
	private String   versionNO;//版本编号
	private String   telephone;//账户
	private String   password;//用户密码
	public Logger   log = LogUtil.getLogger(); 
	/**
	 * 【检查请求token】
	 */
	public boolean	checkToken(HttpServletRequest request){
		String userToken  =request.getParameter("userToken");
		if (StringUtils.isBlank(userToken)) {
			log.error("【检查请求token】userToken为空......");
			return false;
		}else {
			String tokenKey=ConfigUtil.sys_secKey;
			String token;
			
			try {
				token = DesUtil.decrypt(userToken, tokenKey);
				if (StringUtils.isBlank(token)) {
					return false;
				}
				String [] tokens=token.split("-");
				this.telephone=tokens[0];
				this.password =tokens[1];
				this.customerId=new Integer(tokens[2]);
				log.error("【检查请求token】telephone="+telephone+"...password="+password+"...customerId="+customerId);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

			return true;
		} 
	}	
	
	/**
	 * 【检查请求CustomerId】
	 */
	public boolean	checkCustomerId(HttpServletRequest request){
		String customerId  =request.getParameter("customerId");
		if (StringUtils.isBlank(customerId)) {
			log.error("【检查请求token】customerId为空......");
			return false;
		}else {
			this.customerId=new Integer(customerId);
			log.error("【检查请求customerId】customerId="+customerId);
			return true;
		} 
	}	
	
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	 

	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getVersionNO() {
		return versionNO;
	}

	public void setVersionNO(String versionNO) {
		this.versionNO = versionNO;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	
	
	 
	 
	 
	 
	
}
