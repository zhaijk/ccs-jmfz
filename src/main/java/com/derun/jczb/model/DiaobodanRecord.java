package com.derun.jczb.model;

//调拨单附表
public class DiaobodanRecord{
	
	private Long fk_id;				// 主键	
	private Long youpin_code;		// 油品编码
	private Double shiwu = 0d;		// 实物油数量
	private Double jiabo = 0d;		// 价拨油数量
	private Double zigou = 0d;		// 自购油数量
	private String youpin_name;
	private Long  id;
	
	public Double getZigou() {
		return zigou;
	}
	public void setZigou(Double zigou) {
		this.zigou = zigou;
	}
	public Double getJiabo() {
		return jiabo;
	}
	public void setJiabo(Double jiabo) {
		this.jiabo = jiabo;
	}
	public Double getShiwu() {
		return shiwu;
	}
	public void setShiwu(Double shiwu) {
		this.shiwu = shiwu;
	}
	public Long getYoupin_code() {
		return youpin_code;
	}
	public void setYoupin_code(Long youpin_code) {
		this.youpin_code = youpin_code;
	}
	public Long getFk_id() {
		return fk_id;
	}
	public void setFk_id(Long fk_id) {
		this.fk_id = fk_id;
	}
	public String getYoupin_name() {
		return youpin_name;
	}
	public void setYoupin_name(String youpin_name) {
		this.youpin_name = youpin_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}