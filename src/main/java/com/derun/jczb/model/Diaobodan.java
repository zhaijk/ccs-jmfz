package com.derun.jczb.model;

public class Diaobodan  {

	private Long id;			// 主键
	private String danjuhao;	// 单据号
	private String huandanhao;	// 换单号(上张单据号)
	/**
	 * 类型 凭证类型为单数为上级下载，双数为本级开出，
	 * 	1 总后收入
	 * 	2 自购收入
	 * 	3 军区调拨
	 * 	4 本级换单
	 * 	5 上级解放军油库收入
	 * 	6本级解放军油库部队支出
	 *  7 上级武警油库收入
	 *  8 本级解放军油库武警油库支出 
	 *  9 本级武警油库部队支出 
	 *  10 本级武警油库损耗
	 */
	private Long leixing;
	private String kaidanriqi;// 开单日期
	private String gongyingyouku;// 供应油库
	private String shougongdanwei;// 受供单位
	private String junqu_code;// 军区编码(多数时候只是为了记录)
	private Double xiaoji = 0d;// 油料小计,附表油料之和
	private String chengbanren;// 承办人(一般为空,手写在单据上)
	private String jingbanren;// 经办人(一般为空,手写在单据上)
	private String pizhunren;// 批准人(一般为空,手写在单据上)
	private String beizhu;// 备注
	private String beizhu_sys;// 系统用备注
	private Integer niandu;// 年度
	private Long biaozhi = 0l;// 有效标志
	private Long dayin = 0l;// 打印次数
	private String caozuoyuan;// 操作员
	private String caozuoriqi;// 操作日期(最后一次操作日期)
	private String caozuotime;// 操作时间
	private Long jz = 0l;// 结转标志(结转记录使用)
	private Long cishu;// 调拨次数 2014.2.17新加的字段
	private Long jizhang = 0l;// 记账标志(0:未记账，1：待记账，2：记账)

//	// 附表记录
//	private Set<DiaobodanRecord> diaobodanRecords = new HashSet<DiaobodanRecord>(
//			0);
//
//	public Diaobodan() {
//	}
//
//	public Diaobodan(String danjuhao, String huandanhao, Long leixing,
//			String kaidanriqi, String gongyingyouku, String shougongdanwei,
//			String junquCode, Double xiaoji, String chengbanren,
//			String jingbanren, String pizhunren, String beizhu,
//			String beizhuSys, Integer niandu, Long biaozhi, Long dayin,
//			String caozuoyuan, String caozuoriqi, String caozuotime, Long jz,
//			Long cishu,Long jizhang,Set diaobodanRecords) {
//		this.danjuhao = danjuhao;
//		this.huandanhao = huandanhao;
//		this.leixing = leixing;
//		this.kaidanriqi = kaidanriqi;
//		this.gongyingyouku = gongyingyouku;
//		this.shougongdanwei = shougongdanwei;
//		this.junquCode = junquCode;
//		this.xiaoji = xiaoji;
//		this.chengbanren = chengbanren;
//		this.jingbanren = jingbanren;
//		this.pizhunren = pizhunren;
//		this.beizhu = beizhu;
//		this.beizhuSys = beizhuSys;
//		this.niandu = niandu;
//		this.biaozhi = biaozhi;
//		this.dayin = dayin;
//		this.caozuoyuan = caozuoyuan;
//		this.caozuoriqi = caozuoriqi;
//		this.caozuotime = caozuotime;
//		this.jz = jz;
//		this.cishu = cishu;
//		this.jizhang = jizhang;
//		this.diaobodanRecords = diaobodanRecords;
//	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDanjuhao() {
		return this.danjuhao;
	}

	public void setDanjuhao(String danjuhao) {
		this.danjuhao = danjuhao;
	}

	public String getHuandanhao() {
		return this.huandanhao;
	}

	public void setHuandanhao(String huandanhao) {
		this.huandanhao = huandanhao;
	}

	public Long getLeixing() {
		return this.leixing;
	}

	public void setLeixing(Long leixing) {
		this.leixing = leixing;
	}

	public String getKaidanriqi() {
		return this.kaidanriqi;
	}

	public void setKaidanriqi(String kaidanriqi) {
		this.kaidanriqi = kaidanriqi;
	}

	public String getGongyingyouku() {
		return this.gongyingyouku;
	}

	public void setGongyingyouku(String gongyingyouku) {
		this.gongyingyouku = gongyingyouku;
	}


	public String getShougongdanwei() {
		return shougongdanwei;
	}

	public void setShougongdanwei(String shougongdanwei) {
		this.shougongdanwei = shougongdanwei;
	}	

	public Double getXiaoji() {
		return this.xiaoji;
	}

	public void setXiaoji(Double xiaoji) {
		this.xiaoji = xiaoji;
	}

	public String getChengbanren() {
		return this.chengbanren;
	}

	public void setChengbanren(String chengbanren) {
		this.chengbanren = chengbanren;
	}

	public String getJingbanren() {
		return this.jingbanren;
	}

	public void setJingbanren(String jingbanren) {
		this.jingbanren = jingbanren;
	}

	public String getPizhunren() {
		return this.pizhunren;
	}

	public void setPizhunren(String pizhunren) {
		this.pizhunren = pizhunren;
	}

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Integer getNiandu() {
		return this.niandu;
	}

	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}

	public Long getBiaozhi() {
		return this.biaozhi;
	}

	public void setBiaozhi(Long biaozhi) {
		this.biaozhi = biaozhi;
	}

	public Long getDayin() {
		return this.dayin;
	}

	public void setDayin(Long dayin) {
		this.dayin = dayin;
	}

	public String getCaozuoyuan() {
		return this.caozuoyuan;
	}

	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}

	public String getCaozuoriqi() {
		return this.caozuoriqi;
	}

	public void setCaozuoriqi(String caozuoriqi) {
		this.caozuoriqi = caozuoriqi;
	}

	public String getCaozuotime() {
		return this.caozuotime;
	}

	public void setCaozuotime(String caozuotime) {
		this.caozuotime = caozuotime;
	}

	public Long getJz() {
		return this.jz;
	}

	public void setJz(Long jz) {
		this.jz = jz;
	}

	public Long getCishu() {
		return cishu;
	}

	public void setCishu(Long cishu) {
		this.cishu = cishu;
	}
	
	public Long getJizhang() {
		return jizhang;
	}

	public void setJizhang(Long jizhang) {
		this.jizhang = jizhang;
	}

	public String getJunqu_code() {
		return junqu_code;
	}

	public void setJunqu_code(String junqu_code) {
		this.junqu_code = junqu_code;
	}

	public String getBeizhu_sys() {
		return beizhu_sys;
	}

	public void setBeizhu_sys(String beizhu_sys) {
		this.beizhu_sys = beizhu_sys;
	}

//	public Set<DiaobodanRecord> getDiaobodanRecords() {
//		return this.diaobodanRecords;
//	}
//
//	public void setDiaobodanRecords(Set<DiaobodanRecord> diaobodanRecords) {
//		this.diaobodanRecords = diaobodanRecords;
//	}
}