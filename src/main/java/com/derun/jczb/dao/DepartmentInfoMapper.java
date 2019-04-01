package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.CarInfo;
import com.derun.jczb.model.DepartmentInfo;

public interface DepartmentInfoMapper {
	@Select("select  rownum as id ,a.* from iccard.Department_Info a")
	public List<DepartmentInfo> queryALL();
	@Select("select departmentCode from iccard.Department_Info where departmentName=#{departmentCode}")
	public String queryBy(String departmentCode);
	@Insert("insert into iccard.car_info(autoCarCode,departmentCode,autoCarType2,driverName,telephoneNumber,fastdate) values(#{autoCarCode},(select departmentCode from iccard.Department_Info where departmentName=#{departmentCode}  and rownum=1),(select autoCarType2 from iccard.CarType_Dictionary where name=#{carBrand} and rownum=1),#{driverName},#{telephoneNumber},to_char(sysdate,'YYYY-MM-DD'))")
	public int insertOne(CarInfo obj);
	@Update("update iccard.car_info set autoCarCode=#{autoCarCode},departmentCode=(select departmentCode from iccard.Department_Info where departmentName=#{departmentCode}  and rownum=1) , autoCarType2=(select autoCarType2 from iccard.CarType_Dictionary where name=#{carBrand} and rownum=1),driverName=#{driverName} , telephoneNumber=#{telephoneNumber} where autoCarCode=#{name}")
	public int updateOne(CarInfo obj);
	@Delete("delete iccard.car_info where autoCarCode=#{autoCarCode}")
	public int deleteOne(CarInfo obj);
	@Select("select count(*)  from iccard.car_info")
	public int counter();
	@Select("select rownum as id ,a.* from iccard.Department_Info a where departmentCode like #{departmentCode} || '%'  order by departmentCode")
	public List<DepartmentInfo> queryByDepartmentCode(String departmentCode);
	@Select("<script> select rownum as id ,a.* from iccard.Department_Info a where departmentName in <foreach item='item' index='index' collection='departmentName' open='(' separator=',' close=')'> #{item} </foreach> order by departmentCode </script>")
	public List<DepartmentInfo> queryByDepartmenInfo(@Param("departmentName")List<String> departmentName);
	@Select("select departmentName from iccard.Department_Info a where departmentCode like #{departmentCode}||'%'")
	public List<String> queryByDepartmentNames(String departmentCode);
	@Select("select departmentName,departmentCode from iccard.Department_Info a where departmentCode like #{departmentCode}||'%'")
	public List<DepartmentInfo> queryByDepartmentInfos(String departmentCode);
}
