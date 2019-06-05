package com.derun.ccs.jmfz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.derun.ccs.jmfz.model.JMDM;

public interface JMDMMapper {
	@Select("select rownum as id,a.* from DICT_CCS_CLXH_JMDM a")
	public List<JMDM> queryALLJMLX();
	@Select("select count(*) from DICT_CCS_CLXH_JMDM")
	public int queryCounter();
}
