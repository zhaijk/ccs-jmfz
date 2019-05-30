package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.Zhuandaigong;
import com.derun.jczb.model.ZhuandaigongTotal;

public interface ZhuandaigongMapper {

	@Select("select max(wenjianhao) from zhuandaigong  where sg_danwei=#{sg_danwei} and niandu=#{niandu} and leixing=#{leixing}")
	public String queryWjhBy(String sg_danwei,int niandu,int leixing);
	@Select("select * from zhuandaigong  where leixing=#{leixing} and niandu = #{niandu} order by riqi desc,id")
	public List<Zhuandaigong> queryBy(int leixing,int niandu);
	@Select("select d.bumen_code as code ,d.bumen as name ,a.jz, a.pz ,(a.jz+a.pz) as total from (select  sg_danwei as code ,sum(case nvl(jz,0) when 0 then shuliang  end) as pz , sum(case nvl(jz,0) when 1 then shuliang  end) as jz from  zhuandaigong  group by sg_danwei) a ,depar_dictionary d where a.code(+)=d.bumen_code order by d.bumen_code")
	public List<ZhuandaigongTotal> querySumBy(int leixing ,int niandu);
	@Insert("insert into zhuandaigong(id,wenjianhao,sg_danwei,leixing,youpin_code,shuliang,riqi,jz,niandu, biaozhi,remark) values(zhuandaigong_sequences.nextval,#{wenjianhao},#{sg_danwei},#{leixing},#{youpin_code},#{shuliang},#{riqi},#{jz},#{niandu},#{biaozhi},#{remark})")
	public int insertOne(Zhuandaigong obj);
	@Select("select * from zhuandaigong  where sg_danwei=#{sg_danwei} and niandu=#{niandu} order by riqi desc,id")
	public List<Zhuandaigong> queryTotalSgBy(String sg_danwei,int niandu);
	@Select("select max(danjuhao) from diaobodan  where niandu=#{niandu} and leixing=2")
	public String queryZGWjhBy(int niandu);
}
