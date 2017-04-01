package com.hjf.service.impl;

/**
 * 功能说明:【账户信息】
 * 作    者：lihaijun
 * 创建日期：2014-11-21
 */
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjf.core.bean.BaseReqBean;
import com.hjf.core.bean.BaseRespBean;
import com.hjf.core.bean.reqBean.CustomerReqBean;
import com.hjf.core.bean.respBean.CustomerRespBean;
import com.hjf.core.util.CodeUtil;
import com.hjf.dao.CustomerDAO;
import com.hjf.entity.Customer;
import com.hjf.service.CustomerService;
@Service
@Transactional 
public class CustomerServiceImpl   extends BaseService implements CustomerService {
	@Resource CustomerDAO customerDAO;
	private Logger log = Logger.getLogger("h");
	
	/**
	 * 【查询我的账户信息】
	 */
	public CustomerRespBean getMyInfo(BaseReqBean q,CustomerRespBean r){
		try {
			Customer map =customerDAO.getCustomerById(q.getCustomerId());
			copyProperties(r, map);
		} catch (Exception e) {
			r.fail(CodeUtil.e_9996);
			log.error("【查询我的账户信息】..."+q.getCustomerId()+"发生异常...");
			e.printStackTrace();
			return r;
		}
		r.success();
		return r;
	}
	
	/**
	 * 【更新自己账户信息】
	 */
	public BaseRespBean updateMyInfo(CustomerReqBean q,BaseRespBean r){
		try {
			Customer c=new Customer();
			copyProperties(c, q);
			int ret=customerDAO.updateById(c);
			if (ret<0) {
				r.fail(CodeUtil.e_9998);
				log.error("【更新自己账户信息】..."+q.getCustomerId()+"发生异常...");
				return r;
			}
		} catch (Exception e) {
			r.fail(CodeUtil.e_9996);
			log.error("【更新自己账户信息】..."+q.getCustomerId()+"发生异常...");
			e.printStackTrace();
			return r;
		}
		r.success();
		return r;
	}
	
	/**
	 * 【查看他人账户信息】
	 */
	public CustomerRespBean customerInfo(BaseReqBean q,CustomerRespBean r){
		try {
			Customer map =customerDAO.getCustomerById(q.getCustomerId());
			copyProperties(r, map);
		} catch (Exception e) {
			r.fail(CodeUtil.e_9996);
			log.error("【查看他人账户信息】..."+q.getCustomerId()+"发生异常...");
			e.printStackTrace();
			return r;
		}
		r.success();
		return r;
	}	

}
