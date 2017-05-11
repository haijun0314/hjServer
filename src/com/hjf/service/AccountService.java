package com.hjf.service;

import com.hjf.core.bean.BaseReqBean;
import com.hjf.core.bean.BaseRespBean;
import com.hjf.core.bean.reqBean.CustomerReqBean;
import com.hjf.core.bean.respBean.CustomerRespBean;
/**
 * 功能说明:【账户信息】
 * 作    者：lihaijun
 * 创建日期：2014-11-21
 */
public interface AccountService {
	
	//【查询账户信息】
	public CustomerRespBean getMyInfo(BaseReqBean q,CustomerRespBean r);	
	//【更新自己账户信息】
	public BaseRespBean updateMyInfo(CustomerReqBean q,BaseRespBean r)	;	 
	//【查看他人账户信息】
	public CustomerRespBean customerInfo(BaseReqBean q,CustomerRespBean r)	;	
	
	
}
