package com.derun.jczb.dao;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.derun.jczb.model.DepartmentRecord;
import com.derun.jczb.model.ProvideSumInfo;

public interface DepartmentRecordMapper {

	@Select("select oilType as oiltype,sum(inputGuideline) as sum  from iccard.Department_Record  where departmentCode=#{departmentCode} "+
			"and substr(providedate,0,4)>=(select g.niandu from systemconfig g) " + 
			"and providedate>=#{jiezhuanDate} group by oilType")
	public List<ProvideSumInfo>  queryDepartmentRecordSum(String departmentCode,String jiezhuanDate);
	//@SelectKey(statement="select to_char(iccard.Department_Record_sequence.nextval)  from dual" , before=true,keyColumn="credenceNumber",resultType=String.class,keyProperty="credenceNumber")
	@Insert("insert into iccard.Department_Record (credenceNumber,oilType,departmentCode,provideDate,inputGuideline,guidelineType,operator) values(iccard.Department_Record_sequence.nextval,#{oilType},#{departmentCode},#{provideDate},#{inputGuideline},#{guidelineType},#{operator})")
	public int insertOne(DepartmentRecord obj);
//	@Select("select * from (select rownum rn,c.departmentname , b.name as oilname,a.providedate,a.inputguideline,d.name as guidelinename,a.confirmperson,a.operator,a.log from iccard.department_record a ,iccard.oil_dictionary b ,iccard.department_info c ,iccard.guideline_dictionary d where a.oiltype=b.code and a.departmentcode=c.departmentcode and a.guidelinetype=d.code " + 
//			"and  a.departmentcode like #{departmentCode} || '%' order by rownum) where rn between #{start} and #{end}")
	@Select("<script> select * from (select rownum rn,c.departmentname , b.name as oilname,a.providedate,a.inputguideline,d.name as guidelinename,a.confirmperson,a.operator,a.log from iccard.department_record a ,iccard.oil_dictionary b ,iccard.department_info c ,iccard.guideline_dictionary d where a.oiltype=b.code and a.departmentcode=c.departmentcode and a.guidelinetype=d.code " + 
			"and  a.departmentcode like #{departmentCode} || '%' order by rownum) f "+
			"<where>"+
			"<if test='\"all\"!=departmentname'>"+
			" f.departmentname=#{departmentname} </if>"+
			"<if test='\"all\"!=oiltypes'>"+
			" and f.oilname=#{oiltypes} </if>"+
			"<if test='\"all\"!=guidelinetype'>"+
			" and f.guidelinename=#{guidelinetype} </if>"+
			"<if test='\"all\"!=querydate'>"+
			" and f.providedate=#{querydate}  </if>"+
			"</where> </script>")
	public List<DepartmentRecord>  queryBy(String departmentCode,String jiezhuanDate,String departmentname,String oiltypes,String guidelinetype,String querydate);
	@Select("select count(departmentCode) from iccard.department_record where departmentcode like #{departmentCode} || '%'")
	public int queryCount(String departmentCode,String jiezhuanDate);
	
}
