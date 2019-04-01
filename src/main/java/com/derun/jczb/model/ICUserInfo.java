package com.derun.jczb.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class ICUserInfo{
	
	private long userId;
	private String loginName;	
	private String oldPassword;
	private String userName;
	private String loginPassword;	
	private String danWei;	
	private String phone;	
	private String auditingpw;	
	private Long   dankazhibiaocount;

	public String getAuditingpw() {
		return auditingpw;
	}

	public void setAuditingpw(String auditingpw) {
		this.auditingpw = auditingpw;
	}
	
	private Set<TreeMenu> treeMenus = new LinkedHashSet<TreeMenu>();

	public Set<TreeMenu> getTreeMenus() {
		return treeMenus;
	}

	public void setTreeMenus(Set<TreeMenu> treeMenus) {
		this.treeMenus = treeMenus;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDanWei() {
		return danWei;
	}

	public void setDanWei(String danWei) {
		this.danWei = danWei;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
