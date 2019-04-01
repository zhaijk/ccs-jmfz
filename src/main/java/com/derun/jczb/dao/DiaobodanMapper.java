package com.derun.jczb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.derun.jczb.model.Diaobodan;
/**
 *  调拨单操作
 * @author Administrator
 *
 */
public interface DiaobodanMapper {

	@Select("select distinct danjuhao from jiangsu.diaobodan where niandu>=#{niandu} and leixing in (1,2,7,8) order by danjuhao desc")
	public List<String> queryDanjuhao(String niandu);
	@Select("select * from jiangsu.Diaobodan where leixing in (1,2,7,8) and niandu > #{year} order by danjuhao desc")
	public List<Diaobodan> queryBy(String danjuhao,String year);
	@Select("<script> select * from jiangsu.Diaobodan "+
			"<where> niandu=#{niandu} and leixing in (1,2,4,5,6,7,8) "+
			"<if test='\"all\"!=gongyingyouku'>"+
			" and gongyingyouku =#{gongyingyouku} </if>"+			
			"<if test='\"all\"!=shougongdanwei'>"+
			" and shougongdanwei=#{shougongdanwei} </if>"+					
			"<if test='\"all\"!=danjuhao'>"+
			" and danjuhao=#{danjuhao} or huandanhao=#{danjuhao} </if> "+			
			"</where> </script>")
	public List<Diaobodan> queryByModel(String gongyingyouku,String shougongdanwei,String danjuhao,String niandu);
}
