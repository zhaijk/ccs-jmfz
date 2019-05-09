package com.derun.jczb.model;

import java.io.Serializable;

public class UserInfoIccard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long user_id;
	private String  login_name;
	private String  user_name;
	private String  login_password;
	private String  danwei;
	private String  phone;
	private String  auditingpw;
	private String  bankazhibiaocount;
	//private String  
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAuditingpw() {
		return auditingpw;
	}
	public void setAuditingpw(String auditingpw) {
		this.auditingpw = auditingpw;
	}
	public String getBankazhibiaocount() {
		return bankazhibiaocount;
	}
	public void setBankazhibiaocount(String bankazhibiaocount) {
		this.bankazhibiaocount = bankazhibiaocount;
	}
	@Override
	public String toString() {
		return "UserInfoIccard [user_id=" + user_id + ", login_name=" + login_name + ", user_name=" + user_name
				+ ", login_password=" + login_password + ", danwei=" + danwei + ", phone=" + phone + ", auditingpw="
				+ auditingpw + ", bankazhibiaocount=" + bankazhibiaocount + "]";
	}
}
