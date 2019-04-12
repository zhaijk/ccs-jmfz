package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.derun.jczb.model.DiaobodanRecord;

public interface DiaobodanRecordMapper {
	@Select("select c.name as youpin_name,b.youpin_code,b.shiwu from jiangsu.diaobodan a ,jiangsu.diaobodan_record b ,jiangsu.oil_dictionary c where a.id=b.fk_id and b.youpin_code=c.code and niandu>=#{niandu} and leixing =1 and danjuhao=#{danjuhao} order by danjuhao desc")
	public List<DiaobodanRecord> queryOil(String niandu,String danjuhao);
	@Select("select c.name as youpin_name,b.youpin_code,b.shiwu from jiangsu.diaobodan a ,jiangsu.diaobodan_record b ,jiangsu.oil_dictionary c where a.id=b.fk_id and b.youpin_code=c.code and niandu>=#{niandu} and leixing =1  order by danjuhao desc")
	public List<DiaobodanRecord> queryOils(String niandu);
	@Insert("insert into jiangsu.diaobodan_record (fk_id,youpin_code,shiwu,jiabo,zigou,id) values(#{fk_id},#{youpin_code},#{shiwu},#{jiabo},#{zigou},jiangsu.DIAOBODANRECORD_SEQUENCES.nextval) ")
	public int insertOne(DiaobodanRecord obj);
		
}
