package com.derun.jczb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.derun.jczb.dao.DepartDictionaryMapper;
import com.derun.jczb.dao.DiaobodanMapper;
import com.derun.jczb.dao.DiaobodanRecordMapper;
import com.derun.jczb.dao.OilDictionaryMapper;
import com.derun.jczb.dao.YoukuDictionaryMapper;
import com.derun.jczb.model.DeparDictionary;
import com.derun.jczb.model.Diaobodan;
import com.derun.jczb.model.DiaobodanRecord;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.YoukuDictionary;
import com.derun.util.DataTypeConverter;

/**
 **    调拨 解放军换单 
 * @author Administrator
 *
 */
@Service
public class CommitServiceImpl implements CommitService{
	
	@Autowired
	private OilDictionaryMapper oilDictionaryMapper;
	@Autowired
	private YoukuDictionaryMapper youkuDictionaryMapper;
	@Autowired
	private DiaobodanMapper diaobodanMapper;
	@Autowired
	private DiaobodanRecordMapper diaobodanRecordMapper;
	@Autowired
	private DepartDictionaryMapper departInfoMapper;
	
	public List<String> queryDanjuhao(String niandu) {		
		return diaobodanMapper.queryDanjuhao(niandu);
	}
	public List<OilDictionary> queryByOil(String flag){
		return oilDictionaryMapper.queryBy(flag);
	}
	public List<YoukuDictionary> queryByYouku(int leixing,int flag){
		return youkuDictionaryMapper.queryBy(leixing,flag);
	}
	public List<DeparDictionary>  queryDepartInfo(){
		return departInfoMapper.queryBy();
	}
	/* 查询调拨单 类型 1 总后调拨  3 本级换单 
	 * (non-Javadoc)
	 * @see com.derun.jczb.service.CommitService#queryDiaobodanIncomePayment(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<Diaobodan> queryHuanDanIncomePayment(String gongyingdanwei, String departs, String danjuhao,
			String niandu) {
		List<Diaobodan> diaobodans=diaobodanMapper.queryBySZ(gongyingdanwei,departs,danjuhao,niandu);		
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		for(Diaobodan obj:diaobodans){
			List<DiaobodanRecord> objs=diaobodanMapper.queryByRecord(obj.getId().intValue());
			obj.setShiwu(new ArrayList<String>());
			double total=0;
			for(OilDictionary oil:oils) {
				int flag=0;
				for(DiaobodanRecord record:objs) {
				if(oil.getCode()==record.getYoupin_code()) {
					total+=record.getShiwu();
					obj.getShiwu().add(record.getShiwu().toString());
					flag=1;
					break;
				}}
				if(flag==1) flag=0;
				else
					obj.getShiwu().add("0.0");
			}
			if(obj.getLeixing()==1) {//上级调拨单
				obj.setIncome(total);
			}else if(obj.getLeixing()==3) {
				obj.setPayment(total);
			}
		}
		//计算汇总
		double income=0;
		double payment=0;
		double balance=0;
		double[] oilbalance= new double[oils.size()];
		int index=0;
		for(Diaobodan obj:diaobodans){
			long leixing=obj.getLeixing();
			if(leixing==1) {
				income+=obj.getIncome();
			}else if(leixing==3) {
				payment+=obj.getPayment();
			}
			for(String oilval:obj.getShiwu()) {
				double value=Double.parseDouble(oilval);
				if(leixing==1) {
					oilbalance[index]+=value;
				}else if(leixing==3) {
					oilbalance[index]-=value;
				}
				index++;
			}
			index=0;
		}
		balance=income-payment;
		Diaobodan total=new Diaobodan();
		List<String> shiwu=new ArrayList<String>();
		total.setKaidanriqi("合  计");
		total.setIncome(income);
		total.setPayment(payment);
		total.setBalance(balance);
		for(double val:oilbalance) {
			shiwu.add(String.valueOf(val));
		}
		total.setShiwu(shiwu);
		diaobodans.add(0,total);
		return diaobodans;
	}
	/*
	 * 解放军换单diaobodan leixing=3  按油品添加diaobodan_record记录
	 */
	@Transactional(rollbackFor=SQLException.class,propagation=Propagation.REQUIRED)
	public String insertHuanDan(Diaobodan diaobodan, Integer[] oils)  {
		List<OilDictionary> oilinfo=queryByOil("1");
		diaobodan.setCaozuoriqi(DataTypeConverter.getDate());
		diaobodan.setCaozuotime(DataTypeConverter.getTime());
		Diaobodan dbd=diaobodanMapper.queryBySJ(diaobodan.getDanjuhao(), "2016");
		String name=youkuDictionaryMapper.queryNameByCode(diaobodan.getGongyingyouku());
		diaobodan.setBeizhu_sys(name);
		diaobodan.setDayin(0l);
		diaobodan.setShougongdanwei(dbd.getShougongdanwei());
		diaobodan .setJunqu_code(dbd.getJunqu_code());
		diaobodan.setBeizhu("");
		diaobodan.setLeixing(3l);	//本级分配
		//diaobodan.setCaozuoyuan("测试");
		diaobodan.setNiandu(DataTypeConverter.getIntYear());
		double total=0;
		for(Integer obj:oils) {
			if(null!=obj) {	
				total+=obj;
			}
		}
		diaobodan.setXiaoji(total);
		long id=diaobodanMapper.queryDiaobodanId();
		diaobodan.setId(id);
		diaobodan.setCaozuoyuan("");
		diaobodanMapper.insertOne(diaobodan);
		int index=0;
		for(Integer obj:oils) {
			if(null!=obj) {				
				DiaobodanRecord record=new DiaobodanRecord();
				record.setFk_id(id);
				record.setYoupin_code(oilinfo.get(index).getCode());
				record.setShiwu((double)obj);				
				diaobodanRecordMapper.insertOne(record);
			}
			index++;
		}
		return "success";
	}
	
	/* 查询调拨单 类型 3 收入 4 支出 
	 * 
	 * 
	 */
	public List<Diaobodan> queryDiaoboIncomePayment(String jyjyoukus,String shougongdanwei,String niandu){
		List<Diaobodan> diaobodans=diaobodanMapper.queryDiaoboByLeixing(jyjyoukus,shougongdanwei,niandu);		
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		for(Diaobodan obj:diaobodans){
			List<DiaobodanRecord> objs=diaobodanMapper.queryByRecord(obj.getId().intValue());
			obj.setShiwu(new ArrayList<String>());
			double total=0;
			for(OilDictionary oil:oils) {
				int flag=0;
				for(DiaobodanRecord record:objs) {
				if(oil.getCode()==record.getYoupin_code()) {
					Double sum=record.getShiwu()+record.getJiabo();
					total+=sum;
					obj.getShiwu().add(sum.toString());
					flag=1;
					break;
				}}
				if(flag==1) flag=0;
				else
					obj.getShiwu().add("0.0");
			}
			if(obj.getLeixing()==3) {			//换单
				obj.setIncome(total);
			}else if(obj.getLeixing()==4) {		//调拨
				obj.setPayment(total);
			}
		}
		//计算汇总
		double income=0;
		double payment=0;
		double balance=0;
		double[] oilbalance= new double[oils.size()];
		int index=0;
		for(Diaobodan obj:diaobodans){
			long leixing=obj.getLeixing();
			if(leixing==3) {
				income+=obj.getIncome();
			}else if(leixing==4) {
				payment+=obj.getPayment();
			}
			for(String oilval:obj.getShiwu()) {
				double value=Double.parseDouble(oilval);
				if(leixing==3) {
					oilbalance[index]+=value;
				}else if(leixing==4) {
					oilbalance[index]-=value;
				}
				index++;
			}
			index=0;
		}
		balance=income-payment;
		Diaobodan total=new Diaobodan();
		List<String> shiwu=new ArrayList<String>();
		total.setKaidanriqi("合  计");
		total.setIncome(income);
		total.setPayment(payment);
		total.setBalance(balance);
		for(double val:oilbalance) {
			shiwu.add(String.valueOf(val));
		}
		total.setShiwu(shiwu);
		if(shougongdanwei.equals("all")==false) {
			total.setBalance(0);
		}
		diaobodans.add(0,total);
		return diaobodans;
	}
	/*
	 * 解放军换单diaobodan leixing=3  按油品添加diaobodan_record记录
	 */
	@Transactional(rollbackFor=SQLException.class,propagation=Propagation.REQUIRED)
	public String insertDiaobo(Diaobodan diaobodan, Integer[] oils)  {
		List<OilDictionary> oilinfo=queryByOil("1");
		diaobodan.setCaozuoriqi(DataTypeConverter.getDate());
		diaobodan.setCaozuotime(DataTypeConverter.getTime());
		Diaobodan dbd=diaobodanMapper.queryBySJ(diaobodan.getDanjuhao(), "2016");
		String name=youkuDictionaryMapper.queryNameByCode(diaobodan.getGongyingyouku());
		diaobodan.setBeizhu_sys(name);
		diaobodan.setDayin(0l);
		diaobodan.setShougongdanwei(dbd.getShougongdanwei());
		diaobodan .setJunqu_code(dbd.getJunqu_code());
		diaobodan.setBeizhu("");
		diaobodan.setLeixing(3l);	//本级分配
		//diaobodan.setCaozuoyuan("测试");
		diaobodan.setNiandu(DataTypeConverter.getIntYear());
		double total=0;
		for(Integer obj:oils) {
			if(null!=obj) {	
				total+=obj;
			}
		}
		diaobodan.setXiaoji(total);
		long id=diaobodanMapper.queryDiaobodanId();
		diaobodan.setId(id);
		diaobodan.setCaozuoyuan("");
		diaobodanMapper.insertOne(diaobodan);
		int index=0;
		for(Integer obj:oils) {
			if(null!=obj) {				
				DiaobodanRecord record=new DiaobodanRecord();
				record.setFk_id(id);
				record.setYoupin_code(oilinfo.get(index).getCode());
				record.setShiwu((double)obj);				
				diaobodanRecordMapper.insertOne(record);
			}
			index++;
		}
		return "success";
	}
	/*
	 *    油料调拨 单位 武警油库leixing=4,5  按油品添加diaobodan_record记录
	 */
	@Transactional(rollbackFor=SQLException.class,propagation=Propagation.REQUIRED)
	public String insertDiaoboDWWJ(Diaobodan diaobodan, Integer[] oils)  {
		List<OilDictionary> oilinfo=queryByOil("1");
		diaobodan.setCaozuoriqi(DataTypeConverter.getDate());
		diaobodan.setCaozuotime(DataTypeConverter.getTime());
		//Diaobodan dbd=diaobodanMapper.queryBySJ(diaobodan.getDanjuhao(), "2016");
		String name=youkuDictionaryMapper.queryNameByCode(diaobodan.getGongyingyouku());
		diaobodan.setBeizhu_sys(name);
		diaobodan.setDayin(0l);
		//diaobodan.setShougongdanwei(dbd.getShougongdanwei());
		diaobodan .setJunqu_code("");
		diaobodan.setBeizhu("");
		//diaobodan.setLeixing(3l);	//本级分配 4 本级调拨 5 武警油库调拨
		//diaobodan.setCaozuoyuan("测试");
		diaobodan.setDanjuhao(diaoboDanjuhao(diaobodan.getGongyingyouku()));
		diaobodan.setHuandanhao("");
		diaobodan.setNiandu(DataTypeConverter.getIntYear());
		double total=0;
		for(Integer obj:oils) {
			if(null!=obj) {	
				total+=obj;
			}
		}
		diaobodan.setXiaoji(total);
		long id=diaobodanMapper.queryDiaobodanId();
		diaobodan.setId(id);
		diaobodan.setCaozuoyuan("");
		diaobodanMapper.insertOne(diaobodan);
		int len=oils.length/2;
		for(int i=0;i<len;i++) {
			if(oils[i]+oils[i+len]>0){	
				DiaobodanRecord record=new DiaobodanRecord();
				record.setFk_id(id);
				record.setYoupin_code(oilinfo.get(i).getCode());
				record.setShiwu((double)oils[i]);
				record.setJiabo((double)oils[i+len]);
				diaobodanRecordMapper.insertOne(record);
			}
		}
		return "success";
	}
	/**
	 *  单据号生成器  XX年份 XXXX供应油库代码去掉中间两位  尾数 4位序列号
	 * @param gongyingyouku
	 * @return
	 */
	private String diaoboDanjuhao(String gongyingyouku) {
		
		StringBuilder  idStr=new StringBuilder();
		String danjuhao=diaobodanMapper.queryMaxDanjuhao(gongyingyouku);
		int year =Integer.parseInt(danjuhao.substring(0, 2));
		int current_year=DataTypeConverter.getIntYear()%100;
		if(year==current_year) {//同年
			idStr.append(danjuhao.substring(0,6));	
			int counter=Integer.parseInt(danjuhao.substring(6,10))+1;
			idStr.append(String.format("%04d", counter));
		}else {
			idStr.append(DataTypeConverter.getIntYear()%100);
			idStr.append(danjuhao.substring(2,6));
			idStr.append("0001");
		}		
		return idStr.toString();
	}
	
	/* 查询调拨单 类型 5 收入 6 支出 
	 * 
	 * 
	 */
	public List<Diaobodan> queryDiaoboWjIncomePayment(String wjyoukus,String shougongdanwei,String niandu){
		List<Diaobodan> diaobodans=diaobodanMapper.queryDiaoboByWJyouku(wjyoukus,shougongdanwei,niandu);		
		List<OilDictionary> oils=oilDictionaryMapper.queryBy("1");
		for(Diaobodan obj:diaobodans){
			List<DiaobodanRecord> objs=diaobodanMapper.queryByRecord(obj.getId().intValue());
			obj.setShiwu(new ArrayList<String>());
			double total=0;
			for(OilDictionary oil:oils) {
				int flag=0;
				for(DiaobodanRecord record:objs) {
				if(oil.getCode()==record.getYoupin_code()) {
					Double sum=record.getShiwu()+record.getJiabo();
					total+=sum;
					obj.getShiwu().add(sum.toString());
					flag=1;
					break;
				}}
				if(flag==1) flag=0;
				else
					obj.getShiwu().add("0.0");
			}
			if(obj.getLeixing()==5) {			//换单
				obj.setIncome(total);
			}else if(obj.getLeixing()==6) {		//调拨
				obj.setPayment(total);
			}
		}
		//计算汇总
		double income=0;
		double payment=0;
		double balance=0;
		double[] oilbalance= new double[oils.size()];
		int index=0;
		for(Diaobodan obj:diaobodans){
			long leixing=obj.getLeixing();
			if(leixing==5) {
				income+=obj.getIncome();
			}else if(leixing==6) {
				payment+=obj.getPayment();
			}
			for(String oilval:obj.getShiwu()) {
				double value=Double.parseDouble(oilval);
				if(leixing==5) {
					oilbalance[index]+=value;
				}else if(leixing==6) {
					oilbalance[index]-=value;
				}
				index++;
			}
			index=0;
		}
		balance=income-payment;
		Diaobodan total=new Diaobodan();
		List<String> shiwu=new ArrayList<String>();
		total.setKaidanriqi("合  计");
		total.setIncome(income);
		total.setPayment(payment);
		total.setBalance(balance);
		for(double val:oilbalance) {
			shiwu.add(String.valueOf(val));
		}
		total.setShiwu(shiwu);
		if(shougongdanwei.equals("all")==false) {
			total.setBalance(0);
		}
		diaobodans.add(0,total);
		return diaobodans;
	}
	
}
