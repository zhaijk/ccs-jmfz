package com.derun.jczb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.derun.jczb.model.DeparDictionary;

/**
 * supply department manager 受供单位
 * @author Administrator
 *
 */
public interface DepartDictionaryMapper {

	@Select("select rownum as id , a.*  from (select  substr(bumen_code,3,2) as bumen_code,bumen,leixing,jici,ipdizhi,biaozhi,lianqin1,lianqin2  from depar_dictionary order by bumen_code) a")
	public List<DeparDictionary>  queryALL();	
	@Insert("insert into depar_dictionary(junqu_code,junqu,flag) values(#{junqu_code},#{junqu},#{flag})")
	public int  insertOne(DeparDictionary obj);
	@Insert("delete depar_dictionary where bumen_code=#{bumen_code}")
	public int  deleteOne(DeparDictionary obj);
	@Select("select * from  depar_dictionary order by bumen_code")
	public List<DeparDictionary>  queryBy();
	@Select("select * from  depar_dictionary where bumen_code=#{code}")
	public  DeparDictionary queryByCode(String bumen_code);
}
