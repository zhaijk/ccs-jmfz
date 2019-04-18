package com.derun.jczb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.YoukuDictionaryMapper;
import com.derun.jczb.dao.YoukuSunhaoMapper;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YouKuSunHao;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.util.DataTypeConverter;

@Service
public class YoukuSunhaoServiceImpl implements YoukuSunhaoService{
	@Autowired
	private YoukuSunhaoMapper youkuSunhaoMapper;
	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;	
	@Autowired
	private YoukuDictionaryMapper youkuDictionaryMapper;

	
	public List<YoukuDictionary> queryByYouku(int leixing,int flag){
		return youkuDictionaryMapper.queryBy(leixing,flag);
	}
	public List<OilDictionary> queryByOil(String flag){
		return oilDictionaryMapper.queryBy(flag);
	}
	/**
	 *   计算油库损耗文件号
	 * @param sg_danwei
	 * @return
	 */
	private String ykshDJH(String gongyingyouku) {		
		StringBuilder  idStr=new StringBuilder();
		String wenjianhao=youkuSunhaoMapper.queryMaxByDjh(2019);		
		if(null==wenjianhao) {
			idStr.append("耗");
			idStr.append(DataTypeConverter.getIntYear()%100);
			idStr.append(gongyingyouku.substring(0, 2));
			idStr.append("0000001");
			return idStr.toString();
		}
		int counter=Integer.parseInt(wenjianhao.substring(5,12))+1;
		idStr.append(wenjianhao.substring(0,5));
		idStr.append(String.format("%07d", counter));				
		return idStr.toString();
	}
	/* 查询油库损耗 
	 * 
	 *  
	 */
	public List<YouKuSunHao> queryYoukuSunhao(String gongyingyouku,String niandu) {
		List<YouKuSunHao> shs=new ArrayList<YouKuSunHao>(); 
		//查询单据号
		List<String> djhs=youkuSunhaoMapper.queryBy(gongyingyouku,niandu);
		//查询油品信息
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");		
		for(String djh:djhs){		
			//查询单据号对应的记录
			List<YouKuSunHao> ykshs=youkuSunhaoMapper.queryByDjh(djh);
			List<String> youpins=new ArrayList<String>();
			double total=0;
			int flag=0;
			for(OilDictionary oil:oils) {
				for(YouKuSunHao yksh:ykshs) {
					if(yksh.getOil()==oil.getCode().intValue()) {
						total+=yksh.getYoupin();
						youpins.add(String.valueOf(yksh.getYoupin()));
						flag=1;						
					}
				}
				if(flag==0) youpins.add("0.0");
				else 	    flag=0;
			}
			ykshs.get(0).setYoupins(youpins);
			ykshs.get(0).setTotal(total);
			shs.add(ykshs.get(0));
		}		
		YouKuSunHao total=new YouKuSunHao();
		total.setDanjuhao("合计");
		List<String> youpins=new ArrayList<String>();
		for(String val:shs.get(0).getYoupins()) {
			youpins.add(val);
		}		
		double t=shs.get(0).getTotal();
		for(int i=1;i<shs.size();i++) {
			List<String> vals=shs.get(i).getYoupins();
			int counter=0;
			for(String val:vals) {
				Double sum=Double.parseDouble(youpins.get(counter))+Double.parseDouble(val);
				youpins.set(counter,sum.toString());
				counter++;
			}	
			t+=shs.get(i).getTotal();
		}
		total.setYoupins(youpins);
		total.setTotal(t);
		shs.add(0,total);
		return shs;
	}
	@Transactional(rollbackFor=SQLException.class,propagation=Propagation.REQUIRED)
	public String inputYksh(YouKuSunHao shunhao,Double[] oils) {
		int  result=0;
		int  counter=0;
		int  oper=0;
		List<OilDictionary> oilinfos=oilDictionaryMapper.queryBy("1");		
		for(OilDictionary oil:oilinfos) {
			shunhao.setDanjuhao(ykshDJH(shunhao.getYouku()));
			shunhao.setNiandu(DataTypeConverter.getIntYear());
			shunhao.setOil(oil.getCode().intValue());
			shunhao.setRiqi(DataTypeConverter.getDate());
			shunhao.setYoupin(null==oils[counter]?0:oils[counter]);	
			shunhao.setRemark("");
			if(null!=oils[counter] && oils[counter]>0) {
				result=youkuSunhaoMapper.insertOne(shunhao);
				oper++;
			}
			counter++;
		}
		return result==1?"success: "+oper :"failure: "+counter;
	}	
}
