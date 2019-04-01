package com.derun.jczb.controller;

import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Arrays;
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
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardMainMapper;
import com.derun.jczb.dao.CardProvideMapper;
import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.DepartmentRecordMapper;
import com.derun.jczb.dao.OilInfoMapper;
//import com.derun.jczb.dao.OilTypeMapper;
import com.derun.jczb.model.CardMain;
import com.derun.jczb.model.CardProvideReport;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.DepartmentProvideInfo;
import com.derun.jczb.model.OilInfo;
import com.derun.jczb.model.ProvideSumInfo;
import com.derun.util.DataTypeConverter;
//import com.google.common.base.Optional;

//单卡指标发放
@Controller
public class ProvideCardQuota {
	
	private Logger logger=LoggerFactory.getLogger(ProvideCardQuota.class);
	@Autowired 
	private  DepartmentInfoMapper  departmentInfoMapper;
	@Autowired 
	private  DepartmentIncomeMapper  departmentIncomeMapper;
//	@Autowired 
//	private  OilTypeMapper  oilTypeMapper;
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
	
	
	@GetMapping("card_quota_provide.htm")
	public String init(ModelMap model) {
		String departmentCode="7200";
		double shouRu = 0.0;
		double zhiChu = 0.0;
		double luRuZhiChu = 0.0;
		double putValue = 0.0;
		double sjValue = 0.0;
		
		double old = 0.0;
		double put = 0.0;
		double fafang = 0.0;
		
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
			//卡发放量
			List<ProvideSumInfo> kff=cardMainMapper.querySumCardProvideFix(cardCode);
			Map<String,Double> kffs=new HashMap<String,Double>();
			for(ProvideSumInfo objInfo:kff) {
				kffs.put(objInfo.getOilType(), objInfo.getSum());
			}
			//卡已发放量
			List<ProvideSumInfo> ksjff=cardMainMapper.querySumCardProvide(departmentCode, jiezhuanDate);
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
				logger.info(obj.getDepartmentName()+oil.getName()+":="+"*收入："+shouRu+"*支出："+zhiChu+"*录入"+luRuZhiChu+"*re"+(shouRu - zhiChu
						- luRuZhiChu));
				oiltypeSums.add(DataTypeConverter.d2d(shouRu - zhiChu	- luRuZhiChu));
			}
			departmentProvideInfo.setOiltypeSum(oiltypeSums);
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
		
		List<CardMain> cardInfos=cardMainMapper.queryCardMainInfos(departmentCode);
		model.put("cardInfos", cardInfos);
		return "card_quota_provide";
	}
	@PostMapping("card_quota_provide/provide")
	@ResponseBody
	public String provide(String cardcode,String oiltype,String guidline) {
		//System.out.println(objs.toString());
		//提取当前日期
		String strTodayDate=LocalDate.now().toString();
		String strTodayTime=LocalTime.now().withNano(0).toString();
		String departmentCode="7200";
//		System.out.println(cardcode+" "+oiltype+" "+guidline);
//		//固定指标发放
		CardProvideReport cardProvideReport = new CardProvideReport();
		cardProvideReport.setCardCode(cardcode);
		cardProvideReport.setOilType(Integer.parseInt(oiltype));
		cardProvideReport.setGuidelineType(2);
		cardProvideReport.setProvideDate(strTodayDate);
		cardProvideReport.setProvideTime(strTodayTime);
		cardProvideReport.setSendType(2);										//单卡发放
//		//计算发放次数
		int sendFlag=cardTradeMapper.queryCardMaxSendFlag(cardcode);
		cardProvideReport.setSendFlag(sendFlag + 1);	
		cardProvideReport.setGuidelineCount(Double.parseDouble(guidline));
		//获取卡号
		//String cardCode=obj.getCardCode();					
		// 查看卡上的最大限额指标,这里只有固定做处理
//		double maxCount = obj.getMaxcount();					
//		if(maxCount>0) {
//			// 固定发放指标+补助指标+卡上余额+未实录指标
//			double sumProvide = obj.getDestineGuideline()+obj.getBuzhuzhibiao()+
//					            obj.getCardCount()+obj.getNoOperateCount();
//			if(sumProvide>=maxCount) {
//				if(obj.getNoOperateCount()+obj.getCardCount()>=maxCount) {
//					cardProvideReport.setGuidelineCount(0d);
//				}else {// 最大限额-卡上余额
//					cardProvideReport.setGuidelineCount(maxCount-obj.getCardCount()-obj.getNoOperateCount());
//				}
//			}else {
//				cardProvideReport.setGuidelineCount(obj.getDestineGuideline()+obj.getBuzhuzhibiao());
//			}
//		}else {
//			cardProvideReport.setGuidelineCount(obj.getDestineGuideline()+ obj.getBuzhuzhibiao());
//		}
//		//指标最大限额
//		if((maxCount>0&&obj.getNoOperateCount()+obj.getCardCount()>=maxCount)==false) {
////			cardProvideReport.setWriteCard(0);
////			cardProvideReport.setTflagDown(0);
////			cardProvideReport.setTflagUp(0);
////			cardProvideReport.setAccount(0);
////			cardProvideReport.setOperator("");
////			cardProvideReport.setShenpiren("");
//			cardProvideMapper.insertOne(cardProvideReport);
//		}
		double departmentOilSum=queryDepartmentOiltypeSum(cardcode,oiltype);
		if(departmentOilSum <Double.parseDouble(guidline)) {			
			return "部门指标："+departmentOilSum+" 小于发放量："+guidline+" 发放失败！！！";
		}
		cardProvideMapper.insertOne(cardProvideReport);
		return "success";
	}
	//查询部门油品剩余量
	private double queryDepartmentOiltypeSum(String departmentCode,String oilCode) {
		double shouRu = 0.0;
		double zhiChu = 0.0;
		double luRuZhiChu = 0.0;
		String jiezhuanDate=departmentIncomeMapper.jiezhuandate();
		//部门汇总信息
		//List<DepartmentProvideInfo> departmentProvideInfos=new ArrayList<DepartmentProvideInfo>();
		String cardCode=departmentCode.substring(0, 6);
		//部门收入合计
		List<ProvideSumInfo> bmsr=departmentRecordMapper.queryDepartmentRecordSum(cardCode+"000000",jiezhuanDate);
		Map<String,Double> bmsrs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:bmsr) {
			//bmsrs.put(objInfo.getOilType(), objInfo.getSum());
			if(objInfo.getOilType().equals(oilCode)) {
				shouRu=objInfo.getSum();
			}
		}
		//部门发放  实物卡 机动卡
		List<ProvideSumInfo> bmff=cardProvideMapper.querySumCardProvideAllCard(cardCode,jiezhuanDate);
		Map<String,Double> bmffs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:bmff) {
			//bmffs.put(objInfo.getOilType(), objInfo.getSum());
			if(objInfo.getOilType().equals(oilCode)) {
				zhiChu=objInfo.getSum();
			}
		}
		//卡发放量
		List<ProvideSumInfo> kff=cardMainMapper.querySumCardProvideFix(cardCode);
		Map<String,Double> kffs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:kff) {
			//kffs.put(objInfo.getOilType(), objInfo.getSum());
//			if(objInfo.getOilType().equals(oilCode)) {
//				zhiChu=objInfo.getSum();
//			}
		}
		//卡已发放量
		List<ProvideSumInfo> ksjff=cardMainMapper.querySumCardProvide(departmentCode, jiezhuanDate);
		Map<String,Double> ksjffs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:ksjff) {
			ksjffs.put(objInfo.getOilType(), objInfo.getSum());
		}
		//非IC卡消耗
		List<ProvideSumInfo> ficxh=cardTradeMapper.querysumCardTradeNonIC(cardCode, jiezhuanDate);
		Map<String,Double> ficxhs=new HashMap<String,Double>();
		for(ProvideSumInfo objInfo:ficxh) {
			//ficxhs.put(objInfo.getOilType(), objInfo.getSum());
			if(objInfo.getOilType().equals(oilCode)) {
				luRuZhiChu=objInfo.getSum();
			}
		}			
//		List<Double> oiltypeSums=new ArrayList<Double>();
//		try {
//			shouRu=bmsrs.get(oilCode);//部门收入
//		}catch(NullPointerException e) {
//			shouRu=0;
//		}
//		try {
//			zhiChu=bmffs.get(oilCode);//部门支出(发放)
//		}catch(NullPointerException e) {
//			zhiChu=0;
//		}
//		try {
//			luRuZhiChu=ficxhs.get(oilCode);//非IC卡消耗
//		}catch(NullPointerException e) {
//			luRuZhiChu=0;
//		}		
		//logger.info(departmentCode+" "+oilCode+":="+"*收入："+shouRu+"*支出："+zhiChu+"*录入"+luRuZhiChu+"*re"+(shouRu - zhiChu
		//		- luRuZhiChu));		
		return DataTypeConverter.d2d(shouRu - zhiChu	- luRuZhiChu);
	}
}
