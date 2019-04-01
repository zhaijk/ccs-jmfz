package com.derun.jczb.dao;

import java.util.List;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.OilInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OilInfoMapper {
	@Select("select b.name as name ,b.code as code , a.density as density from iccard.Oil_Info a left join iccard.Oil_Dictionary b on a.oiltype=b.code where a.departmentcode=#{departmentId} order by b.code")
	public List<OilDictionary> queryBy(String departmentId);
	@Select("select density  from iccard.Oil_Info a where departmentcode=#{departmentId}  and oiltype=#{code}")
	public double  queryDensityBy(String departmentId,String code);
	@Select("select a.* from iccard.Oil_Info a")
	public List<OilInfo> queryALL();
	@Select("select a.* , b.name as name  from iccard.Oil_Info a left join iccard.Oil_Dictionary b on a.oiltype=b.code where  a.departmentCode like #{departmentCode} || '%' ")
	public List<OilInfo> queryByOilInfo(String departmentCode);
	@Select("select rownum as id , a.* , b.name as name from iccard.Oil_Info a left join iccard.Oil_Dictionary b  on a.oilType=b.code ")
	public List<OilInfo> queryALLJOIN();
	@Insert("insert into iccard.Oil_Info(autoCarType2,name,departmentCode) values(#{autoCarType2},#{name},#{departmentCode})")
	public int insertOne(OilInfo obj);
	@Update("update iccard.Oil_Info set name=#{name},departmentCode=#{departmentCode} where autoCarType2=#{autoCarType2}")
	public int updateOne(OilInfo obj);
	@Delete("delete iccard.Oil_Info where autoCarType2=#{autoCarType2}")
	public int deleteOne(OilInfo obj);
	@Select("select count(*)  from iccard.Oil_Info")
	public int counter();	
}
