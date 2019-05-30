package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.Oilloss;
import com.derun.jczb.model.SunHao;

public interface OillossMapper {
	@Select("select * from OilLoss")
	public List<Oilloss> queryALL();
	@Select("select sum(o.zhugongsunhao) from oilloss o where o.danweiid like #{departmentId}||'%' and lossdate> #{jiezhuanDate}")
	public String queryOilLossheji(String departmentId,String jiezhuanDate);
	@Select("select o.oiltype as oiltype ,sum(o.zhugongsunhao) as sum from wujing.oilloss o where o.danweiid like #{departmentId}||'%' and lossdate>#{jiezhuanDate} group by o.oiltype")
	public List<SunHao> queryOilLossList(String departmentId,String jiezhuanDate);
	@Select("select a.* ,b.name as oilName from OilLoss a,oil_dictionary b where a.oiltype=b.code and danweiid like #{departmentId}||'%' and niandu>#{jiezhuanDate} order by a.id desc")
	public List<Oilloss> queryBy(String departmentId,String jiezhuanDate);
	@Delete("delete from oilloss where id=#{id}")
	public int deleteOne(Oilloss obj);
	@Update("update oilloss set  niandu=#{niandu},jidu=#{jidu},oiltype=#{oiltype},remark=#{remark},zhugongsunhao=#{zhugongsunhao},jiabosunhao=#{jiabosunhao} where id=#{id}")
	public int updateOne(Oilloss obj);
	@Insert("insert into oilloss(id,biaoji,density,danweiid,lossdate,niandu,jidu,oiltype,remark,zhugongsunhao,jiabosunhao) values((select max(id)+1 from oilloss),0,#{density},#{danweiid},#{lossdate},#{niandu},#{jidu},#{oiltype},#{remark},#{zhugongsunhao},#{jiabosunhao})")
	public int insertOne(Oilloss obj);
}
