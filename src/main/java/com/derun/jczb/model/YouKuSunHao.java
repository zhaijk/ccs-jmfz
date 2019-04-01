package com.derun.jczb.model;

public class YouKuSunHao {
	
	private String youkucode;	
	private String danjuhao;	
	private String riqi;
	private Integer oil;		//油品
	private Integer niandu;		//年度	
	private double xiaoji;		//消耗数	
	private String remark;
	
	public String getDanjuhao() {
		return danjuhao;
	}

	public void setDanjuhao(String danjuhao) {
		this.danjuhao = danjuhao;
	}

	public Integer getOil() {
		return oil;
	}

	public void setOil(Integer oil) {
		this.oil = oil;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRiqi() {
		return riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public double getXiaoji() {
		return xiaoji;
	}

	public void setXiaoji(double xiaoji) {
		this.xiaoji = xiaoji;
	}

	public String getYoukucode() {
		return youkucode;
	}

	public void setYoukucode(String youkucode) {
		this.youkucode = youkucode;
	}

	public Integer getNiandu() {
		return niandu;
	}

	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}
}
