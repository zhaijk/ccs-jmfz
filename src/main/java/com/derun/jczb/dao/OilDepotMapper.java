package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.derun.jczb.model.YoukuDictionary;
/**
 * 油库映射操作对象
 * @author Administrator
 *
 */
public interface OilDepotMapper {
	@Select("select youku_code,youku,leixing,flag from youku_dictionary")
	public List<YoukuDictionary> queryALL();
	@Select("select rownum as id,youku_code,youku,leixing,flag from youku_dictionary where flag=#{flag}")
	public List<YoukuDictionary> queryBy(int flag);
	@Update("update youku_dictionary set flag=#{flag} where youku_code=#{youku_code}")
	public int updateOne(YoukuDictionary obj);
	@Insert("insert into youku_dictionary values(#{youku_code},#{youku},#{leixing},0)")
	public int insertOne(YoukuDictionary obj);
	@Delete("delete from youku_dictionary where flag=0 and youku_code=#{youku_code}")
	public int deleteOne(YoukuDictionary obj);
}
