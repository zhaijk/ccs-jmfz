package com.derun.jczb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Zhibiaorecord;
/**
 *    指标记录操作
 * @author Administrator
 *
 */
public interface QuotaMapper {
	
	@Select("select nvl(sum(YL_XIAOJI),0) as YL_XIAOJI,nvl(sum(YL_JDZG),0) as  YL_JDZG,nvl(sum(YL_ZGZY),0) as YL_ZGZY,nvl(sum(YL_ZGFY),0) as YL_ZGFY,nvl(sum(JF_XIAOJI),0) as JF_XIAOJI,nvl(sum(JF_ZGZY),0) as JF_ZGZY,nvl(sum(JF_ZGFY),0) as JF_ZGFY,nvl(sum(JF_YKGL),0)as JF_YKGL,nvl(sum(JF_JYZGL),0) as JF_JYZGL,nvl(sum(JF_YLYWGL),0) as JF_YLYWGL,nvl(sum(JF_YLGL),0) as JF_YLGL from Zhibiaorecord " + 
			" where leixing = #{type} and niandu = #{year} ")
	public Zhibiaorecord queryBy(int type ,int year,String departmentCode);
	
	@Select("select a.*,b.bumen as danwei_name from zhibiaorecord a ,depar_dictionary b where a.danwei=b.bumen_code and a.leixing = #{type} and a.niandu = #{year} order by a.danwei")
	public List<Zhibiaorecord> queryLstBy(int type ,int year,String departmentCode);
	@Select("select a.*,b.bumen as danwei_name from zhibiaorecord a ,depar_dictionary b where a.danwei=b.bumen_code and a.leixing = #{type} and a.niandu = #{year} and a.jizhang=#{fixed} order by a.danwei")
	public List<Zhibiaorecord> queryObjsBy(int type ,int year,int fixed,String departmentCode);
	@Select("select bumen,bumen_code from depar_dictionary t where t.bumen_code not in (select  a.danwei   from zhibiaorecord a   where   a.leixing = #{type} and a.niandu = #{year}) order by bumen_code ")
	public List<DeparDictionary> queryDepartmentBy(int type ,int year);
	@Update("update zhibiaorecord  set jizhang=1 where  jizhang=0 and danwei=(select bumen_code from depar_dictionary where bumen=#{danwei_name}) and niandu = #{niandu}")
	public int updateOne(Zhibiaorecord obj);
	@Insert("insert into  zhibiaorecord(id,danwei,leixing,yl_jdzg,yl_zgzy,yl_zgfy,jf_zgzy,jf_zgfy,jf_ykgl,jf_jyzgl,jf_ylywgl,jf_ylgl,jf_xiaoji,yl_xiaoji,niandu,jizhang,fenpeidate) values(zhibiaorecord_sequences.nextval,(select bumen_code from depar_dictionary where bumen=#{danwei_name}),#{leixing},#{yl_jdzg},#{yl_zgzy},#{yl_zgfy},#{jf_zgzy},#{jf_zgfy},#{jf_ykgl},#{jf_jyzgl},#{jf_ylywgl},#{jf_ylgl},#{jf_xiaoji},#{yl_xiaoji},#{niandu},#{jizhang},#{fenpeidate})")
	public int insertOne(Zhibiaorecord obj);
	@Insert("delete zhibiaorecord  where  jizhang=0 and danwei=(select bumen_code from depar_dictionary where bumen=#{danwei_name}) and niandu = #{niandu} ")
	public int deleteOne(Zhibiaorecord obj);
}
