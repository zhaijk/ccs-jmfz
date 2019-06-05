package com.derun.ccs.jmfz.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.derun.ccs.jmfz.model.BXGS;

public interface BXGSMapper {

	@Select("select rownum as id,a.* from DICT_BXGS a")
	public List<BXGS> queryALLBXGS();
	@Select("select count(*) from DICT_BXGS a")
	public int queryCounter();
}
