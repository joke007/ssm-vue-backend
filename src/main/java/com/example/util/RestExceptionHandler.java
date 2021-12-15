package com.example.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常控制类，可以直接在@Contoller组件中使用
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e){
        return ResponseResult.error().code(500).message(e.getMessage()+",内部异常，请联系管理员");
    }
}
