package com.derun.ccs.jmfz.dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * info 审核减免存储过程
 * @author Administrator
 *
 */
public interface AuditMapper {
	@Select(value="call ZXXNY()")
	@Options(statementType=StatementType.CALLABLE)
	public void  audit();
}
