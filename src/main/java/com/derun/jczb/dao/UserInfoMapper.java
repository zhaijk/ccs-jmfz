package com.derun.jczb.dao;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.UserInfo;

public interface UserInfoMapper {

	@Select("select * from iccard.userinfo where login_name=#{loginname} and login_password=#{password}s")
	public UserInfo queryByUsername(UserInfo obj);
}
