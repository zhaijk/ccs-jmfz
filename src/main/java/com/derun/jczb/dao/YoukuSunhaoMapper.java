package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.YouKuSunHao;

public interface YoukuSunhaoMapper {

	@Select("<script> select danjuhao from youkusunhao"
			+ " where niandu>=#{niandu} "
			+ " <if test='\"all\"!=youku'> "
			+ " and youku=#{youku} </if> "
			+ "  group by danjuhao order by danjuhao desc </script>")
	public List<String> queryBy(String youku,String niandu);
	@Insert("insert into youkusunhao(danjuhao,youku,riqi,oil,youpin,remark,niandu) values(#{danjuhao},#{youku},#{riqi},#{oil},#{youpin},#{remark},#{niandu})")
	public int  insertOne(YouKuSunHao obj);
	@Select("select max(danjuhao) from youkusunhao where niandu=#{niandu}")
	public String queryMaxDjhBy(int niandu);	
	@Select("select * from youkusunhao where danjuhao=#{danjuhao}")
	public List<YouKuSunHao> queryByDjh(String danjuhao);
	@Select("select max(danjuhao) from youkusunhao  where niandu=#{niandu} ")
	public String queryMaxByDjh(int niandu);
	
}
