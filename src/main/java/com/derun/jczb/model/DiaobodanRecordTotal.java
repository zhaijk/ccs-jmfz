package com.derun.jczb.model;

//未转换指标
public class DiaobodanRecordTotal {

	private Integer id;	
	private String danweiCode;	
	private Integer oilcode;	
	private Double shiwu;	
	private Double jiabo;	
	private Double zigou;

	public String getDanweiCode() {
		return danweiCode;
	}

	public void setDanweiCode(String danweiCode) {
		this.danweiCode = danweiCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getJiabo() {
		return jiabo;
	}

	public void setJiabo(Double jiabo) {
		this.jiabo = jiabo;
	}

	public Integer getOilcode() {
		return oilcode;
	}

	public void setOilcode(Integer oilcode) {
		this.oilcode = oilcode;
	}

	public Double getShiwu() {
		return shiwu;
	}

	public void setShiwu(Double shiwu) {
		this.shiwu = shiwu;
	}

	public Double getZigou() {
		return zigou;
	}

	public void setZigou(Double zigou) {
		this.zigou = zigou;
	}
}
