package com.derun.jczb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Userbaseinfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;// 主键
	private String loginname;// 登录名
	private String username;// 用户名
	private String password;// 密码
	private Long operatortype;// 操作类型 类型0维护人员1超级管理员2操作员3本级用户4下级操作员
	private String power;// 权限,在XML表的菜单项
	private Date builddate;// 建立日期
	private String operator;// 开户人
	private String note;// 备注
	private String danwei;// 单位
	private Long   dankazhibiaocount;	
	private Set<TreeMenu> treeset = new HashSet<TreeMenu>();

	public Set<TreeMenu> getTreeset() {
		return treeset;
	}

	public void setTreeset(Set<TreeMenu> treeset) {
		this.treeset = treeset;
	}

//	public Userbaseinfo() {
//	}
//
//	public Userbaseinfo(Long userId) {
//		this.userId = userId;
//	}
//
//	public Userbaseinfo(Long userId, String loginname, String username,
//			String password, Long operatortype, String power, Date builddate,
//			String operator, String note, String danwei) {
//		this.userId = userId;
//		this.loginname = loginname;
//		this.username = username;
//		this.password = password;
//		this.operatortype = operatortype;
//		this.power = power;
//		this.builddate = builddate;
//		this.operator = operator;
//		this.note = note;
//		this.danwei = danwei;
//	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOperatortype() {
		return this.operatortype;
	}

	public void setOperatortype(Long operatortype) {
		this.operatortype = operatortype;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Date getBuilddate() {
		return this.builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDanwei() {
		return this.danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public Long getDankazhibiaocount() {
		return dankazhibiaocount;
	}

	public void setDankazhibiaocount(Long dankazhibiaocount) {
		this.dankazhibiaocount = dankazhibiaocount;
	}

}