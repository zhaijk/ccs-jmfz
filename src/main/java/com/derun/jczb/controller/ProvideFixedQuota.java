package com.derun.jczb.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardMainMapper;
import com.derun.jczb.dao.CardProvideMapper;
import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.DepartmentRecordMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.dao.OilTypeMapper;
import com.derun.jczb.model.CardMain;
import com.derun.jczb.model.CardProvideReport;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.DepartmentProvideInfo;
import com.derun.jczb.model.OilInfo;
import com.derun.jczb.model.ProvideSumInfo;
import com.derun.util.DataTypeConverter;
import com.google.common.base.Optional;

//固定指标发放
@Controller
public class ProvideFixedQuota {
	
	private Logger logger=LoggerFactory.getLogger(ProvideFixedQuota.class);
	@Autowired 
	private  DepartmentInfoMapper  departmentInfoMapper;
	@Autowired 
	private  DepartmentIncomeMapper  departmentIncomeMapper;
	@Autowired 
	private  OilTypeMapper  oilTypeMapper;
	@Autowired 
	private  OilInfoMapper  oilInfoMapper;
	@Autowired
	private DepartmentRecordMapper departmentRecordMapper;
	@Autowired
	private CardProvideMapper cardProvideMapper;
	@Autowired
	private CardMainMapper  cardMainMapper;
	@Autowired
	private CardTradeMapper cardTradeMapper;
	
	
	@GetMapping("fixed_quota_provide.htm")
	public String init(ModelMap model) {
		double shouRu = 0.0;
		double zhiChu = 0.0;
		double luRuZhiChu = 0.0;
		double putValue = 0.0;
		double sjValue = 0.0;
		
		double old = 0.0;
		double put = 0.0;
		double fafang = 0.0;
		
		String departmentCode="7200";
		String jiezhuanDate=departmentIncomeMapper.jiezhuandate();
		//部门信息 油品信息
		List<DepartmentInfo> departmentInfos=departmentInfoMapper.queryByDepartmentCode(departmentCode);
		//List<OilDictionary> oils=oilTypeMapper.queryALL();		
		List<OilInfo> oils=oilInfoMapper.queryByOilInfo(departmentCode);
		//部门汇总信息
		List<DepartmentProvideInfo> departmentProvideInfos=new ArrayList<DepartmentProvideInfo>();
		for(DepartmentInfo obj:departmentInfos) {
			//部门发放汇总信息
			DepartmentProvideInfo departmentProvideInfo=new DepartmentProvideInfo();
			departmentProvideInfo.setDepartmentName(obj.getDepartmentName());
			departmentProvideInfo.setDepartmentCode(obj.getDepartmentCode());
			departmentCode=obj.getDepartmentCode();
			String cardCode=departmentCode.substring(0, 6);
			//部门收入合计
			List<ProvideSumInfo> bmsr=departmentRecordMapper.queryDepartmentRecordSum(departmentCode,jiezhuanDate);
			Map<String,Double> bmsrs=new HashMap<String,Double>();
			for(ProvideSumInfo objInfo:bmsr) {
				bmsrs.put(objInfo.getOilType(), objInfo.getSum());
			}
			//部门发放  实物卡 机动卡
			List<ProvideSumInfo> bmff=cardProvideMapper.querySumCardProvideAllCard(cardCode,jiezhuanDate);
			Map<String,Double> bmffs=new HashMap<String,Double>();
			for(ProvideSumInfo objInfo:bmff) {
				bmffs.put(objInfo.getOilType(), objInfo.getSum());
			}
			//卡固定指标发放量
			List<ProvideSumInfo> kff=cardMainMapper.querySumCardProvideFix(cardCode);
			Map<String,Double> kffs=new HashMap<String,Double>();
			for(ProvideSumInfo objInfo:kff) {
				kffs.put(objInfo.getOilType(), objInfo.getSum());
			}
			//卡应发放量 实际发放数量
			String currentDate=LocalDate.now().toString();
			List<ProvideSumInfo> ksjff=cardMainMapper.querySumCardProvide(cardCode, currentDate);
			Map<String,Double> ksjffs=new HashMap<String,Double>();
			for(ProvideSumInfo objInfo:ksjff) {
				ksjffs.put(objInfo.getOilType(), objInfo.getSum());
			}
			//非IC卡消耗
			List<ProvideSumInfo> ficxh=cardTradeMapper.querysumCardTradeNonIC(cardCode, jiezhuanDate);
			Map<String,Double> ficxhs=new HashMap<String,Double>();
			for(ProvideSumInfo objInfo:ficxh) {
				ficxhs.put(objInfo.getOilType(), objInfo.getSum());
			}			
			List<Double> oiltypeSums=new ArrayList<Double>();
			List<Double> fixedProvide=new ArrayList<Double>();
			List<Double> fafangValue=new ArrayList<Double>();
			int  flag=1;
			for(OilInfo oil:oils) {
				String oilCode=String.valueOf(oil.getOilType());
				try {
					shouRu=bmsrs.get(oilCode);//部门收入
				}catch(NullPointerException e) {
					shouRu=0;
				}
				try {
					zhiChu=bmffs.get(oilCode);//部门支出(发放)
				}catch(NullPointerException e) {
					zhiChu=0;
				}
				try {
					luRuZhiChu=ficxhs.get(oilCode);//非IC卡消耗
				}catch(NullPointerException e) {
					luRuZhiChu=0;
				}
				try {
					putValue=kffs.get(oilCode);//固定发放量
				}catch(NullPointerException e) {
					putValue=0;
				}
				try {
					sjValue=ksjffs.get(oilCode);//实际发放量
				}catch(NullPointerException e) {
					sjValue=0;
				}				
				/*logger.info(obj.getDepartmentName()+oil.getName()+":="+"*收入："+shouRu+"*支出："+zhiChu+"*录入"+luRuZhiChu+"*re"+(shouRu - zhiChu
						- luRuZhiChu));*/
				oiltypeSums.add(DataTypeConverter.d2d(shouRu - zhiChu	- luRuZhiChu));
				fixedProvide.add(DataTypeConverter.d2d(putValue));
				fafangValue.add(DataTypeConverter.d2d(sjValue));
				if((shouRu - zhiChu	- luRuZhiChu)>=sjValue) 
					flag=flag*1;
				else
					flag=flag*0;
			}
			//boolean sendDateFlag=true;
//			String date=getDate();
			try {
				Optional<String> maxDate=Optional.of(cardProvideMapper.queryDepartmentMaxDate(departmentCode.substring(0,6)));
				//System.out.println(obj.getDepartmentName()+" :  "+maxDate.get()+" "+date+" "+obj.getDepartmentName());
				//sendDateFlag=LocalDate.now().isAfter(LocalDate.parse(maxDate.get()));
				if(maxDate.get().compareTo(getDate())>0) {
					//System.out.println(maxDate.get()+" "+date+" "+obj.getDepartmentName());
					flag=0;
				}
			}catch(NullPointerException e) {
				flag=1;
			}			
			departmentProvideInfo.setFixedProvide(fixedProvide);
			departmentProvideInfo.setOiltypeSum(oiltypeSums);
			departmentProvideInfo.setFafangValue(fafangValue);
			departmentProvideInfo.setFlag(flag);
			departmentProvideInfos.add(departmentProvideInfo);
			
		}	
		//部门发放汇总合计信息
		DepartmentProvideInfo totalInfo=new DepartmentProvideInfo();
		totalInfo.setDepartmentName("合计");
		List<Double> oiltypeSums=new ArrayList<Double>();
		for(int i=0;i<oils.size();i++)
			oiltypeSums.add(0.0);
		totalInfo.setOiltypeSum(oiltypeSums);
		for(DepartmentProvideInfo info:departmentProvideInfos) {			
			int index=0;
			for(Double obj:info.getOiltypeSum()) {
				double sum=totalInfo.getOiltypeSum().get(index);
				totalInfo.getOiltypeSum().set(index, DataTypeConverter.d2d(sum+obj));
				index++;
			}
		}
		departmentCode="7200";
		List<ProvideSumInfo> provideSumInfos=departmentIncomeMapper.querySumGuideline(departmentCode,jiezhuanDate);
		for(ProvideSumInfo obj:provideSumInfos) {
			obj.setSum(DataTypeConverter.d2d(obj.getSum()));
		}
		model.put("provideSumInfos",provideSumInfos);
		model.put("oilInfos",oils);
		model.put("departmentProvideInfos",departmentProvideInfos);
		model.put("totalInfo", totalInfo);
		return "fixed_quota_provide";
	}
	@PostMapping("fixed_quota_provide/provide")
	@ResponseBody
	public String provide(@RequestParam(value = "objs[]") List<String> objs) {
		//System.out.println(objs.toString());
		//提取当前日期
		String strTodayDate=LocalDate.now().toString();
		String strTodayTime=LocalTime.now().withNano(0).toString();
		String departmentCode="7200";
		List<DepartmentInfo> departmentInfos=departmentInfoMapper.queryByDepartmenInfo(objs);
		for(DepartmentInfo departmentInfo:departmentInfos) {
			departmentCode=departmentInfo.getDepartmentCode();
			//判断部门剩余指标是否大于本次发放量
			boolean flag=isProvide(departmentCode);
			//查询最后一次固定指标发放日期
			boolean sendDateFlag=false;
			try {
				Optional<String> maxDate=Optional.of(cardProvideMapper.queryDepartmentMaxDate(departmentCode.substring(0, 6)));
				sendDateFlag=LocalDate.now().isAfter(LocalDate.parse(maxDate.get()));				
			}catch(NullPointerException e) {
				sendDateFlag=false;
			}
			if(sendDateFlag==true) {
				departmentInfo.getDepartmentName();
				List<CardMain> cardMains=cardMainMapper.queryCardInfos(departmentCode.substring(0, 6), strTodayDate);
				for(CardMain obj:cardMains) {
					//固定指标发放
					CardProvideReport cardProvideReport = new CardProvideReport();
					cardProvideReport.setCardCode(obj.getCardCode());
					cardProvideReport.setOilType(obj.getOilType());
					cardProvideReport.setGuidelineType(obj.getGuidelineType());
					cardProvideReport.setProvideDate(strTodayDate);
					cardProvideReport.setProvideTime(strTodayTime);
					cardProvideReport.setSendType(1);
					int sendFlag=cardTradeMapper.queryCardMaxSendFlag(obj.getCardCode());
					cardProvideReport.setSendFlag(sendFlag + 1);					
					//获取卡号
					String cardCode=obj.getCardCode();					
					// 查看卡上的最大限额指标,这里只有固定做处理
					double maxCount = obj.getMaxcount();					
					if(maxCount>0) {
						// 固定发放指标+补助指标+卡上余额+未实录指标
						double sumProvide = obj.getDestineGuideline()+obj.getBuzhuzhibiao()+
								            obj.getCardCount()+obj.getNoOperateCount();
						if(sumProvide>=maxCount) {
							if(obj.getNoOperateCount()+obj.getCardCount()>=maxCount) {
								cardProvideReport.setGuidelineCount(0d);
							}else {// 最大限额-卡上余额
								cardProvideReport.setGuidelineCount(maxCount-obj.getCardCount()-obj.getNoOperateCount());
							}
						}else {
							cardProvideReport.setGuidelineCount(obj.getDestineGuideline()+obj.getBuzhuzhibiao());
						}
					}else {
						cardProvideReport.setGuidelineCount(obj.getDestineGuideline()+ obj.getBuzhuzhibiao());
					}
					//指标最大限额
					if((maxCount>0&&obj.getNoOperateCount()+obj.getCardCount()>=maxCount)==false) {
//						cardProvideReport.setWriteCard(0);
//						cardProvideReport.setTflagDown(0);
//						cardProvideReport.setTflagUp(0);
//						cardProvideReport.setAccount(0);
//						cardProvideReport.setOperator("");
//						cardProvideReport.setShenpiren("");
						cardProvideMapper.insertOne(cardProvideReport);
					}
				}
			}
		}
		return "success";
	}	
	/**
	  * 判断单个单位是否有足够的指标发放
	 * @param departmentCode
	 * @return
	 */
	private boolean isProvide(String departmentCode) {
		
		boolean ok = true;
		double shouRu = 0.0;
		double zhiChu = 0.0;
		double luRuZhiChu = 0.0;
		double putValue = 0.0;
		String cardCode = departmentCode.substring(0, 6);//部门卡头六位
		String jiezhuanDate=departmentIncomeMapper.jiezhuandate();
		
		//部门收入合计
		List<ProvideSumInfo> bmsr=departmentRecordMapper.queryDepartmentRecordSum(departmentCode,jiezhuanDate);
		Map<String,Double> bmsrs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:bmsr) {
			bmsrs.put(objInfo.getOilType(), objInfo.getSum());
		}
		//部门发放记录 实物卡 机动卡 临时指标 固定指标 单卡指标
		List<ProvideSumInfo> bmff=cardProvideMapper.querySumCardProvideAllCard(cardCode,jiezhuanDate);
		Map<String,Double> bmffs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:bmff) {
			bmffs.put(objInfo.getOilType(), objInfo.getSum());
		}
		//卡发放量
		List<ProvideSumInfo> kff=cardMainMapper.querySumCardProvideFix(cardCode);
		Map<String,Double> kffs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:kff) {
			kffs.put(objInfo.getOilType(), objInfo.getSum());
		}
		//卡实际发放量
		String currentDate=LocalDate.now().toString();//提取当前日期
		List<ProvideSumInfo> ksjff=cardMainMapper.querySumCardProvide(cardCode, currentDate);
		Map<String,Double> ksjffs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:ksjff) {
			ksjffs.put(objInfo.getOilType(), objInfo.getSum());
		}
		//非IC卡消耗
		List<ProvideSumInfo> ficxh=cardTradeMapper.querysumCardTradeNonIC(cardCode, jiezhuanDate);
		Map<String,Double> ficxhs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:ficxh) {
			ficxhs.put(objInfo.getOilType(), objInfo.getSum());
		}
		List<OilInfo> oils=oilInfoMapper.queryByOilInfo(departmentCode);
		for(OilInfo oilInfo:oils) {
			String oilCode=String.valueOf(oilInfo.getOilType());
			try {
				shouRu=bmsrs.get(oilCode);		//部门收入
			}catch(NullPointerException e) {
				shouRu=0;
			}
			try {
				zhiChu=bmffs.get(oilCode);		//部门支出(发放)
			}catch(NullPointerException e) {
				zhiChu=0;
			}
			try {
				luRuZhiChu=ficxhs.get(oilCode);	//非IC卡消耗
			}catch(NullPointerException e) {
				luRuZhiChu=0;
			}
			try {
				putValue=kffs.get(oilCode);		//卡部门发放量
			}catch(NullPointerException e) {
				putValue=0;
			}
			if(shouRu-zhiChu-luRuZhiChu<putValue)
				return false;
		}
		return true;
	}	
	/**
	 *   获取年月  每月25日之后算下一个月  12月25之后算下一年
	 * @return
	 */
	private String getYearMonth() {
		int day=LocalDate.now().getDayOfMonth();
		int month=LocalDate.now().getMonthValue();
		int year=LocalDate.now().getYear();
		if(day>=25) month=month+1;
		if(month>12) year=year+1;
		return year+String.format("-%02d", month);
	}
	private String getDate() {
		int day=LocalDate.now().getDayOfMonth();
		int month=LocalDate.now().getMonthValue();
		int year=LocalDate.now().getYear();
		if(day<=25) 
			month=month-1;
		day=25;
		if(month==0) {
			year=year-1;
			month=12;
		}
		//if(month>12) {year=year+1;month=1;}
		return year+String.format("-%02d", month)+String.format("-%02d", day);
	}
//	public static void main(String[] args) {
//		/*//Calendar ca = Calendar.getInstance();
//		String date = "";
//		Integer month = 1;
//		Integer day = 26;
//		Integer year =2019;
//		String months ="";
//		if(day<25){
//			if(month<10){
//				months = "0"+month;
//				date =year+ "-0" +month;
//			}else{
//				months = ""+month;
//				date = year+"-"+month;
//			}
//		}else{
//			if(month+1<10){
//				months = "0"+month;
//				date =year+"-0"+(month+1);
//			}else if (month+1<=12){
//				months = "0"+(month+1);
//				date =year+"-" +(month+1);
//			}else{
//				months = "0"+(month+1);
//				date = (year+1)+"-01";
//			}
//		}
//		System.out.println(date);*/
//		ProvideFixedQuota p=new ProvideFixedQuota();
//		String ym=p.getYearMonth();
//		System.out.println(ym);
//	}
//	public static void main(String[] args) {
//		String date=ProvideFixedQuota.getDate();
//		System.out.println(date);
//	}
}
