package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by jams on 2019/5/27.
 */
@Getter
public class CommonException extends RuntimeException {

    private Integer code;

    public CommonException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public CommonException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
