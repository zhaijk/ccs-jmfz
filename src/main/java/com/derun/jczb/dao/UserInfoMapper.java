package com.derun.jczb.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.UserInfo;
/*import com.derun.jczb.model.UserInfoIccard;*/
import com.derun.jczb.model.Userbaseinfo;

public interface UserInfoMapper {

	@Select("select * from iccard.userinfo where login_name=#{login_name} and login_password=#{login_password}")
	public UserInfo queryIccardByUsername(String  login_name,String login_password);
	
	@Select("select b.url from usersroles a,resource_url b  where a.relresid=b.id and a.name=#{rolename}")
	public Set<String> queryRolesByName(String rolename);
	
	@Select("select * from userbaseinfo where loginname=#{loginname} and password=#{password}")
	public Userbaseinfo queryWujingByUsername(String  loginname,String password);
}
