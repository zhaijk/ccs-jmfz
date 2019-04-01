package com.derun.jczb.model;




public class Areadepart {
	
	private String departmentCode;
	private String departmentName;
	private String telephoneNumber;
	private String contact;
	private String buildDate;
	private String operator;
	private int cview;
	private int tflag;
	private String note;
	
	public String getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getCview() {
		return cview;
	}
	public void setCview(int cview) {
		this.cview = cview;
	}
	public int getTflag() {
		return tflag;
	}
	public void setTflag(int tflag) {
		this.tflag = tflag;
	}	

}
