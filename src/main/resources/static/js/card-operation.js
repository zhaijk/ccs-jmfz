/**
*  0.为正确 1.没有连接 2.维护卡 3.不是本系统的卡 
*  4.密码错误 5.卡没有经过发行 6.灰卡 7.无效卡
*  只有状态为0,5,6,7可以进行读卡和修改卡
*	OpenCard(dukaqi.conn())
*/
/**
 * 卡操作代理函数
 * @param oper
 * @returns
 */
function card_operation(oper)
{
	var result=0;
	for(var i=0;i<4;i++){
		result=dukaqi.Conn();		
		if(result==0) break;		
		if(result<0){
			dukaqi.Disconn();
		}
	}
	switch(result){
		case -1:alert('没有检测到读卡器！！！'); break;
		case -2:alert('打开读卡器失败！！！');break;
		case -3:alert('没有检测到卡');break;
	}
	if(result==0) {
		var flag=0;
		var cardtype=dukaqi.ReadCardInfo(2);
		if(cardtype==2)//参数卡
			flag=2;
		else{
		var factoryCode=dukaqi.ReadCardInfo(0);		
		if(factoryCode!='DERUN2.0' || factoryCode=='99999999')//系统初始化
			flag=3;
		else{
		var cardcode=dukaqi.ReadCardInfo(6);
//		if(cardcode.substr(0,6)!='000000')	//已经发放
//			flag=4;
		if(cardcode.substr(0,6)=='000000')	//未发放
			flag=5;
		else{
		var grayflag=dukaqi.ReadCardInfo(5);
		if(grayflag!='0')	//灰卡
			flag=6;
		else{
		var validflag=dukaqi.ReadCardInfo(4);
		if(validflag!='0')	//无效卡
			flag=7;
		}}}}
		oper && oper(flag);
	}
	dukaqi.DisConn();
}
function getSystemDate(){
	var today=new Date();
	var strYear=String(today.getFullYear())		
	var strMonth=String(today.getMonth()+1).length==2?String(today.getMonth()+1):'0'+String(today.getMonth()+1)
	var strDay=String(today.getDate()).length==2?String(today.getDate()):'0'+String(today.getDate())
	return strYear+strMonth+strDay;
}