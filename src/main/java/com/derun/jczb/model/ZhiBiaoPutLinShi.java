package com.derun.jczb.model;

public class ZhiBiaoPutLinShi {
	
	private Long id ;
	private String cardcode;
	private double fafangliang;
	private String providedate;
	private String providetime;
	private Long  oiltype;
	private String operator;
	private Integer sendflag;
	private String carcode;

	public String getCarcode() {
		return carcode;
	}
	public void setCarcode(String carcode) {
		this.carcode = carcode;
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
