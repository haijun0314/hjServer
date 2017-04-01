package org.jxjz.framework.exception;
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
  
import org.jxjz.framework.util.LogUtil;
import org.springframework.web.servlet.HandlerExceptionResolver;   
import org.springframework.web.servlet.ModelAndView;   
public class ExceptionHandler implements HandlerExceptionResolver {   
	 @Override  
	    public ModelAndView resolveException(HttpServletRequest request,   
	            HttpServletResponse response, Object handler, Exception ex) { 
		 	LogUtil.getLogger().error("......"+ex.getMessage());
		 	LogUtil.getLogger().error(ex.getStackTrace());
	        return new ModelAndView("error/error");   
	    }   
}
