package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.OilDictionary;

public interface OilDictionaryMapper {

	@Select("select * from oil_dictionary where flag=#{flag}")
	public List<OilDictionary> queryBy(String flag);
}
