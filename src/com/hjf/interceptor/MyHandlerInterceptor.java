package com.hjf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jxjz.base.spring.WebUtils;
import org.jxjz.common.util.CookieUtil;
import org.jxjz.common.util.JsonUtil;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.common.util.URLUtil;
import org.jxjz.common.util.secret.DesUtil;
import org.jxjz.framework.util.ConfigUtil;
import org.jxjz.framework.util.LogUtil;
import org.jxjz.framework.util.SessionUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hjf.core.bean.BaseRespBean;
import com.hjf.core.util.CodeUtil;
import com.hjf.entity.Customer;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter {
	Logger log=LogUtil.getLogger(); 
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		//就简单判断了一下，如果要详细控制可以用spring security
		String  url=URLUtil.buildRequestUrl(request);
		if(url.endsWith(".html")){
			return true;
		}
		log.info("【权限session拦截】"+url);
        WebUtils.setRequest((HttpServletRequest)request);  
        WebUtils.setResponse((HttpServletResponse)response);  
		String ck=CookieUtil.getCookie(ConfigUtil.Cookie_Login_User);
		if(StringUtils.isBlank(ck)){
			log.info("【权限session拦截】【检测到访问cookie为空】 返回登录页面"+url);
			invalidSession(response);
			return false;
		}
		ck=DesUtil.decrypt(ck, ConfigUtil.sys_secKey);
		if (ConfigUtil.isSessionLocal()) {
			log.info("【权限session拦截】....session本地存储 ck="+ck);
			Customer c=(Customer) SessionUtil.getLocalSession(ConfigUtil.Session_Login_User);
			if(c==null){
				invalidSession(response);
				return false;
			}
		}else {
			log.info("【权限session拦截】....session远程存储 ck="+ck);
			String cks[]=ck.split("_");
			String  session=SessionUtil.getRemoteSession(cks[0]);
			if(StringUtils.isBlank(session)){
				invalidSession(response);
				return false;
			}
			
			
		}
		return true;
			
	}
	
	public void invalidSession(HttpServletResponse response) {
		log.info("【权限session拦截】【session 失效】 返回登录页面");
		BaseRespBean  r=new BaseRespBean();
		r.fail(CodeUtil.e_1010);
		ResponseUtils.renderJson(response, JsonUtil.obj2Json(r));
	}
	
	
	
	
	
}
