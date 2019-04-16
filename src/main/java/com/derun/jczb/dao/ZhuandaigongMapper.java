package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.Zhuandaigong;

public interface ZhuandaigongMapper {

	@Select("select * from jaingsu.zhuandaigong  where leixing=#{leixing} and niandu = #{niandu} order by riqi desc,id")
	public List<Zhuandaigong> queryBy(int leixing,int niandu);
}
