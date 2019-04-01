package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.DanweiShouzhiRecord;

public interface DanweiShouzhiRecordMapper {
	@Select("select * from danweishouzhi_record")
	List<DanweiShouzhiRecord> queryALL();

}
