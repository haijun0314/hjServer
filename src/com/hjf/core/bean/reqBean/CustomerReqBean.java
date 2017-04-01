package com.hjf.core.bean.reqBean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hjf.core.bean.BaseReqBean;

public class CustomerReqBean extends BaseReqBean {
	private String  customerName; 				//用户名称
	private String  password;					//账号密码
	private Integer age;						//年龄
	private String 	 cityCode;				    //城市编号
	private String 	 cityName;				    //城市名称
	private String  dynamicState;				//当前动态
	private String  email;						//email
	private String  headPic;					//头像地址
	private String  imei;						//imei号
	private String  imsi;						//imsi号
	private String  label;						//个人标签//标签【1-2-80后*2-2-交友*3-1-测试】
	private String  QQ;							//qq
	private String  sex;						//性别  0  男 1  女
	private String  gexinCid;					//个信账户ID
	private String  rongToken;					//融云token

	/**
	 * 【检查更新账户请求参数】
	 */
	public boolean	checkUpdateParams(HttpServletRequest request){
		 String  customerName	=request.getParameter("customerName"); 			//用户名称
		 String  password		=request.getParameter("password");				//账号密码
		 String  age			=request.getParameter("age");					//年龄
		 String  cityCode		=request.getParameter("cityCode");				//城市编号
		 String  cityName		=request.getParameter("cityName");				//城市名称
		 String  dynamicState	=request.getParameter("dynamicState");			//当前动态
		 String  email			=request.getParameter("email");					//email
		 String  headPic		=request.getParameter("headPic");				//头像地址
		 String  imei			=request.getParameter("imei");					//imei号
		 String  imsi			=request.getParameter("imsi");					//imsi号
		 String  label			=request.getParameter("label");					//个人标签//标签【1-2-80后*2-2-交友*3-1-测试】
		 String  QQ				=request.getParameter("QQ");					//qq
		 String  sex			=request.getParameter("sex");					//性别  0  男 1  女
		 String  gexinCid		=request.getParameter("gexinCid");				//个信账户ID
		 String  rongToken		=request.getParameter("rongToken");				//融云token
		 
			setCustomerName(customerName);
			setPassword(password);
			if (StringUtils.isNotBlank(age)) {
				setAge(new Integer(age));
			}
			setCityCode(cityCode);
			setCityName(cityName);
			setDynamicState(dynamicState);
			setEmail(email);
			setHeadPic(headPic);
			setImei(imei);
			setImsi(imsi);
			setLabel(label);
			setQQ(QQ);
			setSex(sex);
			setGexinCid(gexinCid);
			setRongToken(rongToken);
			printParams();
			return true;
	}

	
	
	public  void printParams(){
		StringBuffer params=new  StringBuffer();
		params.append("customerName="+customerName) ; 	//用户名称
		params.append("password="+password);			//账号密码
		params.append("age="+age);						//年龄
		params.append("cityCode="+cityCode);			//城市编号
		params.append("cityName="+cityName);			//城市名称
		params.append("dynamicState="+dynamicState);	//当前动态
		params.append("email="+email);					//email
		params.append("headPic="+headPic);				//头像地址
		params.append("imei="+imei);					//imei号
		params.append("imsi="+imsi);					//imsi号
		params.append("label="+label);					//个人标签//标签【1-2-80后*2-2-交友*3-1-测试】
		params.append("QQ="+QQ);						//qq
		params.append("sex="+sex);						//性别  0  男 1  女
		params.append("gexinCid="+gexinCid);			//个信账户ID
		params.append("rongToken="+rongToken);			//融云token
		log.info("params="+params.toString());
	}
	
	
	
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDynamicState() {
		return dynamicState;
	}

	public void setDynamicState(String dynamicState) {
		this.dynamicState = dynamicState;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	 

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGexinCid() {
		return gexinCid;
	}

	public void setGexinCid(String gexinCid) {
		this.gexinCid = gexinCid;
	}

	public String getRongToken() {
		return rongToken;
	}

	public void setRongToken(String rongToken) {
		this.rongToken = rongToken;
	}


	 


	 
	
	
	
}
