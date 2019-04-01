package com.derun.jczb.model;

public class ZhiBiaoPutLinShiLog {
	
	private Long id ;
	private String cardcode;
	private double fafangliang;
	private String providedate;
	private String providetime;
	private Long  oiltype;
	private String operator;
	private Integer sendflag;
	private Integer operatortype;
	private String  shenpiren;
	private String  shenpidate;
	private String  shenpitime;	

	public Integer getOperatortype() {
		return operatortype;
	}
	public void setOperatortype(Integer operatortype) {
		this.operatortype = operatortype;
	}
	public String getShenpidate() {
		return shenpidate;
	}
	public void setShenpidate(String shenpidate) {
		this.shenpidate = shenpidate;
	}
	public String getShenpiren() {
		return shenpiren;
	}
	public void setShenpiren(String shenpiren) {
		this.shenpiren = shenpiren;
	}
	public String getShenpitime() {
		return shenpitime;
	}
	public void setShenpitime(String shenpitime) {
		this.shenpitime = shenpitime;
	}
	public Integer getSendflag() {
		return sendflag;
	}
	public void setSendflag(Integer sendflag) {
		this.sendflag = sendflag;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Long getOiltype() {
		return oiltype;
	}
	public void setOiltype(Long oiltype) {
		this.oiltype = oiltype;
	}
	public String getProvidedate() {
		return providedate;
	}
	public void setProvidedate(String providedate) {
		this.providedate = providedate;
	}
	public String getProvidetime() {
		return providetime;
	}
	public void setProvidetime(String providetime) {
		this.providetime = providetime;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public double getFafangliang() {
		return fafangliang;
	}
	public void setFafangliang(double fafangliang) {
		this.fafangliang = fafangliang;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
