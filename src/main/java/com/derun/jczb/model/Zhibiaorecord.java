package com.derun.jczb.model;

public class Zhibiaorecord {
	
	private Long id;				// 主键
	private String wenjianhao;		// 文件号
	private String danwei;			// 单位编码
	private String danwei_name;		//单位名称
	private String danweiid;
	private Long leixing;			// 类型1为上级指标分配记录2本级指标分配记录3上级指标调整记录4本级指标调整记录
	private Long yl_xiaoji = 0l;		// 油料小计
	private Long yl_jdzg = 0l;		// 油料-军队助供
	private Long yl_zgzy = 0l;		// 油料-自购主油
	private Long yl_zgfy = 0l;		// 油料-自购附油
	private Double jf_xiaoji = 0d;	// 经费小计
	private Double jf_zgzy = 0d;		// 自购主油经费
	private Double jf_zgfy = 0d;		// 自购附油经费
	private Double jf_ykgl = 0d;		// 油库管理费
	private Double jf_jyzgl = 0d;	// 加油站管理费
	private Double jf_ylywgl = 0d;	// 油料业务管理费
	private Double jf_ylgl = 0d;		// 油料管理费
	private String yl_beizhu;		// 油料备注
	private String jf_beizhu;		// 经费备注
	private Long jizhang;			// 记帐标志0未记帐1记帐
	private Integer niandu;			// 年度
	private Long biaozhi;			// 标志
	private String fenpeidate;		// 分配日期
	private String jzdate;			// 暂无留用	
	private String type;			//经费 jf  油料 yl
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
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}	
	public String getDanweiid() {
		return danweiid;
	}
	public void setDanweiid(String danweiid) {
		this.danweiid = danweiid;
	}
	public Long getLeixing() {
		return leixing;
	}
	public void setLeixing(Long leixing) {
		this.leixing = leixing;
	}
	public Long getYl_xiaoji() {
		return yl_xiaoji;
	}
	public void setYl_xiaoji(Long yl_xiaoji) {
		this.yl_xiaoji = yl_xiaoji;
	}
	public Long getYl_jdzg() {
		return yl_jdzg;
	}
	public void setYl_jdzg(Long yl_jdzg) {
		this.yl_jdzg = yl_jdzg;
	}
	public Long getYl_zgzy() {
		return yl_zgzy;
	}
	public void setYl_zgzy(Long yl_zgzy) {
		this.yl_zgzy = yl_zgzy;
	}
	public Long getYl_zgfy() {
		return yl_zgfy;
	}
	public void setYl_zgfy(Long yl_zgfy) {
		this.yl_zgfy = yl_zgfy;
	}
	public Double getJf_xiaoji() {
		return jf_xiaoji;
	}
	public void setJf_xiaoji(Double jf_xiaoji) {
		this.jf_xiaoji = jf_xiaoji;
	}
	public Double getJf_zgzy() {
		return jf_zgzy;
	}
	public void setJf_zgzy(Double jf_zgzy) {
		this.jf_zgzy = jf_zgzy;
	}
	public Double getJf_zgfy() {
		return jf_zgfy;
	}
	public void setJf_zgfy(Double jf_zgfy) {
		this.jf_zgfy = jf_zgfy;
	}
	public Double getJf_ykgl() {
		return jf_ykgl;
	}
	public void setJf_ykgl(Double jf_ykgl) {
		this.jf_ykgl = jf_ykgl;
	}
	public Double getJf_jyzgl() {
		return jf_jyzgl;
	}
	public void setJf_jyzgl(Double jf_jyzgl) {
		this.jf_jyzgl = jf_jyzgl;
	}
	public Double getJf_ylywgl() {
		return jf_ylywgl;
	}
	public void setJf_ylywgl(Double jf_ylywgl) {
		this.jf_ylywgl = jf_ylywgl;
	}
	public Double getJf_ylgl() {
		return jf_ylgl;
	}
	public void setJf_ylgl(Double jf_ylgl) {
		this.jf_ylgl = jf_ylgl;
	}
	public String getYl_beizhu() {
		return yl_beizhu;
	}
	public void setYl_beizhu(String yl_beizhu) {
		this.yl_beizhu = yl_beizhu;
	}
	public String getJf_beizhu() {
		return jf_beizhu;
	}
	public void setJf_beizhu(String jf_beizhu) {
		this.jf_beizhu = jf_beizhu;
	}
	public Long getJizhang() {
		return jizhang;
	}
	public void setJizhang(Long jizhang) {
		this.jizhang = jizhang;
	}
	public Integer getNiandu() {
		return niandu;
	}
	public void setNiandu(Integer niandu) {
		this.niandu = niandu;
	}
	public Long getBiaozhi() {
		return biaozhi;
	}
	public void setBiaozhi(Long biaozhi) {
		this.biaozhi = biaozhi;
	}
	public String getFenpeidate() {
		return fenpeidate;
	}
	public void setFenpeidate(String fenpeidate) {
		this.fenpeidate = fenpeidate;
	}
	public String getJzdate() {
		return jzdate;
	}
	public void setJzdate(String jzdate) {
		this.jzdate = jzdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDanwei_name() {
		return danwei_name;
	}
	public void setDanwei_name(String danwei_name) {
		this.danwei_name = danwei_name;
	}
	public double getJfTotal() {
		return jf_zgzy+jf_zgfy+jf_ykgl+jf_jyzgl+jf_ylywgl+jf_ylgl;
	}
	public long getYlTotal() {
		return 	yl_jdzg+yl_zgzy+yl_zgfy;
	}
}