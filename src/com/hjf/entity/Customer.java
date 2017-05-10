package com.hjf.entity;

import java.util.Date;

import org.jxjz.base.model.BaseModel;

/**
 * 功能说明:【账户信息】
 * 作    者：lihaijun
 * 创建日期：2017-05-10
 */
public class Customer extends BaseModel implements java.io.Serializable {
    private String  userToken;					//账户token  免密码登录
	private Integer customerId;					//用户编号
	private String  customerName; 				//用户名称
	private String  telephone;					//电话号码
	private String  password;					//账号密码
	private Integer age;						//年龄
	private String 	 cityCode;				    //城市编号
	private String 	 cityName;				    //城市名称
	private String  dynamicState;				//当前动态
	private String  email;						//email
	private String  headPic;					//头像地址
	private String  imei;						//imei号
	private String  imsi;						//imsi号
	private Date    loginTime;					//登录时间
	private String  label;						//个人标签//标签【1-2-80后*2-2-交友*3-1-测试】
	private String  QQ;							//qq
	private Date    registTime;					//注册时间	
	private String  status;				//状态1.正常2.暂停
	private String  sex;						//性别  0  男 1  女
	private String  gexinCid;					//个信账户ID
	private String  rongToken;					//融云token
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
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
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	 
	
}
