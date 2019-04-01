package com.derun.jczb.model;

public class Zhuandaigong {
	
	private Long id;			// 主键
	private String wenjianhao;	// 文叔号
	private String zgDanwei;	// 助供单位
	private String sgDanwei;	// 受供单位
	private Long leixing;		// 类型1上级转代供 2本级转代供 3 上级内部转代供 4本级内部转代供 系统计算用双数如11为上级转代供系统记录
	private Long youpinCode;	// 油料标记
	private Long zhibiaoLeixing;// 指标类型0为实物1为自购
	private Double shuliang;	// 数量,通常显录为整数
	private String riqi;		// 日期
	private Long jz;			// 结转标志
	private Integer niandu;		// 年度
	private String remark;
	private Integer biaozhi;	// 下载标志，0未下载，1已下载
	private String zgBumen;		// 助供名称
	private String sgBumen;		// 受供名称
	private String xgBiaozhi;	// 修改标志
	private String sysyear;		// 年度
	private Double sgShuliang;	// 数量,通常显录为整数
	private Long jizhang;		// 记账标志(1：记账，3:待修改，4：可修改)
	private String image;		// 图片base64
	private String imageName;	// 图片名称
	private String shulianges;
	private String sgShulianges;

	public Integer getNiandu() {
		return niandu;
	}

	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWenjianhao() {
		return this.wenjianhao;
	}

	public void setWenjianhao(String wenjianhao) {
		this.wenjianhao = wenjianhao;
	}

	public String getZgDanwei() {
		return this.zgDanwei;
	}

	public void setZgDanwei(String zgDanwei) {
		this.zgDanwei = zgDanwei;
	}

	public String getSgDanwei() {
		return this.sgDanwei;
	}

	public void setSgDanwei(String sgDanwei) {
		this.sgDanwei = sgDanwei;
	}

	public Long getLeixing() {
		return this.leixing;
	}

	public void setLeixing(Long leixing) {
		this.leixing = leixing;
	}

	public Long getYoupinCode() {
		return this.youpinCode;
	}

	public void setYoupinCode(Long youpinCode) {
		this.youpinCode = youpinCode;
	}

	public Long getZhibiaoLeixing() {
		return this.zhibiaoLeixing;
	}

	public void setZhibiaoLeixing(Long zhibiaoLeixing) {
		this.zhibiaoLeixing = zhibiaoLeixing;
	}

	public Double getShuliang() {
		return this.shuliang;
	}

	public void setShuliang(Double shuliang) {
		this.shuliang = shuliang;
	}

	public String getRiqi() {
		return this.riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public Long getJz() {
		return this.jz;
	}

	public void setJz(Long jz) {
		this.jz = jz;
	}

	public Integer getBiaozhi() {
		return biaozhi;
	}

	public void setBiaozhi(Integer biaozhi) {
		this.biaozhi = biaozhi;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getZgBumen() {
		return zgBumen;
	}

	public void setZgBumen(String zgBumen) {
		this.zgBumen = zgBumen;
	}

	public String getSgBumen() {
		return sgBumen;
	}

	public void setSgBumen(String sgBumen) {
		this.sgBumen = sgBumen;
	}

	public String getXgBiaozhi() {
		return xgBiaozhi;
	}

	public void setXgBiaozhi(String xgBiaozhi) {
		this.xgBiaozhi = xgBiaozhi;
	}

	public String getSysyear() {
		return sysyear;
	}

	public void setSysyear(String sysyear) {
		this.sysyear = sysyear;
	}

	public Double getSgShuliang() {
		return sgShuliang;
	}

	public void setSgShuliang(Double sgShuliang) {
		this.sgShuliang = sgShuliang;
	}

	public Long getJizhang() {
		return jizhang;
	}

	public void setJizhang(Long jizhang) {
		this.jizhang = jizhang;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getSgShulianges() {
		return sgShulianges;
	}

	public void setSgShulianges(String sgShulianges) {
		this.sgShulianges = sgShulianges;
	}

	public String getShulianges() {
		return shulianges;
	}

	public void setShulianges(String shulianges) {
		this.shulianges = shulianges;
	}

}