package com.derun.jczb.service;

import java.util.List;

import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.jczb.model.Zhuandaigong;


public interface CommitService {	
	/**
	 * 查询年度单据号
	 * @param niandu
	 * @return
	 */
	List<String> queryDanjuhao(String niandu);
	/**
	 * 查询启用的油品信息
	 * @param flag
	 * @return
	 */
	List<OilDictionary> queryByOil(String flag);
	/**
	 * 查询油库信息
	 * @param leixing
	 * @param flag
	 * @return
	 */
	List<YoukuDictionary> queryByYouku(int leixing,int flag);
	
	List<Diaobodan> queryHuanDanIncomePayment(String gongyingdanwei,String departs,String danjuhao,String niandu);
	String insertHuanDan(Diaobodan diaobodan, Integer[] oils);
	List<DeparDictionary> queryDepartInfo();
	List<Diaobodan> queryDiaoboIncomePayment(String jyjyoukus,String shougongdanwei,String niandu);
	String insertDiaobo(Diaobodan diaobodan, Integer[] oils);
	String insertDiaoboDWWJ(Diaobodan diaobodan, Integer[] oils);
	List<Diaobodan> queryDiaoboWjIncomePayment(String wjyoukus,String shougongdanwei,String niandu);
	int saveZdg(Zhuandaigong obj);
}
