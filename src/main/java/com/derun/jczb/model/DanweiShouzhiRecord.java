package com.derun.jczb.model;

public class DanweiShouzhiRecord  {
	
	private String danwei;		//部门编码
	private String niandu;  	//年度 
	private Integer youpin;		//油品编码
	private Double shouru;		//部门收油指标
	private Double zhichu;      //部门发油数
	private Double jiecun;      //部门结存数
	
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public Double getJiecun() {
		return jiecun;
	}
	public void setJiecun(Double jiecun) {
		this.jiecun = jiecun;
	}
	public String getNiandu() {
		return niandu;
	}
	public void setNiandu(String niandu) {
		this.niandu = niandu;
	}
	public Double getShouru() {
		return shouru;
	}
	public void setShouru(Double shouru) {
		this.shouru = shouru;
	}
	public Integer getYoupin() {
		return youpin;
	}
	public void setYoupin(Integer youpin) {
		this.youpin = youpin;
	}
	public Double getZhichu() {
		return zhichu;
	}
	public void setZhichu(Double zhichu) {
		this.zhichu = zhichu;
	}
}
