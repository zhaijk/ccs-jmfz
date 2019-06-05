package com.derun.ccs.jmfz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.derun.ccs.jmfz.model.BXGS;
import com.derun.ccs.jmfz.model.UserInfo;

public interface UserMapper {

	@Select("select rownum as id,a.*,b.usertypename as usertypename from users a,usertype b where a.usertype=b.usertypeid")
	public List<UserInfo> queryALL();
	@Select("select count(*) from users a")
	public int queryCounter();
	@Select("select * from USERS t where username=#{name} and password1=#{password}")
	public List<UserInfo> querBy(String name,String password);
}
