package com.derun.ccs.jmfz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.derun.ccs.jmfz.model.CLCBJMBAXX;

public interface CLCBJMBAXXMapper {
	@Select("select * from YH_CLCBJMBAXX")
	public List<CLCBJMBAXX> queryALLJMDM();
}
