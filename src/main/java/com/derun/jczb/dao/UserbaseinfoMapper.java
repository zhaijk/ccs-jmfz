package com.derun.jczb.dao;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.Userbaseinfo;

public interface UserbaseinfoMapper {

	@Select("select * from userbaseinfo where loginname=#{loginname}")
	public Userbaseinfo queryByUsername(Userbaseinfo obj);
}
