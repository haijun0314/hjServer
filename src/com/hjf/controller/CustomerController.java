package com.hjf.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jxjz.base.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjf.core.bean.BaseReqBean;
import com.hjf.core.bean.BaseRespBean;
import com.hjf.core.bean.reqBean.CustomerReqBean;
import com.hjf.core.bean.respBean.CustomerRespBean;
import com.hjf.core.util.CodeUtil;
import com.hjf.service.CustomerService;
 
/**
 * 功能说明:【用户信息】
 * 作    者：lihaijun
 * 创建日期：2014-11-21
 */
@Controller  
@RequestMapping("/cus") 
public class CustomerController extends BaseAction{
	@Resource CustomerService     customerService;
	public Logger log = Logger.getLogger("h");	
	/**
	 * 【查询自己账户信息】
	 */
	@RequestMapping(params = "myInfo")   
	public void myInfo(HttpServletRequest request,HttpServletResponse response) {
		try {
			log.info("【查询自己账户信息】...");
			BaseReqBean    		q =new BaseReqBean();
			CustomerRespBean    r =new CustomerRespBean();
			boolean check        =q.checkToken(request);
			if (!check) {
				r.fail(CodeUtil.e_9999);
				respMsgObj(response, r);
				return;	
			}
			r=customerService.getMyInfo(q, r);
			respMsgObj(response, r);
		} catch (Exception e) {
			log.error("【查询自己账户信息】...发生异常");
			errorMsg(response);
		}
	}	
	
	
	
	/**
	 * 【更新自己账户信息】
	 */
	@RequestMapping(params = "updateMyInfo")   
	public void updateMyInfo(HttpServletRequest request,HttpServletResponse response) {
		try {
			CustomerReqBean    	q =new CustomerReqBean();
			BaseRespBean    	r =new BaseRespBean();
			boolean check        =q.checkUpdateParams(request);
			if (!check) {
				r.fail(CodeUtil.e_9999);
				respMsgObj(response, r);
				return;	
			}
			r=customerService.updateMyInfo(q, r);
			respMsgObj(response, r);
		} catch (Exception e) {
			log.error("【查询自己账户信息】...发生异常");
			errorMsg(response);
		}
	}		
	
	/**
	 * 【查看他人账户信息】
	 */
	@RequestMapping(params = "customerInfo")   
	public void customerInfo(HttpServletRequest request,HttpServletResponse response) {
		try {
			BaseReqBean    		q =new BaseReqBean();
			CustomerRespBean    r =new CustomerRespBean();
			boolean check        =q.checkCustomerId(request);
			if (!check) {
				r.fail(CodeUtil.e_9999);
				respMsgObj(response, r);
				return;	
			}
			r=customerService.getMyInfo(q, r);
			respMsgObj(response, r);
		} catch (Exception e) {
			log.error("【查看他人账户信息】...发生异常");
			errorMsg(response);
		}
	}	
	
	
	
	
	
	
	
	 
	
}
