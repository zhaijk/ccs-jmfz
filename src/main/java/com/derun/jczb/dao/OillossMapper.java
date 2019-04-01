package com.derun.jczb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.derun.jczb.model.Oilloss;
import com.derun.jczb.model.SunHao;

public interface OillossMapper {
	@Select("select * from OilLoss")
	public List<Oilloss> queryALL();
	@Select("select sum(o.zhugongsunhao) from oilloss o where o.danweiid like #{departmentId}||'%' and lossdate> #{jiezhuanDate}")
	public String queryOilLossheji(String departmentId,String jiezhuanDate);
	@Select("select o.oiltype as oiltype ,sum(o.zhugongsunhao) as sum from wujing.oilloss o where o.danweiid like #{departmentId}||'%' and lossdate>#{jiezhuanDate} group by o.oiltype")
	public List<SunHao> queryOilLossList(String departmentId,String jiezhuanDate);
}
