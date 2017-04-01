package com.hjf.core.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统错误码
 * @author lihaijun
 * 2014-12-02
 */
public class CodeUtil {
	/**
	 * 代码说明:起始数字
	 * 9：系统错误
	 * 1：账户错误
	 */
	private static Map<String,String>  codeMap=new HashMap<String, String>();
	public static String success="0000";//通用成功
	public static String error="1111"; //系统异常
	public static String e_9999="9999";//参数错误
	public static String e_9998="9998";//更新数据出错
	public static String e_9997="9997";//插入数据出错
	public static String e_9996="9996";//查询数据出错
	public static String e_9995="9995";//删除数据出错
	public static String e_9994="9994";//数据重复
	public static String e_9993="9993";//文件上传失败
	
	public static String e_1001="1001";//密码错误
	public static String e_1002="1002";//没有该账户
	public static String e_1003="1003";//账户或密码错误
	public static String e_1004="1004";//发送短信失败
	public static String e_1005="1005";//注册失败
	public static String e_1006="1006";//短信验证失败
	public static String e_1007="1007";//账户已经注册过
	public static String e_1008="1008";//更新账户信息失败
	public static String e_1009="1009";//缺失账户信息
	
	 
	
	
	public static void initCode(){
		codeMap.put("0000", "成功");
		codeMap.put("1111", "系统异常");
		codeMap.put("9999", "参数错误");
		codeMap.put("9998", "更新数据出错");
		codeMap.put("9997", "插入数据出错");
		codeMap.put("9996", "查询数据出错");
		codeMap.put("9995", "删除数据出错");
		codeMap.put("9994", "数据重复");
		codeMap.put("9993", "文件上传失败");
		codeMap.put("1001", "密码错误");
		codeMap.put("1002", "没有该账户");
		codeMap.put("1003", "账户或密码错误");
		codeMap.put("1004", "发送短信失败");
		codeMap.put("1005", "注册失败");
		codeMap.put("1006", "短信验证失败");
		codeMap.put("1007", "账户已经注册过");
		codeMap.put("1008", "更新账户信息失败");
		codeMap.put("1009", "缺失账户信息");
		
	}
	
	
	public static String getCodeMsg(String code) {
		if (codeMap==null||codeMap.isEmpty()) {
			initCode();
		}
		return codeMap.get(code);
	}	 
	
}
