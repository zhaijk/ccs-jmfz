package com.derun.jczb.service;

import java.sql.SQLException;
import java.util.List;

import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YoukuDictionary;


public interface CommitService {	
	List<String> queryDanjuhao(String niandu);
	List<OilDictionary> queryByOil(String flag);
	List<YoukuDictionary> queryByYouku(int leixing,int flag);
	List<Diaobodan> queryDiaobodanIncomePayment(String gongyingdanwei,String departs,String danjuhao,String niandu);
	String insertDiaobodan(Diaobodan diaobodan, Integer[] oils);
}
