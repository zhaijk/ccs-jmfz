package com.derun.jczb.dao;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.Systemconfig;

public interface SystemconfigMapper {

	@Select("select max(riqi) from jiezhuandate")
	public String queyJiezhuandate();
	@Select("select * from systemconfig")
	public Systemconfig queyZDInfo();
}
