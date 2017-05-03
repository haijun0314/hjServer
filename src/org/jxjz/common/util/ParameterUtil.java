package org.jxjz.common.util;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 *  
 **/
public class ParameterUtil
{
    @SuppressWarnings("unchecked")
	public static Map getParameter(ServletRequest request, String[] paras)
 {
     HashMap map = new HashMap();
     if(paras == null || paras.length == 0)return map;
     for(int i = 0;i < paras.length;i++)
     {
         String para = paras[i];
         if(para == null || para.trim().length() == 0)continue;
         String value = request.getParameter(para);
         if(value == null || value.trim().length() == 0)continue;
         else value = value.trim();
         map.put(para,  URLUtil.decodeURL(value));
     }
     return map;
 }
    
	
	/**
	 * 获取http提交请求参数
	 * @return
	 */
	public static Map getParameters(HttpServletRequest request){
		Map<String, String> hmInput = null;
		String paramName 			= null;
		String paramValue 			= null;
		// 获取接口请求的所有参数名、参数值
		Enumeration enm 			= request.getParameterNames();
		hmInput 					= new HashMap<String, String>();
		while (enm.hasMoreElements()) {
			paramName 				= enm.nextElement().toString();
			paramValue 				= request.getParameter(paramName);
			try{
				paramValue = java.net.URLDecoder.decode(paramValue, "UTF-8");
			}catch(Exception e){
				e.printStackTrace();
			}
//			if (StringUtils.isNotBlank(paramValue)) {
//				hmInput.put(paramName, paramValue);
//			}
			hmInput.put(paramName, paramValue);
		}
		return hmInput;
	}   
	
	
	
	/**
	 * 
	 */
	public static String getParams(Map  hm) {		
		StringBuffer sb = new StringBuffer();
		try {		
			if (hm.isEmpty()) {
				return null ;
			}				
			Object[] key = hm.keySet().toArray(); 
			Arrays.sort(key); 
			for (int i = 0; i < key.length; i++) { 
				Object  o=hm.get(key[i]);
				if (o==null) {
					o="";
				}
				sb.append(key[i]+"="+java.net.URLEncoder.encode(o.toString(),"UTF-8")+"&");	
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  sb.toString();
	}		
	
	
	
	
	
	
}
