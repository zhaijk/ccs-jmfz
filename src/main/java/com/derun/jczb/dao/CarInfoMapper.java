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

import com.derun.jczb.model.CarInfo;
//import com.derun.jczb.model.CarTypeDictionary;

public interface CarInfoMapper {
	@Select("select * from iccard.car_info  order by fastDate")
	public List<CarInfo> queryALL();
	@Select("select rownum as id , a.*,b.departmentName as departmentName , c.name as carBrandName from iccard.car_info a left join iccard.Department_Info b  on a.departmentCode=b.departmentCode left join  iccard.CarType_Dictionary c on a.autoCarType2=c.autoCarType2  order by a.fastDate DESC")
	public List<CarInfo> queryALLUnions();
	@Select("select departmentCode,count(*) as counter from iccard.car_info  group by departmentCode")
	public List<CarInfo> queryGroupByDepartmentCode();
	@Select("select * from iccard.car_info   where autoCarCode=#{autoCarCode} order by fastDate")
	public List<CarInfo> queryByAutoCarCode(String autoCarCode);
	@Select("select * from iccard.car_info   where departmentCode=#{departmentCode} order by fastDate")
	public List<CarInfo> queryByDepartmentCode(String departmentCode);
	@Insert("insert into iccard.car_info(autoCarCode,departmentCode,autoCarType2,driverName,telephoneNumber,fastdate) values(#{autoCarCode},(select departmentCode from iccard.Department_Info where departmentName=#{departmentCode}  and rownum=1),(select autoCarType2 from iccard.CarType_Dictionary where name=#{carBrand} and rownum=1),#{driverName},#{telephoneNumber},to_char(sysdate,'YYYY-MM-DD'))")
	public int insertOne(CarInfo obj);
	@Update("update iccard.car_info set autoCarCode=#{autoCarCode},departmentCode=(select departmentCode from iccard.Department_Info where departmentName=#{departmentCode}  and rownum=1) , autoCarType2=(select autoCarType2 from iccard.CarType_Dictionary where name=#{carBrand} and rownum=1),driverName=#{driverName} , telephoneNumber=#{telephoneNumber} where autoCarCode=#{name}")
	public int updateOne(CarInfo obj);
	@Delete("delete iccard.car_info where autoCarCode=#{autoCarCode}")
	public int deleteOne(CarInfo obj);
	@Select("select count(*)  from iccard.car_info")
	public int counter();
	
//	@Delete("delete fomr iccard.car_info where autoCarCode=#{autoCarCode}")
//	public int deleteOne(String autoCarCode);
	
}
