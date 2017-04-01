package org.jxjz.framework.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jxjz.common.util.URLUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {
	    private Logger log = Logger.getLogger("common");  
	   // @Resource	SecurityService securityService;
	    public SecurityInterceptor() {  
	    }  
	  
	    /** 
	     * 在业务处理器处理请求之前被调用 
	     * 如果返回false   从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
	     * 如果返回true 
	     * 执行下一个拦截器,直到所有的拦截器都执行完毕 
	     * 再执行被拦截的Controller 
	     * 然后进入拦截器链, 
	     * 从最后一个拦截器往回执行所有的postHandle() 
	     * 接着再从最后一个拦截器往回执行所有的afterCompletion() 
	     */  
	    public boolean preHandle(HttpServletRequest request,   HttpServletResponse response, Object handler) throws Exception {  
	        String url=request.getRequestURL().toString();
	        url=URLUtil.buildRequestUrl(request);

//	        if (securityService.decideFilterAuthorities(url)) {
//	        	return true;  
//			}
//	        if (!decideSession(request)) {
//				response.sendRedirect(request.getContextPath()+"/sessionTimeout.jsp");
//				return false;  
//			}
//	        if (!decideAuthent(request,url)) {
//	        	response.sendRedirect(request.getContextPath()+"/accessDenied.jsp");
//	        	return false;  
//			}
	        return true;  
	    }  
	  
	    /**
	     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作   
	     */
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView) throws Exception {  
	   
	    }  
	  
	    /** 
	     * 在DispatcherServlet完全处理完请求后被调用  
	     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
	     */  
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  
	            throws Exception {  
	    }  

	    
	    
	    /**
		 * 判断当前用户是否有操作权限
		 */
		public boolean decideAuthent(HttpServletRequest request,String url) {
//			SysUser sysUser=(SysUser) request.getSession().getAttribute(GlobalsParameter.Session_global);
//			List menuList=sysUser.getMenuBarList();
//			String authority=sysUser.getAuthority();
//			if (authority.indexOf(url)>-1) {
//				return true;
//			}
//			log.info("用户"+sysUser.getUsername()+"没有访问url为"+url+"的权限.......访问失败");
			return true;
		}    
	    
	    
}
