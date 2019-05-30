package com.derun.jczb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import com.derun.jczb.model.DepartmentIncome;
import com.derun.jczb.model.ProvideSumInfo;
import com.derun.jczb.model.SwYlLzZbTjReport;
import com.derun.jczb.model.SwYlXhTjReport;
import com.derun.jczb.model.YL_report;
import com.derun.jczb.model.YouliaozhibiaoReport;
import com.derun.jczb.model.ZdgCardTrades;
import com.derun.jczb.model.Zhibiao;
import com.derun.jczb.model.Zhuandaigong;
/**
 * 
 * @author Administrator
 *
 */
//部门指标收入
public interface DepartmentIncomeMapper {
	@Select("select nvl(sum(tonnum),0) from iccard.department_income where departmentcode='241800000000' and  incomtype=3 and provideDate2 >= '2017-12-26'")
	public double queryBy();
	@Select("select max(t.riqi) from wujing.niandujiezhuan t")
	public String queryDateBy();
	//指标合计
	//@Select("select sum(sw+jb+zg) from wujing.zhibiao where dwcode=#{departmentId} and riqi>#{date}")
	//public String queryZhiBiaoheji(String departmentId,String date);
	@Select("select sum(sw+jb+zg) from wujing.zhibiao where dwcode=#{departmentId}")
	public String queryZhiBiaoheji(String departmentId);
	//指标
	@Select("select * from wujing.zhibiao where dwcode= #{departmentId} and (sw>0 or jb>0 or zg>0) order by riqi")
	public List<Zhibiao> queryZhiBiaoList(String departmentId);
	//指标转换合计
	@Select("select nvl(sum(tonnum),0) from iccard.department_income where departmentcode= #{departmentId} and incomtype=1 and provideDate2 >=#{date}")
	public String queryZhuanhuanHeji(String departmentId,String date);
	//支队指标转代供他部
	@Select("select 0-nvl(sum(sl),0) from zhibiao_zdg where dwcode=#{departmentId} and sl<0")
	public String queryZhiDuiZhiBiaoZdgTaBu(String departmentId);
	@Select("select * from zhibiao_zdg where dwcode=#{departmentId}")
	public List<Object> queryZhiDuiZhiBiaoZdg(String departmentId);
	//价拨支出合计
	@Select("select sum(jb) from zhibiao_jb where dwcode=#{departmentId}")
	public String queryJiaobozhichuheji(String departmentId);
	//临时转代供
	@Select("select nvl(sum(shuliang),0) from zdglinshi where danwei like #{departmentId}||'%'")
	public String queryLinshiZhuandaigong(String departmentId);
	//转代供转换合计
	@Select("select nvl(sum(tonnum),0) from iccard.department_income where departmentcode=#{departmentId} and  incomtype=3 and provideDate2 >= #{jiezhuanDate}")
	public String queryZhuandaigongZhuanhuanHeji(String departmentId,String jiezhuanDate);
	@Select("select * from iccard.department_income where departmentCode like #{departmentId}||'%' and incomType =#{incomeType} and provideDate2 >= #{provideDate} order by provideDate2,incomID")
	public List<DepartmentIncome> queryIncomeBy(String departmentId,int incomeType,String provideDate);
	//价拨支出
	@Select("select * from wujing.zhibiao_jb where dwcode=#{departmentId}")
	public List<Zhibiao> queryJiaboZhichu(String departmentId);
	//代供外部
	@Select("select * from wujing.zhibiao_zdg where dwcode=#{departmentId}")
	public List<Zhibiao> queryDaigongWaibu(String departmentId);
	/*@Select("select max(riqi) from jiezhuandate")
	public String queyJiezhuandate();*/
	//@Select("select iccard.Department_Income_sequence.nextval  from dual")
	//public int getNextValIncomeID();
	@Select("select nvl(sum(shuliang),0) from zdglinshi where danwei like #{danwei}||'%'")
	public double queryZdgLinshi(String danwei);
	@Select("select riqi,shuliang from zdglinshi where danwei like #{danwei}||'%' order by riqi desc")
	public List<Zhuandaigong> queryZhuanDaiGong(String danwei);
	@Select("select oilType as oiltype,sum(tonNum) as total from iccard.Department_Income where departmentCode like #{departmentCode}||'%'"
			+ "and incomType=3 and provideDate2 > #{jiezhuanDate} group by oilType")
	List<ZdgCardTrades> queryZdg(String departmentCode,String jiezhuanDate);
	@Select("select rownum as id ,c.* from (select a.*,b.name as oilName from iccard.department_income a, iccard.oil_dictionary b  where a.oiltype=b.code and a.departmentCode like #{departmentCode}||'%' and a.incomType=2 and a.provideDate2 > #{jiezhuanDate} order by a.incomID desc) c")
	List<DepartmentIncome>  queryZGYL(String departmentCode,String jiezhuanDate);
	@SelectKey(statement="select to_char(iccard.Department_Income_sequence.nextval)  from dual" , before=true,keyColumn="incomID",resultType=String.class,keyProperty="incomID")
	@Insert("insert into iccard.department_income (incomType,inputGuideline2,oilType,incomID,danjuhao,tonNum,density,departmentCode,provideDate2) values(#{incomType},#{inputGuideline2},#{oilType},#{incomID},#{danjuhao},#{tonNum},#{density},#{departmentCode},#{provideDate2})")
	public int insertOne(DepartmentIncome obj);
	@Delete("delete iccard.department_income where incomID=#{incomID}")
	public int deleteOne(DepartmentIncome obj);
	@Update("update iccard.department_income set danjuhao=#{danjuhao},oilType=#{oilType},tonNum=#{tonNum}, density=#{density}, inputGuideline2=#{inputGuideline2} where incomID=#{incomID}")
	public int updateOne(DepartmentIncome obj);
//	@Select("select o.oiltype as oilType,(nvl(din.guideline,0)-nvl(dre.guideline2,0)) as sum from iccard.oil_dictionary o, " + 
//			"(select di.oilType as oil,sum(di.inputGuideline2) as guideline from iccard.Department_Income di where di.departmentCode like #{departmentCode} || '%' and  di.providedate2>=#{jiezhuanDate} group by di.oilType) din, " + 
//			"(select dr.oiltype as dro,sum(dr.inputGuideline) as guideline2 from iccard.Department_Record dr where dr.departmentCode like #{departmentCode} || '%' and  dr.providedate>=#{jiezhuanDate} group by dr.oilType) dre " + 
//			"where o.oiltype=din.oil(+) and o.oiltype=dre.dro(+) order by o.oiltype")
	@Select("select o.oiltype as  oilType ,(nvl(din.guideline,0)-nvl(dre.guideline2,0)) as sum from iccard.oil_dictionary o,(select di.oilType as oil,sum(di.inputGuideline2) as guideline from iccard.Department_Income di where di.departmentCode like  #{departmentCode} || '%'    and di.providedate2>=#{jiezhuanDate}  group by di.oilType) din,(select dr.oiltype as dro,sum(dr.inputGuideline) as guideline2 from iccard.Department_Record dr where dr.departmentCode like  #{departmentCode} || '%'  and dr.providedate>=#{jiezhuanDate}  group by dr.oilType) dre where o.oiltype=din.oil(+) and o.oiltype=dre.dro(+)")
	public List<ProvideSumInfo> querySumGuideline(String departmentCode,String jiezhuanDate);
	
	
	@Select(value="call report.youliaozhibiaotjbiao(#{danwei,mode=IN,jdbcType=VARCHAR},#{nian,mode=IN,jdbcType=FLOAT},#{yl_report,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=zxzb},#{zxzb,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=zxzb})")
	@Results(id="zxzb",
	value= {					
			@Result(column="CODE",property="code",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="HEJIZHIBIAO",property="hejizhibiao",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="JDZGXIAOJI",property="jdzgxiaoji",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="JDZGFP",property="jdzgfp",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="ZG",property="zg",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="SG",property="sg",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="ZGZYHEJI",property="zgzyheji",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="ZGZYFP",property="zgzyfp",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="ZGFYHEJI",property="zgfyheji",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="ZGFYFP",property="zgfyfp",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="ZXZB",property="zxzb",javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="PAIXU",property="paixu",javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	@Options(statementType=StatementType.CALLABLE)
	public List<YL_report> youliaozhibiaoReport(Map<String,Object> params);
	
	@Select(value="call iccard.youliaozhibiaoreport(#{cur_youliaozhibiao,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=youliaozhibiao},#{cur_oil,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=youliaozhibiao},#{departmentcode,mode=IN,jdbcType=VARCHAR},#{niandu,mode=IN,jdbcType=VARCHAR})")
	@Results(id="youliaozhibiao",
	value= {					
			@Result(column="ID",property="id",javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(column="CODE",property="code",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="NAME",property="name",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="OILTYPE",property="oiltype",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="VOLUMN",property="volumn",javaType = Double.class, jdbcType = JdbcType.NUMERIC)
	})
	@Options(statementType=StatementType.CALLABLE)
	public List<YouliaozhibiaoReport> youliao_zhibiao(Map<String,Object> params);
	
//	@Select(value="call iccard.swylzbtj(#{cur_swylzbtj,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=swylzb},#{dbmcode,mode=IN,jdbcType=VARCHAR},#{departmentcode,mode=IN,jdbcType=VARCHAR},#{oil,mode=IN,jdbcType=INTEGER},#{i,mode=IN,jdbcType=INTEGER},#{niandu,mode=IN,jdbcType=VARCHAR},#{guidelinetype,mode=IN,jdbcType=VARCHAR})")
//	@Results(id="swylzb",
//	value= {					
//			@Result(column="recorddate",property="recorddate",	javaType = String.class, jdbcType = JdbcType.VARCHAR),
//			@Result(column="sqjz",		property="sqjz",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
//			@Result(column="shouru",	property="shouru",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
//			@Result(column="zhichu",	property="zhichu",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
//			@Result(column="jiechun",	property="jiechun",		javaType = Double.class, jdbcType = JdbcType.NUMERIC)
//	})
//	@Options(statementType=StatementType.CALLABLE)
//	public List<SwYlLzZbTjReport> swylzbtj(Map<String,Object> params);
	@Select(value="call iccard.swylzbtj(#{cur_swylzbtj,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=swylzb},#{dbmcode,mode=IN,jdbcType=VARCHAR},#{departmentcode,mode=IN,jdbcType=VARCHAR},#{oil,mode=IN,jdbcType=INTEGER},#{i,mode=IN,jdbcType=INTEGER},#{niandu,mode=IN,jdbcType=VARCHAR},#{guidelinetype,mode=IN,jdbcType=VARCHAR})")
	@Results(id="swylzb",
	value= {					
			@Result(column="recorddate",property="recorddate",	javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="sqjz",		property="sqjz",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="shouru",	property="shouru",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="zhichu",	property="zhichu",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="jiechun",	property="jiechun",		javaType = Double.class, jdbcType = JdbcType.NUMERIC)
	})
	@Options(statementType=StatementType.CALLABLE)
	public List<SwYlLzZbTjReport> swylzbtj(Map<String,Object> params);
	/*
	 *      年度价拨油料经费汇总表
	 */
	@Select(value="call iccard.niandujiabojingfei(#{cur_niandujiabojingfei,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=jbjfhz},#{departmentcode,mode=IN,jdbcType=VARCHAR},#{niandu,mode=IN,jdbcType=VARCHAR})")
	@Results(id="jbjfhz",
	value= {					
			@Result(column="recorddate",property="recorddate",	javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="sqjz",		property="sqjz",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="shouru",	property="shouru",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="zhichu",	property="zhichu",		javaType = Double.class, jdbcType = JdbcType.NUMERIC),
			@Result(column="jiechun",	property="jiechun",		javaType = Double.class, jdbcType = JdbcType.NUMERIC)
	})
	@Options(statementType=StatementType.CALLABLE)
	public List<SwYlLzZbTjReport> jbjfhz(Map<String,Object> params);
	//年度实物油料消耗统计查询
	@Select(value="call iccard.niandushiwuxiaohao(#{cur_niandushiwuxiaohao,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=swylxh},#{cur_oil,mode=OUT,jdbcType=CURSOR,javaType=ResultSet,resultMap=swylxh},#{departmentcode,mode=IN,jdbcType=VARCHAR},#{niandu,mode=IN,jdbcType=VARCHAR})")
	@Results(id="swylxh",
	value= {					
			@Result(column="td",property="td",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="toi",property="toi",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="tv",property="tv",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="tvt",property="tvt",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="code",	property="code",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="name",	property="name",javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column="oiltype",	property="oiltype",	javaType = Integer.class, jdbcType = JdbcType.INTEGER)
	})
	@Options(statementType=StatementType.CALLABLE)
	public List<SwYlXhTjReport> swylxhtj(Map<String,Object> params);
}
