package com.icdats.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R doException(Exception exception){
        exception.printStackTrace();
        return new R("服务器发生异常，请稍后重试");
    }
}
