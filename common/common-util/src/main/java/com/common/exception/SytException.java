package com.common.exception;

import lombok.Data;

/**
 * @author 12444
 * @version v1.0
 * @description 自定义异常类
 * @since 2023/7/22 12:08
 */
@Data
public class SytException extends RuntimeException{
    private Integer code;
    private String msg;

    public SytException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
