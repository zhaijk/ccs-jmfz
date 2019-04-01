package com.derun.jczb.model;

public class JunquDictionary{
	
	private int id;
	private Long junqu_code;	// 军区编码,其中北京军区为特殊军区
	private String junqu;	// 军区名称
	private Long flag;		// ZHIBIAORECORD
	private Long biaozhi;	// 为0的时候为其它军区,为1的时候为北京军区(为了不用汉字区分)
	private String paixu;	// 排序


	public String getJunqu() {
		return this.junqu;
	}

	public void setJunqu(String junqu) {
		this.junqu = junqu;
	}

	public Long getFlag() {
		return this.flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public Long getBiaozhi() {
		return this.biaozhi;
	}

	public void setBiaozhi(Long biaozhi) {
		this.biaozhi = biaozhi;
	}

	public String getPaixu() {
		return paixu;
	}

	public void setPaixu(String paixu) {
		this.paixu = paixu;
	}

	public Long getJunqu_code() {
		return junqu_code;
	}

	public void setJunqu_code(Long junqu_code) {
		this.junqu_code = junqu_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}