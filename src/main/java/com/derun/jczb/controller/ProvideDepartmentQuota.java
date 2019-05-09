package com.derun.jczb.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardMainMapper;
import com.derun.jczb.dao.CardProvideMapper;
import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.DepartmentInfoMapper;
import com.derun.jczb.dao.DepartmentRecordMapper;
import com.derun.jczb.dao.OilInfoMapper;
//import com.derun.jczb.dao.OilTypeMapper;
import com.derun.jczb.model.DepartmentInfo;
import com.derun.jczb.model.DepartmentProvideInfo;
import com.derun.jczb.model.DepartmentRecord;
import com.derun.jczb.model.OilInfo;
import com.derun.jczb.model.ProvideSumInfo;
import com.derun.jczb.util.DataTypeConverter;
import com.derun.jczb.util.SessionInfo;

//部门指标发放
@Controller
public class ProvideDepartmentQuota {
	
//	private Logger logger=LoggerFactory.getLogger(ProvideDepartmentQuota.class);
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
	@Autowired
	private SessionInfo sessionInfo;
	
	@GetMapping("department-quota-provide.htm")
	public String init(ModelMap model) {
		double shouRu = 0.0;
		double zhiChu = 0.0;
		double luRuZhiChu = 0.0;
//		double putValue = 0.0;
//		double sjValue = 0.0;
//		
//		double old = 0.0;
//		double put = 0.0;
//		double fafang = 0.0;
		
		String departmentCode="7200";
		String jiezhuanDate=sessionInfo.getJieZhuanDate();
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
				/*try {
					putValue=kffs.get(oilCode);//固定发放量
				}catch(NullPointerException e) {
					putValue=0;
				}
				try {
					sjValue=ksjffs.get(oilCode);//实际发放量
				}catch(NullPointerException e) {
					sjValue=0;
				}				*/
				/*logger.info(obj.getDepartmentName()+oil.getName()+":="+"*收入："+shouRu+"*支出："+zhiChu+"*录入"+luRuZhiChu+"*re"+(shouRu - zhiChu
						- luRuZhiChu));*/
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
		return "department_quota_provide";
	}	
	@PostMapping("department-quota-provide/insert")
	@ResponseBody
	public String insertDepartmentIncome(String departmentCode,String oilType,String inputGuideline) {
		DepartmentRecord obj=new DepartmentRecord();
		obj.setInputGuideline(Double.valueOf(inputGuideline));
		obj.setDepartmentCode(departmentCode);
		obj.setOilType(Integer.valueOf(oilType));
		obj.setOperator("");//当前操作员信息
		obj.setTflag(0);
		obj.setGuidelineType(0);
		obj.setProvideDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		departmentRecordMapper.insertOne(obj);
		return "success";	
	}
}
