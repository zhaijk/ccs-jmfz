package com.derun.jczb.model;

import java.util.List;

public class YouKuSunHao {
	
	private String youku;	
	private String danjuhao;	
	private String riqi;
	private Integer oil;		//油品代码
	private Integer niandu;		//年度	
	private double youpin;		//消耗数	
	private String remark;
	private List<String> youpins;	//油品 数量
	private double total;		//汇总
	
	public String getYouku() {
		return youku;
	}
	public void setYouku(String youku) {
		this.youku = youku;
	}
	public String getDanjuhao() {
		return danjuhao;
	}
	public void setDanjuhao(String danjuhao) {
		this.danjuhao = danjuhao;
	}
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	public Integer getOil() {
		return oil;
	}
	public void setOil(Integer oil) {
		this.oil = oil;
	}
	public Integer getNiandu() {
		return niandu;
	}
	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}
	public double getYoupin() {
		return youpin;
	}
	public void setYoupin(double youpin) {
		this.youpin = youpin;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<String> getYoupins() {
		return youpins;
	}
	public void setYoupins(List<String> youpins) {
		this.youpins = youpins;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
