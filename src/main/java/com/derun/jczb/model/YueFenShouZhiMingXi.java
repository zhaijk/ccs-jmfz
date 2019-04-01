package com.derun.jczb.model;

public class YueFenShouZhiMingXi  {

	private String id;
	private String bumencode;
	private String nianyue;
	private Long youpincode;
	private Double tiaozheng;
	private Double xiaohao;
	private Double xiaoji;
	private String nianyueri;

//	// Constructors
//
//	/** default constructor */
//	public YueFenShouZhiMingXi() {
//	}
//
//	/** full constructor */
//	public YueFenShouZhiMingXi(String bumencode, String nianyue,
//			Long youpincode, String id,
//			Double tiaozheng, Double xiaohao, Double xiaoji, String nianyueri) {
//		this.bumencode = bumencode;
//		this.nianyue = nianyue;
//		this.youpincode = youpincode;
//		this.id = id;
//		this.tiaozheng = tiaozheng;
//		this.xiaohao = xiaohao;
//		this.xiaoji = xiaoji;
//		this.nianyueri = nianyueri;
//	}
//
//	// Property accessors

	public String getBumencode() {
		return this.bumencode;
	}

	public void setBumencode(String bumencode) {
		this.bumencode = bumencode;
	}

	public String getNianyue() {
		return this.nianyue;
	}

	public void setNianyue(String nianyue) {
		this.nianyue = nianyue;
	}

	public Long getYoupincode() {
		return this.youpincode;
	}

	public void setYoupincode(Long youpincode) {
		this.youpincode = youpincode;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getTiaozheng() {
		return this.tiaozheng;
	}

	public void setTiaozheng(Double tiaozheng) {
		this.tiaozheng = tiaozheng;
	}

	public Double getXiaohao() {
		return this.xiaohao;
	}

	public void setXiaohao(Double xiaohao) {
		this.xiaohao = xiaohao;
	}

	public Double getXiaoji() {
		return this.xiaoji;
	}

	public void setXiaoji(Double xiaoji) {
		this.xiaoji = xiaoji;
	}

	public String getNianyueri() {
		return this.nianyueri;
	}

	public void setNianyueri(String nianyueri) {
		this.nianyueri = nianyueri;
	}

}