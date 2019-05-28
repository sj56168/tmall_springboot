package com.jason.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 我不管我最帅 on 2019/2/23.
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e){
ModelAndView m=new ModelAndView();
m.addObject("ex",e);
m.setViewName("unauthorized");
return m;
    }

}
