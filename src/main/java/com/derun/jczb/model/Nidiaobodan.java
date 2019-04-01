package com.derun.jczb.model;

public class Nidiaobodan {

	private Long id;				//序号
	private String shougongdanwei;	// 受供单位
	private String zhuangtai;		// 状态标志
	private String tijiaodate1;		// 支队提交日期
	private String tijiaodate2;		// 总队提交日期
	private Integer niandu;			// 年度
	private String caozuoyuan1;		// 支队操作员
	private String caozuoyuan2;		// 总队操作员
	private Long cishu;				// 调拨次数

//	private Set<NidiaobodanRecord> nidiaobodanRecords = new HashSet<NidiaobodanRecord>();
//	
//	public Nidiaobodan() {
//	}

	public String getCaozuoyuan1() {
		return caozuoyuan1;
	}

	public void setCaozuoyuan1(String caozuoyuan1) {
		this.caozuoyuan1 = caozuoyuan1;
	}

	public String getCaozuoyuan2() {
		return caozuoyuan2;
	}

	public void setCaozuoyuan2(String caozuoyuan2) {
		this.caozuoyuan2 = caozuoyuan2;
	}

	public Long getCishu() {
		return cishu;
	}

	public void setCishu(Long cishu) {
		this.cishu = cishu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNiandu() {
		return niandu;
	}

	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}

//	public Set<NidiaobodanRecord> getNidiaobodanRecords() {
//		return nidiaobodanRecords;
//	}
//
//	public void setNidiaobodanRecords(Set<NidiaobodanRecord> nidiaobodanRecords) {
//		this.nidiaobodanRecords = nidiaobodanRecords;
//	}

	public String getShougongdanwei() {
		return shougongdanwei;
	}

	public void setShougongdanwei(String shougongdanwei) {
		this.shougongdanwei = shougongdanwei;
	}

	public String getTijiaodate1() {
		return tijiaodate1;
	}

	public void setTijiaodate1(String tijiaodate1) {
		this.tijiaodate1 = tijiaodate1;
	}

	public String getTijiaodate2() {
		return tijiaodate2;
	}

	public void setTijiaodate2(String tijiaodate2) {
		this.tijiaodate2 = tijiaodate2;
	}

	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

}
