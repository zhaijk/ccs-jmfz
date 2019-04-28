package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.CardProvideReport;
//import com.derun.jczb.model.DepartmentRecord;
import com.derun.jczb.model.ProvideSumInfo;

public interface CardProvideMapper {

	@Select("select a.oiltype as oiltype,nvl(sum(a.ff),0) as sum from (select p.oilType,sum(p.guidelineCount) as ff from iccard.Card_ProvideReport p,iccard.Card_Main m " + 
			" where p.cardCode like #{cardCode} || '%' and p.cardCode=m.cardCode  and (m.cardType=0 or m.cardType=2) " + 
			" and substr(p.providedate,0,4)>=(select g.niandu from wujing.systemconfig g) " + 
			" and p.providedate>=#{jiezhuanDate} group by p.oilType " + 
			" union select t.oiltype,nvl(sum(t.fafangliang),0) as ff  from iccard.ZhiBiao_LinShi t ,iccard.Card_Main c " + 
			" where t.cardcode like  #{cardCode} || '%' and t.cardcode=c.cardcode and  (c.cardType=0 or c.cardType=2)" + 
			" and t.providedate>=#{jiezhuanDate} group by t.oiltype) a group by a.oiltype ")
	List<ProvideSumInfo> querySumCardProvideAllCard(String cardCode,String jiezhuanDate);
	@Select("select max(p.providedate) from iccard.card_providereport p where p.cardcode like #{departmentCode} || '%' and p.sendtype='1'")
	String queryDepartmentMaxDate(String departmentCode);
	@Insert("insert into iccard.card_providereport(provideid,oiltype,cardcode,providedate,providetime,guidelinetype,guidelinecount,sendtype,sendflag) values((iccard.card_providereport_sequence.nextval) ,#{oilType},#{cardCode},#{provideDate},#{provideTime},#{guidelineType},#{guidelineCount},#{sendType},#{sendFlag})")
	public int insertOne(CardProvideReport obj);
	@Select("<script> select * from (select rownum rn, a.cardcode, b.name as oiltypeName,c.autocarcode as carcode,(case a.sendtype when 1 then '固定'  when 2 then '单卡'  when 3 then '补贴'  when 4 then '作废'  else to_char(a.sendtype) end)  as sendtypeFlag, a.guidelinecount, a.providedate, a.sendflag,case a.writecard when 1 then '已写卡'  else '未写卡'  end as writecardflag, a.operator ,d.name as guidelinetypeName FROM iccard.card_providereport a,iccard.oil_dictionary b,iccard.card_main c, iccard.guideline_dictionary d  "
			+ "where a.oiltype=b.code  and a.cardcode=c.cardcode and a.guidelinetype=d.code order by rownum)  "+
			"<where>"+
			"<if test='\"all\"!=departmentcode'>"+
			" cardcode like #{departmentcode} || '%' </if>"+			
			"<if test='\"all\"!=oiltypes'>"+
			" and oiltypeName=#{oiltypes} </if>"+
			"<if test='\"all\"!=guidelinetype'>"+
			" and guidelinetypeName=#{guidelinetype} </if>"+			
			"<if test='\"all\"!=cardcode'>"+
			" and cardcode like '%' || #{cardcode}  </if>"+
			"<if test='\"all\"!=sendtype'>"+
			" and sendtypeFlag = #{sendtype}  </if>"+
			"<if test='\"all\"!=writecard'>"+
			" and writecardflag = #{writecard}  </if>"+
			"<if test='\"all\"!=datestart'>"+
			" and providedate >= #{datestart}  </if>"+
			"<if test='\"all\"!=datestop'>"+
			" and #{datestop} >=providedate  </if>"+
			"</where> </script>")
	public List<CardProvideReport>  queryBy(String cardcode,String jiezhuanDate,String departmentcode,String oiltypes,String guidelinetype,String sendtype,String writecard,String datestart,String datestop);
	@Delete("")
	public int deleteOne();
	@Update("update iccard.card_providereport set writecard=1 where cardcode=#{cardcode} and sendflag>#{sendflag} and (sendtype=1 or sendtype=2)")
	public int updateOne(CardProvideReport obj);
	@Select("select rownum as rn , a.* from (select * from iccard.card_providereport a where cardcode=#{cardcode} and sendflag>#{sendflag} and (sendtype=1 or sendtype=2) order by sendflag) a")
	public List<CardProvideReport>  queryQuotaByCardcodeSendFlag(CardProvideReport obj);
	// 1.固定发放 2.单卡发放	3.补贴发放  4.作废发放
	@Select("select cardcode,sum(guidelinecount) as guidelinecount,max(sendflag) as sendflag from iccard.card_providereport where cardcode=#{cardcode} and sendflag>#{sendflag} and (sendtype=1 or sendtype=2) group by cardcode")
	public CardProvideReport  queryQuotaTotalByCardcodeSendFlag(CardProvideReport obj);
}
