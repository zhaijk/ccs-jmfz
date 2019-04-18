package com.derun.jczb.service;

import java.util.List;

import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YouKuSunHao;
import com.derun.jczb.model.YoukuDictionary;

public interface YoukuSunhaoService {
	List<OilDictionary> queryByOil(String flag);
	List<YoukuDictionary> queryByYouku(int leixing,int flag);
	List<YouKuSunHao> queryYoukuSunhao(String gongyingyouku,String niandu);
	String inputYksh(YouKuSunHao shunhao,Double[] oils);
}
