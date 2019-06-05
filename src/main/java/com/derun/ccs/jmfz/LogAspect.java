package com.derun.ccs.jmfz;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class LogAspect {
 
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
 
    // ..表示包及子包 该方法代表controller层的所有方法
    @Pointcut("execution(public * com.derun.ccs.jmfz.controller..*.*(..))")
    public void controllerMethod() { }
 
 
    @After("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
 
        //ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
 
        StringBuffer requestLog = new StringBuffer();
        requestLog.append("请求信息：")
                  .append("URL = {" + request.getRequestURI() + "},\t")
                  .append("HTTP_METHOD = {" + request.getMethod() + "},\t")
                  .append("IP = {" + request.getRemoteAddr() + "},\t")
                  .append("CLASS_METHOD = {" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "},\t");
        logger.info(requestLog.toString());
//        if(joinPoint.getArgs().length == 0) {
//            requestLog.append("ARGS = {} ");
//        } else {
//        	for(Object obj:joinPoint.getArgs()) {
//        		requestLog.append(obj.toString());
//        	}
//        }
        
       /* String url=request.getRequestURI();
        String menuStr=".htm";
        if(url.contains(menuStr)==true) {
        	logger.info("加载或者刷新页面  日             志...................................");
        	logger.info(requestLog.toString());
        	Subject subject = SecurityUtils.getSubject();
        	String per=url.replace("/", "");        	
        	logger.info(per+"   "+subject.isPermitted(per));
        	//subject.isPermitted(per);
        	if(subject.isPermitted(per)==false)
        		throw new  AuthorizationException("没有访问权限..");
        }else {
        	logger.info("页面内部操作...................................");
        	logger.info(requestLog.toString());
        }*/
        /*if(url.matches("(.*)htm")==true) {
        	Subject subject = SecurityUtils.getSubject();
        	String per=url.replace("/", "");        	
        	//System.out.println(per+"   "+subject.isPermitted(per));
        	//subject.isPermitted(per);
        	if(subject.isPermitted(per)==true)
        		throw new  AuthorizationException("没有访问权限..");
        }*/
    }
   /* @Before("controllerMethod()")
    public void releaseResource(JoinPoint point) {
        System.out.println("@After：模拟释放资源...");
        System.out.println("@After：目标方法为：" + 
                point.getSignature().getDeclaringTypeName() + 
                "." + point.getSignature().getName());
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@After：被织入的目标对象为：" + point.getTarget());
    }*/
}