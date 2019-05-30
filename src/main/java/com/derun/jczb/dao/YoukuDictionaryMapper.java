package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.YoukuDictionary;

public interface YoukuDictionaryMapper {

	@Select("select * from youku_dictionary where leixing=#{type} and flag=#{flag} order by leixing,youku_code")
	public List<YoukuDictionary> queryBy(int type,int flag);
	@Select("select youku from youku_dictionary where youku_code=#{code}")
	public String queryNameByCode(String code);
}
