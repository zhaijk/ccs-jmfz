package com.derun.jczb.model;

public class DeparDictionary {
	private int id;
	private String bumen_code;	// 12位部门编码
	private String bumen;		// 部门名称	
	private Long leixing;		// 类型,类型为1为直属单位,2是下级单位需有IP
	private Long jici;			// 级次,为当前系统级次+1
	private String ipdizhi;		// IP地址
	private Long biaozhi;		// 标志,暂留
	private String lianqin1;	// 96外部联勤编码
	private String lianqin2;	// 64内部联勤编码	

//	public DeparDictionary() {
//	}
//
//	public DeparDictionary(String bumenCode) {
//		this.bumenCode = bumenCode;
//	}

//	public DeparDictionary(String bumenCode, String bumen, Long leixing,
//			Long jici, String ipdizhi, Long biaozhi, String lianqin1,
//			String lianqin2) {
//		this.bumenCode = bumenCode;
//		this.bumen = bumen;
//		this.leixing = leixing;
//		this.jici = jici;
//		this.ipdizhi = ipdizhi;
//		this.biaozhi = biaozhi;
//		this.lianqin1 = lianqin1;
//		this.lianqin2 = lianqin2;
//	}	
	public String getBumen() {
		return this.bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public Long getLeixing() {
		return this.leixing;
	}

	public void setLeixing(Long leixing) {
		this.leixing = leixing;
	}

	public Long getJici() {
		return this.jici;
	}

	public void setJici(Long jici) {
		this.jici = jici;
	}

	public String getIpdizhi() {
		return this.ipdizhi;
	}

	public void setIpdizhi(String ipdizhi) {
		this.ipdizhi = ipdizhi;
	}

	public Long getBiaozhi() {
		return this.biaozhi;
	}

	public void setBiaozhi(Long biaozhi) {
		this.biaozhi = biaozhi;
	}

	public String getLianqin1() {
		return this.lianqin1;
	}

	public void setLianqin1(String lianqin1) {
		this.lianqin1 = lianqin1;
	}

	public String getLianqin2() {
		return this.lianqin2;
	}

	public void setLianqin2(String lianqin2) {
		this.lianqin2 = lianqin2;
	}

	public String getBumen_code() {
		return bumen_code;
	}

	public void setBumen_code(String bumen_code) {
		this.bumen_code = bumen_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}