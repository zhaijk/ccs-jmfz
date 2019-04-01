package com.derun.jczb.model;

public class ZhiBiaoZhuanXiang {
	
	private Long id;		//主键
	private String pyear;	//年度
	private String danwei;	//单位编码
	private Long yl_xj=0L;	//小计
	private Long yl_cl=0L;	//车辆
	private Long yl_ct=0L;	//船艇
	private Long yl_jj=0L;	//机械
	private Long yl_jx=0L;	//驾训
	private Long yl_bz=0L;	//补助
	private Long yl_jd=0L;	//机动
	private Long yl_fs=0L;	//附属
	private String beizhu;	//备注
	private Integer jizhang;/**冗余字段  0未记账 1记账***/
	private String danweiName;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPyear() {
		return pyear;
	}
	public void setPyear(String pyear) {
		this.pyear = pyear;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public Long getYl_xj() {
		return yl_xj;
	}
	public void setYl_xj(Long ylXj) {
		yl_xj = ylXj;
	}
	public Long getYl_cl() {
		return yl_cl;
	}
	public void setYl_cl(Long ylCl) {
		yl_cl = ylCl;
	}
	public Long getYl_ct() {
		return yl_ct;
	}
	public void setYl_ct(Long ylCt) {
		yl_ct = ylCt;
	}
	public Long getYl_jj() {
		return yl_jj;
	}
	public void setYl_jj(Long ylJj) {
		yl_jj = ylJj;
	}
	public Long getYl_jx() {
		return yl_jx;
	}
	public void setYl_jx(Long ylJx) {
		yl_jx = ylJx;
	}
	public Long getYl_bz() {
		return yl_bz;
	}
	public void setYl_bz(Long ylBz) {
		yl_bz = ylBz;
	}
	public Long getYl_jd() {
		return yl_jd;
	}
	public void setYl_jd(Long ylJd) {
		yl_jd = ylJd;
	}
	public Long getYl_fs() {
		return yl_fs;
	}
	public void setYl_fs(Long ylFs) {
		yl_fs = ylFs;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getDanweiName() {
		return danweiName;
	}
	public void setDanweiName(String danweiName) {
		this.danweiName = danweiName;
	}

	public Integer getJizhang() {
		return jizhang;
	}

	public void setJizhang(Integer jizhang) {
		this.jizhang = jizhang;
	}


	
}