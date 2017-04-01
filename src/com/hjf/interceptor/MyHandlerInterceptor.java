package com.hjf.interceptor;

import java.util.ArrayList;
import java.util.List;

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
	List<String> filterAuthorities=new ArrayList<String>();
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		//就简单判断了一下，如果要详细控制可以用spring security
		String  url=URLUtil.buildRequestUrl(request);
		log.info("【权限session拦截】"+url);
        WebUtils.setRequest((HttpServletRequest)request);  
        WebUtils.setResponse((HttpServletResponse)response);  
		if(decideFilterAuthorities(url)){
			return true;
		}

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
			String cks[]=ck.split("-");
			String  session=SessionUtil.getRemoteSession(cks[0]);
			if(StringUtils.isBlank(session)){
				invalidSession(response);
				return false;
			}
			SessionUtil.continueSession(cks[0], session);
			
		}
		return true;
			
	}
	
	public void invalidSession(HttpServletResponse response) {
		log.info("【权限session拦截】【session 失效】 返回登录页面");
		BaseRespBean  r=new BaseRespBean();
		r.fail(CodeUtil.e_1010);
		ResponseUtils.renderJson(response, JsonUtil.obj2Json(r));
	}
	
	
	/**
	 *  检测是否是不要安全验证的
	 */
	public boolean decideFilterAuthorities(String url) {
		if(url.endsWith(".html")){
			return true;
		}
		if (filterAuthorities==null||filterAuthorities.size()<1) {
			loadSysFilterAuthorities();
		}
		if (filterAuthorities==null||filterAuthorities.size()<1) {
			return false;
		}
		for (int i = 0; i <filterAuthorities.size(); i++) {
			String filterAuthoritie=filterAuthorities.get(i);
			if (url.indexOf(filterAuthoritie)>-1) {
				return true;
			};
		}
		return false;
	}	
	
	/**
	 * 加载系统不需要安全控制的权限【就是action的一个方法】
	 */
	public  void loadSysFilterAuthorities() {
		//静态资源
		filterAuthorities.add("login");
	}	
	
}
