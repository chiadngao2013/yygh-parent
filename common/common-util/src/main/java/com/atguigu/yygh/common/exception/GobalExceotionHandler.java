package com.atguigu.yygh.common.exception;

import com.atguigu.yygh.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理
@RestControllerAdvice
public class GobalExceotionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
//        抛出错误信息
        e.printStackTrace();
        return Result.fail();
    }
    @ExceptionHandler(YyghException.class)
    public Result error(YyghException e){
//        抛出错误信息
        e.printStackTrace();
        return Result.fail();
    }
}

