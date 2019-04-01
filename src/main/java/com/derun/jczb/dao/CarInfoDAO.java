package com.derun.jczb.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.derun.jczb.model.CarInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Repository
public class CarInfoDAO {
	
	@Autowired 
	private CarInfoMapper mapper;
	//@RequestMapping("")
	public PageInfo<CarInfo> pageQuery(int start,int page){
		PageHelper.startPage(start, page);
		List<CarInfo> objs=mapper.queryALL();
		PageInfo<CarInfo> pageInfo = new PageInfo<>(objs);
		return pageInfo;		
	}
}
