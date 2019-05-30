package com.example.demo.enums;

import lombok.Data;

/**
 * Created by jams on 2019/5/27.
 */
@Data
public class ResultEnum {

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
