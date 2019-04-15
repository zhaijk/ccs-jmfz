package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.DiaobodanRecord;
/**
 *  调拨单操作
 * @author Administrator
 *
 */
public interface DiaobodanMapper {

	@Select("select distinct danjuhao from jiangsu.diaobodan where niandu>=#{niandu} and leixing =1 order by danjuhao desc")
	public List<String> queryDanjuhao(String niandu);
	@Select("select * from jiangsu.Diaobodan where leixing in (1,2,7,8) and niandu > #{year} order by danjuhao desc")
	public List<Diaobodan> queryBy(String danjuhao,String year);
	@Select("select * from jiangsu.Diaobodan where rownum=1 and leixing =1 and niandu > #{year} order by danjuhao desc")
	public Diaobodan queryBySJ(String danjuhao,String year);
	@Select("<script> select a.*,(select junqu from JUNQU_DICTIONARY t where junqu_code=a.junqu_code) as danwei_name,(select youku from jiangsu.YOUKU_DICTIONARY t where youku_code=a.gongyingyouku) as youku_name from jiangsu.Diaobodan a "+
			"<where> leixing=#{type} and niandu>=#{niandu} "+
			/*"<if test='\"all\"!=gongyingyouku'>"+
			" and gongyingyouku =#{gongyingyouku} </if>"+			
			"<if test='\"all\"!=shougongdanwei'>"+
			" and shougongdanwei=#{shougongdanwei} </if>"+*/					
			"<if test='\"all\"!=danjuhao'>"+
			" and danjuhao=#{danjuhao} or huandanhao=#{danjuhao} </if> "+			
			"</where></script>")
	public List<Diaobodan> queryByModel(int type,String gongyingyouku,String shougongdanwei,String danjuhao,String niandu);
	@Select("<script> select a.*,(select junqu from JUNQU_DICTIONARY t where junqu_code=a.junqu_code) as danwei_name,(select youku from jiangsu.YOUKU_DICTIONARY t where youku_code=a.gongyingyouku) as youku_name from jiangsu.Diaobodan a "+
			"<where> (leixing=1 or leixing =3) and niandu>=#{niandu} "+
			/*"<if test='\"all\"!=gongyingyouku'>"+
			" and gongyingyouku =#{gongyingyouku} </if>"+			
			"<if test='\"all\"!=shougongdanwei'>"+
			" and shougongdanwei=#{shougongdanwei} </if>"+*/					
			"<if test='\"all\"!=danjuhao'>"+
			" and danjuhao=#{danjuhao} or huandanhao=#{danjuhao} </if> "+			
			"</where> order by leixing asc,kaidanriqi asc</script>")
	public List<Diaobodan> queryBySZ(String gongyingyouku,String shougongdanwei,String danjuhao,String niandu);
	@Select("<script> select a.*,(select bumen from jiangsu.depar_dictionary  where bumen_code=a.shougongdanwei) as danwei_name,(select youku from jiangsu.YOUKU_DICTIONARY t where youku_code=a.gongyingyouku) as youku_name from jiangsu.Diaobodan a "+
			"<where> (leixing=3 or leixing =4) and niandu>=#{niandu} "+
			"<if test='\"all\"!=jyjyoukus'>"+
			" and gongyingyouku =#{jyjyoukus} </if>"+			
			"<if test='\"all\"!=shougongdanwei'>"+
			" and shougongdanwei=#{shougongdanwei} </if>"+					
			/*"<if test='\"all\"!=danjuhao'>"+
			" and danjuhao=#{danjuhao} or huandanhao=#{danjuhao} </if> "+	*/		
			"</where> order by leixing asc,kaidanriqi desc</script>")
	public List<Diaobodan> queryDiaoboByLeixing(String jyjyoukus,String shougongdanwei,String niandu);
	@Select("select * from jiangsu.diaobodan_record where fk_id=#{fk_id}")
	public List<DiaobodanRecord> queryByRecord(int fk_id);
	@Insert("insert into jiangsu.diaobodan (id,danjuhao,huandanhao,leixing,kaidanriqi,gongyingyouku,shougongdanwei,junqu_code,xiaoji,beizhu,niandu,biaozhi,caozuoyuan,caozuoriqi,caozuotime,beizhu_sys,dayin) values(#{id},#{danjuhao},#{huandanhao},#{leixing},#{kaidanriqi},#{gongyingyouku},#{shougongdanwei},#{junqu_code},#{xiaoji},#{beizhu},#{niandu},#{biaozhi},#{caozuoyuan},#{caozuoriqi},#{caozuotime},#{beizhu_sys},#{dayin})")
	public int insertOne(Diaobodan obj);
	@Select("select jiangsu.diaobodan_sequences.nextval from dual")
	public int queryDiaobodanId();
	
}
