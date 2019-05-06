package com.derun.jczb.dao;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.UserInfoIccard;

public interface UserInfoMapper {

	@Select("select * from iccard.userinfo where login_name=#{login_name} and login_password=#{login_password}")
	public UserInfoIccard queryByUsername(UserInfoIccard obj);
}
