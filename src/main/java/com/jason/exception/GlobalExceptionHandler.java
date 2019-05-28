package com.jason.exception;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 我不管我最帅 on 2019/1/20.
 */
//全局异常处理  @ControllerAdvice：用来处理异常
@ControllerAdvice
public class GlobalExceptionHandler {
    //如果单使用@ExceptionHandler，只能在当前Controller中处理异常（即抛出异常的那个controller里面）
    // 但当配合@ControllerAdvice一起使用的时候，就可以摆脱那个限制了。
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("exception",e);
    modelAndView.addObject("url",request.getRequestURL());

        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if(null!=e.getCause()  && constraintViolationException==e.getCause().getClass()) {
            return "违反了约束，多半是外键约束";
        }


    return "errorPage";
    }

}
