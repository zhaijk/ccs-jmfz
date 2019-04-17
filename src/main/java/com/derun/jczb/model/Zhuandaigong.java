package com.derun.jczb.model;

public class Zhuandaigong {
	
	private Long id;			// 主键
	private String wenjianhao;	// 文书号
	private String zg_danwei;	// 助供单位
	private String sg_danwei;	// 受供单位
	private Long leixing;		// 类型1上级转代供 2本级转代供 3 上级内部转代供 4本级内部转代供 系统计算用双数如11为上级转代供系统记录
	private Long youpin_code;	// 油料标记
	private Long zhibiao_leixing;// 指标类型0为实物1为自购
	private Double shuliang;	// 数量,通常显录为整数
	private String riqi;		// 日期
	private Long jz;			// 结转标志
	private Integer niandu;		// 年度
	private String remark;
	private Integer biaozhi;	// 下载标志，0未下载，1已下载
//	private String zgBumen;		// 助供名称
//	private String sgBumen;		// 受供名称
//	private String xgBiaozhi;	// 修改标志
//	private String sysyear;		// 年度
//	private Double sgShuliang;	// 数量,通常显录为整数
//	private Long jizhang;		// 记账标志(1：记账，3:待修改，4：可修改)
//	private String image;		// 图片base64
//	private String imageName;	// 图片名称
//	private String shulianges;
//	private String sgShulianges;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWenjianhao() {
		return wenjianhao;
	}
	public void setWenjianhao(String wenjianhao) {
		this.wenjianhao = wenjianhao;
	}
	public String getZg_danwei() {
		return zg_danwei;
	}
	public void setZg_danwei(String zg_danwei) {
		this.zg_danwei = zg_danwei;
	}
	public String getSg_danwei() {
		return sg_danwei;
	}
	public void setSg_danwei(String sg_danwei) {
		this.sg_danwei = sg_danwei;
	}
	public Long getLeixing() {
		return leixing;
	}
	public void setLeixing(Long leixing) {
		this.leixing = leixing;
	}
	public Long getYoupin_code() {
		return youpin_code;
	}
	public void setYoupin_code(Long youpin_code) {
		this.youpin_code = youpin_code;
	}
	public Long getZhibiao_leixing() {
		return zhibiao_leixing;
	}
	public void setZhibiao_leixing(Long zhibiao_leixing) {
		this.zhibiao_leixing = zhibiao_leixing;
	}
	public Double getShuliang() {
		return shuliang;
	}
	public void setShuliang(Double shuliang) {
		this.shuliang = shuliang;
	}
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	public Long getJz() {
		return jz;
	}
	public void setJz(Long jz) {
		this.jz = jz;
	}
	public Integer getNiandu() {
		return niandu;
	}
	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getBiaozhi() {
		return biaozhi;
	}
	public void setBiaozhi(Integer biaozhi) {
		this.biaozhi = biaozhi;
	}
}