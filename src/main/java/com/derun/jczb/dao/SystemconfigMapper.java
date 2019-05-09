package com.derun.jczb.dao;

import org.apache.ibatis.annotations.Select;

public interface SystemconfigMapper {

	@Select("select max(riqi) from jiezhuandate")
	public String queyJiezhuandate();
}
