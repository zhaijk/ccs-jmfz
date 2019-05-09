package com.derun.jczb.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.jczb.dao.CardTradeMapper;
import com.derun.jczb.dao.DepartmentIncomeMapper;
import com.derun.jczb.dao.OilInfoMapper;
import com.derun.jczb.dao.OillossMapper;
import com.derun.jczb.dao.TotalDTO;
import com.derun.jczb.model.DepartmentIncome;
import com.derun.jczb.model.OilDictionary;
import com.derun.jczb.model.SunHao;
import com.derun.jczb.model.ZdgCardTrades;
import com.derun.jczb.model.Zhibiao;
import com.derun.jczb.model.Zhuandaigong;
import com.derun.jczb.util.DataTypeConverter;
import com.derun.jczb.util.SessionInfo;

@Controller
public class QuotaManager {
	
	private Logger logger=LoggerFactory.getLogger(QuotaManager.class);
	@Autowired
	private DepartmentIncomeMapper departmentIncomeMapper;
	@Autowired
	private OillossMapper oillossMapper;
	@Autowired
	private OilInfoMapper oilInfoMapper;
	@Autowired
	private CardTradeMapper cardTradeMapper;
	@Autowired
	private SessionInfo sessionInfo;
	
   	@GetMapping("quota-manager.htm")
	public String init(ModelMap model) {
   		String departmentId=sessionInfo.getUserInfo().getDanwei();
   		String jiezhuanDate=sessionInfo.getJieZhuanDate();   		
   		double swjiecu = 0,zdgjiecu = 0,heji = 0,shouru = 0,zhuanhuan = 0,daigong=0,jiabo=0,oilloss=0,lsZdg=0,zdgzhuanhuanhj=0;  
   		//部门指标收入 决策系统 二级部门分配给三级部门
   		shouru=Double.parseDouble(departmentIncomeMapper.queryZhiBiaoheji(departmentId));
   		//转换的指标
   		zhuanhuan=Double.parseDouble(departmentIncomeMapper.queryZhuanhuanHeji(departmentId, jiezhuanDate));
   		//支队指标转代供他部
   		daigong=0;//Double.parseDouble(departmentIncomeMapper.queryZhiDuiZhiBiaoZdgTaBu(departmentId));
   		//加拨支出合计
   		jiabo=0;//Double.parseDouble(departmentIncomeMapper.queryJiaobozhichuheji(departmentId));
   		//油料损耗
   		oilloss=0;//Double.parseDouble(oillossMapper.queryOilLossheji(departmentId, jiezhuanDate));
   		//临时转代供
   		lsZdg=0;//Double.parseDouble(departmentIncomeMapper.queryLinshiZhuandaigong(departmentId));
   		//转代供转换合计
   		zdgzhuanhuanhj=0;//Double.parseDouble(departmentIncomeMapper.queryZhuandaigongZhuanhuanHeji(departmentId, jiezhuanDate));
   		
   		//实物结存=收入-转换-代供-价拨-损耗
   		swjiecu=shouru-zhuanhuan-daigong-jiabo-oilloss;
   		//转代供合计=临时转代供-转代供转换合计
   		zdgjiecu=lsZdg-zdgzhuanhuanhj;
   		//合计=实物结存+转代供合计
   		heji=swjiecu+zdgjiecu;
   		model.put("shouru",DataTypeConverter.d2s(shouru));
   		model.put("yizhuanhuan",DataTypeConverter.d2s(daigong+jiabo+oilloss+zhuanhuan));
   		model.put("swjiecu",DataTypeConverter.d2s(swjiecu));
   		model.put("zdgjiecu",DataTypeConverter.d2s(zdgjiecu));
   		model.put("heji",DataTypeConverter.d2s(heji));   		
		return "quota_manager";
	}
	@GetMapping("quota-shiwuzhuanhuan.htm")
	public String shiwuzhuanhuan(ModelMap model) {
		String departmentId=sessionInfo.getDepartmentCode();
   		String jiezhuanDate=sessionInfo.getJieZhuanDate();
   		//logger.info(jiezhuanDate);
   		double swjiecu = 0,zdgjiecu = 0,heji = 0,shouru = 0,zhuanhuan = 0,daigong=0,jiabo=0,oilloss=0,lsZdg=0,zdgzhuanhuanhj=0;  
   		shouru=Double.parseDouble(departmentIncomeMapper.queryZhiBiaoheji(departmentId)==null?"0.0":departmentIncomeMapper.queryZhiBiaoheji(departmentId));
   		zhuanhuan=Double.parseDouble(departmentIncomeMapper.queryZhuanhuanHeji(departmentId, jiezhuanDate));
   		daigong=Double.parseDouble(departmentIncomeMapper.queryZhiDuiZhiBiaoZdgTaBu(departmentId));
   		jiabo=Double.parseDouble(departmentIncomeMapper.queryJiaobozhichuheji(departmentId)==null?"0.0":departmentIncomeMapper.queryJiaobozhichuheji(departmentId));
   		oilloss=Double.parseDouble(oillossMapper.queryOilLossheji(departmentId, jiezhuanDate)==null?"0.0":oillossMapper.queryOilLossheji(departmentId, jiezhuanDate));
   		lsZdg=Double.parseDouble(departmentIncomeMapper.queryLinshiZhuandaigong(departmentId));
   		zdgzhuanhuanhj=Double.parseDouble(departmentIncomeMapper.queryZhuandaigongZhuanhuanHeji(departmentId, jiezhuanDate));
   		//实物结存=收入-转换-代供-价拨-损耗
   		swjiecu=shouru-zhuanhuan-daigong-jiabo-oilloss;
   		logger.info(DataTypeConverter.d2s(shouru)+" "+
   				DataTypeConverter.d2s(zhuanhuan)+" "+
   				DataTypeConverter.d2s(daigong)+" "+
   				DataTypeConverter.d2s(jiabo)+" "+
   				DataTypeConverter.d2s(oilloss));
   		//转代供合计=临时转代供-转代供转换合计
   		zdgjiecu=lsZdg-zdgzhuanhuanhj;
   		//合计=实物结存+转代供合计
   		heji=swjiecu+zdgjiecu;   		
   		model.put("shouru",DataTypeConverter.d2s(shouru));
   		model.put("yizhuanhuan",DataTypeConverter.d2s(daigong+jiabo+oilloss+zhuanhuan));
   		model.put("swjiecu",DataTypeConverter.d2s(swjiecu));
   		model.put("zdgjiecu",DataTypeConverter.d2s(zdgjiecu));
   		model.put("heji",DataTypeConverter.d2s(heji));
   		//启用的油品类型
   		List<OilDictionary> objs=oilInfoMapper.queryBy(departmentId);
   		
   		String[] oiltypes=new String[objs.size()];
   		int i=0;
   		for(OilDictionary obj:objs){
   			oiltypes[i]=obj.getCode().toString();
   			i++;
   		}
   		//启用的油品类型
   		model.put("oilTypeInfos", objs);
   		//油品类型数组
   		model.put("oiltypes", oiltypes);
   		//logger.info(oiltypes.toString());
   		//List<Zhibiao> zhibiaoshouru=departmentIncomeMapper.queryZhiBiaoList(departmentId);
   		//本期实物、价拨指标收入
   		List<Zhibiao> zhibiaoshourus=departmentIncomeMapper.queryZhiBiaoList(departmentId);
   		TotalDTO zhibiaoshourustotal=calcZhibiaoshourus(zhibiaoshourus,oiltypes);
   		TotalDTO jiaboshourustotal=calcJiaboshourus(zhibiaoshourus,oiltypes);
   		model.put("zhibiaoshourus",zhibiaoshourus);
   		model.put("zhibiaoshourustotal",zhibiaoshourustotal);
   		model.put("jiaboshourustotal",jiaboshourustotal);
   		//本期油料损耗
   		List<SunHao> shunhaosum=oillossMapper.queryOilLossList(departmentId, jiezhuanDate);
   		TotalDTO shunhaosumtotal=calcYouliaosunhao(shunhaosum,oiltypes);
   		model.put("shunhaosum", shunhaosum);
   		model.put("shunhaosumtotal", shunhaosumtotal);
		//本期实物转换
   		List<DepartmentIncome> departmentIncomes=departmentIncomeMapper.queryIncomeBy(departmentId,1,jiezhuanDate);
   		TotalDTO departmentIncomestotal=calcShiwuzhuanhuan(departmentIncomes,oiltypes);
   		model.put("departmentIncomes", departmentIncomes);
   		model.put("departmentIncomestotal", departmentIncomestotal);
   		//价拨支出
   		List<Zhibiao> jiabozhichus=departmentIncomeMapper.queryJiaboZhichu(departmentId);
   		TotalDTO jiabozhichustotal=calcJiabozhichus(jiabozhichus,oiltypes);
		model.put("jiabozhichus", jiabozhichus);
		model.put("jiabozhichustotal", jiabozhichustotal);
		//代供外部
		List<Zhibiao> daigongwaibus=departmentIncomeMapper.queryDaigongWaibu(departmentId);
		TotalDTO daigongwaibustotal=calcDaigongwaibus(daigongwaibus,oiltypes);
		model.put("daigongwaibus",daigongwaibus);
		model.put("daigongwaibustotal",daigongwaibustotal);
		//计算总汇总信息
		TotalDTO totals=calcTotal(zhibiaoshourustotal,jiaboshourustotal,jiabozhichustotal,daigongwaibustotal,shunhaosumtotal,departmentIncomestotal, oiltypes);
		model.put("totals",totals);
		return "quota_shiwuzhuanhuan";
	}	
	//计算本期实物收入汇总
	private  TotalDTO calcZhibiaoshourus(List<Zhibiao> objs,String[] oiltypes) {
		TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(Zhibiao obj:objs) {			
			total.setTotal(total.getTotal()+Double.parseDouble(obj.getSw()));
			for(int i=0;i<oiltypes.length;i++){
				if(obj.getYpcode().equals(oiltypes[i])){
					double sum=oils.get(i);
					sum+=Double.parseDouble(obj.getSw());
					oils.set(i, sum);
				}
			}
		}		
		total.setObjs(oils);		
		return total;
	}
	//计算本期价拨收入汇总
	private  TotalDTO calcJiaboshourus(List<Zhibiao> objs,String[] oiltypes) {
		TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(Zhibiao obj:objs) {			
			total.setTotal(total.getTotal()+Double.parseDouble(obj.getJb()));
			for(int i=0;i<oiltypes.length;i++){
				if(obj.getYpcode().equals(oiltypes[i])){
					double sum=oils.get(i);
					sum+=Double.parseDouble(obj.getJb());
					oils.set(i, sum);
				}
			}
		}		
		total.setObjs(oils);		
		return total;
	}	
	//计算本期价拨支出汇总
	private  TotalDTO calcJiabozhichus(List<Zhibiao> objs,String[] oiltypes) {
		TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(Zhibiao obj:objs) {			
			if(null==obj.getRiqi()) break;
			total.setTotal(total.getTotal()+Double.parseDouble(obj.getJb()));
			for(int i=0;i<oiltypes.length;i++){
				if(obj.getYpcode().equals(oiltypes[i])){
					double sum=oils.get(i);
					sum+=Double.parseDouble(obj.getJb());
					oils.set(i, sum);
				}
			}
		}		
		total.setObjs(oils);		
		return total;
	}
	//计算代供外部汇总
	private  TotalDTO calcDaigongwaibus(List<Zhibiao> objs,String[] oiltypes) {
		TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(Zhibiao obj:objs) {			
			if(null==obj.getRiqi()) break;
			total.setTotal(total.getTotal()+Double.parseDouble(obj.getZg()));
			for(int i=0;i<oiltypes.length;i++){
				if(obj.getYpcode().equals(oiltypes[i])){
					double sum=oils.get(i);
					sum+=Double.parseDouble(obj.getZg());
					oils.set(i, sum);
				}
			}
		}		
		total.setObjs(oils);		
		return total;
	}
	//计算本期油料损耗
	private  TotalDTO calcYouliaosunhao(List<SunHao> objs,String[] oiltypes) {
		TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(SunHao obj:objs) {			
			//if(null==obj.get) break;
			total.setTotal(total.getTotal()+obj.getSum());
			for(int i=0;i<oiltypes.length;i++){
				if(obj.getOiltype().equals(oiltypes[i])){
					double sum=oils.get(i);
					sum+=obj.getSum();
					oils.set(i, sum);
				}
			}
		}		
		total.setObjs(oils);		
		return total;
	}
	//计算本期实物转换
    private  TotalDTO calcShiwuzhuanhuan(List<DepartmentIncome> objs,String[] oiltypes) {
		TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(DepartmentIncome obj:objs) {
			total.setTotal(total.getTotal()+obj.getTonNum());
			for(int i=0;i<oiltypes.length;i++){
				if(obj.getOilType()==Integer.parseInt(oiltypes[i])){
					double sum=oils.get(i);
					sum+=obj.getTonNum();
					oils.set(i,sum);
				}
			}
		}		
		total.setObjs(oils);		
		return total;
    }
	//计算总合计
    private TotalDTO calcTotal(TotalDTO swsr,TotalDTO jbsr,TotalDTO jbzc,TotalDTO dgwb,TotalDTO ylsh,TotalDTO swzh,String[] oiltypes) {
    	TotalDTO  total=new TotalDTO();
		total.setTotal(0);
		total.setChange(0);
		total.setBalance(0);
		List<Double> oils=new ArrayList<Double>();
		for(int i=0;i<oiltypes.length;i++){
			oils.add((double) 0);
		}
		for(int i=0;i<oils.size();i++){
			oils.set(i, swsr.getObjs().get(i)+jbsr.getObjs().get(i)-
					 	           jbzc.getObjs().get(i)-dgwb.getObjs().get(i)-
					               ylsh.getObjs().get(i)-swzh.getObjs().get(i));
		}
		total.setTotal(swsr.getTotal()+jbsr.getTotal());
		total.setChange(jbzc.getTotal()+dgwb.getTotal()+ylsh.getTotal()+swzh.getTotal());
		total.setBalance(total.getTotal()-total.getChange());
		total.setObjs(oils);
		return total;
    }
    @PostMapping("quota/shiwuzhuanhuan")
    @ResponseBody
    public String change(String danjuhao,double changenumber,double balance,double density,int code) {
    	String departmentId=sessionInfo.getUserInfo().getDanwei();
   		//String jiezhuanDate=sessionInfo.getJieZhuanDate();  
    	logger.info(danjuhao+" "+changenumber+" "+balance+" "+density);
    	DepartmentIncome obj=new DepartmentIncome();
    	obj.setOilType(code);
    	obj.setTonNum(changenumber);
    	obj.setDanjuhao(danjuhao);
    	obj.setDensity(density);
    	obj.setDepartmentCode(departmentId);
    	obj.setInputGuideline2(changenumber*(density*1000));
    	obj.setIncomType(1);
    	obj.setProvideDate2(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    	//obj.setIncomID(String.valueOf(departmentIncomeMapper.getNextValIncomeID()));
    	departmentIncomeMapper.insertOne(obj);
    	return "success";
    }
	@GetMapping("quota-zhuangongzhuanhuan.htm")
	public String zhuangonginit(ModelMap model) {
		String departmentId=sessionInfo.getUserInfo().getDanwei();
   		String jiezhuanDate=sessionInfo.getJieZhuanDate();  
   		jiezhuanDate=sessionInfo.getJieZhuanDate();
		//启用的油品类型   		
   		List<OilDictionary> objs=oilInfoMapper.queryBy(departmentId);
   		model.put("oilTypeInfos", objs);
   		//查询批准的转代供指标
   		double zdgtotal=departmentIncomeMapper.queryZdgLinshi(departmentId);
   		model.put("zdgtotal", zdgtotal);   		
   		List<Zhuandaigong>  zhuandaigongs=departmentIncomeMapper.queryZhuanDaiGong(departmentId);
   		model.put("zhuandaigongs", zhuandaigongs);
   		//转代供消耗
   		List<ZdgCardTrades> zdgCardTrades=cardTradeMapper.queryZdgTotal(departmentId,jiezhuanDate);
   		model.put("zdgCardTrades", zdgCardTrades);
   		//转换
   		List<ZdgCardTrades> zdgZhs=departmentIncomeMapper.queryZdg(departmentId,jiezhuanDate);
   		model.put("zdgZhs", zdgZhs);
   		return "quota_zgzhuanhuan";
	}	
}
