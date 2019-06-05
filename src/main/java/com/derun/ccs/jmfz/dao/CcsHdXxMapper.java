package com.derun.ccs.jmfz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.derun.ccs.jmfz.model.CcsHdXx;
import com.derun.ccs.jmfz.model.TotalInfo;

public interface CcsHdXxMapper {

	@Select("select * from SYJK_CCS_CCSHDXX")
	public List<CcsHdXx> queryAll();
	@Select("<script> select * from SYJK_CCS_CCSHDXX"
			+"<where>"
			+"<if test='\"normal\"==type'>"
			+" jmyc is null </if>"
			+"<if test='\"all\"!=type and \"normal\"!=type'>"
			+" jmyc=#{type} </if>"
			+"<if test='\"all\"!=bxgs'>"
			+" and jmyc=#{type} </if>"
			+"<if test='\"all\"!=nsrmc'>"
			+" and nsrmc like #{nsrmc} || '%' </if>"
			+"<if test='\"all\"!=hmhp'>"
			+" and hphm like #{hmhp} || '%' </if>"
			+"<if test='\"all\"!=querydatestart'>"
			+" and csdjrq>=to_date(#{querydatestart},'yyyy-MM-dd') </if>"
			+"<if test='\"all\"!=querydatestop'>"
			+" and to_date(#{querydatestop},'yyyy-MM-dd')>=csdjrq </if>"
			+"</where> order by csdjrq"
			+ "</script>")
	public List<CcsHdXx> queryBy(String nsrmc,String type,String bxgs,String hmhp,String querydatestart,String querydatestop);
	@Select("select count(*) from SYJK_CCS_CCSHDXX")
	public int queryCounter();
	@Select("select distinct a.*,b.*,c.* from " + 
			"(select sum(total) as total ,sum(total) as jm , sum(jm) as yc  from (select JMLX,JMYC,count(*) as total,count(JMYC) as jm from SYJK_CCS_CCSHDXX where jmlx in ('AE','PE') group by  jmlx,jmyc)) a ," + 
			"(select sum(JMQSE) as ysse ,sum(JMJE) as jmse,sum(JMQSE-JMJE) as ssse  from SYJK_CCS_CCSHDXX where jmlx in ('AE','PE')) b," + 
			"(select HDRMC,HDSJ from SYJK_CCS_CCSHDXX where jmlx in ('AE','PE')) c ")
	public List<TotalInfo> queryXNYTotal();
	@Select("select distinct a.*,b.*,c.* from " + 
			"(select sum(total) as total ,sum(total) as jm , sum(jm) as yc  from (select JMLX,JMYC,count(*) as total,count(JMYC) as jm from SYJK_CCS_CCSHDXX where jmlx in ('AC') group by  jmlx,jmyc)) a ," + 
			"(select sum(JMQSE) as ysse ,sum(JMJE) as jmse,sum(JMQSE-JMJE) as ssse  from SYJK_CCS_CCSHDXX where jmlx in ('AC')) b," + 
			"(select HDRMC,HDSJ from SYJK_CCS_CCSHDXX where jmlx in ('AC')) c ")
	public List<TotalInfo> querySHTotal();
	@Select("select distinct a.*,b.*,c.* from " + 
			"(select sum(total) as total ,sum(total) as jm , sum(jm) as yc  from (select JMLX,JMYC,count(*) as total,count(JMYC) as jm from SYJK_CCS_CCSHDXX where jmlx in ('AE','PE','AC') group by  jmlx,jmyc)) a ," + 
			"(select sum(JMQSE) as ysse ,sum(JMJE) as jmse,sum(JMQSE-JMJE) as ssse  from SYJK_CCS_CCSHDXX where jmlx in ('AE','PE','AC')) b," + 
			"(select HDRMC,HDSJ from SYJK_CCS_CCSHDXX where jmlx in ('AE','PE','AC')) c ")
	public List<TotalInfo> queryTotal();
	@Delete("delete from SYJK_CCS_CCSHDXX")
	public  int deleteAll();
	@Delete("delete   from SYJK_CCS_CCSHDXX  where jmlx='AC' and nsrmc is null")
	public int deleteRepeat();
}
