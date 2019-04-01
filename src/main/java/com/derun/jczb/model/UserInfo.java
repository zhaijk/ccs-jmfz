package com.derun.jczb.model;

import java.util.Date;

public class UserInfo{
	
	private Long userId;
	private String oldPassword;
	private String loginname;
	private String username;
	private String password;
	private Long operatortype;
	private String power;
	private Date builddate;
	private String operator;
	private String note;
	private String danwei;	
	private Long   dankazhibiaocount;

	public Date getBuilddate() {
		return builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}

	public String getDanwei() {
		return danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOperatortype() {
		return operatortype;
	}

	public void setOperatortype(Long operatortype) {
		this.operatortype = operatortype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Long getDankazhibiaocount() {
		return dankazhibiaocount;
	}

	public void setDankazhibiaocount(Long dankazhibiaocount) {
		this.dankazhibiaocount = dankazhibiaocount;
	}
	
}
