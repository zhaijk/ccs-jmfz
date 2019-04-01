package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.YoukuDictionary;

public interface YoukuDictionaryMapper {

	@Select("select * from jiangsu.youku_dictionary order by leixing,youku_code")
	public List<YoukuDictionary> queryBy();
}
