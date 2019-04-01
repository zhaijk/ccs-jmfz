package com.derun.jczb.controller;

//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;


//@ControllerAdvice
public class ErrorController {

	//这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
//    @ExceptionHandler(Exception.class)
//    //将返回的值转成json格式的数据
//    @ResponseBody
//    //返回的状态码
//    //@ResponseStatus()     
//    public Exception handlerUserNotExistException(Exception exception){
//        
//        return exception;
//    }
    
//    @ExceptionHandler({ Exception.class })
//    //@ResponseStatus(HttpStatus.OK)
//    public ModelAndView processException(Exception exception) {
//        //logger.info("自定义异常处理-Exception");
//        ModelAndView m = new ModelAndView();
//        //m.addObject("roncooException", exception.getMessage());
//        m.setViewName("error");
//        return m;
//    }
    
}
