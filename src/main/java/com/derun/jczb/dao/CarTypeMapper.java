package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

//import com.derun.jczb.model.CarInfo;
//import com.derun.jczb.model.CarTypeDictionary;
import com.derun.jczb.model.CarTypeDictionary;

public interface CarTypeMapper {
	@Select("select rownum as id,a.* from iccard.CarType_Dictionary a")
	public List<CarTypeDictionary> queryALL();
	@Insert("insert into iccard.CarType_Dictionary(autoCarType2,name,departmentCode) values(#{autoCarType2},#{name},#{departmentCode})")
	public int insertOne(CarTypeDictionary obj);
	@Update("update iccard.CarType_Dictionary set name=#{name},departmentCode=#{departmentCode} where autoCarType2=#{autoCarType2}")
	public int updateOne(CarTypeDictionary obj);
	@Delete("delete iccard.CarType_Dictionary where autoCarType2=#{autoCarType2}")
	public int deleteOne(CarTypeDictionary obj);
	@Select("select count(*)  from iccard.CarType_Dictionary")
	public int counter();	
}
