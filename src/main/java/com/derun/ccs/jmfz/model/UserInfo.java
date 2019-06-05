package com.derun.ccs.jmfz.model;

public class UserInfo {

	private int  id;
	private String username;
	private String password1;
	private String password2;
	private String companyname;
	private String companydata;
	private String usertype;
	private String usertypename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanydata() {
		return companydata;
	}
	public void setCompanydata(String companydata) {
		this.companydata = companydata;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUsertypename() {
		return usertypename;
	}
	public void setUsertypename(String usertypename) {
		this.usertypename = usertypename;
	}
}
