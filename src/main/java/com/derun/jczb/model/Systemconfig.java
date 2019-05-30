package com.derun.jczb.model;

public class Systemconfig {
	
	private Long id;			// 主键,固定为1,有只只有一条这样的记录
	private String danwei_code;	// 单位编码
	private String danwei;		// 单位名称
	private Long jici;			// 级次,为0时为总部,为1时为总部下单位,为2时上级单位级次为1
	private String linqinCode1;	// 联勤编码1 96位0或1字符串,外部联勤码
	private String linqinCode2;	// 联勤编码2 64位0或1字符串,内部联勤码
	private String shangjiip;	// 上级IP地址,下载和上传数据使用
	private Integer niandu;		// 年度

//	public Systemconfig() {
//	}
//
//	public Systemconfig(Long id) {
//		this.id = id;
//	}
//
//	public Systemconfig(Long id, String danweiCode, String danwei, Long jici,
//			String linqinCode1, String linqinCode2, String shangjiip,
//			Integer niandu) {
//		this.id = id;
//		this.danweiCode = danweiCode;
//		this.danwei = danwei;
//		this.jici = jici;
//		this.linqinCode1 = linqinCode1;
//		this.linqinCode2 = linqinCode2;
//		this.shangjiip = shangjiip;
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
	
	public String getDanwei() {
		return this.danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public Long getJici() {
		return this.jici;
	}

	public void setJici(Long jici) {
		this.jici = jici;
	}

	public String getLinqinCode1() {
		return this.linqinCode1;
	}

	public void setLinqinCode1(String linqinCode1) {
		this.linqinCode1 = linqinCode1;
	}

	public String getLinqinCode2() {
		return this.linqinCode2;
	}

	public void setLinqinCode2(String linqinCode2) {
		this.linqinCode2 = linqinCode2;
	}

	public String getShangjiip() {
		return this.shangjiip;
	}

	public void setShangjiip(String shangjiip) {
		this.shangjiip = shangjiip;
	}

	public Integer getNiandu() {
		return niandu;
	}

	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}

	public String getDanwei_code() {
		return danwei_code;
	}

	public void setDanwei_code(String danwei_code) {
		this.danwei_code = danwei_code;
	}

}