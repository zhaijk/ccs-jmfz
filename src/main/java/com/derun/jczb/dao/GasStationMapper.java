package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.Jiayouzhan;

public interface GasStationMapper {
	@Select("select a.* from JIAYOUZHAN a")
	public List<Jiayouzhan> queryALL();
	@Insert("insert into JIAYOUZHAN(autoCarType2,name,departmentCode) values(#{autoCarType2},#{name},#{departmentCode})")
	public int insertOne(Jiayouzhan obj);
	@Update("update JIAYOUZHAN set name=#{name},departmentCode=#{departmentCode} where autoCarType2=#{autoCarType2}")
	public int updateOne(Jiayouzhan obj);
	@Delete("delete JIAYOUZHAN where autoCarType2=#{autoCarType2}")
	public int deleteOne(Jiayouzhan obj);
	@Select("select count(*)  from JIAYOUZHAN")
	public int counter();
	
}
