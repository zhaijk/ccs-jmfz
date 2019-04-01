package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.derun.jczb.model.OilDictionary;
/**
 *     决策部分油品管理
 * @author Administrator
 *
 */
public interface OilTypeMapper {
	@Select("select rownum as id,code,name,flag from oil_dictionary order by code")
	public List<OilDictionary> queryALL();
	@Select("select rownum as id,code,name,flag from oil_dictionary where flag=#{flag} order by code")
	public List<OilDictionary> queryBy(int flag);
	@Insert("insert into oil_dictionary(id,code,name,density,flag) values(#{id},#{code},#{name},#{density},#{flag})")
	public int insertOne(OilDictionary obj);
	@Update("update oil_dictionary set flag=#{flag} where code=#{code}")
	public int updateOne(OilDictionary obj);
	@Delete("delete oil_dictionary where code=#{code}")
	public int deleteOne(OilDictionary obj);
}
