package com.example.demo.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

    /**
     * 程序定义状态码
     */
    private int code;
    /**
     * 必要的提示信息
     */
    private String message;
    /**
     * 业务数据
     */
    private Object data;

}
