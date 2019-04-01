package com.derun.jczb.dao;

import java.util.List;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
//import org.springframework.cache.annotation.CacheConfig;

//import com.derun.jczb.model.CardProvideReport;
import com.derun.jczb.model.CardSumInfos;
import com.derun.jczb.model.CardTrade;
import com.derun.jczb.model.ProvideSumInfo;
import com.derun.jczb.model.ZdgCardTrades;

//@CacheConfig(cacheNames = "users")
public interface CardTradeMapper {
	
	///@Cacheable
	@Select("select * from card_trade_out order by tradedate ,tradetime ")
	List<CardTrade> queryALL();
	
	@Select("select count(*) from card_trade_out")
	int queryCount();
	@Select("select t.oiltype,sum(t.volumnt) from card_trade t where t.cardcode like #{departmentCode}||'%'" + 
			"% and t.sign=1 and t.ifchongdi=0 and t.cardtype!=1 group by t.oiltype")//and t.tradedate >= "+YearOverDate.jiezhuantime() + "group by t.oiltype")
	List<CardTrade> queryByNonICCardTrade(String departmentCode);
	@Select("select oilType,sum(inputGuideline) from iccard.Department_Record  where departmentCode='241805000000' and providedate>='2017-12-26' group by oilType")
	List<HashMap<String,Object>> queryByIncome();
	@Select("select t.oiltype,sum(t.volumn) from wujing.card_trade t where t.cardcode like '241805%' and t.sign=1 and t.cardtype=0 and  t.tradedate>='2017-12-26' group by t.oiltype")
	List<HashMap<String,Object>> queryByxiaohao();
	
	@Select("select *  from card_trade where sign=#{type} and tradedate>#{date} and ZHUGONGDANWEIID like #{departmentCode}||'%' ")
	List<CardTrade> queryNonIcTradeBy(String type,String date,String departmentCode);
	@Select("select t.oiltype as oiltype,sum(t.volumnt) as total from card_trade t "
			+ "where substr(t.zhugongdanweiid,0,4)!=substr(t.shougongdanweiid,0,4) and "
			+ "t.shougongdanweiid like #{danweiCode}||'%' and "
			+ "t.tradedate >= #{jiezhuanDate} group by t.oiltype")
	List<ZdgCardTrades> queryZdgTotal(String danweiCode,String jiezhuanDate);
	@Select("select t.oiltype as oiltype,sum(t.volumn) as sum from card_trade t where t.cardcode like #{departmentCode} || '%' "
			+ "and t.sign=1 and t.cardtype=0  and t.tradedate>= #{jiezhuanDate} group by t.oiltype")
	//非IC卡消耗 departmentCode.substring(0,6)
	List<ProvideSumInfo> querysumCardTradeNonIC(String departmentCode,String jiezhuanDate);
	@Select("select max(counter) from (select max(sendFlag) as counter from iccard.Card_ProvideReport a where a.cardcode=#{cardCode} union select max(sendflag) as counter from Card_Trade b where b.cardcode=#{cardCode})")
	public int queryCardMaxSendFlag(String cardCode);
	@Select("<script> select * from (select rownum rn, a.cardcode, a.recno as guncode,d.name as stationname ,e.bumen as departmentname, a.sendflag, b.name as oiltypeName,c.autocarcode as carcode,c.owner as owner ,case c.cardtype when 0 then '实物卡' when 1 then '价拨卡'  when 2 then '机动卡'  else '未知卡类型'   end as cardtypename ,a.volumn,a.balance,a.tradedate ,a.tradetime from  card_trade a,iccard.oil_dictionary b,iccard.card_main c ,jiayouzhan d ,depar_dictionary e "
			+ "where a.oiltype=b.code  and a.cardcode=c.cardcode and a.stationid=d.code and substr(a.cardcode,0,2) =substr(e.bumen_code,0,2) order by rownum)  "+
			"<where>"+
			"<if test='\"all\"!=departmentcode'>"+
			" cardcode like #{departmentcode} || '%' </if>"+			
			"<if test='\"all\"!=oiltypes'>"+
			" and oiltypeName=#{oiltypes} </if>"+					
			"<if test='\"all\"!=cardcode'>"+
			" and cardcode like '%' || #{cardcode}  </if>"+
			"<if test='\"all\"!=carcode'>"+
			" and carcode  like '%' || #{carcode}  </if>"+
			"<if test='\"all\"!=cardtype'>"+
			" and cardtypename = #{cardtype}  </if>"+
			"<if test='\"all\"!=datestart'>"+
			" and tradedate >= #{datestart}  </if>"+
			"<if test='\"all\"!=datestop'>"+
			" and #{datestop} >=tradedate  </if>"+
			"</where> </script>")
	public List<CardTrade>  queryBy(String cardcode,String jiezhuanDate,String departmentcode,String oiltypes,String carcode,String cardtype,String datestart,String datestop);
	@Select("<script> select rownum rn,f.* from (select a.cardcode,b.name as oiltypeName,c.autocarcode as carcode,c.owner as owner,a.recno as guncode,c.cardstatus as cardstatus,g.name as stationname, " + 
			"                 case c.cardtype when 0 then '实物卡' when 1 then '价拨卡' when 2 then '机动卡' else '未知卡类型' end as cardtypename, a.volumn,a.mileage, " + 
			"                 a.balance,a.tradedate,a.tradetime,d.sendflag,case when d.mileage = a.mileage then e.guidelinecount else 0 end as guidelinecount " + 
			"from card_trade a, iccard.oil_dictionary b, iccard.card_main c,(select cardcode, sendflag, min(mileage) as mileage from (select rownum, cardcode, sendflag, mileage from card_trade) group by cardcode, sendflag) d,iccard.card_providereport e, jiayouzhan g " + 
			"where a.oiltype = b.code and a.cardcode = c.cardcode  and a.cardcode = d.cardcode  and a.cardcode = e.cardcode  and a.sendflag = d.sendflag  and a.sendflag = e.sendflag and a.zhugongdanweiid=g.danwei order by cardcode,mileage)  f"+
			"<where>"+
			"<if test='\"all\"!=departmentcode'>"+
			" cardcode like #{departmentcode} || '%' </if>"+
			"<if test='\"all\"!=cardcode'>"+
			" and cardcode like '%' || #{cardcode}  </if>"+	
			"<if test='\"all\"!=carcode'>"+
			" and carcode like '%' || #{carcode}  </if>"+	
			"</where> </script>")
	public List<CardTrade>  queryBycardcar(String departmentcode,String cardcode,String carcode);
	@Select("<script> select rownum rn,f.* from(select ccm.cardcode,nvl(ccm.owner, car.drivername) as drivername,odict.name as oiltype,car.autocarcode,car.note2 as note2,are.departmentcode,"
			+ "	nvl(ctrade.volumn01, 0) as date01 ,nvl(ctrade.volumn02, 0) as date02, nvl(ctrade.volumn03, 0) as date03 ,nvl(ctrade.volumn04, 0) as date04," 
			+ "	nvl(ctrade.volumn05, 0) as date05 ,nvl(ctrade.volumn06, 0) as date06, nvl(ctrade.volumn07, 0) as date07 ,nvl(ctrade.volumn08, 0) as date08," 
			+ "	nvl(ctrade.volumn09, 0) as date09 ,nvl(ctrade.volumn10, 0) as date10, nvl(ctrade.volumn11, 0) as date11 ,nvl(ctrade.volumn12, 0) as date12," 
			+ "	nvl(repo.guide01, 0) as guide01 ,nvl(repo.guide02, 0) as guide02, nvl(repo.guide03, 0) as guide03 ,nvl(repo.guide04, 0) as guide04, " 
			+ "	nvl(repo.guide05, 0) as guide05 ,nvl(repo.guide06, 0) as guide06, nvl(repo.guide07, 0) as guide07 ,nvl(repo.guide08, 0) as guide08, " 
			+ "	nvl(repo.guide09, 0) as guide09 ,nvl(repo.guide10, 0) as guide10, nvl(repo.guide11, 0) as guide11 ,nvl(repo.guide12, 0) as guide12 " 
			+ " from iccard.card_main ccm left join iccard.oil_dictionary odict on ccm.oiltype=odict.oiltype left join iccard.car_info car on ccm.autocarcode = car.autocarcode "  
			+ " left join iccard.areadepart_card are on substr(ccm.cardcode, 0, 6) = substr(are.pubdepartment, 0, 6) " 
			+ " left join (select xh.cardcode, " + 
							" max(case when xh.tradedate = '01' then xh.vol end) as volumn01, " + 
							" max(case when xh.tradedate = '02' then xh.vol end) as volumn02, " + 
							" max(case when xh.tradedate = '03' then xh.vol end) as volumn03, " + 
							" max(case when xh.tradedate = '04' then xh.vol end) as volumn04, " + 
							" max(case when xh.tradedate = '05' then xh.vol end) as volumn05, " + 
							" max(case when xh.tradedate = '06' then xh.vol end) as volumn06, " + 
							" max(case when xh.tradedate = '07' then xh.vol end) as volumn07, " + 
							" max(case when xh.tradedate = '08' then xh.vol end) as volumn08, " + 
							" max(case when xh.tradedate = '09' then xh.vol end) as volumn09, " + 
							" max(case when xh.tradedate = '10' then xh.vol end) as volumn10, " + 
							" max(case when xh.tradedate = '11' then xh.vol end) as volumn11, " + 
							" max(case when xh.tradedate = '12' then xh.vol end) as volumn12 " + 
							" from (select tr.cardcode,substr(tr.tradedate, 6, 2) as tradedate,nvl(sum(tr.volumn), 0) as vol"+ 
							"       from wujing.card_trade tr where 1 = 1 and tr.tradedate like  #{sumdate} || '%' and tr.cardcode like #{sumDepartmentcode} || '%' "
							+ "     group by tr.cardcode, substr(tr.tradedate, 6, 2) order by tr.cardcode) xh group by xh.cardcode) ctrade "
			+" on ccm.cardcode = ctrade.cardcode "  
			+" left join (select zb.cardcode, "+  
			              " max(case when zb.PROVIDEDATE = '01' then zb.guidelinecount end) as guide01, " +
			              " max(case when zb.PROVIDEDATE = '02' then zb.guidelinecount end) as guide02, " +
			              " max(case when zb.PROVIDEDATE = '03' then zb.guidelinecount end) as guide03, " +
			              " max(case when zb.PROVIDEDATE = '04' then zb.guidelinecount end) as guide04, " +
			              " max(case when zb.PROVIDEDATE = '05' then zb.guidelinecount end) as guide05, " +
			              " max(case when zb.PROVIDEDATE = '06' then zb.guidelinecount end) as guide06, " +
			              " max(case when zb.PROVIDEDATE = '07' then zb.guidelinecount end) as guide07, " +
			              " max(case when zb.PROVIDEDATE = '08' then zb.guidelinecount end) as guide08, " +
			              " max(case when zb.PROVIDEDATE = '09' then zb.guidelinecount end) as guide09, " +
			              " max(case when zb.PROVIDEDATE = '10' then zb.guidelinecount end) as guide10, " +
			              " max(case when zb.PROVIDEDATE = '11' then zb.guidelinecount end) as guide11, " +
			              " max(case when zb.PROVIDEDATE = '12' then zb.guidelinecount end) as guide12 " +
			              " from (select cp.cardcode,substr(cp.PROVIDEDATE, 6, 2) as PROVIDEDATE, nvl(sum(cp.guidelinecount), 0) as guidelinecount " + 
			                           " from iccard.card_providereport cp where 1 = 1 and cp.PROVIDEDATE like #{sumdate} || '%' and cp.cardcode like #{sumDepartmentcode} || '%' " + 
			              			   " group by cp.cardcode, substr(cp.PROVIDEDATE, 6, 2) order by cp.cardcode) zb"+ 
			              " group by zb.cardcode) repo "
			+" on ccm.cardcode = repo.cardcode " 
			+" where are.pubdepartment like #{sumDepartmentcode} || '%' order by cardcode) f "+
			"<where>"+
			"<if test='\"all\"!=departmentcode'>"+
			" cardcode like #{departmentcode} || '%' </if>"+
			"<if test='\"all\"!=cardcode'>"+
			" and cardcode like '%' || #{cardcode}  </if>"+	
			"<if test='\"all\"!=carcode'>"+
			" and autocarcode like '%' || #{carcode}  </if>"+	
			"<if test='\"all\"!=oiltype'>"+
			" and oiltype like #{oiltype} || '%' </if>"+
			"</where> </script>")
	public List<CardSumInfos>  queryCardSumBy(String cardcode,String sumdate,String sumDepartmentcode,String departmentcode,String oiltype,String carcode,String cardtype,String datestart,String datestop);

}
