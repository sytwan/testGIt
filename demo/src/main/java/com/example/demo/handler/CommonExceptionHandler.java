package com.example.demo.handler;

import com.example.demo.common.entity.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by annie on 2019/1/4.
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler
    public ApiResponse AllException(Exception e){
        return new ApiResponse(-1,e.getMessage(),null);
    }
}

