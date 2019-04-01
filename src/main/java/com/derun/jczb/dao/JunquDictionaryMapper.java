package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.JunquDictionary;
/**
 * supply department manager 供应单位管理(军区)
 * @author Administrator
 *
 */
public interface JunquDictionaryMapper {

	@Select("select rownum as id,junqu_code,junqu,flag,biaozhi  from jiangsu.JUNQU_DICTIONARY where biaozhi=1 order by junqu_code")
	public List<JunquDictionary>  queryALL();
	@Update("update jiangsu.JUNQU_DICTIONARY set biaozhi=#{biaozhi}  where junqu_code=#{junqu_code}")
	public int  updateOne(JunquDictionary obj);
	@Insert("insert into jiangsu.JUNQU_DICTIONARY(junqu_code,junqu,flag) values(#{junqu_code},#{junqu},#{flag})")
	public int  save(JunquDictionary obj);
	@Select("select rownum as id,junqu_code,junqu,flag,biaozhi  from jiangsu.JUNQU_DICTIONARY where biaozhi is null or biaozhi <> 1  order by junqu_code")
	public List<JunquDictionary>  queryBy();
}
