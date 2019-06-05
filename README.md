 车船税减免政策辅助系统 2019-06-05
 \ccs-jmfz
 * .git 版本管理目录
 * .settings 项目ide配置参数
 * src  源码
 * target 生成目标代码
 * target-deploy  上传的发布文件
 * uml 类图 
src/main/java        java文件
src/main/resources   资源文件   
 *    static/           静态文件 (前端框架css js 图片文件 )
 *    templates/        thymeleaf 模板文件
application.yml 项目配置参数文件
banner.txt   启动标志文件
ehcached.xml  ehcache 缓存框架配置文件   

源码：
主包  com.derun.css.jmfz:
 *    HttpsConfig.java       https配置类
 *    JMFZApp.java           项目启动主类 (内置jetty容器)
 *    LogAspect.java         切面日志、权限实现类 
控制层包  com.derun.css.jmfz.controller:
 *    AuditController.java   审计控制器
 *    BXGMController.java    保险公司信息管理控制器
 *    DataTableDO.java       数据传输模型    
 *    IndexController.java   登录、主页控制器
 *    JMCXController.java    减免车型信息管理控制器
 *    JMLXController.java    减免类型信息管理控制器
 *    QueryController.java   查询控制器
 *    UserInfoController.java用户信息管理控制器
数据访问对象包  com.derun.css.jmfz.dao: mybatis 注解
 *    AuditMapper.java   审计查询
 *    BXGSMapper.java    保险公司信息查询
 *    CcsHdXxMapper.java SYJK_CCS_CCSHDXX表操作接口    
 *    CLCBJMBAXXMapper.java YH_CLCBJMBAXX查询接口  
 *    JMDMMapper.java    减免车型信息查询
 *    JMLXMapper.java    减免类型信息查询
 *    UserMapper.java    用户信息查询
 数据模型包  com.derun.css.jmfz.model: pojo对象
 *    BXGS.java   险公司信息模模型
 *    CcsHdXx.java    审计信息模型
 *    CLCBJMBAXX.java 新能源减免信息模型
 *    JMDM.java    减免车型信息模型
 *    JMLX.java    减免类型信息模型
 *    QueryDataVO.java    查询数据中间结果模型
 *    TotalInfo.java      汇总信息模型
 *    UserInfo.java       用户信息模型
    
   
   