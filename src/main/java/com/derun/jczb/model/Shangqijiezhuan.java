package com.derun.jczb.model;

public class Shangqijiezhuan{

	private Long id;
	private Long niandu;
	private Long youbianhao;
	private String danweiid;
	private Double shangqizhugong;
	private Double shangqizigou;
	private Double shangqijiabo;

//	// Constructors
//
//	/** default constructor */
//	public Shangqijiezhuan() {
//	}
//
//	/** minimal constructor */
//	public Shangqijiezhuan(Long id) {
//		this.id = id;
//	}
//
//	/** full constructor */
//	public Shangqijiezhuan(Long id, Long niandu, Long youbianhao,
//			String danweiid, Double shangqizhugong, Double shangqizigou,
//			Double shangqijiabo) {
//		this.id = id;
//		this.niandu = niandu;
//		this.youbianhao = youbianhao;
//		this.danweiid = danweiid;
//		this.shangqizhugong = shangqizhugong;
//		this.shangqizigou = shangqizigou;
//		this.shangqijiabo = shangqijiabo;
//	}
//
//	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNiandu() {
		return this.niandu;
	}

	public void setNiandu(Long niandu) {
		this.niandu = niandu;
	}

	public Long getYoubianhao() {
		return this.youbianhao;
	}

	public void setYoubianhao(Long youbianhao) {
		this.youbianhao = youbianhao;
	}

	public String getDanweiid() {
		return this.danweiid;
	}

	public void setDanweiid(String danweiid) {
		this.danweiid = danweiid;
	}

	public Double getShangqizhugong() {
		return this.shangqizhugong;
	}

	public void setShangqizhugong(Double shangqizhugong) {
		this.shangqizhugong = shangqizhugong;
	}

	public Double getShangqizigou() {
		return this.shangqizigou;
	}

	public void setShangqizigou(Double shangqizigou) {
		this.shangqizigou = shangqizigou;
	}

	public Double getShangqijiabo() {
		return this.shangqijiabo;
	}

	public void setShangqijiabo(Double shangqijiabo) {
		this.shangqijiabo = shangqijiabo;
	}

}