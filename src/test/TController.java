package test;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.ResponseUtils;
import org.jxjz.framework.jms.JmsSender;
import org.jxjz.framework.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
/**
 * 功能说明:【用户信息】
 * 作    者：lihaijun
 * 创建日期：2014-11-21
 */
@Controller  
@RequestMapping("/t") 
public class TController extends BaseAction{
	 
	Logger logger =LogUtil.getLogger();
	@Resource  private JmsSender jmsSender;
	/**
	 * 【查询自己账户信息】
	 */
	@RequestMapping(params = "jsonp")   
	public void jsonp(HttpServletRequest request,HttpServletResponse response) {
		try {
		 String r= "flightHandler({'code': '0000',  'price': 1111,  'tickets': 2222});";
			ResponseUtils.renderText(response, r);
		} catch (Exception e) {
			errorMsg(response);
		}
	}
	
	
	@RequestMapping(value="/rest/{adId}/{adTitle}")
	public void restful(@ModelAttribute Map map, @PathVariable(value="adId") Integer adId ,@PathVariable(value="adTitle") Integer adTitle ,HttpServletRequest request,HttpServletResponse response) {
		ResponseUtils.renderText(response, adId.toString()+"---"+adTitle);
		
	}


    @RequestMapping(params = "jmsSend")
    @ResponseBody
    public void jmsSend(HttpServletResponse response,Model model,HttpServletRequest request) {
    	String   data =request.getParameter("data");
        jmsSender.sendMessage(data);
        ResponseUtils.renderJson(response, "0000");
    }

	 
	
	
	 
	
}
