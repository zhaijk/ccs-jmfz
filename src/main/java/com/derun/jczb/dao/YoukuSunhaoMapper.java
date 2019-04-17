package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.YouKuSunHao;

public interface YoukuSunhaoMapper {

	@Select("<script> select danjuhao, max(youku) as youku ,max(niandu) as niandu,max(riqi) as riqi ,sum(youpin) as youpin from jiangsu.youkusunhao"
			+ " <where> niandu=#{niandu} "
			+ " <if test='\"all\"!=youku'> "
			+ " youku=#{youku} </if> "
			+ " </where> group by danjuhao</script>")
	public List<YouKuSunHao> queryBy(String youku,String niandu);
	@Insert("insert into from jiangsu.youkusunhao(danjuhao,youku,riqi,oil,youpin,remark,niandu) values(#{danjuhao},#{youku},#{riqi},#{oil},#{youpin},#{remark},#{niandu})")
	public int  insertOne(YouKuSunHao obj);
	@Select("select max(danjuhao) from jiangsu.youkusunhao where niandu=#{niandu}")
	public String queryMaxDjhBy(int niandu);
	@Select("select danjuhao from jiangsu.youkusunhao "
			+ " <where> niandu=#{niandu} "
			+ " <if test='\"all\"!=youku'> "
			+ " youku=#{youku} </if> "
			+ " </where> group by danjuhao</script>")
	public List<String> queryDjhs(String youku ,String niandu);
	@Select("select * from jiangsu.youkusunhao where danjuhao=#{danjuhao}")
	public List<YouKuSunHao> queryByDjh(String danjuhao);
	
}
