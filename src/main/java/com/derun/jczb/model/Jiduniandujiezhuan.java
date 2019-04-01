package com.derun.jczb.model;


public class Jiduniandujiezhuan{

	private Long id;
	private Double sjswzhugong;
	private Double sjjiabo;
	private Long youpin;
	private String buduibianhao;
	private String jidu;
	private String niandu;	
	private String oilName;

//	/** default constructor */
//	public Jiduniandujiezhuan() {
//	}
//
//	/** minimal constructor */
//	public Jiduniandujiezhuan(Long id, Long youpin) {
//		this.id = id;
//		this.youpin = youpin;
//	}
//
//	/** full constructor */
//	public Jiduniandujiezhuan(Long id, Double sjswzhugong, Double sjjiabo,
//			Long youpin, String buduibianhao, String jidu, String niandu) {
//		this.id = id;
//		this.sjswzhugong = sjswzhugong;
//		this.sjjiabo = sjjiabo;
//		this.youpin = youpin;
//		this.buduibianhao = buduibianhao;
//		this.jidu = jidu;
//		this.niandu = niandu;
//	}
//
//	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSjswzhugong() {
		return this.sjswzhugong;
	}

	public void setSjswzhugong(Double sjswzhugong) {
		this.sjswzhugong = sjswzhugong;
	}

	public Double getSjjiabo() {
		return this.sjjiabo;
	}

	public void setSjjiabo(Double sjjiabo) {
		this.sjjiabo = sjjiabo;
	}

	public Long getYoupin() {
		return this.youpin;
	}

	public void setYoupin(Long youpin) {
		this.youpin = youpin;
	}

	public String getBuduibianhao() {
		return this.buduibianhao;
	}

	public void setBuduibianhao(String buduibianhao) {
		this.buduibianhao = buduibianhao;
	}

	public String getJidu() {
		return this.jidu;
	}

	public void setJidu(String jidu) {
		this.jidu = jidu;
	}

	public String getNiandu() {
		return this.niandu;
	}

	public void setNiandu(String niandu) {
		this.niandu = niandu;
	}
	
	public String getOilName() {
		return oilName;
	}

	public void setOilName(String oilName) {
		this.oilName = oilName;
	}
}