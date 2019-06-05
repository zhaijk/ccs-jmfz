package com.derun.ccs.jmfz.model;
/**
 * 
 * @author Administrator
 *
 */
public class CcsHdXx {
	private int row_id;
	private String NSRMC;	//纳税人名称
	private String NSRSBH;	//纳税人识别号
	private String NSRDZ;	//纳税人地址
	private String NSRLXDH;	//纳税人联系电话
	private String NSRSSHY;	//纳税人所属行业
	private String NSRJJLX;	//纳税人经济类型	　
	private String CLSBDM;	//车辆识别代码
	private String HPHM;	//号牌号码
	private String HPZL;	//号牌种类
	private String CLLXDM;	//车辆类型代码
	private String PPXH;	//品牌型号
	private String SYXZ;	//使用性质
	private String FDJH;	//发动机号

	private String CSDJRQ;	//初始登记日期
	private String FZRQ;	//发证日期
	private double ZZL;		//总质量
	private double ZBZL;	//整备质量
	private double HDZZL;	//核定载质量
	private int HDZKS;		//核定载客数
	private int PQL;		//排气量
	private int GL;			//功率
	private int RLZL;		//燃料种类
	private String JMLX;		//减免类型
	private String SYRMC;	//所有人名称
	private String SYRZJHM;	//所有人证件号码
	private String SYRZJLX;	//所有人证件类型
	private String SYRDZ;	//所有人地址
	private String SYRLXDH;	//所有人联系电话

	private String GMRQ;	//购买日期
	private String PZDJJG;	//牌照登记机关
	private String SYQLX;	//所有权类型
	private String SYZTDM;	//使用状态代码
	private String SZSMDM;	//税种税目代码
	private String JSDWDM;	//计税单位代码
	private double DWJSJE;	//单位计税金额
	private double JMQSE;	//减免前税额
	private double NYNSE;	//年应纳税额
	private double DJNDYNSE;//登记年度应纳税额
	private String SWJGDM;	//税务机关代码
	private String SJLY;	//数据来源	
	
	private String JMYYDM;	//减免原因代码	
	private String JMFADM;	//减免方案代码　
	private double JMBL;	//减免比例
	private double JMJE;	//减免金额
	private String CPXH;	//厂牌型号
	private String HPYS;	//号牌颜色
		
	private String CLSYZZRQ;	//车辆使用终止日期
	private String DJBGRQ;	//登记变更日期　
	private String CLLX_ZJTY;	//总局统一车辆类型
	private String SJCQCL_BZ;	//数据抽取处理标志　
	private String ApprovedFlag;	//核定状态	
	private String CARSERIALNO;	//机动车序列号
	private String MOTORTYPECODE;	//交强险车辆种类代码
	private String MODEL;	//车辆型号　
	
	private String SJCJRQ;	//车辆使用终止日期
	private String ValidateFlag;	//登记变更日期　
	private String Cldjddm;	//总局统一车辆类型
	private String Cldjdmc;	//数据抽取处理标志　
	
	private String HDSJ;	//核定时间
	private String HDRMC;	//核定人名称
	private String HDYY;	//核定原因　
	
	private String yxztbgrq;	//有效状态变更时间　
	private String yxztbgyy;	//有效状态变更原因　
	private String RKJE;		// 
	
	public String getNSRMC() {
		return NSRMC;
	}
	public void setNSRMC(String nSRMC) {
		NSRMC = nSRMC;
	}
	public String getNSRSBH() {
		return NSRSBH;
	}
	public void setNSRSBH(String nSRSBH) {
		NSRSBH = nSRSBH;
	}
	public String getNSRDZ() {
		return NSRDZ;
	}
	public void setNSRDZ(String nSRDZ) {
		NSRDZ = nSRDZ;
	}
	public String getNSRLXDH() {
		return NSRLXDH;
	}
	public void setNSRLXDH(String nSRLXDH) {
		NSRLXDH = nSRLXDH;
	}
	public String getNSRSSHY() {
		return NSRSSHY;
	}
	public void setNSRSSHY(String nSRSSHY) {
		NSRSSHY = nSRSSHY;
	}
	public String getNSRJJLX() {
		return NSRJJLX;
	}
	public void setNSRJJLX(String nSRJJLX) {
		NSRJJLX = nSRJJLX;
	}
	public String getCLSBDM() {
		return CLSBDM;
	}
	public void setCLSBDM(String cLSBDM) {
		CLSBDM = cLSBDM;
	}
	public String getHPHM() {
		return HPHM;
	}
	public void setHPHM(String hPHM) {
		HPHM = hPHM;
	}
	public String getHPZL() {
		return HPZL;
	}
	public void setHPZL(String hPZL) {
		HPZL = hPZL;
	}
	public String getCLLXDM() {
		return CLLXDM;
	}
	public void setCLLXDM(String cLLXDM) {
		CLLXDM = cLLXDM;
	}
	public String getPPXH() {
		return PPXH;
	}
	public void setPPXH(String pPXH) {
		PPXH = pPXH;
	}
	public String getSYXZ() {
		return SYXZ;
	}
	public void setSYXZ(String sYXZ) {
		SYXZ = sYXZ;
	}
	public String getFDJH() {
		return FDJH;
	}
	public void setFDJH(String fDJH) {
		FDJH = fDJH;
	}
	public String getCSDJRQ() {
		return CSDJRQ;
	}
	public void setCSDJRQ(String cSDJRQ) {
		CSDJRQ = cSDJRQ;
	}
	public String getFZRQ() {
		return FZRQ;
	}
	public void setFZRQ(String fZRQ) {
		FZRQ = fZRQ;
	}
	public double getZZL() {
		return ZZL;
	}
	public void setZZL(double zZL) {
		ZZL = zZL;
	}
	public double getZBZL() {
		return ZBZL;
	}
	public void setZBZL(double zBZL) {
		ZBZL = zBZL;
	}
	public double getHDZZL() {
		return HDZZL;
	}
	public void setHDZZL(double hDZZL) {
		HDZZL = hDZZL;
	}
	public int getHDZKS() {
		return HDZKS;
	}
	public void setHDZKS(int hDZKS) {
		HDZKS = hDZKS;
	}
	public int getPQL() {
		return PQL;
	}
	public void setPQL(int pQL) {
		PQL = pQL;
	}
	public int getGL() {
		return GL;
	}
	public void setGL(int gL) {
		GL = gL;
	}
	public int getRLZL() {
		return RLZL;
	}
	public void setRLZL(int rLZL) {
		RLZL = rLZL;
	}
	public String getJMLX() {
		return JMLX;
	}
	public void setJMLX(String jMLX) {
		JMLX = jMLX;
	}
	public String getSYRMC() {
		return SYRMC;
	}
	public void setSYRMC(String sYRMC) {
		SYRMC = sYRMC;
	}
	public String getSYRZJHM() {
		return SYRZJHM;
	}
	public void setSYRZJHM(String sYRZJHM) {
		SYRZJHM = sYRZJHM;
	}
	public String getSYRZJLX() {
		return SYRZJLX;
	}
	public void setSYRZJLX(String sYRZJLX) {
		SYRZJLX = sYRZJLX;
	}
	public String getSYRDZ() {
		return SYRDZ;
	}
	public void setSYRDZ(String sYRDZ) {
		SYRDZ = sYRDZ;
	}
	public String getSYRLXDH() {
		return SYRLXDH;
	}
	public void setSYRLXDH(String sYRLXDH) {
		SYRLXDH = sYRLXDH;
	}
	public String getGMRQ() {
		return GMRQ;
	}
	public void setGMRQ(String gMRQ) {
		GMRQ = gMRQ;
	}
	public String getPZDJJG() {
		return PZDJJG;
	}
	public void setPZDJJG(String pZDJJG) {
		PZDJJG = pZDJJG;
	}
	public String getSYQLX() {
		return SYQLX;
	}
	public void setSYQLX(String sYQLX) {
		SYQLX = sYQLX;
	}
	public String getSYZTDM() {
		return SYZTDM;
	}
	public void setSYZTDM(String sYZTDM) {
		SYZTDM = sYZTDM;
	}
	public String getSZSMDM() {
		return SZSMDM;
	}
	public void setSZSMDM(String sZSMDM) {
		SZSMDM = sZSMDM;
	}
	public String getJSDWDM() {
		return JSDWDM;
	}
	public void setJSDWDM(String jSDWDM) {
		JSDWDM = jSDWDM;
	}
	public double getDWJSJE() {
		return DWJSJE;
	}
	public void setDWJSJE(double dWJSJE) {
		DWJSJE = dWJSJE;
	}
	public double getJMQSE() {
		return JMQSE;
	}
	public void setJMQSE(double jMQSE) {
		JMQSE = jMQSE;
	}
	public double getNYNSE() {
		return NYNSE;
	}
	public void setNYNSE(double nYNSE) {
		NYNSE = nYNSE;
	}
	public double getDJNDYNSE() {
		return DJNDYNSE;
	}
	public void setDJNDYNSE(double dJNDYNSE) {
		DJNDYNSE = dJNDYNSE;
	}
	public String getSWJGDM() {
		return SWJGDM;
	}
	public void setSWJGDM(String sWJGDM) {
		SWJGDM = sWJGDM;
	}
	public String getSJLY() {
		return SJLY;
	}
	public void setSJLY(String sJLY) {
		SJLY = sJLY;
	}
	public String getJMYYDM() {
		return JMYYDM;
	}
	public void setJMYYDM(String jMYYDM) {
		JMYYDM = jMYYDM;
	}
	public String getJMFADM() {
		return JMFADM;
	}
	public void setJMFADM(String jMFADM) {
		JMFADM = jMFADM;
	}
	public double getJMBL() {
		return JMBL;
	}
	public void setJMBL(double jMBL) {
		JMBL = jMBL;
	}
	public double getJMJE() {
		return JMJE;
	}
	public void setJMJE(double jMJE) {
		JMJE = jMJE;
	}
	public String getCPXH() {
		return CPXH;
	}
	public void setCPXH(String cPXH) {
		CPXH = cPXH;
	}
	public String getHPYS() {
		return HPYS;
	}
	public void setHPYS(String hPYS) {
		HPYS = hPYS;
	}
	public String getCLSYZZRQ() {
		return CLSYZZRQ;
	}
	public void setCLSYZZRQ(String cLSYZZRQ) {
		CLSYZZRQ = cLSYZZRQ;
	}
	public String getDJBGRQ() {
		return DJBGRQ;
	}
	public void setDJBGRQ(String dJBGRQ) {
		DJBGRQ = dJBGRQ;
	}
	public String getCLLX_ZJTY() {
		return CLLX_ZJTY;
	}
	public void setCLLX_ZJTY(String cLLX_ZJTY) {
		CLLX_ZJTY = cLLX_ZJTY;
	}
	public String getSJCQCL_BZ() {
		return SJCQCL_BZ;
	}
	public void setSJCQCL_BZ(String sJCQCL_BZ) {
		SJCQCL_BZ = sJCQCL_BZ;
	}
	public String getApprovedFlag() {
		return ApprovedFlag;
	}
	public void setApprovedFlag(String approvedFlag) {
		ApprovedFlag = approvedFlag;
	}
	public String getCARSERIALNO() {
		return CARSERIALNO;
	}
	public void setCARSERIALNO(String cARSERIALNO) {
		CARSERIALNO = cARSERIALNO;
	}
	public String getMOTORTYPECODE() {
		return MOTORTYPECODE;
	}
	public void setMOTORTYPECODE(String mOTORTYPECODE) {
		MOTORTYPECODE = mOTORTYPECODE;
	}
	public String getMODEL() {
		return MODEL;
	}
	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}
	public String getSJCJRQ() {
		return SJCJRQ;
	}
	public void setSJCJRQ(String sJCJRQ) {
		SJCJRQ = sJCJRQ;
	}
	public String getValidateFlag() {
		return ValidateFlag;
	}
	public void setValidateFlag(String validateFlag) {
		ValidateFlag = validateFlag;
	}
	public String getCldjddm() {
		return Cldjddm;
	}
	public void setCldjddm(String cldjddm) {
		Cldjddm = cldjddm;
	}
	public String getCldjdmc() {
		return Cldjdmc;
	}
	public void setCldjdmc(String cldjdmc) {
		Cldjdmc = cldjdmc;
	}
	public String getHDSJ() {
		return HDSJ;
	}
	public void setHDSJ(String hDSJ) {
		HDSJ = hDSJ;
	}
	public String getHDRMC() {
		return HDRMC;
	}
	public void setHDRMC(String hDRMC) {
		HDRMC = hDRMC;
	}
	public String getHDYY() {
		return HDYY;
	}
	public void setHDYY(String hDYY) {
		HDYY = hDYY;
	}
	public String getYxztbgrq() {
		return yxztbgrq;
	}
	public void setYxztbgrq(String yxztbgrq) {
		this.yxztbgrq = yxztbgrq;
	}
	public String getYxztbgyy() {
		return yxztbgyy;
	}
	public void setYxztbgyy(String yxztbgyy) {
		this.yxztbgyy = yxztbgyy;
	}
	public String getRKJE() {
		return RKJE;
	}
	public void setRKJE(String rKJE) {
		RKJE = rKJE;
	}
	public int getRow_id() {
		return row_id;
	}
	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}	
}
