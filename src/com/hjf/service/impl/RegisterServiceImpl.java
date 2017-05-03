package com.hjf.service.impl;

/**
 * 登录注册服务
 */
import javax.annotation.Resource;

import org.jxjz.common.util.CookieUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.SessionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjf.core.bean.reqBean.RegisterReqBean;
import com.hjf.core.bean.respBean.RegisterRespBean;
import com.hjf.core.util.CodeUtil;
import com.hjf.core.util.CustomerUtil;
import com.hjf.dao.CustomerDAO;
import com.hjf.entity.Customer;
import com.hjf.service.CustomerService;
import com.hjf.service.RegisterService;
import com.hjf.service.SmsService;
@Service
@Transactional 
public class RegisterServiceImpl extends BaseService  implements RegisterService {
	@Resource  CustomerService   	customerService;
	@Resource  CustomerDAO  	    customerDAO;
	@Resource  SmsService 		    smsService;
 
	/**
	 * 账户注册
	 * 1、检查是否已经注册过
	 * 2、验证短信验证码
	 * 3、准备昵称
	 * 4、创建账户
	 * 3、添加注册用户缓存
	 */
	public RegisterRespBean register( RegisterReqBean  q,RegisterRespBean r ){
		boolean ret =smsService.smsCheck(q.getTelephone(),q.getSmsCode());
		if (!ret) {
			r.fail( CodeUtil.e_1006);
			log.error("【账户注册】"+q.getTelephone()+" 短信验证失败");
			return r;
		}
		//检查是否已经注册过
		Customer c=(Customer) customerDAO.getObjById(q.getTelephone(), "findByTelephone");
		if (c!=null) {
			r.fail(CodeUtil.e_1007);
			log.error("【账户注册】"+q.getTelephone()+" 该账户已经注册   不能重复注册");
			return r;
		}
	
		try {
			//创建账户
			Customer cst=CustomerUtil.createCustomer(q);
			int id=customerDAO.saveWithReturnId(cst);
			if (id<0) {
				r.fail(CodeUtil.e_1005);
				log.info("【账户注册】失败"+q.getTelephone());
				return r;
			}
			cst.setCustomerId(id);
			r.setCustomerId(id);
			CustomerUtil.createToken(cst);
			SessionUtil.setSession(ConfigUtil.Session_Login_User, cst);
			CookieUtil.setCookie(ConfigUtil.Cookie_Login_User, cst.getUserToken());
		} catch (Exception e) {
			log.error("【账户注册】...发生异常..."+e.getMessage());
			e.getMessage();
			r.fail(CodeUtil.e_1005);
			return r;
		}
		r.success();
		return r;
	}
	

}
