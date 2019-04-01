package com.derun.jczb.model;

public class Oilloss  {

	private Long id;
	private Long oiltype;
	private String jidu;
	private Double zhugongsunhao;
	private Double jiabosunhao;
	private String danweiid;
	private String niandu;
	private String remark;
	private Long biaoji;
	private Double density;
	private Double shiwuvolumn;
	private Double jiabovolumn;
	private String lossdate;
	
//	/** default constructor */
//	public Oilloss() {
//	}
//
//	/** minimal constructor */
//	public Oilloss(Long id, Long biaoji) {
//		this.id = id;
//		this.biaoji = biaoji;
//	}
//
//	/** full constructor */
//	public Oilloss(Long id, Long oiltype, String jidu, Double zhugongsunhao,
//			Double jiabosunhao, String danweiid, String niandu, String remark,
//			Long biaoji, Double density, Double shiwuvolumn,
//			Double jiabovolumn, String lossdate) {
//		this.id = id;
//		this.oiltype = oiltype;
//		this.jidu = jidu;
//		this.zhugongsunhao = zhugongsunhao;
//		this.jiabosunhao = jiabosunhao;
//		this.danweiid = danweiid;
//		this.niandu = niandu;
//		this.remark = remark;
//		this.biaoji = biaoji;
//		this.density = density;
//		this.shiwuvolumn = shiwuvolumn;
//		this.jiabovolumn = jiabovolumn;
//		this.lossdate = lossdate;
//	}
//
//	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOiltype() {
		return this.oiltype;
	}

	public void setOiltype(Long oiltype) {
		this.oiltype = oiltype;
	}

	public String getJidu() {
		return this.jidu;
	}

	public void setJidu(String jidu) {
		this.jidu = jidu;
	}

	public Double getZhugongsunhao() {
		return this.zhugongsunhao;
	}

	public void setZhugongsunhao(Double zhugongsunhao) {
		this.zhugongsunhao = zhugongsunhao;
	}

	public Double getJiabosunhao() {
		return this.jiabosunhao;
	}

	public void setJiabosunhao(Double jiabosunhao) {
		this.jiabosunhao = jiabosunhao;
	}

	public String getDanweiid() {
		return this.danweiid;
	}

	public void setDanweiid(String danweiid) {
		this.danweiid = danweiid;
	}

	public String getNiandu() {
		return this.niandu;
	}

	public void setNiandu(String niandu) {
		this.niandu = niandu;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getBiaoji() {
		return this.biaoji;
	}

	public void setBiaoji(Long biaoji) {
		this.biaoji = biaoji;
	}

	public Double getDensity() {
		return this.density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public Double getShiwuvolumn() {
		return this.shiwuvolumn;
	}

	public void setShiwuvolumn(Double shiwuvolumn) {
		this.shiwuvolumn = shiwuvolumn;
	}

	public Double getJiabovolumn() {
		return this.jiabovolumn;
	}

	public void setJiabovolumn(Double jiabovolumn) {
		this.jiabovolumn = jiabovolumn;
	}

	public String getLossdate() {
		return this.lossdate;
	}

	public void setLossdate(String lossdate) {
		this.lossdate = lossdate;
	}

}