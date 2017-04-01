package com.hjf.service.impl;

/**
 * 【用户登录】
 */
import javax.annotation.Resource;

import org.jxjz.common.util.CookieUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.SessionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjf.core.bean.reqBean.LoginReqBean;
import com.hjf.core.bean.respBean.LoginRespBean;
import com.hjf.core.util.CodeUtil;
import com.hjf.core.util.CustomerUtil;
import com.hjf.dao.CustomerDAO;
import com.hjf.entity.Customer;
import com.hjf.service.LoginService;
@Service
@Transactional 
public class LoginServiceImpl extends BaseService  implements LoginService {
	@Resource CustomerDAO customerDAO;
	/**
	 * 【用户登录】
	 */
	public LoginRespBean login(LoginReqBean q,LoginRespBean     r ){
		Customer  lo=new Customer();
		lo.setPassword(q.getPassword());
		lo.setTelephone(q.getTelephone());
		Customer c =(Customer) customerDAO.getObjById(lo, "Customer.login");
		if (c==null) {
			log.error("【用户登录】...登录失败....没有查询到该账户信息");
			r.fail(CodeUtil.e_1003);
			return r;
		}
		CustomerUtil.createToken(c);
		SessionUtil.setSession(ConfigUtil.Session_Login_User, c);
		CookieUtil.setCookie(ConfigUtil.Cookie_Login_User, c.getUserToken());
		copyProperties(r, c);
		r.success();
		return r;
	}
	
	 
	

}
