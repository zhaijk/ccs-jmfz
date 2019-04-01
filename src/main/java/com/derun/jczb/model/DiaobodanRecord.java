package com.derun.jczb.model;

//调拨单附表
public class DiaobodanRecord{
	
	private Long id;				// 主键
	private Diaobodan diaobodan;	// 主对象
	private Long youpinCode;		// 油品编码
	private Double shiwu = 0d;		// 实物油数量
	private Double jiabo = 0d;		// 价拨油数量
	private Double zigou = 0d;		// 自购油数量

//	public DiaobodanRecord() {
//	}
//
//	public DiaobodanRecord(Long id) {
//		this.id = id;
//	}
//
//	public DiaobodanRecord(Long id, Diaobodan diaobodan, Long youpinCode,
//			Double shiwu, Double jiabo, Double zigou) {
//		this.id = id;
//		this.diaobodan = diaobodan;
//		this.youpinCode = youpinCode;
//		this.shiwu = shiwu;
//		this.jiabo = jiabo;
//		this.zigou = zigou;
//	}
//
//	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Diaobodan getDiaobodan() {
		return this.diaobodan;
	}

	public void setDiaobodan(Diaobodan diaobodan) {
		this.diaobodan = diaobodan;
	}

	public Long getYoupinCode() {
		return this.youpinCode;
	}

	public void setYoupinCode(Long youpinCode) {
		this.youpinCode = youpinCode;
	}

	public Double getShiwu() {
		return this.shiwu;
	}

	public void setShiwu(Double shiwu) {
		this.shiwu = shiwu;
	}

	public Double getJiabo() {
		return this.jiabo;
	}

	public void setJiabo(Double jiabo) {
		this.jiabo = jiabo;
	}

	public Double getZigou() {
		return this.zigou;
	}

	public void setZigou(Double zigou) {
		this.zigou = zigou;
	}

}