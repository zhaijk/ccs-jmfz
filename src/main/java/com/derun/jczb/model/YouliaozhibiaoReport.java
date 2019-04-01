package com.derun.jczb.model;

public class YouliaozhibiaoReport {
	
	private Integer id;
	private String code;
	private String name;
	private String oiltype;
	private Double volumn;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOiltype() {
		return oiltype;
	}


	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}


	public Double getVolumn() {
		return volumn;
	}


	public void setVolumn(Double volumn) {
		this.volumn = volumn;
	}


	@Override
	public String toString() {
		return "YouliaozhibiaoReport [id=" + id + ", code=" + code + ", name=" + name + ", oiltype=" + oiltype
				+ ", volumn=" + volumn + "]";
	}

	
}
