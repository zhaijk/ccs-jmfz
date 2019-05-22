package com.derun.jczb.dao;

//import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.CardMain;
import com.derun.jczb.model.ProvideSumInfo;

public interface CardMainMapper {

	@Select("select oilType as oiltype ,sum(destineGuideline+buzhuzhibiao) as sum from iccard.Card_Main "
			+ "where cardCode like #{cardCode} || '%' and cardStatus='正常'  and cardType=0 group by oilType")
	public List<ProvideSumInfo> querySumCardProvideFix(String cardCode);
	@Select("select sum(fafang) as sum ,oiltype as oiltype from(select nvl(sum(nvl(t.destineguideline,0)+nvl(t.buzhuzhibiao,0)),0)as fafang ,oiltype from iccard.card_main t " + 
			"where t.cardcode like #{departmentCode} || '%'  "+
			"and t.maxcount-(t.cardcount+t.nooperatecount+t.destineguideline+t.buzhuzhibiao)>=0 " + 
			"and (t.destineguideline > 0 or t.buzhuzhibiao>0) and t.cardtype=0 and t.cardstatus='正常' and t.fillcardterm > =#{date} group by oiltype "+ 
			"union " + 
			"select nvl(sum(t.maxcount-t.cardcount-t.nooperatecount),0) as fafang ,oiltype from iccard.card_main t " + 
			"where t.cardcode like #{departmentCode} || '%' "+
			"and t.maxcount-(t.cardcount+t.nooperatecount+t.destineguideline+t.buzhuzhibiao)<0 " + 
			"and t.cardcount+t.nooperatecount-t.maxcount<0 " + 
			"and (t.destineguideline > 0 or t.buzhuzhibiao>0) "+
			"and t.cardtype=0 and t.cardstatus='正常' "+
			"and t.fillcardterm > #{date} group by oiltype) group by oiltype")
	public List<ProvideSumInfo> querySumCardProvide(String departmentCode,String date);//departmentCode.substring(0,6)
	@Select("select * from iccard.card_main_view where cardcode  like #{departmentCode}||'%' and cardtype=0 and (destineGuideline>0 or buzhuzhibiao>0) and fillcardterm > #{date} and cardstatus='正常' order by cardcode")
	public List<CardMain>  queryCardInfos(String departmentCode,String date);
	//@Select("select * from iccard.card_main_view where cardcode  like #{departmentCode}||'%' and cardtype=0 and (destineGuideline>0 or buzhuzhibiao>0)  and cardstatus='正常' order by cardcode")
	@Select("select * from iccard.card_main where cardcode  like #{departmentCode}||'%' and cardtype=0  and cardstatus='正常'   order by cardcode")
	public List<CardMain>  queryCardMainInfos(String departmentCode);
	@Select("select rownum as id,a.* ,b.departmentname as departmentname from (select * from iccard.card_main where cardcode like #{code} || '%' order by builddate desc ) a ,iccard.department_info  b where a.cardcode like substr(b.departmentcode,0,6) ||'%' ")
	public List<CardMain>  queryCardinfos(String code);
	@Insert("insert into iccard.card_main (cardcode,stationid,autocarcode,oiltype,destineguideline,carlimit,guidelinetype,cardstatus,builddate,operator,owner,phone,memo,cardtype,buzhuzhibiao,buzhudate,maxcount,tflag,fillcardterm) values(#{cardcode},#{stationid},#{autoCarCode},#{oilType},#{destineGuideline},#{carLimit},#{guidelinetype},#{cardstatus},#{buildDate},#{operator},#{owner},#{phone},#{memo},#{cardType},#{buzhuzhibiao},#{buzhuDate},#{maxcount},#{tflag},#{fillCardterm})")
	public int insertOne(CardMain obj);
	@Select("select * from iccard.card_main where cardcode=#{cardcode}")
	public CardMain queryOne(CardMain obj);
	@Update("update iccard.card_main set fillcardterm=#{fillCardterm} where cardcode=#{cardcode}")
	public int updateValidDate(CardMain obj);
	@Update("update iccard.card_main set destineguideline=#{destineGuideline},carlimit=#{carLimit},owner=#{owner},phone=#{phone},memo=#{memo} ,buzhuzhibiao=#{buzhuzhibiao},buzhudate=#{buzhuDate},maxcount=#{maxcount} where cardcode=#{cardcode}")
	public int updateQuotaInfo(CardMain obj);
	@Update("update iccard.card_main set oiltype=#{oilType} where cardcode=#{cardcode}")
	public int updateOiltype(CardMain obj);
	@Update("update iccard.card_main set autocarcode=#{autoCarCode} where cardcode=#{cardcode}")
	public int updateCarcode(CardMain obj);
	@Update("update iccard.card_main set cardstatus=#{cardstatus} where cardcode=#{cardcode}")
	public int updateStatus(CardMain obj);
	@Select("select fillcardterm from iccard.card_main where cardcode=#{cardcode}")
	public String queryValidDate(String cardcode);
}
