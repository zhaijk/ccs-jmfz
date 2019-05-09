package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.ResourceUrl;

public interface ResoureUrlMapper {

	@Select("select levelname ,min(id) as id from resource_url group by levelname order by id")
	public List<ResourceUrl> queryLevename();
	@Select("select id,name,url,memo,levelname from resource_url where levelname=#{levelname} and id in (select relresid from usersroles where  name=#{rolename}) order by id")
	public List<ResourceUrl> queryResource(String levelname,String rolename);
	
}
