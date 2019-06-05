package com.derun.ccs.jmfz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.derun.ccs.jmfz.model.JMLX;


public interface JMLXMapper {
	@Select("select rownum as id, a.* from DICT_CCS_JMLX a")
	public List<JMLX> queryALLJMLX();
	@Select("select count(*) from DICT_CCS_JMLX")
	public int  queryCounter();
}
