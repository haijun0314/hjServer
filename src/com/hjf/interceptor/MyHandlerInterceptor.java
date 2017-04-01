package com.hjf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jxjz.base.spring.WebUtils;
import org.jxjz.common.util.CookieUtil;
import org.jxjz.common.util.URLUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.LogUtil;
import org.jxjz.framework.util.SessionUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hjf.entity.Customer;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        WebUtils.setRequest((HttpServletRequest)request);  
        WebUtils.setResponse((HttpServletResponse)response);  
		String ck=CookieUtil.getCookie(ConfigUtil.Cookie_Login_User);
		Customer c=(Customer) SessionUtil.getSession(ConfigUtil.Session_Login_User);
		//就简单判断了一下，如果要详细控制可以用spring security
		String  url=URLUtil.buildRequestUrl(request);
		Logger log=LogUtil.getLogger(); 
		log.info("【访问系统URL】"+url);
		return true;
			
	}
	
}
